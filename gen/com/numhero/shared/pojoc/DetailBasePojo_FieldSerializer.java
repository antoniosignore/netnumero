package com.numhero.shared.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class DetailBasePojo_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.pojoc.DetailBasePojo instance) throws SerializationException {
    instance.fParentId = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    
    com.numhero.shared.pojoc.BAPojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static com.numhero.shared.pojoc.DetailBasePojo instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.shared.pojoc.DetailBasePojo();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.pojoc.DetailBasePojo instance) throws SerializationException {
    streamWriter.writeObject(instance.fParentId);
    
    com.numhero.shared.pojoc.BAPojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.deserialize(reader, (com.numhero.shared.pojoc.DetailBasePojo)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer.serialize(writer, (com.numhero.shared.pojoc.DetailBasePojo)object);
  }
  
}
