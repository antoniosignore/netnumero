package com.numhero.client.model.datacargo.moneyout;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MoneyOutRecapResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse instance) throws SerializationException {
    instance.rows = (java.util.List) streamReader.readObject();
    
  }
  
  public static com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse instance) throws SerializationException {
    streamWriter.writeObject(instance.rows);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse)object);
  }
  
}
