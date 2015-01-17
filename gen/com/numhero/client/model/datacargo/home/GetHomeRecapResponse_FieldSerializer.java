package com.numhero.client.model.datacargo.home;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GetHomeRecapResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.home.GetHomeRecapResponse instance) throws SerializationException {
    instance.fLastUpdateRecaps = (com.numhero.shared.pojoc.field.DateField) streamReader.readObject();
    instance.fMonthCost = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fMonthProfit = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fMonthTurnover = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fYearCost = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fYearProfit = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    instance.fYearTurnover = (com.numhero.shared.pojoc.field.DoubleField) streamReader.readObject();
    
  }
  
  public static com.numhero.client.model.datacargo.home.GetHomeRecapResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.home.GetHomeRecapResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.home.GetHomeRecapResponse instance) throws SerializationException {
    streamWriter.writeObject(instance.fLastUpdateRecaps);
    streamWriter.writeObject(instance.fMonthCost);
    streamWriter.writeObject(instance.fMonthProfit);
    streamWriter.writeObject(instance.fMonthTurnover);
    streamWriter.writeObject(instance.fYearCost);
    streamWriter.writeObject(instance.fYearProfit);
    streamWriter.writeObject(instance.fYearTurnover);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.home.GetHomeRecapResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.home.GetHomeRecapResponse_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.home.GetHomeRecapResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.home.GetHomeRecapResponse_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.home.GetHomeRecapResponse)object);
  }
  
}
