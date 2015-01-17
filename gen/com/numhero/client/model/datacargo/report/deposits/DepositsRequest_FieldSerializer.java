package com.numhero.client.model.datacargo.report.deposits;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class DepositsRequest_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.report.deposits.DepositsRequest instance) throws SerializationException {
    
    com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.report.deposits.DepositsRequest instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.report.deposits.DepositsRequest();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.report.deposits.DepositsRequest instance) throws SerializationException {
    
    com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.report.deposits.DepositsRequest_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.report.deposits.DepositsRequest_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.report.deposits.DepositsRequest)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.report.deposits.DepositsRequest_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.report.deposits.DepositsRequest)object);
  }
  
}
