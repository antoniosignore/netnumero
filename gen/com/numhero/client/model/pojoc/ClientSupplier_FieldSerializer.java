package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ClientSupplier_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native com.numhero.shared.pojoc.field.OwnedListField getFContacts(com.numhero.client.model.pojoc.ClientSupplier instance) /*-{
    return instance.@com.numhero.client.model.pojoc.ClientSupplier::fContacts;
  }-*/;
  
  private static native void setFContacts(com.numhero.client.model.pojoc.ClientSupplier instance, com.numhero.shared.pojoc.field.OwnedListField value) 
  /*-{
    instance.@com.numhero.client.model.pojoc.ClientSupplier::fContacts = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.ClientSupplier instance) throws SerializationException {
    instance.fAddress = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCity = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fClient = (com.numhero.shared.pojoc.field.BooleanField) streamReader.readObject();
    instance.fCompanyEmail = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCompanyFax = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCompanyPhone = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fContactEmail = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fContactMobile = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fContactName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fContactPhone = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    setFContacts(instance, (com.numhero.shared.pojoc.field.OwnedListField) streamReader.readObject());
    instance.fCountry = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fLedgerAccountBalanceDate = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fLedgerAccountBalanceValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fNotes = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fRegion = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fSupplier = (com.numhero.shared.pojoc.field.BooleanField) streamReader.readObject();
    instance.fVat = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fZipCode = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.ClientSupplier instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.ClientSupplier();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.ClientSupplier instance) throws SerializationException {
    streamWriter.writeObject(instance.fAddress);
    streamWriter.writeObject(instance.fCity);
    streamWriter.writeObject(instance.fClient);
    streamWriter.writeObject(instance.fCompanyEmail);
    streamWriter.writeObject(instance.fCompanyFax);
    streamWriter.writeObject(instance.fCompanyPhone);
    streamWriter.writeObject(instance.fContactEmail);
    streamWriter.writeObject(instance.fContactMobile);
    streamWriter.writeObject(instance.fContactName);
    streamWriter.writeObject(instance.fContactPhone);
    streamWriter.writeObject(getFContacts(instance));
    streamWriter.writeObject(instance.fCountry);
    streamWriter.writeObject(instance.fLedgerAccountBalanceDate);
    streamWriter.writeObject(instance.fLedgerAccountBalanceValue);
    streamWriter.writeObject(instance.fNotes);
    streamWriter.writeObject(instance.fRegion);
    streamWriter.writeObject(instance.fSupplier);
    streamWriter.writeObject(instance.fVat);
    streamWriter.writeObject(instance.fZipCode);
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.ClientSupplier_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.ClientSupplier_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.ClientSupplier)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.ClientSupplier_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.ClientSupplier)object);
  }
  
}
