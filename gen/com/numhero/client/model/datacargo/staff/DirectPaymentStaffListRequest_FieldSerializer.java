package com.numhero.client.model.datacargo.staff;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class DirectPaymentStaffListRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.numhero.shared.enums.CountryEnum getCountryCode(com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest::countryCode;
  }-*/;
  
  private static native void setCountryCode(com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest instance, com.numhero.shared.enums.CountryEnum value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest::countryCode = value;
  }-*/;
  
  private static native com.numhero.shared.enums.ReceiptStatusEnum getStatus(com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest::status;
  }-*/;
  
  private static native void setStatus(com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest instance, com.numhero.shared.enums.ReceiptStatusEnum value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest::status = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest instance) throws SerializationException {
    setCountryCode(instance, (com.numhero.shared.enums.CountryEnum) streamReader.readObject());
    setStatus(instance, (com.numhero.shared.enums.ReceiptStatusEnum) streamReader.readObject());
    
    com.numhero.shared.datacargo.BulkActionRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest instance) throws SerializationException {
    streamWriter.writeObject(getCountryCode(instance));
    streamWriter.writeObject(getStatus(instance));
    
    com.numhero.shared.datacargo.BulkActionRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest)object);
  }
  
}
