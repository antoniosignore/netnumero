package com.numhero.client.model.datacargo.currency;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ConversionBean_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native double getExchangeRate(com.numhero.client.model.datacargo.currency.ConversionBean instance) /*-{
    return instance.@com.numhero.client.model.datacargo.currency.ConversionBean::exchangeRate;
  }-*/;
  
  private static native void setExchangeRate(com.numhero.client.model.datacargo.currency.ConversionBean instance, double value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.currency.ConversionBean::exchangeRate = value;
  }-*/;
  
  private static native com.numhero.shared.enums.CurrencyEnum getFromCurrency(com.numhero.client.model.datacargo.currency.ConversionBean instance) /*-{
    return instance.@com.numhero.client.model.datacargo.currency.ConversionBean::fromCurrency;
  }-*/;
  
  private static native void setFromCurrency(com.numhero.client.model.datacargo.currency.ConversionBean instance, com.numhero.shared.enums.CurrencyEnum value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.currency.ConversionBean::fromCurrency = value;
  }-*/;
  
  private static native com.numhero.shared.enums.CurrencyEnum getToCurrency(com.numhero.client.model.datacargo.currency.ConversionBean instance) /*-{
    return instance.@com.numhero.client.model.datacargo.currency.ConversionBean::toCurrency;
  }-*/;
  
  private static native void setToCurrency(com.numhero.client.model.datacargo.currency.ConversionBean instance, com.numhero.shared.enums.CurrencyEnum value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.currency.ConversionBean::toCurrency = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.currency.ConversionBean instance) throws SerializationException {
    setExchangeRate(instance, streamReader.readDouble());
    setFromCurrency(instance, (com.numhero.shared.enums.CurrencyEnum) streamReader.readObject());
    setToCurrency(instance, (com.numhero.shared.enums.CurrencyEnum) streamReader.readObject());
    
  }
  
  public static com.numhero.client.model.datacargo.currency.ConversionBean instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.currency.ConversionBean();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.currency.ConversionBean instance) throws SerializationException {
    streamWriter.writeDouble(getExchangeRate(instance));
    streamWriter.writeObject(getFromCurrency(instance));
    streamWriter.writeObject(getToCurrency(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.currency.ConversionBean_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.currency.ConversionBean_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.currency.ConversionBean)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.currency.ConversionBean_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.currency.ConversionBean)object);
  }
  
}
