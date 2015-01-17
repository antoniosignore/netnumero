package com.numhero.shared.enums;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CountryEnum_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.numhero.shared.enums.CurrencyEnum getCurrency(com.numhero.shared.enums.CountryEnum instance) /*-{
    return instance.@com.numhero.shared.enums.CountryEnum::currency;
  }-*/;
  
  private static native void setCurrency(com.numhero.shared.enums.CountryEnum instance, com.numhero.shared.enums.CurrencyEnum value) 
  /*-{
    instance.@com.numhero.shared.enums.CountryEnum::currency = value;
  }-*/;
  
  private static native java.lang.String getValue(com.numhero.shared.enums.CountryEnum instance) /*-{
    return instance.@com.numhero.shared.enums.CountryEnum::value;
  }-*/;
  
  private static native void setValue(com.numhero.shared.enums.CountryEnum instance, java.lang.String value) 
  /*-{
    instance.@com.numhero.shared.enums.CountryEnum::value = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.enums.CountryEnum instance) throws SerializationException {
    // Enum deserialization is handled via the instantiate method
  }
  
  public static com.numhero.shared.enums.CountryEnum instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int ordinal = streamReader.readInt();
    com.numhero.shared.enums.CountryEnum[] values = com.numhero.shared.enums.CountryEnum.values();
    assert (ordinal >= 0 && ordinal < values.length);
    return values[ordinal];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.enums.CountryEnum instance) throws SerializationException {
    assert (instance != null);
    streamWriter.writeInt(instance.ordinal());
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.enums.CountryEnum_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.enums.CountryEnum_FieldSerializer.deserialize(reader, (com.numhero.shared.enums.CountryEnum)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.enums.CountryEnum_FieldSerializer.serialize(writer, (com.numhero.shared.enums.CountryEnum)object);
  }
  
}
