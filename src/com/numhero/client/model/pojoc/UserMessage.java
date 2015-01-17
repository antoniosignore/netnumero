package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;
import com.numhero.shared.enums.MessageTypeEnum;
import com.numhero.shared.pojoc.SearchablePojo;
import com.numhero.shared.pojoc.field.EnumField;
import com.numhero.shared.pojoc.field.StringField;

public class UserMessage extends SearchablePojo implements Suggestion {
	private static final long serialVersionUID = 802252962267607348L;

	private static final String MESSAGE_TYPE = "messageType";

    public StringField fMessage = stringField("message", 2048);
    public EnumField<MessageTypeEnum> fMessageType = enumField(MESSAGE_TYPE, MessageTypeEnum.Feedback);


    @Override
    public String getDisplayString() {
        return fName.getValue();
    }

    @Override
    public String getReplacementString() {
        return fName.getValue();
    }

    public UserMessage clone() {
        UserMessage ret = new UserMessage();
        ret.copyFrom(this);
        return ret;
    }
    
    @Override
    public String getKind() {
    	return "UserMessage";
    }
}
