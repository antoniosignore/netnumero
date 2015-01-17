package com.numhero.client.widget;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class TabBar_INumheroTab_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.widget.TabBar.INumheroTab instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.numhero.client.widget.TabBar.INumheroTab instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.numhero.client.widget.TabBar.INumheroTab[] values = com.numhero.client.widget.TabBar.INumheroTab.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.widget.TabBar.INumheroTab instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.widget.TabBar_INumheroTab_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.widget.TabBar_INumheroTab_FieldSerializer.deserialize(reader, (com.numhero.client.widget.TabBar.INumheroTab)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.widget.TabBar_INumheroTab_FieldSerializer.serialize(writer, (com.numhero.client.widget.TabBar.INumheroTab)object);
  }
  
}
