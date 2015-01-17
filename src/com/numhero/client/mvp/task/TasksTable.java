package com.numhero.client.mvp.task;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.Task;
import com.numhero.client.mvp.AbstractTableForEntities;

import java.util.List;

public class TasksTable extends AbstractTableForEntities<Task> {

    @Override
    public void setEntities(List<Task> taskCs) {
        removeAllRows();
        int row = 0;
        for (Task taskC : taskCs) {
            row++;
            HTML hID = new HTML("<a href='#task/" + taskC.getId() + "'>" + taskC.fName.getValue() + "</a>");
            setWidget(row, 0, getCheckbox(taskC.getId()));
            setWidget(row, 1, hID);

            setText(row, 2, taskC.getDescription());
            if (taskC.getCreated() != null)
                setText(row, 3, DateTimeFormat.getShortDateFormat().format(taskC.getCreated()));
            else
                setText(row, 3, "");

            if (taskC.fBillable.getValue() != null)  {
                setText(row, 4, taskC.fBillingRate.getValueAsString());
                setText(row, 5, taskC.fCurrency.getValueAsString());
            }
            else  {
                setText(row, 4, "");
                setText(row, 5, "");
            }

        }
        addEmptyStatus();
    }




	protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().name(), HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(2, Application.getConstants().description(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(3, Application.getConstants().billable(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(4, Application.getConstants().billingRate(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(5, Application.getConstants().currency(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
    }
}
