package com.numhero.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.user.client.rpc.impl.TypeHandler;
import java.util.HashMap;
import java.util.Map;
import com.google.gwt.core.client.GwtScriptOnly;

public class DataService_TypeSerializer extends com.google.gwt.user.client.rpc.impl.SerializerBase {
  private static final MethodMap methodMapNative;
  private static final JsArrayString signatureMapNative;
  
  static {
    methodMapNative = loadMethodsNative();
    signatureMapNative = loadSignaturesNative();
  }
  
  @SuppressWarnings("deprecation")
  @GwtScriptOnly
  private static native MethodMap loadMethodsNative() /*-{
    var result = {};
    result["[B/3308590456"] = [
        @com.google.gwt.user.client.rpc.core.byte_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.byte_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[B),
        @com.google.gwt.user.client.rpc.core.byte_Array_Rank_1_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;[B)
      ];
    
    result["com.google.gwt.canvas.dom.client.Context2d$Composite/3412511209"] = [
        @com.google.gwt.canvas.dom.client.Context2d_Composite_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.canvas.dom.client.Context2d_Composite_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/canvas/dom/client/Context2d$Composite;),
        @com.google.gwt.canvas.dom.client.Context2d_Composite_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/canvas/dom/client/Context2d$Composite;)
      ];
    
    result["com.google.gwt.canvas.dom.client.Context2d$LineCap/4137629416"] = [
        @com.google.gwt.canvas.dom.client.Context2d_LineCap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.canvas.dom.client.Context2d_LineCap_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/canvas/dom/client/Context2d$LineCap;),
        @com.google.gwt.canvas.dom.client.Context2d_LineCap_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/canvas/dom/client/Context2d$LineCap;)
      ];
    
    result["com.google.gwt.canvas.dom.client.Context2d$LineJoin/773759908"] = [
        @com.google.gwt.canvas.dom.client.Context2d_LineJoin_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.canvas.dom.client.Context2d_LineJoin_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/canvas/dom/client/Context2d$LineJoin;),
        @com.google.gwt.canvas.dom.client.Context2d_LineJoin_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/canvas/dom/client/Context2d$LineJoin;)
      ];
    
    result["com.google.gwt.canvas.dom.client.Context2d$Repetition/200032891"] = [
        @com.google.gwt.canvas.dom.client.Context2d_Repetition_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.canvas.dom.client.Context2d_Repetition_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/canvas/dom/client/Context2d$Repetition;),
        @com.google.gwt.canvas.dom.client.Context2d_Repetition_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/canvas/dom/client/Context2d$Repetition;)
      ];
    
    result["com.google.gwt.canvas.dom.client.Context2d$TextAlign/96304101"] = [
        @com.google.gwt.canvas.dom.client.Context2d_TextAlign_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.canvas.dom.client.Context2d_TextAlign_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/canvas/dom/client/Context2d$TextAlign;),
        @com.google.gwt.canvas.dom.client.Context2d_TextAlign_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/canvas/dom/client/Context2d$TextAlign;)
      ];
    
    result["com.google.gwt.canvas.dom.client.Context2d$TextBaseline/1387606880"] = [
        @com.google.gwt.canvas.dom.client.Context2d_TextBaseline_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.canvas.dom.client.Context2d_TextBaseline_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/canvas/dom/client/Context2d$TextBaseline;),
        @com.google.gwt.canvas.dom.client.Context2d_TextBaseline_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/canvas/dom/client/Context2d$TextBaseline;)
      ];
    
    result["com.google.gwt.cell.client.ButtonCellBase$Decoration/2339543658"] = [
        @com.google.gwt.cell.client.ButtonCellBase_Decoration_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.cell.client.ButtonCellBase_Decoration_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/cell/client/ButtonCellBase$Decoration;),
        @com.google.gwt.cell.client.ButtonCellBase_Decoration_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/cell/client/ButtonCellBase$Decoration;)
      ];
    
    result["com.google.gwt.core.client.CodeDownloadException$Reason/4099226274"] = [
        @com.google.gwt.core.client.CodeDownloadException_Reason_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.core.client.CodeDownloadException_Reason_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/core/client/CodeDownloadException$Reason;),
        @com.google.gwt.core.client.CodeDownloadException_Reason_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/core/client/CodeDownloadException$Reason;)
      ];
    
    result["com.google.gwt.dom.client.Style$BorderStyle/2769837833"] = [
        @com.google.gwt.dom.client.Style_BorderStyle_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_BorderStyle_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$BorderStyle;),
        @com.google.gwt.dom.client.Style_BorderStyle_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$BorderStyle;)
      ];
    
    result["com.google.gwt.dom.client.Style$Cursor/2666657890"] = [
        @com.google.gwt.dom.client.Style_Cursor_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Cursor_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Cursor;),
        @com.google.gwt.dom.client.Style_Cursor_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$Cursor;)
      ];
    
    result["com.google.gwt.dom.client.Style$Display/1537475515"] = [
        @com.google.gwt.dom.client.Style_Display_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Display_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Display;),
        @com.google.gwt.dom.client.Style_Display_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$Display;)
      ];
    
    result["com.google.gwt.dom.client.Style$Float/1495215860"] = [
        @com.google.gwt.dom.client.Style_Float_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Float_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Float;),
        @com.google.gwt.dom.client.Style_Float_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$Float;)
      ];
    
    result["com.google.gwt.dom.client.Style$FontStyle/2182768286"] = [
        @com.google.gwt.dom.client.Style_FontStyle_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_FontStyle_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$FontStyle;),
        @com.google.gwt.dom.client.Style_FontStyle_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$FontStyle;)
      ];
    
    result["com.google.gwt.dom.client.Style$FontWeight/3557458763"] = [
        @com.google.gwt.dom.client.Style_FontWeight_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_FontWeight_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$FontWeight;),
        @com.google.gwt.dom.client.Style_FontWeight_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$FontWeight;)
      ];
    
    result["com.google.gwt.dom.client.Style$ListStyleType/1064239610"] = [
        @com.google.gwt.dom.client.Style_ListStyleType_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_ListStyleType_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$ListStyleType;),
        @com.google.gwt.dom.client.Style_ListStyleType_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$ListStyleType;)
      ];
    
    result["com.google.gwt.dom.client.Style$Overflow/982122884"] = [
        @com.google.gwt.dom.client.Style_Overflow_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Overflow_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Overflow;),
        @com.google.gwt.dom.client.Style_Overflow_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$Overflow;)
      ];
    
    result["com.google.gwt.dom.client.Style$Position/548017857"] = [
        @com.google.gwt.dom.client.Style_Position_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Position_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Position;),
        @com.google.gwt.dom.client.Style_Position_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$Position;)
      ];
    
    result["com.google.gwt.dom.client.Style$TableLayout/1430616401"] = [
        @com.google.gwt.dom.client.Style_TableLayout_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_TableLayout_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$TableLayout;),
        @com.google.gwt.dom.client.Style_TableLayout_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$TableLayout;)
      ];
    
    result["com.google.gwt.dom.client.Style$TextDecoration/3846779252"] = [
        @com.google.gwt.dom.client.Style_TextDecoration_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_TextDecoration_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$TextDecoration;),
        @com.google.gwt.dom.client.Style_TextDecoration_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$TextDecoration;)
      ];
    
    result["com.google.gwt.dom.client.Style$Unit/269426519"] = [
        @com.google.gwt.dom.client.Style_Unit_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Unit_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Unit;),
        @com.google.gwt.dom.client.Style_Unit_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$Unit;)
      ];
    
    result["com.google.gwt.dom.client.Style$VerticalAlign/352429624"] = [
        @com.google.gwt.dom.client.Style_VerticalAlign_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_VerticalAlign_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$VerticalAlign;),
        @com.google.gwt.dom.client.Style_VerticalAlign_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$VerticalAlign;)
      ];
    
    result["com.google.gwt.dom.client.Style$Visibility/1861510052"] = [
        @com.google.gwt.dom.client.Style_Visibility_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.dom.client.Style_Visibility_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/dom/client/Style$Visibility;),
        @com.google.gwt.dom.client.Style_Visibility_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/dom/client/Style$Visibility;)
      ];
    
    result["com.google.gwt.i18n.client.DateTimeFormat$PredefinedFormat/229723443"] = [
        @com.google.gwt.i18n.client.DateTimeFormat_PredefinedFormat_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.i18n.client.DateTimeFormat_PredefinedFormat_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/i18n/client/DateTimeFormat$PredefinedFormat;),
        @com.google.gwt.i18n.client.DateTimeFormat_PredefinedFormat_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/i18n/client/DateTimeFormat$PredefinedFormat;)
      ];
    
    result["com.google.gwt.i18n.client.HasDirection$Direction/1284232723"] = [
        @com.google.gwt.i18n.client.HasDirection_Direction_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.i18n.client.HasDirection_Direction_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/i18n/client/HasDirection$Direction;),
        @com.google.gwt.i18n.client.HasDirection_Direction_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/i18n/client/HasDirection$Direction;)
      ];
    
    result["com.google.gwt.i18n.shared.DateTimeFormat$PredefinedFormat/649735428"] = [
        @com.google.gwt.i18n.shared.DateTimeFormat_PredefinedFormat_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.i18n.shared.DateTimeFormat_PredefinedFormat_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/i18n/shared/DateTimeFormat$PredefinedFormat;),
        @com.google.gwt.i18n.shared.DateTimeFormat_PredefinedFormat_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/i18n/shared/DateTimeFormat$PredefinedFormat;)
      ];
    
    result["com.google.gwt.i18n.shared.impl.DateRecord/3375188634"] = [
        @com.google.gwt.i18n.shared.impl.DateRecord_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.i18n.shared.impl.DateRecord_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/i18n/shared/impl/DateRecord;),
        @com.google.gwt.i18n.shared.impl.DateRecord_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/i18n/shared/impl/DateRecord;)
      ];
    
    result["com.google.gwt.layout.client.Layout$Alignment/1758648740"] = [
        @com.google.gwt.layout.client.Layout_Alignment_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.layout.client.Layout_Alignment_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/layout/client/Layout$Alignment;),
        @com.google.gwt.layout.client.Layout_Alignment_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/layout/client/Layout$Alignment;)
      ];
    
    result["com.google.gwt.resources.client.ImageResource$RepeatStyle/2798118115"] = [
        @com.google.gwt.resources.client.ImageResource_RepeatStyle_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.resources.client.ImageResource_RepeatStyle_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/resources/client/ImageResource$RepeatStyle;),
        @com.google.gwt.resources.client.ImageResource_RepeatStyle_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/resources/client/ImageResource$RepeatStyle;)
      ];
    
    result["com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy$KeyboardPagingPolicy/3115114274"] = [
        @com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy_KeyboardPagingPolicy_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy_KeyboardPagingPolicy_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/cellview/client/HasKeyboardPagingPolicy$KeyboardPagingPolicy;),
        @com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy_KeyboardPagingPolicy_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/cellview/client/HasKeyboardPagingPolicy$KeyboardPagingPolicy;)
      ];
    
    result["com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy$KeyboardSelectionPolicy/2212535585"] = [
        @com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy_KeyboardSelectionPolicy_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy_KeyboardSelectionPolicy_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/cellview/client/HasKeyboardSelectionPolicy$KeyboardSelectionPolicy;),
        @com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy_KeyboardSelectionPolicy_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/cellview/client/HasKeyboardSelectionPolicy$KeyboardSelectionPolicy;)
      ];
    
    result["com.google.gwt.user.cellview.client.SimplePager$TextLocation/844327705"] = [
        @com.google.gwt.user.cellview.client.SimplePager_TextLocation_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.cellview.client.SimplePager_TextLocation_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/cellview/client/SimplePager$TextLocation;),
        @com.google.gwt.user.cellview.client.SimplePager_TextLocation_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/cellview/client/SimplePager$TextLocation;)
      ];
    
    result["com.google.gwt.user.client.DocumentModeAsserter$Severity/1368792051"] = [
        @com.google.gwt.user.client.DocumentModeAsserter_Severity_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.DocumentModeAsserter_Severity_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/DocumentModeAsserter$Severity;),
        @com.google.gwt.user.client.DocumentModeAsserter_Severity_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/DocumentModeAsserter$Severity;)
      ];
    
    result["com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533"] = [
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;),
        @com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/rpc/IncompatibleRemoteServiceException;)
      ];
    
    result["com.google.gwt.user.client.rpc.RpcTokenException/2345075298"] = [
        @com.google.gwt.user.client.rpc.RpcTokenException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.RpcTokenException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/RpcTokenException;),
      ];
    
    result["com.google.gwt.user.client.rpc.XsrfToken/4254043109"] = [
        ,
        ,
        @com.google.gwt.user.client.rpc.XsrfToken_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/rpc/XsrfToken;)
      ];
    
    result["com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter$ResponseReader/3885798731"] = [
        @com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter_ResponseReader_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter_ResponseReader_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/rpc/impl/RequestCallbackAdapter$ResponseReader;),
        @com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter_ResponseReader_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/rpc/impl/RequestCallbackAdapter$ResponseReader;)
      ];
    
    result["com.google.gwt.user.client.ui.ChangeListenerCollection/287642957"] = [
        @com.google.gwt.user.client.ui.ChangeListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.ChangeListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/ChangeListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.ClickListenerCollection/2152455986"] = [
        @com.google.gwt.user.client.ui.ClickListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.ClickListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/ClickListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.DockLayoutPanel$Direction/1124902987"] = [
        @com.google.gwt.user.client.ui.DockLayoutPanel_Direction_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.DockLayoutPanel_Direction_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/DockLayoutPanel$Direction;),
        @com.google.gwt.user.client.ui.DockLayoutPanel_Direction_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/ui/DockLayoutPanel$Direction;)
      ];
    
    result["com.google.gwt.user.client.ui.FocusListenerCollection/119490835"] = [
        @com.google.gwt.user.client.ui.FocusListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.FocusListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/FocusListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.FormHandlerCollection/3088681894"] = [
        @com.google.gwt.user.client.ui.FormHandlerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.FormHandlerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/FormHandlerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.KeyboardListenerCollection/1040442242"] = [
        @com.google.gwt.user.client.ui.KeyboardListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.KeyboardListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/KeyboardListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.LoadListenerCollection/3174178888"] = [
        @com.google.gwt.user.client.ui.LoadListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.LoadListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/LoadListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.MouseListenerCollection/465158911"] = [
        @com.google.gwt.user.client.ui.MouseListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.MouseListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/MouseListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.MouseWheelListenerCollection/370304552"] = [
        @com.google.gwt.user.client.ui.MouseWheelListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.MouseWheelListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/MouseWheelListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion/2803420099"] = [
        @com.google.gwt.user.client.ui.MultiWordSuggestOracle_MultiWordSuggestion_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.MultiWordSuggestOracle_MultiWordSuggestion_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/MultiWordSuggestOracle$MultiWordSuggestion;),
      ];
    
    result["[Lcom.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion;/1531882420"] = [
        @com.google.gwt.user.client.ui.MultiWordSuggestOracle_MultiWordSuggestion_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.MultiWordSuggestOracle_MultiWordSuggestion_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/google/gwt/user/client/ui/MultiWordSuggestOracle$MultiWordSuggestion;),
      ];
    
    result["com.google.gwt.user.client.ui.PopupListenerCollection/1920131050"] = [
        @com.google.gwt.user.client.ui.PopupListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.PopupListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/PopupListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.PopupPanel$AnimationType/2686977168"] = [
        @com.google.gwt.user.client.ui.PopupPanel_AnimationType_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.PopupPanel_AnimationType_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/PopupPanel$AnimationType;),
        @com.google.gwt.user.client.ui.PopupPanel_AnimationType_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/ui/PopupPanel$AnimationType;)
      ];
    
    result["com.google.gwt.user.client.ui.ScrollListenerCollection/210686268"] = [
        @com.google.gwt.user.client.ui.ScrollListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.ScrollListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/ScrollListenerCollection;),
      ];
    
    result["[Lcom.google.gwt.user.client.ui.SuggestOracle$Suggestion;/3224244884"] = [
        @com.google.gwt.user.client.ui.SuggestOracle_Suggestion_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.SuggestOracle_Suggestion_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/google/gwt/user/client/ui/SuggestOracle$Suggestion;),
      ];
    
    result["com.google.gwt.user.client.ui.TabListenerCollection/3768293299"] = [
        @com.google.gwt.user.client.ui.TabListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.TabListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/TabListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.TableListenerCollection/2254740473"] = [
        @com.google.gwt.user.client.ui.TableListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.TableListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/TableListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.TreeListenerCollection/3716243734"] = [
        @com.google.gwt.user.client.ui.TreeListenerCollection_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.TreeListenerCollection_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/TreeListenerCollection;),
      ];
    
    result["com.google.gwt.user.client.ui.ValueBoxBase$TextAlignment/3036099298"] = [
        @com.google.gwt.user.client.ui.ValueBoxBase_TextAlignment_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.ui.ValueBoxBase_TextAlignment_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/user/client/ui/ValueBoxBase$TextAlignment;),
        @com.google.gwt.user.client.ui.ValueBoxBase_TextAlignment_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/user/client/ui/ValueBoxBase$TextAlignment;)
      ];
    
    result["com.google.gwt.view.client.DefaultSelectionEventManager$SelectAction/3096171525"] = [
        @com.google.gwt.view.client.DefaultSelectionEventManager_SelectAction_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.view.client.DefaultSelectionEventManager_SelectAction_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/google/gwt/view/client/DefaultSelectionEventManager$SelectAction;),
        @com.google.gwt.view.client.DefaultSelectionEventManager_SelectAction_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/google/gwt/view/client/DefaultSelectionEventManager$SelectAction;)
      ];
    
    result["com.numhero.client.model.datacargo.GlobalSearchListRequest/1415047289"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.GlobalSearchListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/GlobalSearchListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.GlobalSearchListResponse/2773384870"] = [
        @com.numhero.client.model.datacargo.GlobalSearchListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.GlobalSearchListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/GlobalSearchListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.account.AccountListRequest/2778263853"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.account.AccountListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/account/AccountListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.account.AccountListResponse/2409187366"] = [
        @com.numhero.client.model.datacargo.account.AccountListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.account.AccountListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/account/AccountListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.account.ExpenseAccountListRequest/3541968901"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.account.ExpenseAccountListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/account/ExpenseAccountListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.auth.AuthRequest/3523095594"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.auth.AuthRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/auth/AuthRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.auth.AuthResponse/2772891835"] = [
        @com.numhero.client.model.datacargo.auth.AuthResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.auth.AuthResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/auth/AuthResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.bankaccount.BankAccountListRequest/285927829"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.bankaccount.BankAccountListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/bankaccount/BankAccountListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.bankaccount.BankAccountListResponse/2949603313"] = [
        @com.numhero.client.model.datacargo.bankaccount.BankAccountListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.bankaccount.BankAccountListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/bankaccount/BankAccountListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.bankaccount.DeleteBankAccountsRequest/3655399674"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.bankaccount.DeleteBankAccountsRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/bankaccount/DeleteBankAccountsRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.bankaccount.GetBankAccountRequest/1912745531"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.bankaccount.GetBankAccountRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/bankaccount/GetBankAccountRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.bankaccount.GetBankAccountResponse/691990797"] = [
        @com.numhero.client.model.datacargo.bankaccount.GetBankAccountResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.bankaccount.GetBankAccountResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/bankaccount/GetBankAccountResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.bankaccount.GetMainTradingBankAccountRequest/1603623706"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.bankaccount.GetMainTradingBankAccountRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/bankaccount/GetMainTradingBankAccountRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.bankaccount.GetMainTradingBankAccountResponse/1160678858"] = [
        @com.numhero.client.model.datacargo.bankaccount.GetMainTradingBankAccountResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.bankaccount.GetMainTradingBankAccountResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/bankaccount/GetMainTradingBankAccountResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.bankaccount.SaveBankAccountRequest/3088907543"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.bankaccount.SaveBankAccountRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/bankaccount/SaveBankAccountRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.bankaccount.SaveBankAccountResponse/3730039240"] = [
        @com.numhero.client.model.datacargo.bankaccount.SaveBankAccountResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.bankaccount.SaveBankAccountResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/bankaccount/SaveBankAccountResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.banktransaction.BankTransactionListRequest/34955617"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.banktransaction.BankTransactionListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/banktransaction/BankTransactionListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse/3586002529"] = [
        @com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/banktransaction/BankTransactionListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.banktransaction.DeleteBankTransactionsRequest/2297198804"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.banktransaction.DeleteBankTransactionsRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/banktransaction/DeleteBankTransactionsRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.banktransaction.GetBankTransactionRequest/50265061"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.banktransaction.GetBankTransactionRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/banktransaction/GetBankTransactionRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.banktransaction.GetBankTransactionResponse/3441293070"] = [
        @com.numhero.client.model.datacargo.banktransaction.GetBankTransactionResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.banktransaction.GetBankTransactionResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/banktransaction/GetBankTransactionResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionRequest/3335398039"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/banktransaction/SaveBankTransactionRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionResponse/2458697293"] = [
        @com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/banktransaction/SaveBankTransactionResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountRequest/3104897775"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/businessaccount/GetBusinessAccountRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountResponse/405084058"] = [
        @com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/businessaccount/GetBusinessAccountResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest/2301758768"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/businessaccount/SaveBusinessAccountRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse/3072429847"] = [
        @com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/businessaccount/SaveBusinessAccountResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListRequest/3228902633"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/businesstransaction/BusinessTransactionListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListResponse/564758270"] = [
        @com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/businesstransaction/BusinessTransactionListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionRequest/1399209423"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/businesstransaction/GetBusinessTransactionRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionResponse/2268279115"] = [
        @com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/businesstransaction/GetBusinessTransactionResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.category.CategoryListRequest/1807937467"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.category.CategoryListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/category/CategoryListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.category.CategoryListResponse/741266905"] = [
        @com.numhero.client.model.datacargo.category.CategoryListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.category.CategoryListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/category/CategoryListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.category.DeleteCategoriesRequest/3216781130"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.category.DeleteCategoriesRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/category/DeleteCategoriesRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.category.GetCategoryRequest/1777780323"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.category.GetCategoryRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/category/GetCategoryRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.category.SaveCategoryRequest/163924632"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.category.SaveCategoryRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/category/SaveCategoryRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.client_supplier.ClientListRequest/3942858711"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.client_supplier.ClientListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/client_supplier/ClientListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse/1226992143"] = [
        @com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/client_supplier/ClientSupplierListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest/3482739333"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/client_supplier/DeleteClientsSuppliersRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.client_supplier.GetClientSupplierRequest/1702853917"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.client_supplier.GetClientSupplierRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/client_supplier/GetClientSupplierRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest/2671794519"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/client_supplier/SaveClientSupplierRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.client_supplier.SupplierListRequest/1425530501"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.client_supplier.SupplierListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/client_supplier/SupplierListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.currency.ConversionBean/5209266"] = [
        @com.numhero.client.model.datacargo.currency.ConversionBean_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.currency.ConversionBean_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/currency/ConversionBean;),
        @com.numhero.client.model.datacargo.currency.ConversionBean_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/currency/ConversionBean;)
      ];
    
    result["com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest/579293438"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/currency/GetCurrencyConversionRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse/3480043506"] = [
        @com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/currency/GetCurrencyConversionResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.expense.DeleteReceiptsRequest/800809633"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.expense.DeleteReceiptsRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/expense/DeleteReceiptsRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.expense.GetReceiptRequest/3951230355"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.expense.GetReceiptRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/expense/GetReceiptRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.expense.GetReceiptResponse/1802170109"] = [
        @com.numhero.client.model.datacargo.expense.GetReceiptResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.expense.GetReceiptResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/expense/GetReceiptResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.expense.GetUnbilledReceiptRequest/2867227619"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.expense.GetUnbilledReceiptRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/expense/GetUnbilledReceiptRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.expense.ReceiptsBilledStatusRequest/36231013"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.expense.ReceiptsBilledStatusRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/expense/ReceiptsBilledStatusRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest/3782048366"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/expense/ReceiptsBillingListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.expense.ReceiptsListRequest/1267250518"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.expense.ReceiptsListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/expense/ReceiptsListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.expense.ReceiptsListResponse/787101621"] = [
        @com.numhero.client.model.datacargo.expense.ReceiptsListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.expense.ReceiptsListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/expense/ReceiptsListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.expense.SaveReceiptRequest/3619677380"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.expense.SaveReceiptRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/expense/SaveReceiptRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.expense.SaveReceiptResponse/3633693367"] = [
        @com.numhero.client.model.datacargo.expense.SaveReceiptResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.expense.SaveReceiptResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/expense/SaveReceiptResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.expense.SetToPaidReceiptsRequest/823407606"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.expense.SetToPaidReceiptsRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/expense/SetToPaidReceiptsRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.expense.UnpaidReceiptsListRequest/1560140714"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.expense.UnpaidReceiptsListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/expense/UnpaidReceiptsListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.home.GetHomeRecapRequest/2513666458"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.home.GetHomeRecapRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/home/GetHomeRecapRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.home.GetHomeRecapResponse/2592194150"] = [
        @com.numhero.client.model.datacargo.home.GetHomeRecapResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.home.GetHomeRecapResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/home/GetHomeRecapResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest/1365334999"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/invoice/ChangeStatusOfDocumentsRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest/1426432063"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/invoice/ConvertToInvoiceRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.invoice.DeleteDocumentsRequest/433466953"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.invoice.DeleteDocumentsRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/invoice/DeleteDocumentsRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.invoice.GetInvoiceRequest/2198754457"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.invoice.GetInvoiceRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/invoice/GetInvoiceRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.invoice.InvoiceListRequest/2368069121"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.invoice.InvoiceListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/invoice/InvoiceListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.invoice.InvoiceListResponse/3656705939"] = [
        @com.numhero.client.model.datacargo.invoice.InvoiceListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.invoice.InvoiceListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/invoice/InvoiceListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest/3718780255"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/invoice/SaveInvoiceRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.invoice.SendInvoiceRequest/2885623757"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.invoice.SendInvoiceRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/invoice/SendInvoiceRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.moneyin.MoneyInRecapRequest/3038489661"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.moneyin.MoneyInRecapRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/moneyin/MoneyInRecapRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse/2267306801"] = [
        @com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/moneyin/MoneyInRecapResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.moneyout.MoneyOutRecapRequest/237290167"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.moneyout.MoneyOutRecapRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/moneyout/MoneyOutRecapRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse/8295472"] = [
        @com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/moneyout/MoneyOutRecapResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.product.DeleteProductsRequest/90583503"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.product.DeleteProductsRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/product/DeleteProductsRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.product.GetItemRequest/1211369307"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.product.GetItemRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/product/GetItemRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.product.GetItemResponse/640414491"] = [
        @com.numhero.client.model.datacargo.product.GetItemResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.product.GetItemResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/product/GetItemResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.product.ProductListResponse/4070669360"] = [
        @com.numhero.client.model.datacargo.product.ProductListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.product.ProductListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/product/ProductListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.product.ProductServicesListRequest/116089481"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.product.ProductServicesListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/product/ProductServicesListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.product.SaveProductRequest/918443797"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.product.SaveProductRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/product/SaveProductRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.product.SaveProductResponse/1318298314"] = [
        @com.numhero.client.model.datacargo.product.SaveProductResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.product.SaveProductResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/product/SaveProductResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.project.DeleteProjectsRequest/1044347972"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.project.DeleteProjectsRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/project/DeleteProjectsRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.project.GetProjectRequest/2528371432"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.project.GetProjectRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/project/GetProjectRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.project.GetProjectResponse/2155205757"] = [
        @com.numhero.client.model.datacargo.project.GetProjectResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.project.GetProjectResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/project/GetProjectResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.project.ProjectGenerateEstimatesRequest/2347274469"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.project.ProjectGenerateEstimatesRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/project/ProjectGenerateEstimatesRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceRequest/2289661517"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/project/ProjectGenerateInvoiceRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceResponse/2890295228"] = [
        @com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/project/ProjectGenerateInvoiceResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.project.ProjectListRequest/1169967495"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.project.ProjectListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/project/ProjectListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.project.ProjectListResponse/1790163104"] = [
        @com.numhero.client.model.datacargo.project.ProjectListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.project.ProjectListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/project/ProjectListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.project.SaveProjectRequest/1554365846"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.project.SaveProjectRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/project/SaveProjectRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.project.SaveProjectResponse/643760575"] = [
        @com.numhero.client.model.datacargo.project.SaveProjectResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.project.SaveProjectResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/project/SaveProjectResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.project.StaffProjectsListRequest/1192220939"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.project.StaffProjectsListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/project/StaffProjectsListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.project.StaffProjectsListResponse/2470358130"] = [
        @com.numhero.client.model.datacargo.project.StaffProjectsListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.project.StaffProjectsListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/project/StaffProjectsListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest/828284416"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/report/chartofaccounts/AccountBalanceRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse/1902922380"] = [
        @com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/report/chartofaccounts/AccountBalanceResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsRequest/373171461"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/report/chartofaccounts/ChartOfAccountsRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse/838240676"] = [
        @com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/report/chartofaccounts/ChartOfAccountsResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.report.deposits.DepositsRequest/902090805"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.report.deposits.DepositsRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/report/deposits/DepositsRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.report.profitloss.GetProfitLossRequest/4190476728"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.report.profitloss.GetProfitLossRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/report/profitloss/GetProfitLossRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse/556862267"] = [
        @com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/report/profitloss/GetProfitLossResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.report.receivables.ReceivablesRequest/1411668717"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.report.receivables.ReceivablesRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/report/receivables/ReceivablesRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.report.taxes.TaxesRequest/799634893"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.report.taxes.TaxesRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/report/taxes/TaxesRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceRequest/62915179"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/report/trialbalance/TrialBalanceRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse/3016441642"] = [
        @com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/report/trialbalance/TrialBalanceResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.report.vat.VATRequest/159286927"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.report.vat.VATRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/report/vat/VATRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.staff.DeleteStaffRequest/2933393746"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.staff.DeleteStaffRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/staff/DeleteStaffRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest/3340411610"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/staff/DirectPaymentStaffListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.staff.GetStaffRequest/3639519983"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.staff.GetStaffRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/staff/GetStaffRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.staff.GetStaffResponse/705297605"] = [
        @com.numhero.client.model.datacargo.staff.GetStaffResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.staff.GetStaffResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/staff/GetStaffResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest/2061135771"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/staff/ReimbursableStaffListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.staff.SaveStaffRequest/1456858727"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.staff.SaveStaffRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/staff/SaveStaffRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.staff.SaveStaffResponse/2513995753"] = [
        @com.numhero.client.model.datacargo.staff.SaveStaffResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.staff.SaveStaffResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/staff/SaveStaffResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.staff.StaffListRequest/1256742212"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.staff.StaffListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/staff/StaffListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.staff.StaffListResponse/2442341319"] = [
        @com.numhero.client.model.datacargo.staff.StaffListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.staff.StaffListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/staff/StaffListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.task.DeleteTasksRequest/3043837057"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.task.DeleteTasksRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/task/DeleteTasksRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.task.GetTaskRequest/685043340"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.task.GetTaskRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/task/GetTaskRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.task.GetTaskResponse/1665705933"] = [
        @com.numhero.client.model.datacargo.task.GetTaskResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.task.GetTaskResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/task/GetTaskResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.task.ProjectTasksListRequest/77671078"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.task.ProjectTasksListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/task/ProjectTasksListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.task.ProjectTasksListResponse/2807959834"] = [
        @com.numhero.client.model.datacargo.task.ProjectTasksListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.task.ProjectTasksListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/task/ProjectTasksListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.task.SaveTaskRequest/1475878870"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.task.SaveTaskRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/task/SaveTaskRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.task.SaveTaskResponse/4278115533"] = [
        @com.numhero.client.model.datacargo.task.SaveTaskResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.task.SaveTaskResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/task/SaveTaskResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.task.TaskListRequest/814671622"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.task.TaskListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/task/TaskListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.task.TaskListResponse/1034211273"] = [
        @com.numhero.client.model.datacargo.task.TaskListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.task.TaskListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/task/TaskListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.taxinfo.DeleteTaxInfosRequest/854384337"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.taxinfo.DeleteTaxInfosRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/taxinfo/DeleteTaxInfosRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.taxinfo.GetTaxInfoRequest/1477072542"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.taxinfo.GetTaxInfoRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/taxinfo/GetTaxInfoRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse/1173436341"] = [
        @com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/taxinfo/GetTaxInfoResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoRequest/1819449239"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/taxinfo/SaveTaxInfoRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoResponse/1456052279"] = [
        @com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/taxinfo/SaveTaxInfoResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.taxinfo.TaxInfoListRequest/3303747890"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.taxinfo.TaxInfoListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/taxinfo/TaxInfoListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse/2930014386"] = [
        @com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/taxinfo/TaxInfoListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.timeentry.DeleteTimeEntriesRequest/3312663709"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.timeentry.DeleteTimeEntriesRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/timeentry/DeleteTimeEntriesRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.timeentry.GetTimeEntryRequest/3983292273"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.timeentry.GetTimeEntryRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/timeentry/GetTimeEntryRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.timeentry.GetTimeEntryResponse/3605365335"] = [
        @com.numhero.client.model.datacargo.timeentry.GetTimeEntryResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.timeentry.GetTimeEntryResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/timeentry/GetTimeEntryResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.timeentry.SaveTimeEntryRequest/967967633"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.timeentry.SaveTimeEntryRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/timeentry/SaveTimeEntryRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.timeentry.SaveTimeEntryResponse/1209774166"] = [
        @com.numhero.client.model.datacargo.timeentry.SaveTimeEntryResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.timeentry.SaveTimeEntryResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/timeentry/SaveTimeEntryResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.timeentry.TimeEntriesBilledStatusRequest/1127846168"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.timeentry.TimeEntriesBilledStatusRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/timeentry/TimeEntriesBilledStatusRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.timeentry.TimeEntryBillingListRequest/2974096383"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.timeentry.TimeEntryBillingListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/timeentry/TimeEntryBillingListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest/1689839279"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/timeentry/TimeEntryListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.timeentry.TimeEntryListResponse/1968718203"] = [
        @com.numhero.client.model.datacargo.timeentry.TimeEntryListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.timeentry.TimeEntryListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/timeentry/TimeEntryListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.user.DeleteUsersRequest/2544097544"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.user.DeleteUsersRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/user/DeleteUsersRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.user.GetUserRequest/4140023347"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.user.GetUserRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/user/GetUserRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.user.GetUserResponse/913876242"] = [
        @com.numhero.client.model.datacargo.user.GetUserResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.user.GetUserResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/user/GetUserResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.user.ReactivateUsersRequest/3609337106"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.user.ReactivateUsersRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/user/ReactivateUsersRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.user.SaveUserRequest/394828003"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.user.SaveUserRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/user/SaveUserRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.user.SaveUserResponse/3048250915"] = [
        @com.numhero.client.model.datacargo.user.SaveUserResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.user.SaveUserResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/user/SaveUserResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.user.SuspendUsersRequest/3588810177"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.user.SuspendUsersRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/user/SuspendUsersRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.user.UserListRequest/2152122457"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.user.UserListRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/user/UserListRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.user.UserListResponse/3394798223"] = [
        @com.numhero.client.model.datacargo.user.UserListResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.user.UserListResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/user/UserListResponse;),
      ];
    
    result["com.numhero.client.model.datacargo.usermessage.SaveUserMessageRequest/2399314241"] = [
        ,
        ,
        @com.numhero.client.model.datacargo.usermessage.SaveUserMessageRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/datacargo/usermessage/SaveUserMessageRequest;)
      ];
    
    result["com.numhero.client.model.datacargo.usermessage.SaveUserMessageResponse/428762030"] = [
        @com.numhero.client.model.datacargo.usermessage.SaveUserMessageResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.datacargo.usermessage.SaveUserMessageResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/datacargo/usermessage/SaveUserMessageResponse;),
      ];
    
    result["com.numhero.client.model.pojoc.AccountBalanceRow/1902321997"] = [
        @com.numhero.client.model.pojoc.AccountBalanceRow_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.AccountBalanceRow_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/AccountBalanceRow;),
      ];
    
    result["[Lcom.numhero.client.model.pojoc.AccountBalanceRow;/1754777518"] = [
        @com.numhero.client.model.pojoc.AccountBalanceRow_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.AccountBalanceRow_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/AccountBalanceRow;),
      ];
    
    result["com.numhero.client.model.pojoc.AccountingLeg/4125162674"] = [
        @com.numhero.client.model.pojoc.AccountingLeg_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.AccountingLeg_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/AccountingLeg;),
        @com.numhero.client.model.pojoc.AccountingLeg_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/AccountingLeg;)
      ];
    
    result["com.numhero.client.model.pojoc.BalanceSheetRow/1413226503"] = [
        @com.numhero.client.model.pojoc.BalanceSheetRow_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.BalanceSheetRow_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/BalanceSheetRow;),
      ];
    
    result["[Lcom.numhero.client.model.pojoc.BalanceSheetRow;/2059252156"] = [
        @com.numhero.client.model.pojoc.BalanceSheetRow_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.BalanceSheetRow_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/BalanceSheetRow;),
      ];
    
    result["com.numhero.client.model.pojoc.BankAccount/3380069698"] = [
        @com.numhero.client.model.pojoc.BankAccount_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.BankAccount_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/BankAccount;),
        @com.numhero.client.model.pojoc.BankAccount_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/BankAccount;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.BankAccount;/352899095"] = [
        @com.numhero.client.model.pojoc.BankAccount_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.BankAccount_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/BankAccount;),
      ];
    
    result["com.numhero.client.model.pojoc.BankTransaction/549380439"] = [
        @com.numhero.client.model.pojoc.BankTransaction_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.BankTransaction_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/BankTransaction;),
        @com.numhero.client.model.pojoc.BankTransaction_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/BankTransaction;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.BankTransaction;/2661502968"] = [
        @com.numhero.client.model.pojoc.BankTransaction_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.BankTransaction_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/BankTransaction;),
      ];
    
    result["com.numhero.client.model.pojoc.BusinessAccount/3599369956"] = [
        @com.numhero.client.model.pojoc.BusinessAccount_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.BusinessAccount_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/BusinessAccount;),
        @com.numhero.client.model.pojoc.BusinessAccount_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/BusinessAccount;)
      ];
    
    result["com.numhero.client.model.pojoc.BusinessTransaction/2760065969"] = [
        @com.numhero.client.model.pojoc.BusinessTransaction_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.BusinessTransaction_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/BusinessTransaction;),
        @com.numhero.client.model.pojoc.BusinessTransaction_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/BusinessTransaction;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.BusinessTransaction;/3364130227"] = [
        @com.numhero.client.model.pojoc.BusinessTransaction_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.BusinessTransaction_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/BusinessTransaction;),
      ];
    
    result["com.numhero.client.model.pojoc.Category/864344537"] = [
        @com.numhero.client.model.pojoc.Category_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.Category_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/Category;),
        @com.numhero.client.model.pojoc.Category_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/Category;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.Category;/157292121"] = [
        @com.numhero.client.model.pojoc.Category_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.Category_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/Category;),
      ];
    
    result["com.numhero.client.model.pojoc.ClientSupplier/160860766"] = [
        @com.numhero.client.model.pojoc.ClientSupplier_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.ClientSupplier_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/ClientSupplier;),
        @com.numhero.client.model.pojoc.ClientSupplier_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/ClientSupplier;)
      ];
    
    result["com.numhero.client.model.pojoc.ClientSupplierContact/1552600155"] = [
        @com.numhero.client.model.pojoc.ClientSupplierContact_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.ClientSupplierContact_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/ClientSupplierContact;),
        @com.numhero.client.model.pojoc.ClientSupplierContact_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/ClientSupplierContact;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.ClientSupplier;/1689176280"] = [
        @com.numhero.client.model.pojoc.ClientSupplier_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.ClientSupplier_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/ClientSupplier;),
      ];
    
    result["com.numhero.client.model.pojoc.ExpenseReceipt/3402698023"] = [
        @com.numhero.client.model.pojoc.ExpenseReceipt_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.ExpenseReceipt_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/ExpenseReceipt;),
        @com.numhero.client.model.pojoc.ExpenseReceipt_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/ExpenseReceipt;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.ExpenseReceipt;/4054639204"] = [
        @com.numhero.client.model.pojoc.ExpenseReceipt_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.ExpenseReceipt_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/ExpenseReceipt;),
      ];
    
    result["com.numhero.client.model.pojoc.Invoice/421963278"] = [
        @com.numhero.client.model.pojoc.Invoice_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.Invoice_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/Invoice;),
        @com.numhero.client.model.pojoc.Invoice_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/Invoice;)
      ];
    
    result["com.numhero.client.model.pojoc.InvoiceDetail/549076338"] = [
        @com.numhero.client.model.pojoc.InvoiceDetail_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.InvoiceDetail_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/InvoiceDetail;),
        @com.numhero.client.model.pojoc.InvoiceDetail_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/InvoiceDetail;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.Invoice;/2376911255"] = [
        @com.numhero.client.model.pojoc.Invoice_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.Invoice_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/Invoice;),
      ];
    
    result["com.numhero.client.model.pojoc.MoneyInOutRecapRow/2219631580"] = [
        @com.numhero.client.model.pojoc.MoneyInOutRecapRow_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.MoneyInOutRecapRow_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/MoneyInOutRecapRow;),
      ];
    
    result["[Lcom.numhero.client.model.pojoc.MoneyInOutRecapRow;/3580751726"] = [
        @com.numhero.client.model.pojoc.MoneyInOutRecapRow_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.MoneyInOutRecapRow_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/MoneyInOutRecapRow;),
      ];
    
    result["com.numhero.client.model.pojoc.NominalLedgerAccount/2051633461"] = [
        @com.numhero.client.model.pojoc.NominalLedgerAccount_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.NominalLedgerAccount_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/NominalLedgerAccount;),
        @com.numhero.client.model.pojoc.NominalLedgerAccount_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/NominalLedgerAccount;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.NominalLedgerAccount;/131089151"] = [
        @com.numhero.client.model.pojoc.NominalLedgerAccount_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.NominalLedgerAccount_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/NominalLedgerAccount;),
      ];
    
    result["com.numhero.client.model.pojoc.ProductService/1235013462"] = [
        @com.numhero.client.model.pojoc.ProductService_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.ProductService_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/ProductService;),
        @com.numhero.client.model.pojoc.ProductService_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/ProductService;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.ProductService;/2568585669"] = [
        @com.numhero.client.model.pojoc.ProductService_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.ProductService_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/ProductService;),
      ];
    
    result["com.numhero.client.model.pojoc.Project/3493186853"] = [
        @com.numhero.client.model.pojoc.Project_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.Project_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/Project;),
        @com.numhero.client.model.pojoc.Project_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/Project;)
      ];
    
    result["com.numhero.client.model.pojoc.ProjectStaffDetail/1185165357"] = [
        @com.numhero.client.model.pojoc.ProjectStaffDetail_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.ProjectStaffDetail_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/ProjectStaffDetail;),
        @com.numhero.client.model.pojoc.ProjectStaffDetail_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/ProjectStaffDetail;)
      ];
    
    result["com.numhero.client.model.pojoc.ProjectTaskDetail/1425337177"] = [
        @com.numhero.client.model.pojoc.ProjectTaskDetail_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.ProjectTaskDetail_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/ProjectTaskDetail;),
        @com.numhero.client.model.pojoc.ProjectTaskDetail_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/ProjectTaskDetail;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.Project;/253590211"] = [
        @com.numhero.client.model.pojoc.Project_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.Project_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/Project;),
      ];
    
    result["com.numhero.client.model.pojoc.Staff/3067237141"] = [
        @com.numhero.client.model.pojoc.Staff_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.Staff_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/Staff;),
        @com.numhero.client.model.pojoc.Staff_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/Staff;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.Staff;/3695232072"] = [
        @com.numhero.client.model.pojoc.Staff_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.Staff_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/Staff;),
      ];
    
    result["com.numhero.client.model.pojoc.Task/3125812632"] = [
        @com.numhero.client.model.pojoc.Task_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.Task_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/Task;),
        @com.numhero.client.model.pojoc.Task_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/Task;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.Task;/3139782620"] = [
        @com.numhero.client.model.pojoc.Task_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.Task_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/Task;),
      ];
    
    result["com.numhero.client.model.pojoc.TaxInfo/1278648742"] = [
        @com.numhero.client.model.pojoc.TaxInfo_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.TaxInfo_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/TaxInfo;),
        @com.numhero.client.model.pojoc.TaxInfo_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/TaxInfo;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.TaxInfo;/1832304194"] = [
        @com.numhero.client.model.pojoc.TaxInfo_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.TaxInfo_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/TaxInfo;),
      ];
    
    result["com.numhero.client.model.pojoc.TimeEntry/3268799324"] = [
        @com.numhero.client.model.pojoc.TimeEntry_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.TimeEntry_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/TimeEntry;),
        @com.numhero.client.model.pojoc.TimeEntry_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/TimeEntry;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.TimeEntry;/3254322577"] = [
        @com.numhero.client.model.pojoc.TimeEntry_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.TimeEntry_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/TimeEntry;),
      ];
    
    result["com.numhero.client.model.pojoc.User/920365610"] = [
        @com.numhero.client.model.pojoc.User_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.User_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/User;),
        @com.numhero.client.model.pojoc.User_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/User;)
      ];
    
    result["com.numhero.client.model.pojoc.UserDetail/3419498336"] = [
        @com.numhero.client.model.pojoc.UserDetail_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.UserDetail_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/UserDetail;),
        @com.numhero.client.model.pojoc.UserDetail_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/UserDetail;)
      ];
    
    result["com.numhero.client.model.pojoc.UserMessage/4227829079"] = [
        @com.numhero.client.model.pojoc.UserMessage_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.UserMessage_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/model/pojoc/UserMessage;),
        @com.numhero.client.model.pojoc.UserMessage_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/model/pojoc/UserMessage;)
      ];
    
    result["[Lcom.numhero.client.model.pojoc.UserMessage;/3748085439"] = [
        @com.numhero.client.model.pojoc.UserMessage_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.UserMessage_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/UserMessage;),
      ];
    
    result["[Lcom.numhero.client.model.pojoc.User;/4229133123"] = [
        @com.numhero.client.model.pojoc.User_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.model.pojoc.User_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/client/model/pojoc/User;),
      ];
    
    result["com.numhero.client.widget.HeaderLine$Tab/3183962440"] = [
        @com.numhero.client.widget.HeaderLine_Tab_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.widget.HeaderLine_Tab_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/widget/HeaderLine$Tab;),
        @com.numhero.client.widget.HeaderLine_Tab_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/widget/HeaderLine$Tab;)
      ];
    
    result["com.numhero.client.widget.InfoPanel$InfoPanelType/1774755255"] = [
        @com.numhero.client.widget.InfoPanel_InfoPanelType_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.widget.InfoPanel_InfoPanelType_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/widget/InfoPanel$InfoPanelType;),
        @com.numhero.client.widget.InfoPanel_InfoPanelType_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/widget/InfoPanel$InfoPanelType;)
      ];
    
    result["com.numhero.client.widget.TabBar$INumheroTab/2222550768"] = [
        @com.numhero.client.widget.TabBar_INumheroTab_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.widget.TabBar_INumheroTab_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/widget/TabBar$INumheroTab;),
        @com.numhero.client.widget.TabBar_INumheroTab_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/widget/TabBar$INumheroTab;)
      ];
    
    result["com.numhero.client.widget.filter.BAPojoFilter/3513957671"] = [
        ,
        ,
        @com.numhero.client.widget.filter.BAPojoFilter_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/widget/filter/BAPojoFilter;)
      ];
    
    result["com.numhero.client.widget.table.MouseEvent$EventType/3192759283"] = [
        @com.numhero.client.widget.table.MouseEvent_EventType_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.client.widget.table.MouseEvent_EventType_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/client/widget/table/MouseEvent$EventType;),
        @com.numhero.client.widget.table.MouseEvent_EventType_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/client/widget/table/MouseEvent$EventType;)
      ];
    
    result["com.numhero.shared.datacargo.BulkActionRequest/987043168"] = [
        ,
        ,
        @com.numhero.shared.datacargo.BulkActionRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/datacargo/BulkActionRequest;)
      ];
    
    result["com.numhero.shared.datacargo.BulkActionResponse/4124045909"] = [
        @com.numhero.shared.datacargo.BulkActionResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.datacargo.BulkActionResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/datacargo/BulkActionResponse;),
      ];
    
    result["com.numhero.shared.datacargo.GetSingleEntityResponse/1015660428"] = [
        @com.numhero.shared.datacargo.GetSingleEntityResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.datacargo.GetSingleEntityResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/datacargo/GetSingleEntityResponse;),
      ];
    
    result["com.numhero.shared.datacargo.ListCommandRequest/1304944093"] = [
        ,
        ,
        @com.numhero.shared.datacargo.ListCommandRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/datacargo/ListCommandRequest;)
      ];
    
    result["com.numhero.shared.datacargo.ListCommandRequest$TYPE/1600406708"] = [
        @com.numhero.shared.datacargo.ListCommandRequest_TYPE_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.datacargo.ListCommandRequest_TYPE_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/datacargo/ListCommandRequest$TYPE;),
        @com.numhero.shared.datacargo.ListCommandRequest_TYPE_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/datacargo/ListCommandRequest$TYPE;)
      ];
    
    result["com.numhero.shared.datacargo.ListCommandResponse/2223501275"] = [
        @com.numhero.shared.datacargo.ListCommandResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.datacargo.ListCommandResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/datacargo/ListCommandResponse;),
      ];
    
    result["com.numhero.shared.datacargo.SaveSingleEntityRequest/2448965411"] = [
        ,
        ,
        @com.numhero.shared.datacargo.SaveSingleEntityRequest_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/datacargo/SaveSingleEntityRequest;)
      ];
    
    result["com.numhero.shared.datacargo.SaveSingleEntityResponse/2079662726"] = [
        @com.numhero.shared.datacargo.SaveSingleEntityResponse_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.datacargo.SaveSingleEntityResponse_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/datacargo/SaveSingleEntityResponse;),
      ];
    
    result["com.numhero.shared.enums.AccountClassEnum/673822520"] = [
        @com.numhero.shared.enums.AccountClassEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.AccountClassEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/AccountClassEnum;),
        @com.numhero.shared.enums.AccountClassEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/AccountClassEnum;)
      ];
    
    result["com.numhero.shared.enums.AccountingEntrySide/486987885"] = [
        @com.numhero.shared.enums.AccountingEntrySide_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.AccountingEntrySide_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/AccountingEntrySide;),
        @com.numhero.shared.enums.AccountingEntrySide_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/AccountingEntrySide;)
      ];
    
    result["com.numhero.shared.enums.AccountingGroupEnum/2168275085"] = [
        @com.numhero.shared.enums.AccountingGroupEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.AccountingGroupEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/AccountingGroupEnum;),
        @com.numhero.shared.enums.AccountingGroupEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/AccountingGroupEnum;)
      ];
    
    result["com.numhero.shared.enums.BalanceSheetEnum/4087895338"] = [
        @com.numhero.shared.enums.BalanceSheetEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.BalanceSheetEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/BalanceSheetEnum;),
        @com.numhero.shared.enums.BalanceSheetEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/BalanceSheetEnum;)
      ];
    
    result["com.numhero.shared.enums.BillingMethodEnum/2857025183"] = [
        @com.numhero.shared.enums.BillingMethodEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.BillingMethodEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/BillingMethodEnum;),
        @com.numhero.shared.enums.BillingMethodEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/BillingMethodEnum;)
      ];
    
    result["com.numhero.shared.enums.BusinessTransactionEnum/2861262854"] = [
        @com.numhero.shared.enums.BusinessTransactionEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.BusinessTransactionEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/BusinessTransactionEnum;),
        @com.numhero.shared.enums.BusinessTransactionEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/BusinessTransactionEnum;)
      ];
    
    result["com.numhero.shared.enums.ClientSupplierEnum/2338190884"] = [
        @com.numhero.shared.enums.ClientSupplierEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.ClientSupplierEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/ClientSupplierEnum;),
        @com.numhero.shared.enums.ClientSupplierEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/ClientSupplierEnum;)
      ];
    
    result["com.numhero.shared.enums.ColorSchemeEnum/521841446"] = [
        @com.numhero.shared.enums.ColorSchemeEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.ColorSchemeEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/ColorSchemeEnum;),
        @com.numhero.shared.enums.ColorSchemeEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/ColorSchemeEnum;)
      ];
    
    result["com.numhero.shared.enums.CountryEnum/3968176534"] = [
        @com.numhero.shared.enums.CountryEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.CountryEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/CountryEnum;),
        @com.numhero.shared.enums.CountryEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/CountryEnum;)
      ];
    
    result["com.numhero.shared.enums.CurrencyEnum/1700759417"] = [
        @com.numhero.shared.enums.CurrencyEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.CurrencyEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/CurrencyEnum;),
        @com.numhero.shared.enums.CurrencyEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/CurrencyEnum;)
      ];
    
    result["[Lcom.numhero.shared.enums.CurrencyEnum;/1601183606"] = [
        @com.numhero.shared.enums.CurrencyEnum_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.CurrencyEnum_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/shared/enums/CurrencyEnum;),
      ];
    
    result["com.numhero.shared.enums.DateFormatEnum/2703475582"] = [
        @com.numhero.shared.enums.DateFormatEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.DateFormatEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/DateFormatEnum;),
        @com.numhero.shared.enums.DateFormatEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/DateFormatEnum;)
      ];
    
    result["com.numhero.shared.enums.InvoiceDetailTypeEnum/2515287434"] = [
        @com.numhero.shared.enums.InvoiceDetailTypeEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.InvoiceDetailTypeEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/InvoiceDetailTypeEnum;),
        @com.numhero.shared.enums.InvoiceDetailTypeEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/InvoiceDetailTypeEnum;)
      ];
    
    result["com.numhero.shared.enums.InvoiceStatusEnum/524953253"] = [
        @com.numhero.shared.enums.InvoiceStatusEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.InvoiceStatusEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/InvoiceStatusEnum;),
        @com.numhero.shared.enums.InvoiceStatusEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/InvoiceStatusEnum;)
      ];
    
    result["com.numhero.shared.enums.InvoiceTypeEnum/4011555972"] = [
        @com.numhero.shared.enums.InvoiceTypeEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.InvoiceTypeEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/InvoiceTypeEnum;),
        @com.numhero.shared.enums.InvoiceTypeEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/InvoiceTypeEnum;)
      ];
    
    result["com.numhero.shared.enums.LocaleEnum/3921920095"] = [
        @com.numhero.shared.enums.LocaleEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.LocaleEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/LocaleEnum;),
        @com.numhero.shared.enums.LocaleEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/LocaleEnum;)
      ];
    
    result["com.numhero.shared.enums.MessageTypeEnum/1989470887"] = [
        @com.numhero.shared.enums.MessageTypeEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.MessageTypeEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/MessageTypeEnum;),
        @com.numhero.shared.enums.MessageTypeEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/MessageTypeEnum;)
      ];
    
    result["com.numhero.shared.enums.PaymentMethodEnum/2323190794"] = [
        @com.numhero.shared.enums.PaymentMethodEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.PaymentMethodEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/PaymentMethodEnum;),
        @com.numhero.shared.enums.PaymentMethodEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/PaymentMethodEnum;)
      ];
    
    result["com.numhero.shared.enums.ProductTypeEnum/294375076"] = [
        @com.numhero.shared.enums.ProductTypeEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.ProductTypeEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/ProductTypeEnum;),
        @com.numhero.shared.enums.ProductTypeEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/ProductTypeEnum;)
      ];
    
    result["com.numhero.shared.enums.ProjectStateEnum/3494353003"] = [
        @com.numhero.shared.enums.ProjectStateEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.ProjectStateEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/ProjectStateEnum;),
        @com.numhero.shared.enums.ProjectStateEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/ProjectStateEnum;)
      ];
    
    result["com.numhero.shared.enums.ReceiptStatusEnum/267590174"] = [
        @com.numhero.shared.enums.ReceiptStatusEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.ReceiptStatusEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/ReceiptStatusEnum;),
        @com.numhero.shared.enums.ReceiptStatusEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/ReceiptStatusEnum;)
      ];
    
    result["com.numhero.shared.enums.RecurringFrequencyEnum/2374859358"] = [
        @com.numhero.shared.enums.RecurringFrequencyEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.RecurringFrequencyEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/RecurringFrequencyEnum;),
        @com.numhero.shared.enums.RecurringFrequencyEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/RecurringFrequencyEnum;)
      ];
    
    result["com.numhero.shared.enums.ReferenceDocEnum/2585573584"] = [
        @com.numhero.shared.enums.ReferenceDocEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.ReferenceDocEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/ReferenceDocEnum;),
        @com.numhero.shared.enums.ReferenceDocEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/ReferenceDocEnum;)
      ];
    
    result["com.numhero.shared.enums.SendInvoiceTypeEnum/3205692530"] = [
        @com.numhero.shared.enums.SendInvoiceTypeEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.SendInvoiceTypeEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/SendInvoiceTypeEnum;),
        @com.numhero.shared.enums.SendInvoiceTypeEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/SendInvoiceTypeEnum;)
      ];
    
    result["com.numhero.shared.enums.ServiceUnitEnum/2180894013"] = [
        @com.numhero.shared.enums.ServiceUnitEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.ServiceUnitEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/ServiceUnitEnum;),
        @com.numhero.shared.enums.ServiceUnitEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/ServiceUnitEnum;)
      ];
    
    result["com.numhero.shared.enums.StaffTypeEnum/3186282008"] = [
        @com.numhero.shared.enums.StaffTypeEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.StaffTypeEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/StaffTypeEnum;),
        @com.numhero.shared.enums.StaffTypeEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/StaffTypeEnum;)
      ];
    
    result["com.numhero.shared.enums.TaskStatusEnum/2908914537"] = [
        @com.numhero.shared.enums.TaskStatusEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.TaskStatusEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/TaskStatusEnum;),
        @com.numhero.shared.enums.TaskStatusEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/TaskStatusEnum;)
      ];
    
    result["com.numhero.shared.enums.TimeFormatEnum/3555602821"] = [
        @com.numhero.shared.enums.TimeFormatEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.TimeFormatEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/TimeFormatEnum;),
        @com.numhero.shared.enums.TimeFormatEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/TimeFormatEnum;)
      ];
    
    result["com.numhero.shared.enums.TimeUnitEnum/852479113"] = [
        @com.numhero.shared.enums.TimeUnitEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.TimeUnitEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/TimeUnitEnum;),
        @com.numhero.shared.enums.TimeUnitEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/TimeUnitEnum;)
      ];
    
    result["com.numhero.shared.enums.TransactionEnum/3108098270"] = [
        @com.numhero.shared.enums.TransactionEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.TransactionEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/TransactionEnum;),
        @com.numhero.shared.enums.TransactionEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/TransactionEnum;)
      ];
    
    result["com.numhero.shared.enums.UserRoleEnum/801563701"] = [
        @com.numhero.shared.enums.UserRoleEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.UserRoleEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/UserRoleEnum;),
        @com.numhero.shared.enums.UserRoleEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/UserRoleEnum;)
      ];
    
    result["com.numhero.shared.enums.UserStatusEnum/1605068790"] = [
        @com.numhero.shared.enums.UserStatusEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.enums.UserStatusEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/enums/UserStatusEnum;),
        @com.numhero.shared.enums.UserStatusEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/enums/UserStatusEnum;)
      ];
    
    result["com.numhero.shared.exception.ClientWarningException/200491243"] = [
        @com.numhero.shared.exception.ClientWarningException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.exception.ClientWarningException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/exception/ClientWarningException;),
      ];
    
    result["com.numhero.shared.exception.NotAuthorizedException/2742406763"] = [
        @com.numhero.shared.exception.NotAuthorizedException_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.exception.NotAuthorizedException_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/exception/NotAuthorizedException;),
      ];
    
    result["com.numhero.shared.pojoc.DetailBasePojo/3055638112"] = [
        @com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/DetailBasePojo;),
        @com.numhero.shared.pojoc.DetailBasePojo_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/DetailBasePojo;)
      ];
    
    result["com.numhero.shared.pojoc.SearchReference/4160700827"] = [
        @com.numhero.shared.pojoc.SearchReference_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.SearchReference_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/SearchReference;),
        @com.numhero.shared.pojoc.SearchReference_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/SearchReference;)
      ];
    
    result["[Lcom.numhero.shared.pojoc.SearchReference;/3489026200"] = [
        @com.numhero.shared.pojoc.SearchReference_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.SearchReference_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/shared/pojoc/SearchReference;),
      ];
    
    result["[Lcom.numhero.shared.pojoc.SearchablePojo;/3669164154"] = [
        @com.numhero.shared.pojoc.SearchablePojo_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.SearchablePojo_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Lcom/numhero/shared/pojoc/SearchablePojo;),
      ];
    
    result["com.numhero.shared.pojoc.field.BlobField/1058811189"] = [
        @com.numhero.shared.pojoc.field.BlobField_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.field.BlobField_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/field/BlobField;),
        @com.numhero.shared.pojoc.field.BlobField_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/field/BlobField;)
      ];
    
    result["com.numhero.shared.pojoc.field.BooleanField/3295358712"] = [
        @com.numhero.shared.pojoc.field.BooleanField_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.field.BooleanField_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/field/BooleanField;),
        @com.numhero.shared.pojoc.field.BooleanField_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/field/BooleanField;)
      ];
    
    result["com.numhero.shared.pojoc.field.DateField/2059010416"] = [
        @com.numhero.shared.pojoc.field.DateField_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.field.DateField_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/field/DateField;),
        @com.numhero.shared.pojoc.field.DateField_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/field/DateField;)
      ];
    
    result["com.numhero.shared.pojoc.field.DateTimeField/1793860338"] = [
        @com.numhero.shared.pojoc.field.DateTimeField_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.field.DateTimeField_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/field/DateTimeField;),
        @com.numhero.shared.pojoc.field.DateTimeField_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/field/DateTimeField;)
      ];
    
    result["com.numhero.shared.pojoc.field.DoubleField/3738214366"] = [
        @com.numhero.shared.pojoc.field.DoubleField_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.field.DoubleField_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/field/DoubleField;),
        @com.numhero.shared.pojoc.field.DoubleField_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/field/DoubleField;)
      ];
    
    result["com.numhero.shared.pojoc.field.EnumField/513988664"] = [
        @com.numhero.shared.pojoc.field.EnumField_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.field.EnumField_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/field/EnumField;),
        @com.numhero.shared.pojoc.field.EnumField_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/field/EnumField;)
      ];
    
    result["com.numhero.shared.pojoc.field.FieldDsTypeEnum/980095764"] = [
        @com.numhero.shared.pojoc.field.FieldDsTypeEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.field.FieldDsTypeEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/field/FieldDsTypeEnum;),
        @com.numhero.shared.pojoc.field.FieldDsTypeEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/field/FieldDsTypeEnum;)
      ];
    
    result["com.numhero.shared.pojoc.field.IdField/3700348165"] = [
        @com.numhero.shared.pojoc.field.IdField_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.field.IdField_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/field/IdField;),
        @com.numhero.shared.pojoc.field.IdField_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/field/IdField;)
      ];
    
    result["com.numhero.shared.pojoc.field.IntegerField/2865172625"] = [
        @com.numhero.shared.pojoc.field.IntegerField_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.field.IntegerField_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/field/IntegerField;),
        @com.numhero.shared.pojoc.field.IntegerField_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/field/IntegerField;)
      ];
    
    result["com.numhero.shared.pojoc.field.LongField/755342160"] = [
        @com.numhero.shared.pojoc.field.LongField_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.field.LongField_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/field/LongField;),
        @com.numhero.shared.pojoc.field.LongField_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/field/LongField;)
      ];
    
    result["com.numhero.shared.pojoc.field.OwnedListField/3243315559"] = [
        @com.numhero.shared.pojoc.field.OwnedListField_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.field.OwnedListField_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/field/OwnedListField;),
        @com.numhero.shared.pojoc.field.OwnedListField_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/field/OwnedListField;)
      ];
    
    result["com.numhero.shared.pojoc.field.StringField/110753163"] = [
        @com.numhero.shared.pojoc.field.StringField_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.pojoc.field.StringField_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/pojoc/field/StringField;),
        @com.numhero.shared.pojoc.field.StringField_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/pojoc/field/StringField;)
      ];
    
    result["com.numhero.shared.service.ApplicationCommandEnum/1339581709"] = [
        @com.numhero.shared.service.ApplicationCommandEnum_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.numhero.shared.service.ApplicationCommandEnum_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Lcom/numhero/shared/service/ApplicationCommandEnum;),
        @com.numhero.shared.service.ApplicationCommandEnum_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Lcom/numhero/shared/service/ApplicationCommandEnum;)
      ];
    
    result["eu.maydu.gwt.validation.client.description.PopupDescription$Location/2564891797"] = [
        @eu.maydu.gwt.validation.client.description.PopupDescription_Location_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @eu.maydu.gwt.validation.client.description.PopupDescription_Location_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Leu/maydu/gwt/validation/client/description/PopupDescription$Location;),
        @eu.maydu.gwt.validation.client.description.PopupDescription_Location_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Leu/maydu/gwt/validation/client/description/PopupDescription$Location;)
      ];
    
    result["java.lang.Boolean/476441737"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Boolean;),
        @com.google.gwt.user.client.rpc.core.java.lang.Boolean_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Boolean;)
      ];
    
    result["java.lang.Double/858496421"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Double_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Double_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Double;),
        @com.google.gwt.user.client.rpc.core.java.lang.Double_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Double;)
      ];
    
    result["java.lang.Integer/3438268394"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Integer_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Integer_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Integer;),
        @com.google.gwt.user.client.rpc.core.java.lang.Integer_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Integer;)
      ];
    
    result["java.lang.Long/4227064769"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/Long;),
        @com.google.gwt.user.client.rpc.core.java.lang.Long_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/Long;)
      ];
    
    result["[Ljava.lang.Long;/97727328"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.Long_Array_Rank_1_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.Long_Array_Rank_1_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;[Ljava/lang/Long;),
        @com.google.gwt.user.client.rpc.core.java.lang.Long_Array_Rank_1_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;[Ljava/lang/Long;)
      ];
    
    result["java.lang.String/2004016611"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/String;),
        @com.google.gwt.user.client.rpc.core.java.lang.String_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/String;)
      ];
    
    result["java.lang.annotation.ElementType/15413163"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.ElementType_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.ElementType_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/annotation/ElementType;),
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.ElementType_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/annotation/ElementType;)
      ];
    
    result["java.lang.annotation.RetentionPolicy/1244130522"] = [
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.RetentionPolicy_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.RetentionPolicy_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/lang/annotation/RetentionPolicy;),
        @com.google.gwt.user.client.rpc.core.java.lang.annotation.RetentionPolicy_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/lang/annotation/RetentionPolicy;)
      ];
    
    result["java.math.RoundingMode/2365096428"] = [
        @com.google.gwt.user.client.rpc.core.java.math.RoundingMode_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.math.RoundingMode_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/math/RoundingMode;),
        @com.google.gwt.user.client.rpc.core.java.math.RoundingMode_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/math/RoundingMode;)
      ];
    
    result["java.sql.Date/730999118"] = [
        @com.google.gwt.user.client.rpc.core.java.sql.Date_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.sql.Date_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/sql/Date;),
        @com.google.gwt.user.client.rpc.core.java.sql.Date_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/sql/Date;)
      ];
    
    result["java.sql.Time/1816797103"] = [
        @com.google.gwt.user.client.rpc.core.java.sql.Time_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.sql.Time_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/sql/Time;),
        @com.google.gwt.user.client.rpc.core.java.sql.Time_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/sql/Time;)
      ];
    
    result["java.sql.Timestamp/3040052672"] = [
        @com.google.gwt.user.client.rpc.core.java.sql.Timestamp_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.sql.Timestamp_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/sql/Timestamp;),
        @com.google.gwt.user.client.rpc.core.java.sql.Timestamp_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/sql/Timestamp;)
      ];
    
    result["java.util.ArrayList/4159755760"] = [
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/ArrayList;),
        @com.google.gwt.user.client.rpc.core.java.util.ArrayList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/ArrayList;)
      ];
    
    result["java.util.Arrays$ArrayList/2507071751"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/List;),
        @com.google.gwt.user.client.rpc.core.java.util.Arrays.ArrayList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/List;)
      ];
    
    result["java.util.Collections$EmptyList/4157118744"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/List;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/List;)
      ];
    
    result["java.util.Collections$EmptyMap/4174664486"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyMap_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Map;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptyMap_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Map;)
      ];
    
    result["java.util.Collections$EmptySet/3523698179"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptySet_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.EmptySet_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Set;),
      ];
    
    result["java.util.Collections$SingletonList/1586180994"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/List;),
        @com.google.gwt.user.client.rpc.core.java.util.Collections.SingletonList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/List;)
      ];
    
    result["java.util.Date/3385151746"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Date;),
        @com.google.gwt.user.client.rpc.core.java.util.Date_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Date;)
      ];
    
    result["java.util.HashMap/1797211028"] = [
        @com.google.gwt.user.client.rpc.core.java.util.HashMap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.HashMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/HashMap;),
        @com.google.gwt.user.client.rpc.core.java.util.HashMap_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/HashMap;)
      ];
    
    result["java.util.HashSet/3273092938"] = [
        @com.google.gwt.user.client.rpc.core.java.util.HashSet_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.HashSet_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/HashSet;),
      ];
    
    result["java.util.IdentityHashMap/1839153020"] = [
        @com.google.gwt.user.client.rpc.core.java.util.IdentityHashMap_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.IdentityHashMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/IdentityHashMap;),
        @com.google.gwt.user.client.rpc.core.java.util.IdentityHashMap_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/IdentityHashMap;)
      ];
    
    result["java.util.LinkedHashMap/3008245022"] = [
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedHashMap;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashMap_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/LinkedHashMap;)
      ];
    
    result["java.util.LinkedHashSet/1826081506"] = [
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedHashSet_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedHashSet;),
      ];
    
    result["java.util.LinkedList/3953877921"] = [
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/LinkedList;),
        @com.google.gwt.user.client.rpc.core.java.util.LinkedList_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/LinkedList;)
      ];
    
    result["java.util.Stack/1346942793"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Stack;),
        @com.google.gwt.user.client.rpc.core.java.util.Stack_FieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Stack;)
      ];
    
    result["java.util.TreeMap/1493889780"] = [
        @com.google.gwt.user.client.rpc.core.java.util.TreeMap_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.TreeMap_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/TreeMap;),
        @com.google.gwt.user.client.rpc.core.java.util.TreeMap_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/TreeMap;)
      ];
    
    result["java.util.TreeSet/4043497002"] = [
        @com.google.gwt.user.client.rpc.core.java.util.TreeSet_CustomFieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.TreeSet_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/TreeSet;),
      ];
    
    result["java.util.Vector/3057315478"] = [
        @com.google.gwt.user.client.rpc.core.java.util.Vector_FieldSerializer::instantiate(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;),
        @com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer::deserialize(Lcom/google/gwt/user/client/rpc/SerializationStreamReader;Ljava/util/Vector;),
        @com.google.gwt.user.client.rpc.core.java.util.Vector_CustomFieldSerializer::serialize(Lcom/google/gwt/user/client/rpc/SerializationStreamWriter;Ljava/util/Vector;)
      ];
    
    return result;
  }-*/;
  
  @SuppressWarnings("deprecation")
  @GwtScriptOnly
  private static native JsArrayString loadSignaturesNative() /*-{
    var result = [];
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@byte[]::class)] = "[B/3308590456";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.canvas.dom.client.Context2d.Composite::class)] = "com.google.gwt.canvas.dom.client.Context2d$Composite/3412511209";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.canvas.dom.client.Context2d.LineCap::class)] = "com.google.gwt.canvas.dom.client.Context2d$LineCap/4137629416";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.canvas.dom.client.Context2d.LineJoin::class)] = "com.google.gwt.canvas.dom.client.Context2d$LineJoin/773759908";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.canvas.dom.client.Context2d.Repetition::class)] = "com.google.gwt.canvas.dom.client.Context2d$Repetition/200032891";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.canvas.dom.client.Context2d.TextAlign::class)] = "com.google.gwt.canvas.dom.client.Context2d$TextAlign/96304101";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.canvas.dom.client.Context2d.TextBaseline::class)] = "com.google.gwt.canvas.dom.client.Context2d$TextBaseline/1387606880";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.cell.client.ButtonCellBase.Decoration::class)] = "com.google.gwt.cell.client.ButtonCellBase$Decoration/2339543658";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.core.client.CodeDownloadException.Reason::class)] = "com.google.gwt.core.client.CodeDownloadException$Reason/4099226274";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.BorderStyle::class)] = "com.google.gwt.dom.client.Style$BorderStyle/2769837833";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.Cursor::class)] = "com.google.gwt.dom.client.Style$Cursor/2666657890";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.Display::class)] = "com.google.gwt.dom.client.Style$Display/1537475515";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.Float::class)] = "com.google.gwt.dom.client.Style$Float/1495215860";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.FontStyle::class)] = "com.google.gwt.dom.client.Style$FontStyle/2182768286";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.FontWeight::class)] = "com.google.gwt.dom.client.Style$FontWeight/3557458763";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.ListStyleType::class)] = "com.google.gwt.dom.client.Style$ListStyleType/1064239610";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.Overflow::class)] = "com.google.gwt.dom.client.Style$Overflow/982122884";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.Position::class)] = "com.google.gwt.dom.client.Style$Position/548017857";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.TableLayout::class)] = "com.google.gwt.dom.client.Style$TableLayout/1430616401";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.TextDecoration::class)] = "com.google.gwt.dom.client.Style$TextDecoration/3846779252";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.Unit::class)] = "com.google.gwt.dom.client.Style$Unit/269426519";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.VerticalAlign::class)] = "com.google.gwt.dom.client.Style$VerticalAlign/352429624";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.dom.client.Style.Visibility::class)] = "com.google.gwt.dom.client.Style$Visibility/1861510052";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat::class)] = "com.google.gwt.i18n.client.DateTimeFormat$PredefinedFormat/229723443";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.i18n.client.HasDirection.Direction::class)] = "com.google.gwt.i18n.client.HasDirection$Direction/1284232723";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.i18n.shared.DateTimeFormat.PredefinedFormat::class)] = "com.google.gwt.i18n.shared.DateTimeFormat$PredefinedFormat/649735428";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.i18n.shared.impl.DateRecord::class)] = "com.google.gwt.i18n.shared.impl.DateRecord/3375188634";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.layout.client.Layout.Alignment::class)] = "com.google.gwt.layout.client.Layout$Alignment/1758648740";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.resources.client.ImageResource.RepeatStyle::class)] = "com.google.gwt.resources.client.ImageResource$RepeatStyle/2798118115";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy.KeyboardPagingPolicy::class)] = "com.google.gwt.user.cellview.client.HasKeyboardPagingPolicy$KeyboardPagingPolicy/3115114274";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy::class)] = "com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy$KeyboardSelectionPolicy/2212535585";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.cellview.client.SimplePager.TextLocation::class)] = "com.google.gwt.user.cellview.client.SimplePager$TextLocation/844327705";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.DocumentModeAsserter.Severity::class)] = "com.google.gwt.user.client.DocumentModeAsserter$Severity/1368792051";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException::class)] = "com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.RpcTokenException::class)] = "com.google.gwt.user.client.rpc.RpcTokenException/2345075298";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.XsrfToken::class)] = "com.google.gwt.user.client.rpc.XsrfToken/4254043109";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader::class)] = "com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter$ResponseReader/3885798731";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.ChangeListenerCollection::class)] = "com.google.gwt.user.client.ui.ChangeListenerCollection/287642957";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.ClickListenerCollection::class)] = "com.google.gwt.user.client.ui.ClickListenerCollection/2152455986";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.DockLayoutPanel.Direction::class)] = "com.google.gwt.user.client.ui.DockLayoutPanel$Direction/1124902987";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.FocusListenerCollection::class)] = "com.google.gwt.user.client.ui.FocusListenerCollection/119490835";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.FormHandlerCollection::class)] = "com.google.gwt.user.client.ui.FormHandlerCollection/3088681894";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.KeyboardListenerCollection::class)] = "com.google.gwt.user.client.ui.KeyboardListenerCollection/1040442242";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.LoadListenerCollection::class)] = "com.google.gwt.user.client.ui.LoadListenerCollection/3174178888";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.MouseListenerCollection::class)] = "com.google.gwt.user.client.ui.MouseListenerCollection/465158911";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.MouseWheelListenerCollection::class)] = "com.google.gwt.user.client.ui.MouseWheelListenerCollection/370304552";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion::class)] = "com.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion/2803420099";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion[]::class)] = "[Lcom.google.gwt.user.client.ui.MultiWordSuggestOracle$MultiWordSuggestion;/1531882420";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.PopupListenerCollection::class)] = "com.google.gwt.user.client.ui.PopupListenerCollection/1920131050";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.PopupPanel.AnimationType::class)] = "com.google.gwt.user.client.ui.PopupPanel$AnimationType/2686977168";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.ScrollListenerCollection::class)] = "com.google.gwt.user.client.ui.ScrollListenerCollection/210686268";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.SuggestOracle.Suggestion[]::class)] = "[Lcom.google.gwt.user.client.ui.SuggestOracle$Suggestion;/3224244884";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.TabListenerCollection::class)] = "com.google.gwt.user.client.ui.TabListenerCollection/3768293299";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.TableListenerCollection::class)] = "com.google.gwt.user.client.ui.TableListenerCollection/2254740473";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.TreeListenerCollection::class)] = "com.google.gwt.user.client.ui.TreeListenerCollection/3716243734";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment::class)] = "com.google.gwt.user.client.ui.ValueBoxBase$TextAlignment/3036099298";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.google.gwt.view.client.DefaultSelectionEventManager.SelectAction::class)] = "com.google.gwt.view.client.DefaultSelectionEventManager$SelectAction/3096171525";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.GlobalSearchListRequest::class)] = "com.numhero.client.model.datacargo.GlobalSearchListRequest/1415047289";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.GlobalSearchListResponse::class)] = "com.numhero.client.model.datacargo.GlobalSearchListResponse/2773384870";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.account.AccountListRequest::class)] = "com.numhero.client.model.datacargo.account.AccountListRequest/2778263853";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.account.AccountListResponse::class)] = "com.numhero.client.model.datacargo.account.AccountListResponse/2409187366";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.account.ExpenseAccountListRequest::class)] = "com.numhero.client.model.datacargo.account.ExpenseAccountListRequest/3541968901";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.auth.AuthRequest::class)] = "com.numhero.client.model.datacargo.auth.AuthRequest/3523095594";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.auth.AuthResponse::class)] = "com.numhero.client.model.datacargo.auth.AuthResponse/2772891835";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.bankaccount.BankAccountListRequest::class)] = "com.numhero.client.model.datacargo.bankaccount.BankAccountListRequest/285927829";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.bankaccount.BankAccountListResponse::class)] = "com.numhero.client.model.datacargo.bankaccount.BankAccountListResponse/2949603313";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.bankaccount.DeleteBankAccountsRequest::class)] = "com.numhero.client.model.datacargo.bankaccount.DeleteBankAccountsRequest/3655399674";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.bankaccount.GetBankAccountRequest::class)] = "com.numhero.client.model.datacargo.bankaccount.GetBankAccountRequest/1912745531";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.bankaccount.GetBankAccountResponse::class)] = "com.numhero.client.model.datacargo.bankaccount.GetBankAccountResponse/691990797";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.bankaccount.GetMainTradingBankAccountRequest::class)] = "com.numhero.client.model.datacargo.bankaccount.GetMainTradingBankAccountRequest/1603623706";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.bankaccount.GetMainTradingBankAccountResponse::class)] = "com.numhero.client.model.datacargo.bankaccount.GetMainTradingBankAccountResponse/1160678858";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.bankaccount.SaveBankAccountRequest::class)] = "com.numhero.client.model.datacargo.bankaccount.SaveBankAccountRequest/3088907543";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.bankaccount.SaveBankAccountResponse::class)] = "com.numhero.client.model.datacargo.bankaccount.SaveBankAccountResponse/3730039240";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.banktransaction.BankTransactionListRequest::class)] = "com.numhero.client.model.datacargo.banktransaction.BankTransactionListRequest/34955617";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse::class)] = "com.numhero.client.model.datacargo.banktransaction.BankTransactionListResponse/3586002529";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.banktransaction.DeleteBankTransactionsRequest::class)] = "com.numhero.client.model.datacargo.banktransaction.DeleteBankTransactionsRequest/2297198804";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.banktransaction.GetBankTransactionRequest::class)] = "com.numhero.client.model.datacargo.banktransaction.GetBankTransactionRequest/50265061";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.banktransaction.GetBankTransactionResponse::class)] = "com.numhero.client.model.datacargo.banktransaction.GetBankTransactionResponse/3441293070";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionRequest::class)] = "com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionRequest/3335398039";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionResponse::class)] = "com.numhero.client.model.datacargo.banktransaction.SaveBankTransactionResponse/2458697293";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountRequest::class)] = "com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountRequest/3104897775";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountResponse::class)] = "com.numhero.client.model.datacargo.businessaccount.GetBusinessAccountResponse/405084058";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest::class)] = "com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountRequest/2301758768";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse::class)] = "com.numhero.client.model.datacargo.businessaccount.SaveBusinessAccountResponse/3072429847";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListRequest::class)] = "com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListRequest/3228902633";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListResponse::class)] = "com.numhero.client.model.datacargo.businesstransaction.BusinessTransactionListResponse/564758270";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionRequest::class)] = "com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionRequest/1399209423";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionResponse::class)] = "com.numhero.client.model.datacargo.businesstransaction.GetBusinessTransactionResponse/2268279115";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.category.CategoryListRequest::class)] = "com.numhero.client.model.datacargo.category.CategoryListRequest/1807937467";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.category.CategoryListResponse::class)] = "com.numhero.client.model.datacargo.category.CategoryListResponse/741266905";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.category.DeleteCategoriesRequest::class)] = "com.numhero.client.model.datacargo.category.DeleteCategoriesRequest/3216781130";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.category.GetCategoryRequest::class)] = "com.numhero.client.model.datacargo.category.GetCategoryRequest/1777780323";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.category.SaveCategoryRequest::class)] = "com.numhero.client.model.datacargo.category.SaveCategoryRequest/163924632";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.client_supplier.ClientListRequest::class)] = "com.numhero.client.model.datacargo.client_supplier.ClientListRequest/3942858711";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse::class)] = "com.numhero.client.model.datacargo.client_supplier.ClientSupplierListResponse/1226992143";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest::class)] = "com.numhero.client.model.datacargo.client_supplier.DeleteClientsSuppliersRequest/3482739333";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.client_supplier.GetClientSupplierRequest::class)] = "com.numhero.client.model.datacargo.client_supplier.GetClientSupplierRequest/1702853917";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest::class)] = "com.numhero.client.model.datacargo.client_supplier.SaveClientSupplierRequest/2671794519";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.client_supplier.SupplierListRequest::class)] = "com.numhero.client.model.datacargo.client_supplier.SupplierListRequest/1425530501";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.currency.ConversionBean::class)] = "com.numhero.client.model.datacargo.currency.ConversionBean/5209266";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest::class)] = "com.numhero.client.model.datacargo.currency.GetCurrencyConversionRequest/579293438";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse::class)] = "com.numhero.client.model.datacargo.currency.GetCurrencyConversionResponse/3480043506";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.expense.DeleteReceiptsRequest::class)] = "com.numhero.client.model.datacargo.expense.DeleteReceiptsRequest/800809633";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.expense.GetReceiptRequest::class)] = "com.numhero.client.model.datacargo.expense.GetReceiptRequest/3951230355";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.expense.GetReceiptResponse::class)] = "com.numhero.client.model.datacargo.expense.GetReceiptResponse/1802170109";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.expense.GetUnbilledReceiptRequest::class)] = "com.numhero.client.model.datacargo.expense.GetUnbilledReceiptRequest/2867227619";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.expense.ReceiptsBilledStatusRequest::class)] = "com.numhero.client.model.datacargo.expense.ReceiptsBilledStatusRequest/36231013";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest::class)] = "com.numhero.client.model.datacargo.expense.ReceiptsBillingListRequest/3782048366";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.expense.ReceiptsListRequest::class)] = "com.numhero.client.model.datacargo.expense.ReceiptsListRequest/1267250518";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.expense.ReceiptsListResponse::class)] = "com.numhero.client.model.datacargo.expense.ReceiptsListResponse/787101621";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.expense.SaveReceiptRequest::class)] = "com.numhero.client.model.datacargo.expense.SaveReceiptRequest/3619677380";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.expense.SaveReceiptResponse::class)] = "com.numhero.client.model.datacargo.expense.SaveReceiptResponse/3633693367";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.expense.SetToPaidReceiptsRequest::class)] = "com.numhero.client.model.datacargo.expense.SetToPaidReceiptsRequest/823407606";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.expense.UnpaidReceiptsListRequest::class)] = "com.numhero.client.model.datacargo.expense.UnpaidReceiptsListRequest/1560140714";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.home.GetHomeRecapRequest::class)] = "com.numhero.client.model.datacargo.home.GetHomeRecapRequest/2513666458";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.home.GetHomeRecapResponse::class)] = "com.numhero.client.model.datacargo.home.GetHomeRecapResponse/2592194150";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest::class)] = "com.numhero.client.model.datacargo.invoice.ChangeStatusOfDocumentsRequest/1365334999";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest::class)] = "com.numhero.client.model.datacargo.invoice.ConvertToInvoiceRequest/1426432063";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.invoice.DeleteDocumentsRequest::class)] = "com.numhero.client.model.datacargo.invoice.DeleteDocumentsRequest/433466953";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.invoice.GetInvoiceRequest::class)] = "com.numhero.client.model.datacargo.invoice.GetInvoiceRequest/2198754457";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.invoice.InvoiceListRequest::class)] = "com.numhero.client.model.datacargo.invoice.InvoiceListRequest/2368069121";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.invoice.InvoiceListResponse::class)] = "com.numhero.client.model.datacargo.invoice.InvoiceListResponse/3656705939";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest::class)] = "com.numhero.client.model.datacargo.invoice.SaveInvoiceRequest/3718780255";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.invoice.SendInvoiceRequest::class)] = "com.numhero.client.model.datacargo.invoice.SendInvoiceRequest/2885623757";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.moneyin.MoneyInRecapRequest::class)] = "com.numhero.client.model.datacargo.moneyin.MoneyInRecapRequest/3038489661";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse::class)] = "com.numhero.client.model.datacargo.moneyin.MoneyInRecapResponse/2267306801";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.moneyout.MoneyOutRecapRequest::class)] = "com.numhero.client.model.datacargo.moneyout.MoneyOutRecapRequest/237290167";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse::class)] = "com.numhero.client.model.datacargo.moneyout.MoneyOutRecapResponse/8295472";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.product.DeleteProductsRequest::class)] = "com.numhero.client.model.datacargo.product.DeleteProductsRequest/90583503";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.product.GetItemRequest::class)] = "com.numhero.client.model.datacargo.product.GetItemRequest/1211369307";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.product.GetItemResponse::class)] = "com.numhero.client.model.datacargo.product.GetItemResponse/640414491";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.product.ProductListResponse::class)] = "com.numhero.client.model.datacargo.product.ProductListResponse/4070669360";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.product.ProductServicesListRequest::class)] = "com.numhero.client.model.datacargo.product.ProductServicesListRequest/116089481";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.product.SaveProductRequest::class)] = "com.numhero.client.model.datacargo.product.SaveProductRequest/918443797";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.product.SaveProductResponse::class)] = "com.numhero.client.model.datacargo.product.SaveProductResponse/1318298314";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.project.DeleteProjectsRequest::class)] = "com.numhero.client.model.datacargo.project.DeleteProjectsRequest/1044347972";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.project.GetProjectRequest::class)] = "com.numhero.client.model.datacargo.project.GetProjectRequest/2528371432";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.project.GetProjectResponse::class)] = "com.numhero.client.model.datacargo.project.GetProjectResponse/2155205757";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.project.ProjectGenerateEstimatesRequest::class)] = "com.numhero.client.model.datacargo.project.ProjectGenerateEstimatesRequest/2347274469";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceRequest::class)] = "com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceRequest/2289661517";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceResponse::class)] = "com.numhero.client.model.datacargo.project.ProjectGenerateInvoiceResponse/2890295228";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.project.ProjectListRequest::class)] = "com.numhero.client.model.datacargo.project.ProjectListRequest/1169967495";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.project.ProjectListResponse::class)] = "com.numhero.client.model.datacargo.project.ProjectListResponse/1790163104";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.project.SaveProjectRequest::class)] = "com.numhero.client.model.datacargo.project.SaveProjectRequest/1554365846";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.project.SaveProjectResponse::class)] = "com.numhero.client.model.datacargo.project.SaveProjectResponse/643760575";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.project.StaffProjectsListRequest::class)] = "com.numhero.client.model.datacargo.project.StaffProjectsListRequest/1192220939";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.project.StaffProjectsListResponse::class)] = "com.numhero.client.model.datacargo.project.StaffProjectsListResponse/2470358130";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest::class)] = "com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceRequest/828284416";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse::class)] = "com.numhero.client.model.datacargo.report.chartofaccounts.AccountBalanceResponse/1902922380";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsRequest::class)] = "com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsRequest/373171461";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse::class)] = "com.numhero.client.model.datacargo.report.chartofaccounts.ChartOfAccountsResponse/838240676";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.report.deposits.DepositsRequest::class)] = "com.numhero.client.model.datacargo.report.deposits.DepositsRequest/902090805";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.report.profitloss.GetProfitLossRequest::class)] = "com.numhero.client.model.datacargo.report.profitloss.GetProfitLossRequest/4190476728";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse::class)] = "com.numhero.client.model.datacargo.report.profitloss.GetProfitLossResponse/556862267";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.report.receivables.ReceivablesRequest::class)] = "com.numhero.client.model.datacargo.report.receivables.ReceivablesRequest/1411668717";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.report.taxes.TaxesRequest::class)] = "com.numhero.client.model.datacargo.report.taxes.TaxesRequest/799634893";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceRequest::class)] = "com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceRequest/62915179";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse::class)] = "com.numhero.client.model.datacargo.report.trialbalance.TrialBalanceResponse/3016441642";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.report.vat.VATRequest::class)] = "com.numhero.client.model.datacargo.report.vat.VATRequest/159286927";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.staff.DeleteStaffRequest::class)] = "com.numhero.client.model.datacargo.staff.DeleteStaffRequest/2933393746";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest::class)] = "com.numhero.client.model.datacargo.staff.DirectPaymentStaffListRequest/3340411610";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.staff.GetStaffRequest::class)] = "com.numhero.client.model.datacargo.staff.GetStaffRequest/3639519983";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.staff.GetStaffResponse::class)] = "com.numhero.client.model.datacargo.staff.GetStaffResponse/705297605";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest::class)] = "com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest/2061135771";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.staff.SaveStaffRequest::class)] = "com.numhero.client.model.datacargo.staff.SaveStaffRequest/1456858727";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.staff.SaveStaffResponse::class)] = "com.numhero.client.model.datacargo.staff.SaveStaffResponse/2513995753";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.staff.StaffListRequest::class)] = "com.numhero.client.model.datacargo.staff.StaffListRequest/1256742212";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.staff.StaffListResponse::class)] = "com.numhero.client.model.datacargo.staff.StaffListResponse/2442341319";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.task.DeleteTasksRequest::class)] = "com.numhero.client.model.datacargo.task.DeleteTasksRequest/3043837057";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.task.GetTaskRequest::class)] = "com.numhero.client.model.datacargo.task.GetTaskRequest/685043340";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.task.GetTaskResponse::class)] = "com.numhero.client.model.datacargo.task.GetTaskResponse/1665705933";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.task.ProjectTasksListRequest::class)] = "com.numhero.client.model.datacargo.task.ProjectTasksListRequest/77671078";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.task.ProjectTasksListResponse::class)] = "com.numhero.client.model.datacargo.task.ProjectTasksListResponse/2807959834";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.task.SaveTaskRequest::class)] = "com.numhero.client.model.datacargo.task.SaveTaskRequest/1475878870";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.task.SaveTaskResponse::class)] = "com.numhero.client.model.datacargo.task.SaveTaskResponse/4278115533";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.task.TaskListRequest::class)] = "com.numhero.client.model.datacargo.task.TaskListRequest/814671622";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.task.TaskListResponse::class)] = "com.numhero.client.model.datacargo.task.TaskListResponse/1034211273";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.taxinfo.DeleteTaxInfosRequest::class)] = "com.numhero.client.model.datacargo.taxinfo.DeleteTaxInfosRequest/854384337";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.taxinfo.GetTaxInfoRequest::class)] = "com.numhero.client.model.datacargo.taxinfo.GetTaxInfoRequest/1477072542";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse::class)] = "com.numhero.client.model.datacargo.taxinfo.GetTaxInfoResponse/1173436341";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoRequest::class)] = "com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoRequest/1819449239";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoResponse::class)] = "com.numhero.client.model.datacargo.taxinfo.SaveTaxInfoResponse/1456052279";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.taxinfo.TaxInfoListRequest::class)] = "com.numhero.client.model.datacargo.taxinfo.TaxInfoListRequest/3303747890";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse::class)] = "com.numhero.client.model.datacargo.taxinfo.TaxInfoListResponse/2930014386";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.timeentry.DeleteTimeEntriesRequest::class)] = "com.numhero.client.model.datacargo.timeentry.DeleteTimeEntriesRequest/3312663709";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.timeentry.GetTimeEntryRequest::class)] = "com.numhero.client.model.datacargo.timeentry.GetTimeEntryRequest/3983292273";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.timeentry.GetTimeEntryResponse::class)] = "com.numhero.client.model.datacargo.timeentry.GetTimeEntryResponse/3605365335";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.timeentry.SaveTimeEntryRequest::class)] = "com.numhero.client.model.datacargo.timeentry.SaveTimeEntryRequest/967967633";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.timeentry.SaveTimeEntryResponse::class)] = "com.numhero.client.model.datacargo.timeentry.SaveTimeEntryResponse/1209774166";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.timeentry.TimeEntriesBilledStatusRequest::class)] = "com.numhero.client.model.datacargo.timeentry.TimeEntriesBilledStatusRequest/1127846168";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.timeentry.TimeEntryBillingListRequest::class)] = "com.numhero.client.model.datacargo.timeentry.TimeEntryBillingListRequest/2974096383";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest::class)] = "com.numhero.client.model.datacargo.timeentry.TimeEntryListRequest/1689839279";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.timeentry.TimeEntryListResponse::class)] = "com.numhero.client.model.datacargo.timeentry.TimeEntryListResponse/1968718203";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.user.DeleteUsersRequest::class)] = "com.numhero.client.model.datacargo.user.DeleteUsersRequest/2544097544";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.user.GetUserRequest::class)] = "com.numhero.client.model.datacargo.user.GetUserRequest/4140023347";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.user.GetUserResponse::class)] = "com.numhero.client.model.datacargo.user.GetUserResponse/913876242";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.user.ReactivateUsersRequest::class)] = "com.numhero.client.model.datacargo.user.ReactivateUsersRequest/3609337106";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.user.SaveUserRequest::class)] = "com.numhero.client.model.datacargo.user.SaveUserRequest/394828003";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.user.SaveUserResponse::class)] = "com.numhero.client.model.datacargo.user.SaveUserResponse/3048250915";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.user.SuspendUsersRequest::class)] = "com.numhero.client.model.datacargo.user.SuspendUsersRequest/3588810177";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.user.UserListRequest::class)] = "com.numhero.client.model.datacargo.user.UserListRequest/2152122457";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.user.UserListResponse::class)] = "com.numhero.client.model.datacargo.user.UserListResponse/3394798223";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.usermessage.SaveUserMessageRequest::class)] = "com.numhero.client.model.datacargo.usermessage.SaveUserMessageRequest/2399314241";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.datacargo.usermessage.SaveUserMessageResponse::class)] = "com.numhero.client.model.datacargo.usermessage.SaveUserMessageResponse/428762030";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.AccountBalanceRow::class)] = "com.numhero.client.model.pojoc.AccountBalanceRow/1902321997";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.AccountBalanceRow[]::class)] = "[Lcom.numhero.client.model.pojoc.AccountBalanceRow;/1754777518";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.AccountingLeg::class)] = "com.numhero.client.model.pojoc.AccountingLeg/4125162674";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.BalanceSheetRow::class)] = "com.numhero.client.model.pojoc.BalanceSheetRow/1413226503";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.BalanceSheetRow[]::class)] = "[Lcom.numhero.client.model.pojoc.BalanceSheetRow;/2059252156";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.BankAccount::class)] = "com.numhero.client.model.pojoc.BankAccount/3380069698";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.BankAccount[]::class)] = "[Lcom.numhero.client.model.pojoc.BankAccount;/352899095";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.BankTransaction::class)] = "com.numhero.client.model.pojoc.BankTransaction/549380439";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.BankTransaction[]::class)] = "[Lcom.numhero.client.model.pojoc.BankTransaction;/2661502968";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.BusinessAccount::class)] = "com.numhero.client.model.pojoc.BusinessAccount/3599369956";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.BusinessTransaction::class)] = "com.numhero.client.model.pojoc.BusinessTransaction/2760065969";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.BusinessTransaction[]::class)] = "[Lcom.numhero.client.model.pojoc.BusinessTransaction;/3364130227";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.Category::class)] = "com.numhero.client.model.pojoc.Category/864344537";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.Category[]::class)] = "[Lcom.numhero.client.model.pojoc.Category;/157292121";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.ClientSupplier::class)] = "com.numhero.client.model.pojoc.ClientSupplier/160860766";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.ClientSupplierContact::class)] = "com.numhero.client.model.pojoc.ClientSupplierContact/1552600155";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.ClientSupplier[]::class)] = "[Lcom.numhero.client.model.pojoc.ClientSupplier;/1689176280";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.ExpenseReceipt::class)] = "com.numhero.client.model.pojoc.ExpenseReceipt/3402698023";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.ExpenseReceipt[]::class)] = "[Lcom.numhero.client.model.pojoc.ExpenseReceipt;/4054639204";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.Invoice::class)] = "com.numhero.client.model.pojoc.Invoice/421963278";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.InvoiceDetail::class)] = "com.numhero.client.model.pojoc.InvoiceDetail/549076338";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.Invoice[]::class)] = "[Lcom.numhero.client.model.pojoc.Invoice;/2376911255";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.MoneyInOutRecapRow::class)] = "com.numhero.client.model.pojoc.MoneyInOutRecapRow/2219631580";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.MoneyInOutRecapRow[]::class)] = "[Lcom.numhero.client.model.pojoc.MoneyInOutRecapRow;/3580751726";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.NominalLedgerAccount::class)] = "com.numhero.client.model.pojoc.NominalLedgerAccount/2051633461";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.NominalLedgerAccount[]::class)] = "[Lcom.numhero.client.model.pojoc.NominalLedgerAccount;/131089151";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.ProductService::class)] = "com.numhero.client.model.pojoc.ProductService/1235013462";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.ProductService[]::class)] = "[Lcom.numhero.client.model.pojoc.ProductService;/2568585669";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.Project::class)] = "com.numhero.client.model.pojoc.Project/3493186853";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.ProjectStaffDetail::class)] = "com.numhero.client.model.pojoc.ProjectStaffDetail/1185165357";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.ProjectTaskDetail::class)] = "com.numhero.client.model.pojoc.ProjectTaskDetail/1425337177";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.Project[]::class)] = "[Lcom.numhero.client.model.pojoc.Project;/253590211";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.Staff::class)] = "com.numhero.client.model.pojoc.Staff/3067237141";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.Staff[]::class)] = "[Lcom.numhero.client.model.pojoc.Staff;/3695232072";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.Task::class)] = "com.numhero.client.model.pojoc.Task/3125812632";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.Task[]::class)] = "[Lcom.numhero.client.model.pojoc.Task;/3139782620";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.TaxInfo::class)] = "com.numhero.client.model.pojoc.TaxInfo/1278648742";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.TaxInfo[]::class)] = "[Lcom.numhero.client.model.pojoc.TaxInfo;/1832304194";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.TimeEntry::class)] = "com.numhero.client.model.pojoc.TimeEntry/3268799324";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.TimeEntry[]::class)] = "[Lcom.numhero.client.model.pojoc.TimeEntry;/3254322577";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.User::class)] = "com.numhero.client.model.pojoc.User/920365610";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.UserDetail::class)] = "com.numhero.client.model.pojoc.UserDetail/3419498336";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.UserMessage::class)] = "com.numhero.client.model.pojoc.UserMessage/4227829079";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.UserMessage[]::class)] = "[Lcom.numhero.client.model.pojoc.UserMessage;/3748085439";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.model.pojoc.User[]::class)] = "[Lcom.numhero.client.model.pojoc.User;/4229133123";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.widget.HeaderLine.Tab::class)] = "com.numhero.client.widget.HeaderLine$Tab/3183962440";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.widget.InfoPanel.InfoPanelType::class)] = "com.numhero.client.widget.InfoPanel$InfoPanelType/1774755255";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.widget.TabBar.INumheroTab::class)] = "com.numhero.client.widget.TabBar$INumheroTab/2222550768";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.widget.filter.BAPojoFilter::class)] = "com.numhero.client.widget.filter.BAPojoFilter/3513957671";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.client.widget.table.MouseEvent.EventType::class)] = "com.numhero.client.widget.table.MouseEvent$EventType/3192759283";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.datacargo.BulkActionRequest::class)] = "com.numhero.shared.datacargo.BulkActionRequest/987043168";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.datacargo.BulkActionResponse::class)] = "com.numhero.shared.datacargo.BulkActionResponse/4124045909";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.datacargo.GetSingleEntityResponse::class)] = "com.numhero.shared.datacargo.GetSingleEntityResponse/1015660428";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.datacargo.ListCommandRequest::class)] = "com.numhero.shared.datacargo.ListCommandRequest/1304944093";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.datacargo.ListCommandRequest.TYPE::class)] = "com.numhero.shared.datacargo.ListCommandRequest$TYPE/1600406708";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.datacargo.ListCommandResponse::class)] = "com.numhero.shared.datacargo.ListCommandResponse/2223501275";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.datacargo.SaveSingleEntityRequest::class)] = "com.numhero.shared.datacargo.SaveSingleEntityRequest/2448965411";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.datacargo.SaveSingleEntityResponse::class)] = "com.numhero.shared.datacargo.SaveSingleEntityResponse/2079662726";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.AccountClassEnum::class)] = "com.numhero.shared.enums.AccountClassEnum/673822520";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.AccountingEntrySide::class)] = "com.numhero.shared.enums.AccountingEntrySide/486987885";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.AccountingGroupEnum::class)] = "com.numhero.shared.enums.AccountingGroupEnum/2168275085";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.BalanceSheetEnum::class)] = "com.numhero.shared.enums.BalanceSheetEnum/4087895338";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.BillingMethodEnum::class)] = "com.numhero.shared.enums.BillingMethodEnum/2857025183";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.BusinessTransactionEnum::class)] = "com.numhero.shared.enums.BusinessTransactionEnum/2861262854";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.ClientSupplierEnum::class)] = "com.numhero.shared.enums.ClientSupplierEnum/2338190884";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.ColorSchemeEnum::class)] = "com.numhero.shared.enums.ColorSchemeEnum/521841446";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.CountryEnum::class)] = "com.numhero.shared.enums.CountryEnum/3968176534";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.CurrencyEnum::class)] = "com.numhero.shared.enums.CurrencyEnum/1700759417";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.CurrencyEnum[]::class)] = "[Lcom.numhero.shared.enums.CurrencyEnum;/1601183606";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.DateFormatEnum::class)] = "com.numhero.shared.enums.DateFormatEnum/2703475582";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.InvoiceDetailTypeEnum::class)] = "com.numhero.shared.enums.InvoiceDetailTypeEnum/2515287434";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.InvoiceStatusEnum::class)] = "com.numhero.shared.enums.InvoiceStatusEnum/524953253";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.InvoiceTypeEnum::class)] = "com.numhero.shared.enums.InvoiceTypeEnum/4011555972";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.LocaleEnum::class)] = "com.numhero.shared.enums.LocaleEnum/3921920095";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.MessageTypeEnum::class)] = "com.numhero.shared.enums.MessageTypeEnum/1989470887";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.PaymentMethodEnum::class)] = "com.numhero.shared.enums.PaymentMethodEnum/2323190794";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.ProductTypeEnum::class)] = "com.numhero.shared.enums.ProductTypeEnum/294375076";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.ProjectStateEnum::class)] = "com.numhero.shared.enums.ProjectStateEnum/3494353003";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.ReceiptStatusEnum::class)] = "com.numhero.shared.enums.ReceiptStatusEnum/267590174";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.RecurringFrequencyEnum::class)] = "com.numhero.shared.enums.RecurringFrequencyEnum/2374859358";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.ReferenceDocEnum::class)] = "com.numhero.shared.enums.ReferenceDocEnum/2585573584";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.SendInvoiceTypeEnum::class)] = "com.numhero.shared.enums.SendInvoiceTypeEnum/3205692530";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.ServiceUnitEnum::class)] = "com.numhero.shared.enums.ServiceUnitEnum/2180894013";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.StaffTypeEnum::class)] = "com.numhero.shared.enums.StaffTypeEnum/3186282008";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.TaskStatusEnum::class)] = "com.numhero.shared.enums.TaskStatusEnum/2908914537";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.TimeFormatEnum::class)] = "com.numhero.shared.enums.TimeFormatEnum/3555602821";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.TimeUnitEnum::class)] = "com.numhero.shared.enums.TimeUnitEnum/852479113";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.TransactionEnum::class)] = "com.numhero.shared.enums.TransactionEnum/3108098270";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.UserRoleEnum::class)] = "com.numhero.shared.enums.UserRoleEnum/801563701";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.enums.UserStatusEnum::class)] = "com.numhero.shared.enums.UserStatusEnum/1605068790";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.exception.ClientWarningException::class)] = "com.numhero.shared.exception.ClientWarningException/200491243";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.exception.NotAuthorizedException::class)] = "com.numhero.shared.exception.NotAuthorizedException/2742406763";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.DetailBasePojo::class)] = "com.numhero.shared.pojoc.DetailBasePojo/3055638112";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.SearchReference::class)] = "com.numhero.shared.pojoc.SearchReference/4160700827";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.SearchReference[]::class)] = "[Lcom.numhero.shared.pojoc.SearchReference;/3489026200";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.SearchablePojo[]::class)] = "[Lcom.numhero.shared.pojoc.SearchablePojo;/3669164154";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.field.BlobField::class)] = "com.numhero.shared.pojoc.field.BlobField/1058811189";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.field.BooleanField::class)] = "com.numhero.shared.pojoc.field.BooleanField/3295358712";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.field.DateField::class)] = "com.numhero.shared.pojoc.field.DateField/2059010416";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.field.DateTimeField::class)] = "com.numhero.shared.pojoc.field.DateTimeField/1793860338";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.field.DoubleField::class)] = "com.numhero.shared.pojoc.field.DoubleField/3738214366";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.field.EnumField::class)] = "com.numhero.shared.pojoc.field.EnumField/513988664";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.field.FieldDsTypeEnum::class)] = "com.numhero.shared.pojoc.field.FieldDsTypeEnum/980095764";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.field.IdField::class)] = "com.numhero.shared.pojoc.field.IdField/3700348165";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.field.IntegerField::class)] = "com.numhero.shared.pojoc.field.IntegerField/2865172625";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.field.LongField::class)] = "com.numhero.shared.pojoc.field.LongField/755342160";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.field.OwnedListField::class)] = "com.numhero.shared.pojoc.field.OwnedListField/3243315559";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.pojoc.field.StringField::class)] = "com.numhero.shared.pojoc.field.StringField/110753163";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@com.numhero.shared.service.ApplicationCommandEnum::class)] = "com.numhero.shared.service.ApplicationCommandEnum/1339581709";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@eu.maydu.gwt.validation.client.description.PopupDescription.Location::class)] = "eu.maydu.gwt.validation.client.description.PopupDescription$Location/2564891797";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Boolean::class)] = "java.lang.Boolean/476441737";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Double::class)] = "java.lang.Double/858496421";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Integer::class)] = "java.lang.Integer/3438268394";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Long::class)] = "java.lang.Long/4227064769";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.Long[]::class)] = "[Ljava.lang.Long;/97727328";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.String::class)] = "java.lang.String/2004016611";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.annotation.ElementType::class)] = "java.lang.annotation.ElementType/15413163";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.lang.annotation.RetentionPolicy::class)] = "java.lang.annotation.RetentionPolicy/1244130522";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.math.RoundingMode::class)] = "java.math.RoundingMode/2365096428";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.sql.Date::class)] = "java.sql.Date/730999118";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.sql.Time::class)] = "java.sql.Time/1816797103";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.sql.Timestamp::class)] = "java.sql.Timestamp/3040052672";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.ArrayList::class)] = "java.util.ArrayList/4159755760";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Arrays.ArrayList::class)] = "java.util.Arrays$ArrayList/2507071751";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections.EmptyList::class)] = "java.util.Collections$EmptyList/4157118744";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections.EmptyMap::class)] = "java.util.Collections$EmptyMap/4174664486";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections.EmptySet::class)] = "java.util.Collections$EmptySet/3523698179";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Collections.SingletonList::class)] = "java.util.Collections$SingletonList/1586180994";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Date::class)] = "java.util.Date/3385151746";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.HashMap::class)] = "java.util.HashMap/1797211028";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.HashSet::class)] = "java.util.HashSet/3273092938";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.IdentityHashMap::class)] = "java.util.IdentityHashMap/1839153020";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.LinkedHashMap::class)] = "java.util.LinkedHashMap/3008245022";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.LinkedHashSet::class)] = "java.util.LinkedHashSet/1826081506";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.LinkedList::class)] = "java.util.LinkedList/3953877921";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Stack::class)] = "java.util.Stack/1346942793";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.TreeMap::class)] = "java.util.TreeMap/1493889780";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.TreeSet::class)] = "java.util.TreeSet/4043497002";
    result[@com.google.gwt.core.client.impl.Impl::getHashCode(Ljava/lang/Object;)(@java.util.Vector::class)] = "java.util.Vector/3057315478";
    return result;
  }-*/;
  
  public DataService_TypeSerializer() {
    super(null, methodMapNative, null, signatureMapNative);
  }
  
}
