package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BalanceSheetRow_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.BalanceSheetRow instance) throws SerializationException {
    instance.fAccountingGroup = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fBalanceSheetType = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fCreditValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fCurrency = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fDebitValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fNominalLedgerName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    
    com.numhero.shared.pojoc.EntityPojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.BalanceSheetRow instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.BalanceSheetRow();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.BalanceSheetRow instance) throws SerializationException {
    streamWriter.writeObject(instance.fAccountingGroup);
    streamWriter.writeObject(instance.fBalanceSheetType);
    streamWriter.writeObject(instance.fCreditValue);
    streamWriter.writeObject(instance.fCurrency);
    streamWriter.writeObject(instance.fDebitValue);
    streamWriter.writeObject(instance.fNominalLedgerName);
    
    com.numhero.shared.pojoc.EntityPojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.BalanceSheetRow_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.BalanceSheetRow_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.BalanceSheetRow)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.BalanceSheetRow_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.BalanceSheetRow)object);
  }
  
}
