package com.numhero.client.model.datacargo.auth;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AuthRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getHttpSessionID(com.numhero.client.model.datacargo.auth.AuthRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.auth.AuthRequest::httpSessionID;
  }-*/;
  
  private static native void setHttpSessionID(com.numhero.client.model.datacargo.auth.AuthRequest instance, java.lang.String value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.auth.AuthRequest::httpSessionID = value;
  }-*/;
  
  private static native java.lang.String getPassword(com.numhero.client.model.datacargo.auth.AuthRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.auth.AuthRequest::password;
  }-*/;
  
  private static native void setPassword(com.numhero.client.model.datacargo.auth.AuthRequest instance, java.lang.String value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.auth.AuthRequest::password = value;
  }-*/;
  
  private static native java.lang.String getUsername(com.numhero.client.model.datacargo.auth.AuthRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.auth.AuthRequest::username;
  }-*/;
  
  private static native void setUsername(com.numhero.client.model.datacargo.auth.AuthRequest instance, java.lang.String value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.auth.AuthRequest::username = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.auth.AuthRequest instance) throws SerializationException {
    setHttpSessionID(instance, streamReader.readString());
    setPassword(instance, streamReader.readString());
    setUsername(instance, streamReader.readString());
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.auth.AuthRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.auth.AuthRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.auth.AuthRequest instance) throws SerializationException {
    streamWriter.writeString(getHttpSessionID(instance));
    streamWriter.writeString(getPassword(instance));
    streamWriter.writeString(getUsername(instance));
    
    com.numhero.shared.datacargo.CommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.auth.AuthRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.auth.AuthRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.auth.AuthRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.auth.AuthRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.auth.AuthRequest)object);
  }
  
}
