package com.numhero.client.mvp.timeentry;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.inject.Inject;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.TimeEntry;
import com.numhero.client.mvp.AbstractTableForEntities;
import com.numhero.client.widget.filter.FilterPanel;
import com.numhero.client.widget.textbox.NumberTextBox;

import java.util.ArrayList;
import java.util.List;

public class TimeEntriesTable extends AbstractTableForEntities<TimeEntry> {
    private List<TimeEntry> timeEntries;

    @Inject
    public TimeEntriesTable(FilterPanel filter) {
        super(filter);
        hideNavigationButtons();
    }

    @UiConstructor
    public TimeEntriesTable() {
        this.hideNavigationButtons();
    }

    @Override
    public void setEntities(List<TimeEntry> timeEntries) {
        removeAllRows();
        this.timeEntries = timeEntries;
        if (timeEntries != null) {
            for (int row = 0; row < timeEntries.size(); row++) {
                TimeEntry entry = timeEntries.get(row);
                HTML hID = new HTML("<a href='#timeentry/" + entry.getId() + "'>" + DateTimeFormat.getShortDateFormat().format(entry.fDate.getValue()) + "</a>");
                setWidget(row, 0, getCheckbox(entry.getId()));
                setWidget(row, 1, hID);
                setText(row, 2, entry.fStaffName.getValue());
                setText(row, 3, entry.fProjectName.getValue());
                setText(row, 4, entry.fTaskName.getValue());
                NumberTextBox timeUnits = new NumberTextBox();
                timeUnits.setAmount(entry.fHours.getValue());
                timeUnits.setReadOnly(true);
                setText(row, 5, entry.fBilled.getValueAsString());
                setText(row, 6, timeUnits.getAmountBox().getText());
            }
        }
        addEmptyStatus();
    }

	protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().date(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(2, Application.getConstants().staff(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(3, Application.getConstants().project(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(4, Application.getConstants().task(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(5, Application.getConstants().billed(), HasHorizontalAlignment.ALIGN_LEFT, "20px");
        setHeader(6, Application.getConstants().hours(), HasHorizontalAlignment.ALIGN_LEFT, "40px");
    }


    public List<TimeEntry> getTimeEntries() {
        return timeEntries;
    }

    public List<TimeEntry> getCheckedTimeEntries() {
        List<TimeEntry> checkedEntries = new ArrayList<TimeEntry>();
        if (timeEntries != null) {
            for (int row = 0; row < timeEntries.size(); row++) {
                TimeEntry entry = timeEntries.get(row);
                CheckBox box = (CheckBox) getWidget(row, 0);
                if (box.getValue()) {
                    checkedEntries.add(entry);
                }
            }
        }
        return checkedEntries;
    }

    public void setHandler(ClickHandler handler) {
        if (timeEntries != null) {
            for (int row = 0; row < timeEntries.size(); row++) {
                ((CheckBox) getWidget(row, 0)).addClickHandler(handler);
            }
        }
    }
}
