package com.numhero.client.util;

import com.google.gwt.user.client.Window;
import com.numhero.client.Application;

public class ClientDialogUtils {
    // current user utils -----------------------------------------
    // public static boolean isGranted(GrantType grant, RoleType userRole) {
    // boolean forEverybody = userRole == null && grant ==
    // GrantType.FOR_EVERYBODY;
    // boolean specificForUser = userRole != null && userRole.isGranted(grant);
    // return forEverybody || specificForUser;
    // }

    // dialog & header messages -----------------------------------------
//    public static void showMessageDialog(String message) {
//        // SC.say(message);
//    }

    public static void showWarningDialog(String message) {
        // SC.warn(message, null);

		Window.alert(message);
    }

//    public static void showMessageDialog(String message, String largeContent) {
//        // MessageDialog dialog = new MessageDialog("Message", 600, 400);
//        // dialog.setMessage(message);
//        // dialog.setLargeContent(largeContent);
//        // dialog.show();
//    }

//    public static void showServerDownErrorMessage() {
//        // showMessageDialog(constants.ServerCommunicationFailed());
//    }
//
//    public static void showGenericErrorMessage() {
//        // showMessageDialog(constants.GenericException());
//    }

    public static void showGeneralError() {
        showWarningDialog(Application.getConstants().generalUntranslatedErrorMessage());
    }
    
    public static void showErrorMessage(String message) {
        showWarningDialog(message);
    }

    // public static void showGenericErrorMessage(ApplicationException ae) {
    // showApplicationError(ae);
    // }
    //
    // private static void showApplicationError(ApplicationException ae) {
    // final Dialog dialog = new Dialog();
    // dialog.setShowShadow(true);
    // dialog.setIsModal(true);
    // dialog.setShowModalMask(true);
    // dialog.setShadowDepth(5);
    // dialog.setWidth(600);
    // dialog.setHeight(400);
    // dialog.setShowMinimizeButton(false);
    // dialog.setShowCloseButton(false);
    // dialog.setIsModal(true);
    // dialog.centerInPage();
    // dialog.setTitle("Application error");
    // dialog.setShowTitle(false);
    // dialog.setBackgroundColor("ligthblue");
    //
    // SectionStack sectionStack = new SectionStack();
    // sectionStack.setHeight(350);
    // sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);
    //
    // SectionStackSection errorMessageSection = new
    // SectionStackSection("Error message");
    // errorMessageSection.setExpanded(true);
    // errorMessageSection.setCanCollapse(false);
    // String message = "Error comunicating with server: " + ae.getMessage();
    // final Label messageLabel = new Label(message);
    // messageLabel.setWidth100();
    // messageLabel.setHeight(25);
    // messageLabel.setAlign(Alignment.CENTER);
    // errorMessageSection.addItem(messageLabel);
    // sectionStack.addSection(errorMessageSection);
    //
    // Button closeButton = new Button("Close");
    // closeButton.setAlign(Alignment.CENTER);
    // closeButton.addClickHandler(new ClickHandler() {
    // public void onClick(ClickEvent arg0) {
    // dialog.destroy();
    // }
    // });
    //
    // TextArea errorDetails = new TextArea();
    // errorDetails.setWidth("580");
    // errorDetails.setHeight("280");
    // errorDetails.setText(ae.getFormattedStackTrace());
    // Canvas errorDetailsCanvas = new HLayout();
    // errorDetailsCanvas.addChild(errorDetails);
    //
    // SectionStackSection errorDetailsSection = new
    // SectionStackSection("Error details");
    // errorDetailsSection.setExpanded(false);
    // errorDetailsSection.setCanCollapse(true);
    // errorDetailsSection.addItem(errorDetailsCanvas);
    // sectionStack.addSection(errorDetailsSection);
    //
    // dialog.addMember(sectionStack);
    // dialog.addMember(closeButton);
    //
    // dialog.show();
    // }
}
