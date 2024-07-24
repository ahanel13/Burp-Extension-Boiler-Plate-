package model.scanner;

import burp.api.montoya.http.message.HttpRequestResponse;
import burp.api.montoya.scanner.AuditResult;
import burp.api.montoya.scanner.ConsolidationAction;
import burp.api.montoya.scanner.ScanCheck;
import burp.api.montoya.scanner.audit.insertionpoint.AuditInsertionPoint;
import burp.api.montoya.scanner.audit.issues.AuditIssue;

////////////////////////////////////////
// CLASS CustomScanCheck
////////////////////////////////////////
public class CustomScanCheck implements ScanCheck{


//-----------------------------------------------------------------------------
@Override
public AuditResult activeAudit(HttpRequestResponse baseRequestResponse, AuditInsertionPoint auditInsertionPoint){
  return null;
}

//-----------------------------------------------------------------------------
@Override
public AuditResult passiveAudit(HttpRequestResponse baseRequestResponse){
  return null;
}

//-----------------------------------------------------------------------------
@Override
public ConsolidationAction consolidateIssues(AuditIssue newIssue, AuditIssue existingIssue){
  return null;
}


}
////////////////////////////////////////
// END CLASS CustomScanCheck
////////////////////////////////////////