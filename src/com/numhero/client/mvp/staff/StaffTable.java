package com.numhero.client.mvp.staff;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.numhero.client.Application;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.client.mvp.AbstractTableForEntities;
import com.numhero.shared.enums.StaffTypeEnum;

import java.util.List;

public class StaffTable extends AbstractTableForEntities<Staff>{


    public StaffTable() {
    }

    @Override
    public void setEntities(List<Staff> staffCollection) {
        removeAllRows();
        int row = 0;
        for (Staff staff : staffCollection) {
            row++;
            HTML hID;
            if (staff.getStaffType() == StaffTypeEnum.Internal)
                hID = new HTML("<a href='#internal/" + staff.getId() + "'>" + staff.fName.getValue() + "</a>");
            else
                hID = new HTML("<a href='#contractor/" + staff.getId() + "'>" + staff.fName.getValue() + "</a>");

            setWidget(row, 0, getCheckbox(staff.getId()));
            setWidget(row, 1, hID);
            setText(row, 2, staff.getEmail());
            setText(row, 3, staff.getPhone());
            setText(row, 4, staff.getAddress());
            setText(row, 5, staff.getNotes());
        }
        addEmptyStatus();
    }

	protected void setHeader() {
        setHeader(0, "", HasHorizontalAlignment.ALIGN_CENTER, "20px");
        setHeader(1, Application.getConstants().name(), HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(2, Application.getConstants().email(), HasHorizontalAlignment.ALIGN_LEFT, "140px");
        setHeader(3, Application.getConstants().phone(), HasHorizontalAlignment.ALIGN_LEFT, "80px");
        setHeader(4, Application.getConstants().address(), HasHorizontalAlignment.ALIGN_LEFT, "200px");
        setHeader(5, Application.getConstants().notes(), HasHorizontalAlignment.ALIGN_LEFT, "%");
    }
}
