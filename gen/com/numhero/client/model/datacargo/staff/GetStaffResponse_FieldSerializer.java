package com.numhero.client.model.datacargo.staff;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GetStaffResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.util.List getRemboursableExpenses(com.numhero.client.model.datacargo.staff.GetStaffResponse instance) /*-{
    return instance.@com.numhero.client.model.datacargo.staff.GetStaffResponse::remboursableExpenses;
  }-*/;
  
  private static native void setRemboursableExpenses(com.numhero.client.model.datacargo.staff.GetStaffResponse instance, java.util.List value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.staff.GetStaffResponse::remboursableExpenses = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.staff.GetStaffResponse instance) throws SerializationException {
    setRemboursableExpenses(instance, (java.util.List) streamReader.readObject());
    
    com.numhero.shared.datacargo.GetSingleEntityResponse_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.staff.GetStaffResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.staff.GetStaffResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.staff.GetStaffResponse instance) throws SerializationException {
    streamWriter.writeObject(getRemboursableExpenses(instance));
    
    com.numhero.shared.datacargo.GetSingleEntityResponse_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.staff.GetStaffResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.staff.GetStaffResponse_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.staff.GetStaffResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.staff.GetStaffResponse_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.staff.GetStaffResponse)object);
  }
  
}
