package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MoneyInOutRecapRow_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.MoneyInOutRecapRow instance) throws SerializationException {
    instance.fCurrency = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fEstimatesValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fExpensesValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fInvoiceValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fMonth = (com.numhero.shared.pojoc.field.IntegerField) streamReader.readObject();
    instance.fReceiptsValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fYear = (com.numhero.shared.pojoc.field.IntegerField) streamReader.readObject();
    
    com.numhero.shared.pojoc.EntityPojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.MoneyInOutRecapRow instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.MoneyInOutRecapRow();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.MoneyInOutRecapRow instance) throws SerializationException {
    streamWriter.writeObject(instance.fCurrency);
    streamWriter.writeObject(instance.fEstimatesValue);
    streamWriter.writeObject(instance.fExpensesValue);
    streamWriter.writeObject(instance.fInvoiceValue);
    streamWriter.writeObject(instance.fMonth);
    streamWriter.writeObject(instance.fReceiptsValue);
    streamWriter.writeObject(instance.fYear);
    
    com.numhero.shared.pojoc.EntityPojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.MoneyInOutRecapRow_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.MoneyInOutRecapRow_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.MoneyInOutRecapRow)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.MoneyInOutRecapRow_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.MoneyInOutRecapRow)object);
  }
  
}
