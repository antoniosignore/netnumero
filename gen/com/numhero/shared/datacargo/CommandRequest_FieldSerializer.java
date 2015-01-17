package com.numhero.shared.datacargo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CommandRequest_FieldSerializer {
  private static native java.lang.String getBusinessAccountId(com.numhero.shared.datacargo.CommandRequest instance) /*-{
    return instance.@com.numhero.shared.datacargo.CommandRequest::businessAccountId;
  }-*/;
  
  private static native void setBusinessAccountId(com.numhero.shared.datacargo.CommandRequest instance, java.lang.String value) 
  /*-{
    instance.@com.numhero.shared.datacargo.CommandRequest::businessAccountId = value;
  }-*/;
  
  private static native com.numhero.shared.service.ApplicationCommandEnum getCommand(com.numhero.shared.datacargo.CommandRequest instance) /*-{
    return instance.@com.numhero.shared.datacargo.CommandRequest::command;
  }-*/;
  
  private static native void setCommand(com.numhero.shared.datacargo.CommandRequest instance, com.numhero.shared.service.ApplicationCommandEnum value) 
  /*-{
    instance.@com.numhero.shared.datacargo.CommandRequest::command = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.datacargo.CommandRequest instance) throws SerializationException {
    setBusinessAccountId(instance, streamReader.readString());
    setCommand(instance, (com.numhero.shared.service.ApplicationCommandEnum) streamReader.readObject());
    
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.datacargo.CommandRequest instance) throws SerializationException {
    streamWriter.writeString(getBusinessAccountId(instance));
    streamWriter.writeObject(getCommand(instance));
    
  }
  
}
