package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Invoice_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.numhero.shared.pojoc.field.BooleanField getFArchived(com.numhero.client.model.pojoc.Invoice instance) /*-{
    return instance.@com.numhero.client.model.pojoc.Invoice::fArchived;
  }-*/;
  
  private static native void setFArchived(com.numhero.client.model.pojoc.Invoice instance, com.numhero.shared.pojoc.field.BooleanField value) 
  /*-{
    instance.@com.numhero.client.model.pojoc.Invoice::fArchived = value;
  }-*/;
  
  private static native com.numhero.shared.pojoc.field.EnumField getFStatus(com.numhero.client.model.pojoc.Invoice instance) /*-{
    return instance.@com.numhero.client.model.pojoc.Invoice::fStatus;
  }-*/;
  
  private static native void setFStatus(com.numhero.client.model.pojoc.Invoice instance, com.numhero.shared.pojoc.field.EnumField value) 
  /*-{
    instance.@com.numhero.client.model.pojoc.Invoice::fStatus = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.Invoice instance) throws SerializationException {
    instance.details = (com.numhero.shared.pojoc.field.OwnedListField) streamReader.readObject();
    instance.fAccountID = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fAccountName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    setFArchived(instance, (com.numhero.shared.pojoc.field.BooleanField) streamReader.readObject());
    instance.fClientSupplierID = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fClientSupplierName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCurrency = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fDate = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fDateDue = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fDatePaid = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fDateRaised = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fDiscount = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fNotes = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fPDF = (com.numhero.shared.pojoc.field.BlobField) streamReader.readObject();
    instance.fPO = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    setFStatus(instance, (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject());
    instance.fTermsConditions = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fType = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.Invoice instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.Invoice();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.Invoice instance) throws SerializationException {
    streamWriter.writeObject(instance.details);
    streamWriter.writeObject(instance.fAccountID);
    streamWriter.writeObject(instance.fAccountName);
    streamWriter.writeObject(getFArchived(instance));
    streamWriter.writeObject(instance.fClientSupplierID);
    streamWriter.writeObject(instance.fClientSupplierName);
    streamWriter.writeObject(instance.fCurrency);
    streamWriter.writeObject(instance.fDate);
    streamWriter.writeObject(instance.fDateDue);
    streamWriter.writeObject(instance.fDatePaid);
    streamWriter.writeObject(instance.fDateRaised);
    streamWriter.writeObject(instance.fDiscount);
    streamWriter.writeObject(instance.fNotes);
    streamWriter.writeObject(instance.fPDF);
    streamWriter.writeObject(instance.fPO);
    streamWriter.writeObject(getFStatus(instance));
    streamWriter.writeObject(instance.fTermsConditions);
    streamWriter.writeObject(instance.fType);
    streamWriter.writeObject(instance.fValue);
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.Invoice_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.Invoice_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.Invoice)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.Invoice_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.Invoice)object);
  }
  
}
