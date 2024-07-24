package model.scanner;

import burp.api.montoya.http.message.HttpRequestResponse;
import burp.api.montoya.scanner.audit.insertionpoint.AuditInsertionPoint;
import burp.api.montoya.scanner.audit.insertionpoint.AuditInsertionPointProvider;

import java.util.List;

////////////////////////////////////////
// CLASS CustomInsertionPointProvider
////////////////////////////////////////
public class CustomInsertionPointProvider implements AuditInsertionPointProvider{

//-----------------------------------------------------------------------------
@Override
public List<AuditInsertionPoint> provideInsertionPoints(HttpRequestResponse baseHttpRequestResponse){
  return List.of(new CustomAuditInsertionPoint());
}


}
////////////////////////////////////////
// END CLASS CustomInsertionPointProvider
////////////////////////////////////////