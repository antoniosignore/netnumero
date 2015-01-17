package com.numhero.client.model.datacargo.currency;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GetCurrencyConversionResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Map getData(com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse instance) /*-{
    return instance.@com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse::data;
  }-*/;
  
  private static native void setData(com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse instance, java.util.Map value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse::data = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse instance) throws SerializationException {
    setData(instance, (java.util.Map) streamReader.readObject());
    
  }
  
  public static com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse instance) throws SerializationException {
    streamWriter.writeObject(getData(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse)object);
  }
  
}
