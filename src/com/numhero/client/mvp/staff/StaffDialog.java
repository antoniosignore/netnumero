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
import com.numhero.shared.enums.StaffTypeEnum;

public class StaffDialog extends DialogBox {
    private Staff staff;

    public StaffDialog(final Service<SaveStaffRequest, SaveStaffResponse> staffSaveService,
                       final StaffPanel staffPanel,
                       String staffName,
                       StaffTypeEnum type) {

        setText(Application.getConstants().staff());
        setModal(true);
        setGlassEnabled(true);
        setAnimationEnabled(true);

        staff = new Staff();
        staff.fName.setValue(staffName);
        staff.fStaffType.setValue(type);

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
                            StaffDialog.this.hide();
                        }
                    });
                }
            }
        });
        staffPanel.getBtCancel().addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                StaffDialog.this.hide();
            }
        });
        setWidget(staffPanel);
    }

    public Staff getStaff() {
        return staff;
    }

}
