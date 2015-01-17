package com.numhero.shared.enums;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class CurrencyEnum_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.enums.CurrencyEnum[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.enums.CurrencyEnum[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new com.numhero.shared.enums.CurrencyEnum[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.enums.CurrencyEnum[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.enums.CurrencyEnum_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.enums.CurrencyEnum_Array_Rank_1_FieldSerializer.deserialize(reader, (com.numhero.shared.enums.CurrencyEnum[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.enums.CurrencyEnum_Array_Rank_1_FieldSerializer.serialize(writer, (com.numhero.shared.enums.CurrencyEnum[])object);
  }
  
}
