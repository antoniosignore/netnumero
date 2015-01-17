package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BankAccount_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.BankAccount instance) throws SerializationException {
    instance.fAccountNumber = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fAddress = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fBank = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCity = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCountry = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fCurrency = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fDate = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fExternalAccountNumber = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fIban = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fIsMainTradingAccount = (com.numhero.shared.pojoc.field.BooleanField) streamReader.readObject();
    instance.fLedgerAccountBalanceDate = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fLedgerAccountBalanceValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fOpeningBalance = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fRegion = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fSwift = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fZipCode = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.BankAccount instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.BankAccount();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.BankAccount instance) throws SerializationException {
    streamWriter.writeObject(instance.fAccountNumber);
    streamWriter.writeObject(instance.fAddress);
    streamWriter.writeObject(instance.fBank);
    streamWriter.writeObject(instance.fCity);
    streamWriter.writeObject(instance.fCountry);
    streamWriter.writeObject(instance.fCurrency);
    streamWriter.writeObject(instance.fDate);
    streamWriter.writeObject(instance.fExternalAccountNumber);
    streamWriter.writeObject(instance.fIban);
    streamWriter.writeObject(instance.fIsMainTradingAccount);
    streamWriter.writeObject(instance.fLedgerAccountBalanceDate);
    streamWriter.writeObject(instance.fLedgerAccountBalanceValue);
    streamWriter.writeObject(instance.fOpeningBalance);
    streamWriter.writeObject(instance.fRegion);
    streamWriter.writeObject(instance.fSwift);
    streamWriter.writeObject(instance.fValue);
    streamWriter.writeObject(instance.fZipCode);
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.BankAccount_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.BankAccount_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.BankAccount)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.BankAccount_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.BankAccount)object);
  }
  
}
