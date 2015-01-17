package com.numhero.shared.exception;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ClientWarningException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getMessage(com.numhero.shared.exception.ClientWarningException instance) /*-{
    return instance.@com.numhero.shared.exception.ClientWarningException::message;
  }-*/;
  
  private static native void setMessage(com.numhero.shared.exception.ClientWarningException instance, java.lang.String value) 
  /*-{
    instance.@com.numhero.shared.exception.ClientWarningException::message = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.exception.ClientWarningException instance) throws SerializationException {
    setMessage(instance, streamReader.readString());
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.exception.ClientWarningException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.exception.ClientWarningException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.exception.ClientWarningException instance) throws SerializationException {
    streamWriter.writeString(getMessage(instance));
    
    com.google.gwt.user.client.rpc.core.java.lang.RuntimeException_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.exception.ClientWarningException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.exception.ClientWarningException_FieldSerializer.deserialize(reader, (com.numhero.shared.exception.ClientWarningException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.exception.ClientWarningException_FieldSerializer.serialize(writer, (com.numhero.shared.exception.ClientWarningException)object);
  }
  
}
