package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BankTransaction_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.BankTransaction instance) throws SerializationException {
    instance.fAccountID = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fAccountName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fBankAccountId = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fBankAccountName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCurrency = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fDate = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fNotes = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fType = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.BankTransaction instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.BankTransaction();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.BankTransaction instance) throws SerializationException {
    streamWriter.writeObject(instance.fAccountID);
    streamWriter.writeObject(instance.fAccountName);
    streamWriter.writeObject(instance.fBankAccountId);
    streamWriter.writeObject(instance.fBankAccountName);
    streamWriter.writeObject(instance.fCurrency);
    streamWriter.writeObject(instance.fDate);
    streamWriter.writeObject(instance.fNotes);
    streamWriter.writeObject(instance.fType);
    streamWriter.writeObject(instance.fValue);
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.BankTransaction_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.BankTransaction_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.BankTransaction)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.BankTransaction_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.BankTransaction)object);
  }
  
}
