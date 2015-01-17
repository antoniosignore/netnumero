package com.numhero.client.model.datacargo.auth;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AuthResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Date getExpirationDate(com.numhero.client.model.datacargo.auth.AuthResponse instance) /*-{
    return instance.@com.numhero.client.model.datacargo.auth.AuthResponse::expirationDate;
  }-*/;
  
  private static native void setExpirationDate(com.numhero.client.model.datacargo.auth.AuthResponse instance, java.util.Date value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.auth.AuthResponse::expirationDate = value;
  }-*/;
  
  private static native java.lang.String getSessionID(com.numhero.client.model.datacargo.auth.AuthResponse instance) /*-{
    return instance.@com.numhero.client.model.datacargo.auth.AuthResponse::sessionID;
  }-*/;
  
  private static native void setSessionID(com.numhero.client.model.datacargo.auth.AuthResponse instance, java.lang.String value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.auth.AuthResponse::sessionID = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.auth.AuthResponse instance) throws SerializationException {
    setExpirationDate(instance, (java.util.Date) streamReader.readObject());
    setSessionID(instance, streamReader.readString());
    
  }
  
  public static com.numhero.client.model.datacargo.auth.AuthResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.auth.AuthResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.auth.AuthResponse instance) throws SerializationException {
    streamWriter.writeObject(getExpirationDate(instance));
    streamWriter.writeString(getSessionID(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.auth.AuthResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.auth.AuthResponse_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.auth.AuthResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.auth.AuthResponse_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.auth.AuthResponse)object);
  }
  
}
