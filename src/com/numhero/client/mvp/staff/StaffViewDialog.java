package com.numhero.client.mvp.staff;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.DialogBox;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.staff.SaveStaffRequest;
import com.numhero.client.model.datacargo.staff.SaveStaffResponse;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;

public class StaffViewDialog extends DialogBox {

    public StaffViewDialog(final Service<SaveStaffRequest, SaveStaffResponse> staffSaveService, final StaffPanel staffPanel, final Staff staff) {

        setText(Application.getConstants().staff());
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);

        staffPanel.setPojo(staff);

        staffPanel.getBtSave().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (staffPanel.saveValuesFromUi()) {
                    SaveStaffRequest request = new SaveStaffRequest();
                    request.setStaff(staff);
                    Application.showGlasspanelLoading();
                    staffSaveService.execute(request, new ServiceCallbackImpl<SaveStaffResponse>() {
                        @Override
                        public void onSuccess(SaveStaffResponse response) {
                            Application.toasterMessage(Application.getConstants().staffSaved());
                            staff.setId(response.getEntityId());
                            StaffViewDialog.this.hide();
                        }
                    });
                }
            }
        });
        staffPanel.getBtCancel().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                StaffViewDialog.this.hide();
            }
        });
        setWidget(staffPanel);
    }
}
