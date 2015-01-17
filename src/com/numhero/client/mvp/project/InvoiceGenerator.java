package com.numhero.client.mvp.project;

import com.google.gwt.user.client.Window;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceRequest;
import com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceResponse;
import com.numhero.client.model.datacargo.project.SaveProjectRequest;
import com.numhero.client.model.datacargo.project.SaveProjectResponse;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.model.pojoc.Invoice;
import com.numhero.client.model.pojoc.InvoiceDetail;
import com.numhero.client.model.pojoc.TimeEntry;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.shared.enums.*;

import java.util.Date;
import java.util.List;

public class InvoiceGenerator {

    public static void addExpensesLine(ProjectPanel projectPanel, Invoice invoice) {
        ProjectExpensesTable table = projectPanel.getExpensesTable();
        List<ExpenseReceipt> expensesToBill = table.getCheckedExpenses();
        for (ExpenseReceipt expenseReceipt : expensesToBill) {
            InvoiceDetail detail = new InvoiceDetail();
            detail.fOriginatingType.setValue(InvoiceDetailTypeEnum.from_expense);
            detail.fOriginalID.setValue(expenseReceipt.getId());
            detail.fName.setValue(Application.getConstants().categoryIs() + expenseReceipt.fCategoryName.getValue());
            detail.setDescription(Application.getConstants().expenseReceiptBy() + expenseReceipt.fStaffName.getValue());
            detail.setQuantity(1D);
            detail.setPrice(expenseReceipt.fValue.getValue());
            detail.setCreated(new Date());
            invoice.addInvoiceDetail(detail);
        }
    }

    public static void formatTaskRateProjectInvoiceDetails(ProjectPanel projectPanel, Invoice invoice, InvoiceTypeEnum type) {
        ProjectTasksDetailsTable table = projectPanel.getProjectTasksDetailsTable();
        List<ProjectTasksDetailsTable.TaskLine> tasks = table.getLines();
        for (ProjectTasksDetailsTable.TaskLine taskLine : tasks) {
            double hourlyRate = normalizedRateInHours(taskLine.timeUnit.getValue(), taskLine.billingRate.getAmount());
            if (taskLine.notBilledHours.getAmount() > 0 || type == InvoiceTypeEnum.Estimate) {
                InvoiceDetail detail = new InvoiceDetail();
                detail.fOriginatingType.setValue(InvoiceDetailTypeEnum.from_task);
                detail.fOriginalID.setValue(taskLine.getSuggestBoxTask().getPojo().getId());
                detail.fName.setValue(Application.getConstants().taskIs() + taskLine.getSuggestBoxTask().getSuggestBox().getText());
                detail.setDescription(taskLine.notBilledHours.getAmount() + Application.getConstants().hoursPer() + hourlyRate + Application.getConstants().hourlyRate());
                detail.setQuantity(1D);
                detail.setPrice(hourlyRate * taskLine.notBilledHours.getAmount());
                detail.setCreated(new Date());
                invoice.addInvoiceDetail(detail);
            }
        }
    }

    public static void prepareProjectRateInvoiceDetails(ProjectPanel projectPanel, Invoice invoice, InvoiceTypeEnum type) {
        InvoiceDetail detail = new InvoiceDetail();
        detail.fOriginatingType.setValue(InvoiceDetailTypeEnum.from_project);
        detail.fOriginalID.setValue(projectPanel.getProject().getId());
        detail.fName.setValue(Application.getConstants().projectIs() + projectPanel.getProject().fName.getValue());

        Double hoursToBill = 0D;
        for (int i = 0; i < projectPanel.getTimeEntriesTable().getCheckedTimeEntries().size(); i++) {
            TimeEntry entry = projectPanel.getTimeEntriesTable().getCheckedTimeEntries().get(i);
            hoursToBill = +hoursToBill + entry.fHours.getValue();
        }

        double hourlyRate = normalizedRateInHours(projectPanel.getTimeUnit().getValue(), projectPanel.getBillingRate().getAmount());
        double numberOfBillableHours = hoursToBill;

        if (numberOfBillableHours != 0 || type == InvoiceTypeEnum.Estimate) {
            detail.setDescription(numberOfBillableHours + Application.getConstants().hoursPer() + hourlyRate + Application.getConstants().hourlyRate());
            detail.setQuantity(1D);
            detail.setPrice(hourlyRate * numberOfBillableHours);
            detail.setCreated(new Date());
            invoice.addInvoiceDetail(detail);
        }
    }

    public static void prepareStaffRateProjectInvoiceDetails(ProjectPanel projectPanel, Invoice invoice, InvoiceTypeEnum type) {
        ProjectStaffDetailsTable table = projectPanel.getProjectStaffDetailsTable();
        List<ProjectStaffDetailsTable.StaffLine> staffLines = table.getLines();

        for (ProjectStaffDetailsTable.StaffLine staffLine : staffLines) {
            double hourlyRate = normalizedRateInHours(staffLine.timeUnit.getValue(), staffLine.billingRate.getAmount());

            if (staffLine.billableHours.getAmount() > 0 || type == InvoiceTypeEnum.Estimate) {
                InvoiceDetail detail = new InvoiceDetail();
                detail.fOriginatingType.setValue(InvoiceDetailTypeEnum.from_project);
                detail.fOriginalID.setValue(staffLine.getSbStaff().getPojo().getId());
                detail.fName.setValue(Application.getConstants().staffIs() + staffLine.getSbStaff().getSuggestBox().getText());
                detail.setDescription(staffLine.billableHours.getAmount() + Application.getConstants().hoursPer() + hourlyRate + Application.getConstants().hourlyRate());
                detail.setQuantity(1D);
                detail.setPrice(hourlyRate * staffLine.billableHours.getAmount());
                detail.setCreated(new Date());
                invoice.addInvoiceDetail(detail);
            }
        }
    }

    public static void formatFlatProjectInvoiceDetails(ProjectPanel projectPanel, Invoice invoice, InvoiceTypeEnum type) {
        InvoiceDetail detail = new InvoiceDetail();
        detail.fName.setValue(Application.getConstants().projectIs() + projectPanel.getProject().fName.getValue());
        detail.fOriginatingType.setValue(InvoiceDetailTypeEnum.from_project);
        detail.fOriginalID.setValue(projectPanel.getProject().getId());
        detail.setDescription(Application.getConstants().flatPrice());
        detail.setQuantity(1D);
        detail.setPrice(projectPanel.getBillingFlatRate().getAmount());
        detail.setCreated(new Date());
        invoice.addInvoiceDetail(detail);
    }

    public static double normalizedRateInHours(TimeUnitEnum timeUnit, Double rate) {
        if (timeUnit == TimeUnitEnum.Minute) return rate * 60;
        if (timeUnit == TimeUnitEnum.Hour) return rate;
        if (timeUnit == TimeUnitEnum.Day) return rate / 8;
        return 0;
    }

    public static void generateInvoiceFromProject(final ProjectPresenter presenter,
                                                  final ProjectPanel projectPanel,
                                                  final InvoiceTypeEnum type,
                                                  final Service<SaveProjectRequest, SaveProjectResponse> projectSaveService
    ) {

        boolean ret = projectPanel.validator.validate();
        if (ret) {

            if (projectPanel.getValuation() > 0 && !presenter.isSameCurrency && type == InvoiceTypeEnum.Estimate) {
                Window.alert(Application.getConstants().noValueToInvoice());
                return;
            }

            projectPanel.getLastBilled().setText(new Date().toString());

            Invoice invoice = new Invoice();
            invoice.fName.setValue(projectPanel.getProject().fName.getValue());
            invoice.fDescription.setValue("Generated from project " + projectPanel.getProject().fName.getValue());

            invoice.setInvoiceType(type);
            invoice.setInvoiceStatus(InvoiceStatusEnum.Draft);
            invoice.setDateRaised(new Date());
            invoice.setClientSupplierID(projectPanel.getProject().fClientSupplierID.getValue());
            invoice.setClientSupplierName(projectPanel.getProject().fClientSupplierName.getValue());
            invoice.setCurrency(projectPanel.getProject().fCurrency.getValue());

            invoice.setDiscount(0D);
            if (ClientCache.getCurrentBA() != null) {
                invoice.fName.setValue(ClientCache.getCurrentBA().fPrefix.getValue() + "---");
                invoice.fDateDue.setValue(new Date(System.currentTimeMillis() + (ClientCache.getCurrentBA().fDefaultDaysDue.getValue()) * 24 * 60 * 60 * 1000));
                invoice.setTermsConditions(ClientCache.getCurrentBA().fTermsConditions.getValue());
            }

            invoice.setCreated(new Date());
            invoice.setPrice(projectPanel.getValuation());

            BillingMethodEnum enumer = projectPanel.getBillingMethod().getValue();
            if (enumer == BillingMethodEnum.FLAT_AMOUNT) {
                invoice.setNotes(Application.getConstants().projectIs() + projectPanel.getProject().fName.getValue() + " - " + Application.getConstants().flatPrice());
                formatFlatProjectInvoiceDetails(projectPanel, invoice, type);
            } else {
                if (enumer == BillingMethodEnum.PROJECT_RATE) {
                    invoice.setNotes(Application.getConstants().projectIs() + projectPanel.getProject().fName.getValue() + " - " + Application.getConstants().projectRate());
                    prepareProjectRateInvoiceDetails(projectPanel, invoice, type);
                } else if (enumer == BillingMethodEnum.STAFF_RATE) {
                    invoice.setNotes(Application.getConstants().projectIs() + projectPanel.getProject().fName.getValue() + " - " + Application.getConstants().staffRate());
                    prepareStaffRateProjectInvoiceDetails(projectPanel, invoice, type);
                } else if (enumer == BillingMethodEnum.TASK_RATE) {
                    invoice.setNotes(Application.getConstants().projectIs() + projectPanel.getProject().fName.getValue() + " - " + Application.getConstants().taskRate());
                    formatTaskRateProjectInvoiceDetails(projectPanel, invoice, type);
                }
            }

            addExpensesLine(projectPanel, invoice);
            if (invoice.getDetails() == null || invoice.getDetails().isEmpty()) {
                Window.alert(Application.getConstants().noHoursAndExpensesToInvoice());
                return;
            }

            ProjectGenerateInvoiceRequest requestRequest = new ProjectGenerateInvoiceRequest();
            requestRequest.setEntity(invoice);
            presenter.generateInvoiceService.execute(requestRequest, new ServiceCallbackImpl<ProjectGenerateInvoiceResponse>() {
                @Override
                public void onSuccess(final ProjectGenerateInvoiceResponse response) {
                    Application.toasterMessage(Application.getConstants().invoiceGenerated());
                    SaveProjectRequest saveProjectRequest = new SaveProjectRequest();
                    if (projectPanel.saveValuesFromUi()) {
                        saveProjectRequest.setProject(projectPanel.getProject());
                        projectPanel.getProject().fLastBilled.setValue(new Date());
                        projectPanel.getProject().fTotalBilledTime.setValue(
                                projectPanel.getProject().fTotalBilledTime.getValue() +
                                        projectPanel.getProject().fBillableTime.getValue());
                        Application.showGlasspanelLoading();

                        projectSaveService.execute(saveProjectRequest, new ServiceCallbackImpl<SaveProjectResponse>() {
                            @Override
                            public void onSuccess(SaveProjectResponse saveresponse) {
                                Application.toasterMessage(Application.getConstants().projectSaved());
                                presenter.timeEntriesBilled();
                                presenter.expensesBilled();
                                if (type == InvoiceTypeEnum.Invoice)
                                    Application.placeManager.moveToPlace("invoice/" + response.getEntityId());
                                else if (type == InvoiceTypeEnum.Estimate)
                                    Application.placeManager.moveToPlace("estimate/" + response.getEntityId());
                            }
                        });
                    }
                }
            });
        } else {
            projectPanel.errorsPanel.setVisible(true);
        }
    }
}
