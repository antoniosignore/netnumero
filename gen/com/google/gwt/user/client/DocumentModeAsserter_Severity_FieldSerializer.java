package com.google.gwt.user.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class DocumentModeAsserter_Severity_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.user.client.DocumentModeAsserter.Severity instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.google.gwt.user.client.DocumentModeAsserter.Severity instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.google.gwt.user.client.DocumentModeAsserter.Severity[] values = com.google.gwt.user.client.DocumentModeAsserter.Severity.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.user.client.DocumentModeAsserter.Severity instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.user.client.DocumentModeAsserter_Severity_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.user.client.DocumentModeAsserter_Severity_FieldSerializer.deserialize(reader, (com.google.gwt.user.client.DocumentModeAsserter.Severity)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.user.client.DocumentModeAsserter_Severity_FieldSerializer.serialize(writer, (com.google.gwt.user.client.DocumentModeAsserter.Severity)object);
  }
  
}
