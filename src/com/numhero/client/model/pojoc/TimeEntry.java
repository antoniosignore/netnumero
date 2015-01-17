package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.ui.SuggestOracle;
import com.numhero.shared.pojoc.BAPojo;
import com.numhero.shared.pojoc.field.*;

import java.util.Date;

public class TimeEntry extends BAPojo implements SuggestOracle.Suggestion {

    public static final String DATE = "date";
    public static final String STAFF_ID = "staffId";
    public static final String STAFF_NAME = "staffName";
    public static final String PROJECT_ID = "projectId";
    public static final String TASK_ID = "taskId";
    public static final String PROJECT_NAME = "projectName";
    public static final String TASK_NAME = "taskName";
    public static final String NOTES = "notes";
    public static final String HOURS = "hours";
    public static final String BILLED = "billed";

    public DateTimeField fDate = dateTimeField(DATE, new Date());
    public IdField fStaffId = idField(STAFF_ID);
    public StringField fStaffName = stringField(STAFF_NAME, 100);
    public IdField fProjectId = idField(PROJECT_ID);
    public IdField fTaskId = idField(TASK_ID);
    public StringField fProjectName = stringField(PROJECT_NAME, 100);
    public StringField fTaskName = stringField(TASK_NAME, 100);
    public StringField fNotes = stringField(NOTES, 100);
    public DoubleField fHours = doubleField(HOURS, 0D);
    public BooleanField fBilled = booleanField(BILLED);

    @Override
    public String getDisplayString() {
        return fName.getValue();
    }

    @Override
    public String getReplacementString() {
        return fName.getValue();
    }
}
