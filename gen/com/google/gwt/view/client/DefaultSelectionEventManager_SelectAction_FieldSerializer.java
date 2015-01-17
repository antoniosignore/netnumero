package com.google.gwt.view.client;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class DefaultSelectionEventManager_SelectAction_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.google.gwt.view.client.DefaultSelectionEventManager.SelectAction instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.google.gwt.view.client.DefaultSelectionEventManager.SelectAction instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.google.gwt.view.client.DefaultSelectionEventManager.SelectAction[] values = com.google.gwt.view.client.DefaultSelectionEventManager.SelectAction.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.google.gwt.view.client.DefaultSelectionEventManager.SelectAction instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.google.gwt.view.client.DefaultSelectionEventManager_SelectAction_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.google.gwt.view.client.DefaultSelectionEventManager_SelectAction_FieldSerializer.deserialize(reader, (com.google.gwt.view.client.DefaultSelectionEventManager.SelectAction)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.google.gwt.view.client.DefaultSelectionEventManager_SelectAction_FieldSerializer.serialize(writer, (com.google.gwt.view.client.DefaultSelectionEventManager.SelectAction)object);
  }
  
}
