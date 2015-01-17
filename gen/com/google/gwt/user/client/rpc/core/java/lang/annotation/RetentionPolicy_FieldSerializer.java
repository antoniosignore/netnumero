package com.google.gwt.user.client.rpc.core.java.lang.annotation;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class RetentionPolicy_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, java.lang.annotation.RetentionPolicy instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static java.lang.annotation.RetentionPolicy instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    java.lang.annotation.RetentionPolicy[] values = java.lang.annotation.RetentionPolicy.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, java.lang.annotation.RetentionPolicy instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.user.client.rpc.core.java.lang.annotation.RetentionPolicy_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.annotation.RetentionPolicy_FieldSerializer.deserialize(reader, (java.lang.annotation.RetentionPolicy)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.annotation.RetentionPolicy_FieldSerializer.serialize(writer, (java.lang.annotation.RetentionPolicy)object);
  }
  
}
