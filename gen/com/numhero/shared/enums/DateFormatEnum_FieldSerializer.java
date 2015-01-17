package com.numhero.shared.enums;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class DateFormatEnum_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getValue(com.numhero.shared.enums.DateFormatEnum instance) /*-{
    return instance.@com.numhero.shared.enums.DateFormatEnum::value;
  }-*/;
  
  private static native void setValue(com.numhero.shared.enums.DateFormatEnum instance, java.lang.String value) 
  /*-{
    instance.@com.numhero.shared.enums.DateFormatEnum::value = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.enums.DateFormatEnum instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.numhero.shared.enums.DateFormatEnum instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.numhero.shared.enums.DateFormatEnum[] values = com.numhero.shared.enums.DateFormatEnum.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.enums.DateFormatEnum instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.enums.DateFormatEnum_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.enums.DateFormatEnum_FieldSerializer.deserialize(reader, (com.numhero.shared.enums.DateFormatEnum)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.enums.DateFormatEnum_FieldSerializer.serialize(writer, (com.numhero.shared.enums.DateFormatEnum)object);
  }
  
}
