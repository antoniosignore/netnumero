package com.numhero.client.mvp;

public interface BaseView {
    void replaceInWrapperDiv();

    //accessors for singletons
    void showGlassPanel();

    void showToaster(String message);

    void showError(String message);

}
