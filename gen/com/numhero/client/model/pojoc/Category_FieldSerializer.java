package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Category_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.Category instance) throws SerializationException {
    instance.fLedgerAccountBalanceDate = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fLedgerAccountBalanceValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fTaxPercent = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.Category instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.Category();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.Category instance) throws SerializationException {
    streamWriter.writeObject(instance.fLedgerAccountBalanceDate);
    streamWriter.writeObject(instance.fLedgerAccountBalanceValue);
    streamWriter.writeObject(instance.fTaxPercent);
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.Category_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.Category_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.Category)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.Category_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.Category)object);
  }
  
}
