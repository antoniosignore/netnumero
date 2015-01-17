package com.numhero.shared.datacargo;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ListCommandRequest_TYPE_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.datacargo.ListCommandRequest.TYPE instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.numhero.shared.datacargo.ListCommandRequest.TYPE instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.numhero.shared.datacargo.ListCommandRequest.TYPE[] values = com.numhero.shared.datacargo.ListCommandRequest.TYPE.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.datacargo.ListCommandRequest.TYPE instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.datacargo.ListCommandRequest_TYPE_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.datacargo.ListCommandRequest_TYPE_FieldSerializer.deserialize(reader, (com.numhero.shared.datacargo.ListCommandRequest.TYPE)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.datacargo.ListCommandRequest_TYPE_FieldSerializer.serialize(writer, (com.numhero.shared.datacargo.ListCommandRequest.TYPE)object);
  }
  
}
