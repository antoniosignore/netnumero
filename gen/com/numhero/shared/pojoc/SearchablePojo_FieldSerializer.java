package com.numhero.shared.pojoc;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class SearchablePojo_FieldSerializer {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.shared.pojoc.SearchablePojo instance) throws SerializationException {
    
    com.numhero.shared.pojoc.BAPojo_FieldSerializer.deserialize(streamReader, instance);
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.shared.pojoc.SearchablePojo instance) throws SerializationException {
    
    com.numhero.shared.pojoc.BAPojo_FieldSerializer.serialize(streamWriter, instance);
  }
  
}
