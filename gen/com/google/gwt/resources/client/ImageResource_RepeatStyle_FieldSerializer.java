package com.google.gwt.resources.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ImageResource_RepeatStyle_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.resources.client.ImageResource.RepeatStyle instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.google.gwt.resources.client.ImageResource.RepeatStyle instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.google.gwt.resources.client.ImageResource.RepeatStyle[] values = com.google.gwt.resources.client.ImageResource.RepeatStyle.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.resources.client.ImageResource.RepeatStyle instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.resources.client.ImageResource_RepeatStyle_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.resources.client.ImageResource_RepeatStyle_FieldSerializer.deserialize(reader, (com.google.gwt.resources.client.ImageResource.RepeatStyle)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.resources.client.ImageResource_RepeatStyle_FieldSerializer.serialize(writer, (com.google.gwt.resources.client.ImageResource.RepeatStyle)object);
  }
  
}
