package com.numhero.client.model.datacargo.staff;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ReimbursableStaffListRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.numhero.shared.enums.StaffTypeEnum getStaffType(com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest instance) /*-{
    return instance.@com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest::staffType;
  }-*/;
  
  private static native void setStaffType(com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest instance, com.numhero.shared.enums.StaffTypeEnum value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest::staffType = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest instance) throws SerializationException {
    setStaffType(instance, (com.numhero.shared.enums.StaffTypeEnum) streamReader.readObject());
    
    com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest instance) throws SerializationException {
    streamWriter.writeObject(getStaffType(instance));
    
    com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest)object);
  }
  
}
