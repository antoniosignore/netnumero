package com.numhero.client.model.datacargo.report.profitloss;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class GetProfitLossResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.Double getCostOfSales(com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse instance) /*-{
    return instance.@com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse::costOfSales;
  }-*/;
  
  private static native void setCostOfSales(com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse instance, java.lang.Double value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse::costOfSales = value;
  }-*/;
  
  private static native java.lang.Double getGrossProfit(com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse instance) /*-{
    return instance.@com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse::grossProfit;
  }-*/;
  
  private static native void setGrossProfit(com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse instance, java.lang.Double value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse::grossProfit = value;
  }-*/;
  
  private static native java.lang.Double getSales(com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse instance) /*-{
    return instance.@com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse::sales;
  }-*/;
  
  private static native void setSales(com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse instance, java.lang.Double value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse::sales = value;
  }-*/;
  
  private static native java.util.List getSheetRows(com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse instance) /*-{
    return instance.@com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse::sheetRows;
  }-*/;
  
  private static native void setSheetRows(com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse instance, java.util.List value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse::sheetRows = value;
  }-*/;
  
  private static native java.lang.Double getTotalExpenses(com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse instance) /*-{
    return instance.@com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse::totalExpenses;
  }-*/;
  
  private static native void setTotalExpenses(com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse instance, java.lang.Double value) 
  /*-{
    instance.@com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse::totalExpenses = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse instance) throws SerializationException {
    setCostOfSales(instance, (java.lang.Double) streamReader.readObject());
    setGrossProfit(instance, (java.lang.Double) streamReader.readObject());
    setSales(instance, (java.lang.Double) streamReader.readObject());
    setSheetRows(instance, (java.util.List) streamReader.readObject());
    setTotalExpenses(instance, (java.lang.Double) streamReader.readObject());
    
  }
  
  public static com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse instance) throws SerializationException {
    streamWriter.writeObject(getCostOfSales(instance));
    streamWriter.writeObject(getGrossProfit(instance));
    streamWriter.writeObject(getSales(instance));
    streamWriter.writeObject(getSheetRows(instance));
    streamWriter.writeObject(getTotalExpenses(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse_FieldSerializer.deserialize(reader, (com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse_FieldSerializer.serialize(writer, (com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse)object);
  }
  
}
