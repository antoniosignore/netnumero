package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Staff_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.Staff instance) throws SerializationException {
    instance.fAddress = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fBillingRate = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fCity = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCountry = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fCurrency = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fDate = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fEmail = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fFax = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fIsAdmin = (com.numhero.shared.pojoc.field.BooleanField) streamReader.readObject();
    instance.fMobile = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fNotes = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fPhone = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fRegion = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fStaffType = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fTimeUnit = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fUserId = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fValue = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fZipCode = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.Staff instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.Staff();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.Staff instance) throws SerializationException {
    streamWriter.writeObject(instance.fAddress);
    streamWriter.writeObject(instance.fBillingRate);
    streamWriter.writeObject(instance.fCity);
    streamWriter.writeObject(instance.fCountry);
    streamWriter.writeObject(instance.fCurrency);
    streamWriter.writeObject(instance.fDate);
    streamWriter.writeObject(instance.fEmail);
    streamWriter.writeObject(instance.fFax);
    streamWriter.writeObject(instance.fIsAdmin);
    streamWriter.writeObject(instance.fMobile);
    streamWriter.writeObject(instance.fNotes);
    streamWriter.writeObject(instance.fPhone);
    streamWriter.writeObject(instance.fRegion);
    streamWriter.writeObject(instance.fStaffType);
    streamWriter.writeObject(instance.fTimeUnit);
    streamWriter.writeObject(instance.fUserId);
    streamWriter.writeObject(instance.fValue);
    streamWriter.writeObject(instance.fZipCode);
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.Staff_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.Staff_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.Staff)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.Staff_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.Staff)object);
  }
  
}
