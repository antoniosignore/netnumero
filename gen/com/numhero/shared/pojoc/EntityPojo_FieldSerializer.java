package com.numhero.shared.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class EntityPojo_FieldSerializer {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.pojoc.EntityPojo instance) throws SerializationException {
    instance.fieldsList = (java.util.Map) streamReader.readObject();
    instance.ownedCollectionList = (java.util.Map) streamReader.readObject();
    
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.pojoc.EntityPojo instance) throws SerializationException {
    streamWriter.writeObject(instance.fieldsList);
    streamWriter.writeObject(instance.ownedCollectionList);
    
  }
  
}
