package com.numhero.client.mvp.users;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.numhero.client.Application;
import com.numhero.client.model.datacargo.user.GetUserRequest;
import com.numhero.client.model.datacargo.user.GetUserResponse;
import com.numhero.client.model.datacargo.user.SaveUserRequest;
import com.numhero.client.model.datacargo.user.SaveUserResponse;
import com.numhero.client.model.pojoc.User;
import com.numhero.client.mvp.BasePresenter;
import com.numhero.client.place.PlaceManager;
import com.numhero.client.service.Service;
import com.numhero.client.service.ServiceCallbackImpl;
import com.numhero.client.util.LocationUtils;

@Singleton
public class UserPresenter extends BasePresenter {
    Service<GetUserRequest, GetUserResponse> userGetService;
    Service<SaveUserRequest, SaveUserResponse> userSaveService;

    @Inject
    public UserPresenter(PlaceManager eventManager,
                         Service<GetUserRequest, GetUserResponse> userGetService,
                         Service<SaveUserRequest, SaveUserResponse> userSaveService,
                         UserView userView) {
        super(eventManager, userView);
        this.userGetService = userGetService;
        this.userSaveService = userSaveService;
    }

    @Override
    public UserView getView() {
        return (UserView) super.getView();
    }

    @Override
    public void onShow() {
        if (getUrl().getId() == null) {
            getView().getUserPanel().setPojo(new User());
        } else {
            GetUserRequest request = new GetUserRequest();
            request.setEntityId(getUrl().getId());
            userGetService.execute(request, new ServiceCallbackImpl<GetUserResponse>() {
                @Override
                public void onSuccess(GetUserResponse response) {
                    getView().getUserPanel().setPojo(response.getEntity());
                }
            });
        }
    }
    
    @Override
    protected void onBind() {
    	super.onBind();
    	UserPanel panel = getView().getUserPanel();
    	panel.getBtSave().addClickHandler(saveUserHandler());
    }

    private ClickHandler saveUserHandler() {
        ClickHandler ret = new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                SaveUserRequest request = new SaveUserRequest();
                if (getView().getUserPanel().saveValuesFromUi()) {
                    request.setUser(getView().getUserPanel().getUser());

                    userSaveService.execute(request, new ServiceCallbackImpl<SaveUserResponse>() {
                        @Override
                        public void onSuccess(SaveUserResponse response) {
                            Application.toasterMessage(Application.getConstants().userSaved());
                            LocationUtils.redirect("#users");
                        }
                    });
                }
            }
        };
        return ret;
    }
}
