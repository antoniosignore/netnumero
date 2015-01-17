package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class ClientSupplierContact_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.ClientSupplierContact instance) throws SerializationException {
    instance.fEmail = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fMobile = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fPhone = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.ClientSupplierContact instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.ClientSupplierContact();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.ClientSupplierContact instance) throws SerializationException {
    streamWriter.writeObject(instance.fEmail);
    streamWriter.writeObject(instance.fMobile);
    streamWriter.writeObject(instance.fPhone);
    
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.ClientSupplierContact_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.ClientSupplierContact_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.ClientSupplierContact)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.ClientSupplierContact_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.ClientSupplierContact)object);
  }
  
}
