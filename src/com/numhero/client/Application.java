package com.numhero.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountRequest;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.ApplicationInjector;
import com.numhero.client.widget.InfoPanel;
import com.numhero.shared.datacargo.CommandResponse;

public class Application implements EntryPoint {
    private static LocalizableConstants constants = GWT.create(LocalizableConstants.class);
    private static LocalizableMessages messages = GWT.create(LocalizableMessages.class);

    public static ApplicationInjector injector = GWT.create(ApplicationInjector.class);

    public static PlaceManager placeManager;

    public void onModuleLoad() {
        injector.getApplicationController();

        placeManager = injector.getPlaceManager();

        initCache();
    }

    public static PlaceManager getPlaceManager() {
        return placeManager;
    }

    public static LocalizableConstants getConstants() {
        return constants;
    }

    public static LocalizableMessages getMessages() {
        return messages;
    }

    public static void toasterMessage(String msg) {
        InfoPanel.show("", msg);
    }

    public static void showGlasspanelLoading() {
        RootPanel element = RootPanel.get("glasspanel_loading");
        if (element != null) {
            element.setStyleName("on");
        }
    }

    public static void hideGlasspanelLoading() {
        RootPanel element = RootPanel.get("glasspanel_loading");
        if (element != null) {
            element.removeStyleName("on");
        }
    }

    // private methods ---------------------------------------
    private void initCache() {
//
//
//        Service<GetBusinessAccountRequest, GetBusinessAccountResponse> service =
//                (Service<GetBusinessAccountRequest, GetBusinessAccountResponse>) Application.injector.getAsyncService();
//
//        service.execute(new GetBusinessAccountRequest(), new ServiceCallbackImpl<GetBusinessAccountResponse>() {
//            @Override
//            public void onSuccess(GetBusinessAccountResponse getBusinessAccountResponse) {
//
//                BusinessAccount ba = getBusinessAccountResponse.getEntity();
//
//                placeManager.fireCurrentPlace();
//
//            }
//        });

        //todo mikado: move to somewhereelse
//         placeManager.fireCurrentPlace();

        injector.getClientCache().useCache(new GetBusinessAccountRequest(), new ServiceCallbackImpl<CommandResponse>() {
            @Override
            public void onSuccess(CommandResponse response) {
                placeManager.fireCurrentPlace();
                hideGlasspanelLoading();
            }
        });
    }
}
