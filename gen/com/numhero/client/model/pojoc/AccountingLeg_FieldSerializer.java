package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class AccountingLeg_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.AccountingLeg instance) throws SerializationException {
    instance.fAccountClass = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fAccountId = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fAccountName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fDate = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fDoubleEntryType = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fNominalCode = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.AccountingLeg instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.AccountingLeg();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.AccountingLeg instance) throws SerializationException {
    streamWriter.writeObject(instance.fAccountClass);
    streamWriter.writeObject(instance.fAccountId);
    streamWriter.writeObject(instance.fAccountName);
    streamWriter.writeObject(instance.fDate);
    streamWriter.writeObject(instance.fDoubleEntryType);
    streamWriter.writeObject(instance.fNominalCode);
    streamWriter.writeObject(instance.fValue);
    
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.AccountingLeg_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.AccountingLeg_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.AccountingLeg)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.AccountingLeg_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.AccountingLeg)object);
  }
  
}
