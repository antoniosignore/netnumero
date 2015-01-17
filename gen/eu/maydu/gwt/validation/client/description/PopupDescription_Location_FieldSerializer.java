package eu.maydu.gwt.validation.client.description;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class PopupDescription_Location_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, eu.maydu.gwt.validation.client.description.PopupDescription.Location instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static eu.maydu.gwt.validation.client.description.PopupDescription.Location instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    eu.maydu.gwt.validation.client.description.PopupDescription.Location[] values = eu.maydu.gwt.validation.client.description.PopupDescription.Location.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, eu.maydu.gwt.validation.client.description.PopupDescription.Location instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return eu.maydu.gwt.validation.client.description.PopupDescription_Location_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    eu.maydu.gwt.validation.client.description.PopupDescription_Location_FieldSerializer.deserialize(reader, (eu.maydu.gwt.validation.client.description.PopupDescription.Location)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    eu.maydu.gwt.validation.client.description.PopupDescription_Location_FieldSerializer.serialize(writer, (eu.maydu.gwt.validation.client.description.PopupDescription.Location)object);
  }
  
}
