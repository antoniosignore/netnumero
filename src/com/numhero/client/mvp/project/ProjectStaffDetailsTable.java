package com.numhero.client.mvp.project;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest;
import com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse;
import com.numhero.client.model.datacargo.staff.SaveStaffRequest;
import com.numhero.client.model.datacargo.staff.SaveStaffResponse;
import com.numhero.client.model.datacargo.staff.StaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.model.pojoc.Project;
import com.numhero.client.model.pojoc.ProjectStaffDetail;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.client.mvp.staff.StaffPanel;
import com.numhero.client.mvp.staff.StaffSelect;
import com.numhero.client.mvp.staff.StaffViewDialog;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.widget.combobox.CurrencySelect;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.client.widget.combobox.DropDownBox.DropDownBoxHandler;
import com.numhero.client.widget.combobox.TimeUnitComboBox;
import com.numhero.client.widget.table.FlexTableWithHeader;
import com.numhero.client.widget.table.TableDetailToolbar;
import com.numhero.client.widget.textbox.NumberTextBox;
import com.numhero.shared.datacargo.ListCommandRequest;
import com.numhero.shared.datacargo.ListCommandResponse;
import com.numhero.shared.enums.CurrencyEnum;
import eu.maydu.gwt.validation.client.ValidationProcessor;

import java.util.ArrayList;
import java.util.List;

public class ProjectStaffDetailsTable extends FlexTableWithHeader {

    protected List<StaffLine> lines;

    private StaffPanel staffPanel;
    private Service<ListCommandRequest,ListCommandResponse<CurrencyEnum>> getCurrenciesService;
    private Service<SaveBusinessAccountRequest,SaveBusinessAccountResponse> businessAccountSaveService;

    public List<StaffLine> getLines() {
        return lines;
    }

    private Project project;
    private ValidationProcessor validator;

    private Service<StaffListRequest, StaffListResponse> getListService;
    private Service<SaveStaffRequest, SaveStaffResponse> saveService;
    private PlaceManager eventManager;

    @Inject
    public ProjectStaffDetailsTable(PlaceManager eventManager,
                                    Service<StaffListRequest, StaffListResponse> getListService,
                                    Service<SaveStaffRequest, SaveStaffResponse> saveService,
                                    Service<ListCommandRequest,ListCommandResponse<CurrencyEnum>> getCurrenciesService,
                                    Service<SaveBusinessAccountRequest,SaveBusinessAccountResponse> businessAccountSaveService,
                                    StaffPanel staffPanel) {
        this.getListService = getListService;
        this.saveService = saveService;
        this.staffPanel = staffPanel;
        this.eventManager = eventManager;
                this.getCurrenciesService = getCurrenciesService;
        this.businessAccountSaveService = businessAccountSaveService;
        this.lines = new ArrayList<StaffLine>();
        setStyleName("entity-details-table");
    }

    public void setProject(Project pC) {
        this.project = pC;

        if (project.fProjectStaffDetails.isEmpty()) {
            ProjectStaffDetail psd1 = new ProjectStaffDetail();
            psd1.fCurrency.setValue(project.fCurrency.getValue());
            project.fProjectStaffDetails.add(psd1);

            ProjectStaffDetail idc2 = new ProjectStaffDetail();
            idc2.fCurrency.setValue(project.fCurrency.getValue());
            project.fProjectStaffDetails.add(idc2);

            ProjectStaffDetail idc3 = new ProjectStaffDetail();
            idc3.fCurrency.setValue(project.fCurrency.getValue());
            project.fProjectStaffDetails.add(idc3);
        }

        lines.clear();

        for (ProjectStaffDetail idc : project.fProjectStaffDetails) {
            addLine(idc);
        }
        setHeader();
        setValues();
    }

    public void addLine(ProjectStaffDetail idc) {
        lines.add(new StaffLine(idc));
        eventManager.fireEvent(new ProjectValuationChangedEvent("added staff to project"));
    }

    private void setHeader() {
        removeHeaderRow();

        setHeader(0, Application.getConstants().item(), HasHorizontalAlignment.ALIGN_RIGHT, "140px");
        setHeader(1, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(2, Application.getConstants().currency(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(3, Application.getConstants().billingRate(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(4, Application.getConstants().timeUnit(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(5, Application.getConstants().hoursNotBilled(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(6, Application.getConstants().valueToBill(), HasHorizontalAlignment.ALIGN_LEFT, "70px");
        setHeader(7, "", HasHorizontalAlignment.ALIGN_RIGHT, "52px", "invoiceDetailsToolbar");
    }

    public void setValues() {
        removeAllRows();
        for (int row = 0; row < lines.size(); row++) {
            StaffLine idline = lines.get(row);
            setWidget(row, 0, idline.sbStaff);
            setWidget(row, 1, idline.txDescription);
            setWidget(row, 2, idline.currency);
            setWidget(row, 3, idline.billingRate);
            setWidget(row, 4, idline.timeUnit);
            setWidget(row, 5, idline.billableHours);
            setWidget(row, 6, idline.valueToBill);
            setWidget(row, 7, idline.toolbar);
            for (int i = 0; i < 8; i++) {
                getCellFormatter().setStyleName(row, i, NETNUMERO_ROW);
            }
        }
    }

    public void saveValuesFromUi() {
        project.fProjectStaffDetails.clear();
        for (int row = 0; row < lines.size(); row++) {
            StaffLine idline = lines.get(row);
            idline.saveValuesFromUi();
            project.fProjectStaffDetails.add(idline.projectStaffDetail);
        }
    }

    public void removeEmptyRows() {
        for (int row = 0; row < lines.size(); row++) {
            StaffLine idline = lines.get(row);
            idline.remove();
        }
    }

    public void paint() {
        setHeader();
        setValues();
    }


    public void setValidator(ValidationProcessor validator) {
        this.validator = validator;
    }

    public Project getProject() {
        return project;
    }

    // inner classes ------------------
    public class StaffLine implements DropDownBox.DropDownBoxHandler {

        ProjectStaffDetail projectStaffDetail;
        StaffSelect sbStaff;
        TextBox txDescription;

        NumberTextBox billingRate;
        TimeUnitComboBox timeUnit;
        CurrencySelect currency;

        NumberTextBox billableHours;
        NumberTextBox valueToBill;

        TableDetailToolbar toolbar;

        StaffLine(ProjectStaffDetail idc) {
            projectStaffDetail = idc;

            sbStaff = new StaffSelect(this, getListService, saveService, staffPanel);
            sbStaff.setStaff(projectStaffDetail.fStaffId.getValue(), projectStaffDetail.fName.getValue());

            txDescription = new TextBox();
            txDescription.setValue(projectStaffDetail.getDescription());

            currency = new CurrencySelect(getCurrenciesService, businessAccountSaveService);
            currency.setPojo(projectStaffDetail.fCurrency.getValue());
            currency.setWidth("60px");
            currency.setHandler(new DropDownBoxHandler() {
                @Override
                public void itemSelected(Suggestion pojo) {
                    CurrencyEnum currency = (CurrencyEnum) pojo;
                    billingRate.setCurrency(currency);
                    valueToBill.setCurrency(currency);
                    eventManager.fireEvent(new ProjectValuationChangedEvent("staff currency change"));
                }
            });

            billingRate = new NumberTextBox(projectStaffDetail.fCurrency.getValue()) {
                public void stopEdit() {
                    super.stopEdit();
                    eventManager.fireEvent(new ProjectValuationChangedEvent("staff amount change"));
                }
            };
            billingRate.setAmount(projectStaffDetail.fBillingRate.getValue());

            timeUnit = new TimeUnitComboBox();
            timeUnit.setValue(projectStaffDetail.fTimeUnit.getValue());
            timeUnit.setWidth("90px");
            timeUnit.addChangeHandler(new ChangeHandler() {
                @Override
                public void onChange(ChangeEvent changeEvent) {
                    eventManager.fireEvent(new ProjectValuationChangedEvent("staff timeunit change"));
                }
            });

            billableHours = new NumberTextBox();
            billableHours.setAmount(0);

            valueToBill = new NumberTextBox();
            valueToBill.setAmount(0);

            toolbar = new TableDetailToolbar();

            toolbar.getBtDelete().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    destroy();
                }
            });
            toolbar.getBtMoveUp().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    moveUp();
                }
            });
            toolbar.getBtMoveDown().addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    moveDown();
                }
            });
            addValidators();
            setLineValues();
        }

        void setLineValues() {
            txDescription.setText(projectStaffDetail.getDescription());
            currency.setPojo(projectStaffDetail.fCurrency.getValue());
            billingRate.setAmount(projectStaffDetail.fBillingRate.getValue());
            timeUnit.setValue(projectStaffDetail.fTimeUnit.getValue());
        }

        int getRow() {
            return lines.indexOf(StaffLine.this);
        }

        void moveUp() {
            int row = getRow();
            if (row > 0) {
                lines.set(row, lines.get(row - 1));
                lines.set(row - 1, StaffLine.this);
                setValues();
            }
        }

        void moveDown() {
            int row = getRow();
            if (row < lines.size() - 1) {
                lines.set(row, lines.get(row + 1));
                lines.set(row + 1, StaffLine.this);
                setValues();
            }
        }

        void destroy() {
            validator.removeValidators("Item" + this);
            removeRow(getRow());
            lines.remove(StaffLine.this);
            eventManager.fireEvent(new ProjectValuationChangedEvent("removed staff from project"));
        }

        void edit() {
            validator.removeValidators("Item" + this);
            Staff staff = this.getSbStaff().getPojo();
            final StaffViewDialog dlg = new StaffViewDialog(saveService, staffPanel, staff);
            dlg.center();
        }

        void remove() {
            if (this.getSbStaff().getSuggestBox().getText() == null || this.getSbStaff().getSuggestBox().getText().length() == 0) {
                destroy();
            }
        }

        public void saveValuesFromUi() {
            projectStaffDetail.fName.setValue(sbStaff.getSuggestBox().getText());
            projectStaffDetail.setDescription(txDescription.getText());
            projectStaffDetail.fBillingRate.setValue(billingRate.getAmount());
            projectStaffDetail.fTimeUnit.setValue(timeUnit.getValue());
            projectStaffDetail.fCurrency.setValue(currency.getPojo());
        }

        @Override
        public void itemSelected(Suggestion pojo) {
            Staff staffC = (Staff) pojo;
            projectStaffDetail.fName.setValue(staffC.fName.getValue());
            projectStaffDetail.fDescription.setValue(staffC.fDescription.getValue());
            projectStaffDetail.fBillingRate.setValue(staffC.fBillingRate.getValue());
            projectStaffDetail.fCurrency.setValue(staffC.fCurrency.getValue());
            projectStaffDetail.fTimeUnit.setValue(staffC.fTimeUnit.getValue());
            valuesChanged();
        }

        void valuesChanged() {
            setLineValues();
        }

        private void addValidators() {
        }

        public StaffSelect getSbStaff() {
            return sbStaff;
        }

        public NumberTextBox getBillingRate() {
            return billingRate;
        }

        public void setBillingRate(NumberTextBox billingRate) {
            this.billingRate = billingRate;
        }
    }
}
