package com.numhero.client.model.datacargo.moneyin;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MoneyInRecapResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse instance) throws SerializationException {
    instance.rows = (java.util.List) streamReader.readObject();
    
  }
  
  public static com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse instance) throws SerializationException {
    streamWriter.writeObject(instance.rows);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse)object);
  }
  
}
