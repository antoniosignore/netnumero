package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class NominalLedgerAccount_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.NominalLedgerAccount instance) throws SerializationException {
    instance.fAccountingGroup = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fBalanceSheetType = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fCode = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCreditValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fDebitValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fLedgerAccountBalanceDate = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fLedgerAccountBalanceValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.NominalLedgerAccount instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.NominalLedgerAccount();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.NominalLedgerAccount instance) throws SerializationException {
    streamWriter.writeObject(instance.fAccountingGroup);
    streamWriter.writeObject(instance.fBalanceSheetType);
    streamWriter.writeObject(instance.fCode);
    streamWriter.writeObject(instance.fCreditValue);
    streamWriter.writeObject(instance.fDebitValue);
    streamWriter.writeObject(instance.fLedgerAccountBalanceDate);
    streamWriter.writeObject(instance.fLedgerAccountBalanceValue);
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.NominalLedgerAccount_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.NominalLedgerAccount_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.NominalLedgerAccount)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.NominalLedgerAccount_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.NominalLedgerAccount)object);
  }
  
}
