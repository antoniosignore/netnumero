package com.numhero.client.mvp;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.HasValue;
import com.numhero.client.util.ApplicationValidationMessages;
import com.numhero.client.widget.NetNumeroButton;
import com.numhero.shared.pojoc.EntityPojo;
import eu.maydu.gwt.validation.client.DefaultValidationProcessor;
import eu.maydu.gwt.validation.client.ValidationProcessor;
import eu.maydu.gwt.validation.client.Validator;
import eu.maydu.gwt.validation.client.actions.DisclosureTextAction;
import eu.maydu.gwt.validation.client.actions.FocusAction;
import eu.maydu.gwt.validation.client.actions.StyleAction;
import eu.maydu.gwt.validation.client.i18n.ValidationMessages;
import eu.maydu.gwt.validation.client.validators.numeric.DoubleValidator;
import eu.maydu.gwt.validation.client.validators.standard.NotEmptyValidator;
import eu.maydu.gwt.validation.client.validators.standard.RegularExpressionValidator;

@SuppressWarnings({"unchecked", "rawtypes"})
public abstract class AbstractEditEntityPanel extends Composite {
    protected EntityPojo pojo; //TODO remove from here, should be stateless

    public ValidationProcessor validator;
    private DisclosurePanel errorsPanel;
    private FocusAction focusAction;

    public void setPojo(EntityPojo pojo) {
        this.pojo = pojo;
        resetValidator();
    }

    public abstract boolean saveValuesFromUi();

    public abstract NetNumeroButton getBtSave();

    public abstract NetNumeroButton getBtCancel();

    protected void createValidator(DisclosurePanel errorsPanel) {
        this.errorsPanel = errorsPanel;
        errorsPanel.setVisible(false);
        validator = new DefaultValidationProcessor(createValidationMessages());
        validator.addGlobalAction(new DisclosureTextAction(errorsPanel, "error", " "));
        focusAction = new FocusAction();
    }

    protected void resetValidator() {
        errorsPanel.setVisible(false);
        validator.reset();
        validator.removeAllValidators();
        addValidators();
    }

    protected void addValidators(String name, Validator... validators) {
        for (Validator v : validators) {
            v.addActionForFailure(focusAction);
            v.addActionForFailure(new StyleAction("validation-failed"));
        }
        validator.addValidators(name, validators);
    }

    protected ValidationMessages createValidationMessages() {
        return new ApplicationValidationMessages();
    }

    protected abstract void addValidators();

    protected Validator notEmptyValidator(HasValue<String> control) {
        return new NotEmptyValidator<HasValue<String>>(control, true, "required");
    }

    protected Validator doubleValidator(HasValue<String> control, float min, float max, boolean required) {
        Validator ret = new DoubleValidator<HasValue<String>>(control, min, max);
        ret.setRequired(required);
        return ret;
    }

    protected Validator emailValidator(HasValue<String> control, boolean required) {
        Validator ret = new RegularExpressionValidator<HasValue<String>>(control, "^([a-zA-Z0-9_.\\-+])+@(([a-zA-Z0-9\\-])+\\.)+[a-zA-Z0-9]{2,4}$", "isNotAnEmail");
        ret.setRequired(required);
        return ret;
    }

    protected Validator phoneValidator(HasValue<String> control, boolean required) {
        Validator ret = new RegularExpressionValidator<HasValue<String>>(control, "\\d{3,}", "isNotAPhone");
        ret.setRequired(required);
        return ret;
    }

    protected Validator zipCodeValidator(HasValue<String> control, boolean required) {
        Validator ret = new RegularExpressionValidator<HasValue<String>>(control, "^[a-zA-Z0-9]*$", "invalidCharacters");
        ret.setRequired(required);
        return ret;
    }

    protected Validator alphaNumValidator(HasValue<String> control, boolean required) {
        Validator ret = new RegularExpressionValidator<HasValue<String>>(control, "^\\w*$", "invalidCharacters");
        ret.setRequired(required);
        return ret;
    }

    protected Validator urlValidator(HasValue<String> control, boolean required) {
        Validator ret = new RegularExpressionValidator<HasValue<String>>(control,
                "^(https?://){0,1}" + "?(([0-9a-zA-Z_!~*'().&=+$%-]+: )?[0-9a-zA-Z_!~*'().&=+$%-]+@)?" //user@
                        + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP- 199.194.52.184
                        + "|" // allows either IP or domain
                        + "([0-9a-zA-Z_!~*'()-]+\\.)*" // tertiary domain(s)- www.
                        + "([0-9a-zA-Z][0-9a-zA-Z-]{0,61})?[0-9a-zA-Z]\\." // second level domain
                        + "[a-zA-Z]{2,6})" // first level domain- .com or .museum
                        + "(:[0-9]{1,4})?" // port number- :80
                        + "((/?)|" // a slash isn't required if there is no file name
                        + "(/[0-9a-zA-Z_!~*'().;?:@&=+$,%#-]+)+/?)\\s*$", "url");
        ret.setRequired(required);
        return ret;
    }


    public EntityPojo getPojo() { //todo mikado -> not sure pojo should stay here
        return pojo;

    }

//    public abstract String getConstantsNewEntity();
//
//
//
//    public abstract String getConstantsEditEntity();

}
