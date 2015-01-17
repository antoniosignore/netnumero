package com.numhero.shared.exception;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class NotAuthorizedException_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.exception.NotAuthorizedException instance) throws SerializationException {
    
    com.numhero.shared.exception.ClientWarningException_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.exception.NotAuthorizedException instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.exception.NotAuthorizedException();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.exception.NotAuthorizedException instance) throws SerializationException {
    
    com.numhero.shared.exception.ClientWarningException_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.exception.NotAuthorizedException_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.exception.NotAuthorizedException_FieldSerializer.deserialize(reader, (com.numhero.shared.exception.NotAuthorizedException)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.exception.NotAuthorizedException_FieldSerializer.serialize(writer, (com.numhero.shared.exception.NotAuthorizedException)object);
  }
  
}
