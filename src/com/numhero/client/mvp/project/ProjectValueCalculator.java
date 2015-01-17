package com.numhero.client.mvp.project;

import com.numhero.client.model.pojoc.TimeEntry;
import com.numhero.shared.enums.CurrencyEnum;
import com.numhero.shared.enums.TaskStatusEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectValueCalculator {


    public static void setProjectFlatValuation(ProjectPanel projectPanel) {
        projectPanel.setValuation(projectPanel.getBillingFlatRate().getAmount());
    }

    public static void setProjectRateValuation(ProjectPanel projectPanel) {
        double hourlyRate = InvoiceGenerator.normalizedRateInHours(projectPanel.getTimeUnit().getValue(), projectPanel.getBillingRate().getAmount());
        double numberOfBillableHours = getBillableHours(projectPanel);
        projectPanel.setValuation(hourlyRate * numberOfBillableHours);
        projectPanel.getBillableTime().setText(String.valueOf(numberOfBillableHours));
    }

    public static double getBillableHours(ProjectPanel projectPanel) {
        double numberOfBillableHours = 0D;
        List<TimeEntry> pojos = projectPanel.getTimeEntriesTable().getCheckedTimeEntries();
        if (pojos != null) {
            for (TimeEntry entry : pojos) {
                numberOfBillableHours += entry.fHours.getValue();
            }
        }
        return numberOfBillableHours;
    }

    public static boolean setProjectTaskRateValuation(ProjectPanel projectPanel) {
        boolean isSameCurrency = true;

        ProjectTasksDetailsTable table = projectPanel.getProjectTasksDetailsTable();
        List<ProjectTasksDetailsTable.TaskLine> tasks = table.getLines();
        Map<String, Double> hoursMap = new HashMap<String, Double>();
        for (ProjectTasksDetailsTable.TaskLine taskLine : tasks) {
            CurrencyEnum taskCurrency = taskLine.currency.getPojo();
            if (!taskLine.getSuggestBoxTask().getSuggestBox().getText().isEmpty()) {
                hoursMap.put(taskLine.getSuggestBoxTask().getSuggestBox().getText(), 0D);
                if (taskCurrency != projectPanel.getCbCurrency().getPojo()) {
                    taskLine.currency.setStyleName("error-cell");
                    isSameCurrency = false;
                } else
                    taskLine.currency.setStyleName("gwt-ListBox");
            }
        }

        List<TimeEntry> pojos = projectPanel.getTimeEntriesTable().getCheckedTimeEntries();
        if (pojos != null) {
            for (TimeEntry entry : pojos) {
                String taskName = entry.fTaskName.getValue();
                if (hoursMap.get(taskName) != null)
                    hoursMap.put(taskName, hoursMap.get(taskName) + entry.fHours.getValue());
            }
        }

        Double valuation = 0D;
        Double notBilledHours = 0D;
        for (ProjectTasksDetailsTable.TaskLine taskLine : tasks) {
            if (canTaskBeBilled(taskLine)) {
                taskLine.notBilledHours.setAmount(hoursMap.get(taskLine.getSuggestBoxTask().getSuggestBox().getText()));
                double hourlyRate = InvoiceGenerator.normalizedRateInHours(taskLine.timeUnit.getValue(), taskLine.billingRate.getAmount());

                taskLine.valueToBill.setAmount(hourlyRate * taskLine.notBilledHours.getAmount());
                taskLine.valueToBill.setCurrency(taskLine.currency.getPojo());
                taskLine.billingRate.setCurrency(taskLine.currency.getPojo());

                if (taskLine.valueToBill.getAmount() > 0) taskLine.status.setValue(TaskStatusEnum.working);

                valuation += taskLine.valueToBill.getAmount();
                notBilledHours += taskLine.notBilledHours.getAmount();
            }
        }
        projectPanel.setValuation(valuation);
        projectPanel.getBillableTime().setText(String.valueOf(notBilledHours));

        return isSameCurrency;
    }

    public static boolean canTaskBeBilled(ProjectTasksDetailsTable.TaskLine taskLine) {
        return !taskLine.getSuggestBoxTask().getSuggestBox().getText().isEmpty()
                && taskLine.billable.getText().equals("true");
    }

    public static boolean setProjectStaffRateValuation(ProjectPanel projectPanel) {

        boolean isSameCurrency = true;

        ProjectStaffDetailsTable table = projectPanel.getProjectStaffDetailsTable();
        List<ProjectStaffDetailsTable.StaffLine> staffLines = table.getLines();
        Map<String, Double> hoursMap = new HashMap<String, Double>();
        for (ProjectStaffDetailsTable.StaffLine staffLine : staffLines) {
            CurrencyEnum taskCurrency = staffLine.currency.getPojo();
            if (!staffLine.getSbStaff().getSuggestBox().getText().isEmpty()) {
                hoursMap.put(staffLine.getSbStaff().getSuggestBox().getText(), 0D);
                if (taskCurrency != projectPanel.getCbCurrency().getPojo()) {
                    staffLine.currency.setStyleName("error-cell");
                    isSameCurrency = false;
                } else
                    staffLine.currency.setStyleName("gwt-ListBox");
            }
        }

        List<TimeEntry> pojoc = projectPanel.getTimeEntriesTable().getCheckedTimeEntries();
        if (pojoc != null) {
            for (TimeEntry entry : pojoc) {
                String staffName = entry.fStaffName.getValue();
                if (hoursMap.get(staffName) != null)
                    hoursMap.put(staffName, hoursMap.get(staffName) + entry.fHours.getValue());
            }
        }
        Double valuation = 0D;
        Double notBilledHours = 0D;
        for (ProjectStaffDetailsTable.StaffLine line : staffLines) {
            if (!line.getSbStaff().getSuggestBox().getText().isEmpty()) {
                line.billableHours.setAmount(hoursMap.get(line.getSbStaff().getSuggestBox().getText()));
                double hourlyRate = InvoiceGenerator.normalizedRateInHours(line.timeUnit.getValue(), line.billingRate.getAmount());
                line.valueToBill.setAmount(hourlyRate * line.billableHours.getAmount());
                line.valueToBill.setCurrency(line.currency.getPojo());
                line.billingRate.setCurrency(line.currency.getPojo());

                valuation += line.valueToBill.getAmount();
                notBilledHours += line.billableHours.getAmount();
            }
        }
        projectPanel.setValuation(valuation);
        projectPanel.getBillableTime().setText(String.valueOf(notBilledHours));

        return isSameCurrency;

    }
}
