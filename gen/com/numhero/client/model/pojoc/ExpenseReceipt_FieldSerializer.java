package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ExpenseReceipt_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.ExpenseReceipt instance) throws SerializationException {
    instance.fCategoryID = (com.numhero.shared.pojoc.field.LongField) streamReader.readObject();
    instance.fCategoryName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fClientSupplierID = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fClientSupplierName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCurrency = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fDate = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fDatePaid = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fFrequency = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fInvoiceStatus = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fNotes = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fReceiptStatus = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fRecurring = (com.numhero.shared.pojoc.field.BooleanField) streamReader.readObject();
    instance.fStaffId = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fStaffName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.ExpenseReceipt instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.ExpenseReceipt();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.ExpenseReceipt instance) throws SerializationException {
    streamWriter.writeObject(instance.fCategoryID);
    streamWriter.writeObject(instance.fCategoryName);
    streamWriter.writeObject(instance.fClientSupplierID);
    streamWriter.writeObject(instance.fClientSupplierName);
    streamWriter.writeObject(instance.fCurrency);
    streamWriter.writeObject(instance.fDate);
    streamWriter.writeObject(instance.fDatePaid);
    streamWriter.writeObject(instance.fFrequency);
    streamWriter.writeObject(instance.fInvoiceStatus);
    streamWriter.writeObject(instance.fNotes);
    streamWriter.writeObject(instance.fReceiptStatus);
    streamWriter.writeObject(instance.fRecurring);
    streamWriter.writeObject(instance.fStaffId);
    streamWriter.writeObject(instance.fStaffName);
    streamWriter.writeObject(instance.fValue);
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.ExpenseReceipt_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.ExpenseReceipt_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.ExpenseReceipt)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.ExpenseReceipt_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.ExpenseReceipt)object);
  }
  
}
