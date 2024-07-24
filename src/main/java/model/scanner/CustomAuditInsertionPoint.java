package model.scanner;

import burp.api.montoya.core.ByteArray;
import burp.api.montoya.core.Range;
import burp.api.montoya.http.message.requests.HttpRequest;
import burp.api.montoya.scanner.audit.insertionpoint.AuditInsertionPoint;

import java.util.List;

////////////////////////////////////////
// CLASS CustomAuditInsertionPoint
////////////////////////////////////////
public class CustomAuditInsertionPoint implements AuditInsertionPoint{


//-----------------------------------------------------------------------------
@Override
public String name(){
  return "";
}

//-----------------------------------------------------------------------------
@Override
public String baseValue(){
  return "";
}

//-----------------------------------------------------------------------------
@Override
public HttpRequest buildHttpRequestWithPayload(ByteArray payload){
  return null;
}

//-----------------------------------------------------------------------------
@Override
public List<Range> issueHighlights(ByteArray payload){
  return List.of();
}


}
////////////////////////////////////////
// END CLASS CustomAuditInsertionPoint
////////////////////////////////////////