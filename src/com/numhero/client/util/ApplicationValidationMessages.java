package com.numhero.client.util;

import com.numhero.client.Application;
import eu.maydu.gwt.validation.client.i18n.ValidationMessages;

public class ApplicationValidationMessages extends ValidationMessages {
	@Override
	public String getPropertyName(String propertyName) {
		return propertyName;
	}

	@Override
	public String getCustomMessage(String key, Object... parameters) {
		return Application.getConstants().validationMessages().get(key);
	}
}
