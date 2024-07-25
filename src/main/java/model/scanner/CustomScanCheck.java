package model.scanner;

import burp.api.montoya.http.message.HttpRequestResponse;
import burp.api.montoya.scanner.AuditResult;
import burp.api.montoya.scanner.ConsolidationAction;
import burp.api.montoya.scanner.ScanCheck;
import burp.api.montoya.scanner.audit.insertionpoint.AuditInsertionPoint;
import burp.api.montoya.scanner.audit.issues.AuditIssue;

import java.util.ArrayList;

////////////////////////////////////////
// CLASS CustomScanCheck
////////////////////////////////////////
public class CustomScanCheck implements ScanCheck{


//-----------------------------------------------------------------------------
@Override
public AuditResult activeAudit(HttpRequestResponse baseRequestResponse, AuditInsertionPoint auditInsertionPoint){
  return AuditResult.auditResult(new ArrayList<>());
}

//-----------------------------------------------------------------------------
@Override
public AuditResult passiveAudit(HttpRequestResponse baseRequestResponse){
  return AuditResult.auditResult(new ArrayList<>());
}

//-----------------------------------------------------------------------------
@Override
public ConsolidationAction consolidateIssues(AuditIssue newIssue, AuditIssue existingIssue){
  return ConsolidationAction.KEEP_BOTH;
}


}
////////////////////////////////////////
// END CLASS CustomScanCheck
////////////////////////////////////////