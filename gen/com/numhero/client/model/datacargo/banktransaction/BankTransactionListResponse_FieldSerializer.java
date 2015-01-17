package com.numhero.client.model.datacargo.banktransaction;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BankTransactionListResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse instance) throws SerializationException {
    
    com.numhero.shared.datacargo.ListCommandResponse_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse instance) throws SerializationException {
    
    com.numhero.shared.datacargo.ListCommandResponse_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse)object);
  }
  
}
