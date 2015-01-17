package com.numhero.client.mvp.staff;

import com.numhero.client.Application;
import com.numhero.client.model.datacargo.staff.StaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.service.Service;
import com.numhero.client.widget.search.SearchPanel;
import com.numhero.client.widget.search.SearchPojoDialog;

public class SearchStaffDialog extends SearchPojoDialog {

    public SearchStaffDialog(Service<StaffListRequest, StaffListResponse> getListService, String search) {
        super(Application.getConstants().searchInternalStaff(), search, getListService, new SearchPanel(new SearchInternalTable()), new StaffListRequest());
    }
}
