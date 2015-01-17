package com.numhero.client.widget.table;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MouseEvent_EventType_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.widget.table.MouseEvent.EventType instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.numhero.client.widget.table.MouseEvent.EventType instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.numhero.client.widget.table.MouseEvent.EventType[] values = com.numhero.client.widget.table.MouseEvent.EventType.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.widget.table.MouseEvent.EventType instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.widget.table.MouseEvent_EventType_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.widget.table.MouseEvent_EventType_FieldSerializer.deserialize(reader, (com.numhero.client.widget.table.MouseEvent.EventType)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.widget.table.MouseEvent_EventType_FieldSerializer.serialize(writer, (com.numhero.client.widget.table.MouseEvent.EventType)object);
  }
  
}
