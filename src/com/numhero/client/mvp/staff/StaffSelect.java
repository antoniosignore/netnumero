package com.numhero.client.mvp.staff;

import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.staff.SaveStaffRequest;
import com.numhero.client.model.datacargo.staff.SaveStaffResponse;
import com.numhero.client.model.datacargo.staff.StaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.client.service.Service;
import com.numhero.client.widget.combobox.DropDownBox;
import com.numhero.client.widget.combobox.ServerSuggestOracle;
import com.numhero.client.widget.combobox.ServerSuggestOracle.CommandItem;
import com.numhero.shared.enums.StaffTypeEnum;

public class StaffSelect extends DropDownBox<StaffListRequest, StaffListResponse> {
    private Service<SaveStaffRequest, SaveStaffResponse> saveService;
    private Staff pojo;
    private StaffPanel panel;

    public StaffSelect(
            DropDownBoxHandler handler,
            Service<StaffListRequest, StaffListResponse> getListService,
            Service<SaveStaffRequest, SaveStaffResponse> saveService,
            StaffPanel panel) {
        super(getListService, new StaffListRequest());
        setHandler(handler);

        this.panel = panel;
        this.saveService = saveService;
        initPojo();
    }

    public void setStaff(Long id, String name) {
        pojo.setId(id);
        pojo.fName.setValue(name);
        suggestBox.setValue(name, false);
    }

    @Override
    public void setPojo(Suggestion pojo) {
        super.setPojo(pojo);
        if (pojo instanceof Staff) {
            this.pojo = (Staff) pojo;
        }
    }

    @Override
    public Staff getPojo() {
        return pojo;
    }

    @Override
    protected void initPojo() {
        pojo = new Staff();
    }

    // private methods --------------------------------------------------
    @Override
    protected void commandSelected(CommandItem commandItem) {
        suggestBox.hideSuggestionList();
        if (commandItem.getReplacementString().equals("+i")) {
            showAddNewInternalDialog();
        } else if (commandItem.getReplacementString().equals("+c")) {
            showAddNewContractorDialog();
        } else if (commandItem.getReplacementString().equals(ServerSuggestOracle.CommandItem.moreKey)) {
            showMoreDialog();
        }
    }

    protected void addCommandItems(ServerSuggestOracle<StaffListRequest, StaffListResponse> so) {
        so.addCommandItem(new ServerSuggestOracle.CommandItem("+i", Application.getConstants().newInternal() + "..."));
        so.addCommandItem(new ServerSuggestOracle.CommandItem("+c", Application.getConstants().newContractor() + "..."));
        so.addMoreItem();
    }

    private void showAddNewInternalDialog() {
        final StaffDialog dlg = new StaffDialog(saveService, panel, sso.getLastSuggestRequest(), StaffTypeEnum.Internal);
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getStaff() != null && dlg.getStaff().getId() != null) {
                    suggestBox.setValue(dlg.getStaff().getReplacementString());
                    handler.itemSelected(dlg.getStaff());
                }
            }
        });
        dlg.center();
    }

    private void showAddNewContractorDialog() {
        final StaffDialog dlg = new StaffDialog(saveService, panel, sso.getLastSuggestRequest(), StaffTypeEnum.Contractor);
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getStaff() != null && dlg.getStaff().getId() != null) {
                    suggestBox.setValue(dlg.getStaff().getReplacementString());
                    handler.itemSelected(dlg.getStaff());
                }
            }
        });
        dlg.center();
    }

    private void showMoreDialog() {
        final SearchStaffDialog dlg = new SearchStaffDialog(getListService, sso.getLastSuggestRequest());
        dlg.addCloseHandler(new CloseHandler<PopupPanel>() {
            @Override
            public void onClose(CloseEvent<PopupPanel> event) {
                if (dlg.getPojo() != null && dlg.getPojo().getId() != null) {
                    suggestBox.setValue(dlg.getPojo().fName.getValue());
                    handler.itemSelected(dlg.getPojo());
                }
            }
        });
        dlg.center();
    }
}
