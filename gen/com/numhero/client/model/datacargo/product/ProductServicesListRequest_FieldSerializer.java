package com.numhero.client.model.datacargo.product;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ProductServicesListRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.numhero.shared.enums.ProductTypeEnum getProductType(com.numhero.client.model.datacargo.product.ProductServicesListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.product.ProductServicesListRequest::productType;
  }-*/;
  
  private static native void setProductType(com.numhero.client.model.datacargo.product.ProductServicesListRequest instance, com.numhero.shared.enums.ProductTypeEnum value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.product.ProductServicesListRequest::productType = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.product.ProductServicesListRequest instance) throws SerializationException {
    setProductType(instance, (com.numhero.shared.enums.ProductTypeEnum) streamReader.readObject());
    
    com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.product.ProductServicesListRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.product.ProductServicesListRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.product.ProductServicesListRequest instance) throws SerializationException {
    streamWriter.writeObject(getProductType(instance));
    
    com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.product.ProductServicesListRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.product.ProductServicesListRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.product.ProductServicesListRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.product.ProductServicesListRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.product.ProductServicesListRequest)object);
  }
  
}
