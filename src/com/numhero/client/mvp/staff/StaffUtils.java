package com.numhero.client.mvp.staff;

import com.google.gwt.user.client.Window;
import com.numhero.client.Application;
import com.numhero.client.ClientCache;
import com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest;
import com.numhero.client.mvp.PageView;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.ClientUtils;
import com.numhero.shared.datacargo.BulkActionResponse;
import com.numhero.shared.enums.ReceiptStatusEnum;

import java.util.List;

public class StaffUtils {

    public static void directPayment(Service<DirectPaymentStaffListRequest, BulkActionResponse> directPaymentStaffService,
                                     List<Long> ids,
                                     ReceiptStatusEnum status, PageView view) {
        if (ClientUtils.warnNotEmptyIds(ids, view)) return;
        DirectPaymentStaffListRequest request = new DirectPaymentStaffListRequest();
        request.setStatus(status);
        request.setEntityIdList(ids);
        request.setCountryCode(ClientCache.getCurrentBA().fCountry.getValue());
        directPaymentStaffService.execute(request, new ServiceCallbackImpl<BulkActionResponse>() {
            @Override
            public void onSuccess(BulkActionResponse response) {
                if (!response.getFailureIdList().isEmpty()) {
                    Window.alert(Application.getConstants().errorDeleting());
                } else {
                    Application.toasterMessage(Application.getConstants().expensesProcessed());
                }
            }
        });
    }

}
