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
/**
 * <p>The <code>CustomScanCheck</code> class implements the <code>ScanCheck</code> interface and provides custom logic
 * for performing active and passive security audits within Burp Suite. This class is responsible for defining
 * how the extension should audit HTTP requests and responses to identify potential security issues.</p>
 *
 * <p>When Burp Suite performs a scan, it calls the methods in this class to execute custom audit logic.
 * The results of these audits are then used to identify and report security vulnerabilities.</p>
 *
 * <p>Key responsibilities of this class include:</p>
 * <ul>
 *   <li>Performing active audits on HTTP requests and responses</li>
 *   <li>Performing passive audits on HTTP requests and responses</li>
 *   <li>Consolidating audit issues to avoid duplicate reports</li>
 * </ul>
 *
 * <p>This class provides a way to extend Burp Suite's scanning capabilities by adding custom audit checks
 * for specific security issues.</p>
 *
 * @see burp.api.montoya.scanner.ScanCheck
 * @see burp.api.montoya.scanner.AuditResult
 * @see burp.api.montoya.scanner.audit.insertionpoint.AuditInsertionPoint
 * @see burp.api.montoya.scanner.audit.issues.AuditIssue
 */
public class CustomScanCheck implements ScanCheck {

//-----------------------------------------------------------------------------
/**
 * Performs an active audit on the given HTTP request and response using the specified audit insertion point.
 * This method is called by Burp Suite during active scanning to identify security issues.
 *
 * @param baseRequestResponse the base HTTP request and response to be audited
 * @param auditInsertionPoint the insertion point within the request where payloads can be inserted
 * @return the result of the audit, containing any identified security issues
 */
@Override
public AuditResult activeAudit(HttpRequestResponse baseRequestResponse, AuditInsertionPoint auditInsertionPoint) {
  return AuditResult.auditResult(new ArrayList<>());
}

//-----------------------------------------------------------------------------
/**
 * Performs a passive audit on the given HTTP request and response. This method is called by Burp Suite
 * during passive scanning to identify security issues without modifying the request.
 *
 * @param baseRequestResponse the base HTTP request and response to be audited
 * @return the result of the audit, containing any identified security issues
 */
@Override
public AuditResult passiveAudit(HttpRequestResponse baseRequestResponse) {
  return AuditResult.auditResult(new ArrayList<>());
}

//-----------------------------------------------------------------------------
/**
 * Consolidates new and existing audit issues to avoid duplicate reports. This method is called by Burp Suite
 * when a new issue is identified to determine whether it should be reported as a new issue or merged with an existing one.
 *
 * @param newIssue the new audit issue identified during scanning
 * @param existingIssue an existing audit issue that may be similar to the new issue
 * @return the action to be taken, indicating whether to keep both issues, replace the existing issue, or ignore the new issue
 */
@Override
public ConsolidationAction consolidateIssues(AuditIssue newIssue, AuditIssue existingIssue) {
  return ConsolidationAction.KEEP_BOTH;
}


}
////////////////////////////////////////
// END CLASS CustomScanCheck
////////////////////////////////////////