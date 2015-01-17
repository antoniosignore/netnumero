package com.numhero.client.model.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BusinessTransaction_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.pojoc.BusinessTransaction instance) throws SerializationException {
    instance.fBusinessTransaction = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    instance.fDate = (com.numhero.shared.pojoc.field.DateTimeField) streamReader.readObject();
    instance.fLegs = (com.numhero.shared.pojoc.field.OwnedListField) streamReader.readObject();
    instance.fReferenceDocId = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fReferenceDocName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fReferenceDocType = (com.numhero.shared.pojoc.field.EnumField) streamReader.readObject();
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.client.model.pojoc.BusinessTransaction instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.pojoc.BusinessTransaction();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.pojoc.BusinessTransaction instance) throws SerializationException {
    streamWriter.writeObject(instance.fBusinessTransaction);
    streamWriter.writeObject(instance.fDate);
    streamWriter.writeObject(instance.fLegs);
    streamWriter.writeObject(instance.fReferenceDocId);
    streamWriter.writeObject(instance.fReferenceDocName);
    streamWriter.writeObject(instance.fReferenceDocType);
    
    com.numhero.shared.pojoc.SearchablePojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.pojoc.BusinessTransaction_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.BusinessTransaction_FieldSerializer.deserialize(reader, (com.numhero.client.model.pojoc.BusinessTransaction)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.pojoc.BusinessTransaction_FieldSerializer.serialize(writer, (com.numhero.client.model.pojoc.BusinessTransaction)object);
  }
  
}
