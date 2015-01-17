package com.numhero.shared.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class BAPojo_FieldSerializer {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.pojoc.BAPojo instance) throws SerializationException {
    instance.fBusinessAccountUri = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fCreated = (com.numhero.shared.pojoc.field.DateTimeField) streamReader.readObject();
    instance.fDbVersion = (com.numhero.shared.pojoc.field.IntegerField) streamReader.readObject();
    instance.fDescription = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    instance.fId = (com.numhero.shared.pojoc.field.IdField) streamReader.readObject();
    instance.fLastUpdated = (com.numhero.shared.pojoc.field.DateTimeField) streamReader.readObject();
    instance.fName = (com.numhero.shared.pojoc.field.StringField) streamReader.readObject();
    
    com.numhero.shared.pojoc.EntityPojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.pojoc.BAPojo instance) throws SerializationException {
    streamWriter.writeObject(instance.fBusinessAccountUri);
    streamWriter.writeObject(instance.fCreated);
    streamWriter.writeObject(instance.fDbVersion);
    streamWriter.writeObject(instance.fDescription);
    streamWriter.writeObject(instance.fId);
    streamWriter.writeObject(instance.fLastUpdated);
    streamWriter.writeObject(instance.fName);
    
    com.numhero.shared.pojoc.EntityPojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
