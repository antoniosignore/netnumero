package com.google.gwt.canvas.dom.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Context2d_LineCap_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.canvas.dom.client.Context2d.LineCap instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.google.gwt.canvas.dom.client.Context2d.LineCap instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.google.gwt.canvas.dom.client.Context2d.LineCap[] values = com.google.gwt.canvas.dom.client.Context2d.LineCap.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.canvas.dom.client.Context2d.LineCap instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.canvas.dom.client.Context2d_LineCap_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.canvas.dom.client.Context2d_LineCap_FieldSerializer.deserialize(reader, (com.google.gwt.canvas.dom.client.Context2d.LineCap)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.canvas.dom.client.Context2d_LineCap_FieldSerializer.serialize(writer, (com.google.gwt.canvas.dom.client.Context2d.LineCap)object);
  }
  
}
