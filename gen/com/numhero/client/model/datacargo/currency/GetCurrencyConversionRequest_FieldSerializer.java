package com.numhero.client.model.datacargo.currency;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GetCurrencyConversionRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.Map getData(com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest::data;
  }-*/;
  
  private static native void setData(com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest instance, java.util.Map value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest::data = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest instance) throws SerializationException {
    setData(instance, (java.util.Map) streamReader.readObject());
    
    com.numhero.shared.datacargo.GetSingleEntityRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest instance) throws SerializationException {
    streamWriter.writeObject(getData(instance));
    
    com.numhero.shared.datacargo.GetSingleEntityRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest)object);
  }
  
}
