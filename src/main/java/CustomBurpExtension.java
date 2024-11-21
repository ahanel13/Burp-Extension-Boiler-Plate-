import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.extension.ExtensionUnloadingHandler;
import controller.MenuItemController;
import model.proxy.CustomProxyRequestHandler;
import model.proxy.CustomProxyResponseHandler;
import model.proxy.CustomWebSocketCreationHandler;
import model.scanner.CustomInsertionPointProvider;
import model.scanner.CustomScanCheck;
import view.CustomSuiteTab;
import view.MenuProvider;

////////////////////////////////////////
// CLASS CustomBurpExtension
////////////////////////////////////////
/**
 * The <code>CustomBurpExtension</code> class implements the {@link burp.api.montoya.BurpExtension BurpExtension}
 * interface and serves as the main entry point for the Burp Suite extension. This class
 * is responsible for initializing and setting up various components of the extension,
 * including menu providers, custom suite tabs, proxy handlers, scan checks, and insertion point providers.<br>
 * <br>
 * <p>When the extension is loaded by Burp Suite, the <code>initialize(MontoyaApi)</code> method is called, which sets up the extension by registering
 * various handlers and components with the Montoya API.</p>
 *
 * <p>Key responsibilities of this class include:</p>
 * <ul>
 *   <li>Setting the extension name</li>
 *   <li>Registering custom proxy request and response handlers</li>
 *   <li>Registering custom WebSocket creation handlers</li>
 *   <li>Registering custom scan checks for active and passive scanning</li>
 *   <li>Registering custom insertion point providers for defining custom locations within HTTP requests for payload insertion</li>
 *   <li>Registering a custom suite tab in the Burp Suite user interface</li>
 *   <li>Handling the unloading of the extension</li>
 * </ul>
 *
 * <p>This class provides a structured way to extend Burp Suite's functionality by integrating custom logic for scanning, proxying,
 * and user interface enhancements.</p>
 *
 * @see burp.api.montoya.BurpExtension
 * @see burp.api.montoya.MontoyaApi
 * @see burp.api.montoya.extension.ExtensionUnloadingHandler
 * @see burp.api.montoya.proxy.Proxy
 * @see burp.api.montoya.scanner.Scanner
 * @see burp.api.montoya.ui.UserInterface
 */
public class CustomBurpExtension implements BurpExtension{


////////////////////////////////////////
// PUBLIC METHODS
////////////////////////////////////////
//-----------------------------------------------------------------------------
/**
 * This function is called by Burp Suite to Initialize the extension.
 * This method sets up various components of the extension, including
 * menu providers, custom suite tabs, proxy handlers, scan checks, and
 * insertion point providers.
 *
 * @param montoyaApi the Montoya API instance provided by Burp Suite
 */
@Override
public void initialize(MontoyaApi montoyaApi) {
  _api                   = montoyaApi;
  _menuContext           = new MenuProvider();
  _view                  = new CustomSuiteTab();
  _contextMenuController = new MenuItemController(_menuContext);
  
  _api.logging().logToOutput("Enabling Extension");
  
  _registerUnloader();
  _setExtensionName();
  _registerProxyClasses();
  _registerScanChecks();
  _registerInsertionPntProvider();
  _registerSuiteTab();
  
  _api.logging().logToOutput("Extension Enabled");
}

////////////////////////////////////////
// PRIVATE FIELDS
////////////////////////////////////////
private static final String _EXT_NAME = "Boiler Plate";

private MontoyaApi         _api;
private MenuProvider       _menuContext;
private MenuItemController _contextMenuController;
private CustomSuiteTab     _view;

////////////////////////////////////////
// PRIVATE METHODS
////////////////////////////////////////
//-----------------------------------------------------------------------------
private void _registerSuiteTab(){
  _api.userInterface().registerSuiteTab(_EXT_NAME, _view);
}

//-----------------------------------------------------------------------------
/**
 * Registers an unloading handler for the Burp Suite extension.
 * This handler is called when the extension is unloaded from Burp Suite.
 */
private void _registerUnloader(){
  _api.extension().registerUnloadingHandler(new ExtensionUnloadingHandler(){
    @Override
    public void extensionUnloaded(){
      _api.logging().logToOutput("Extension unloaded.");
    }
  });
}

//-----------------------------------------------------------------------------
private void _setExtensionName(){
  _api.extension().setName(_EXT_NAME);
}

//-----------------------------------------------------------------------------
/**
 * Registers custom handlers for proxy requests, proxy responses, and WebSocket creation
 * with the Montoya API. These handlers allow the extension to intercept and modify
 * HTTP requests, HTTP responses, and WebSocket messages processed by Burp Suite.
 */
private void _registerProxyClasses(){
  CustomProxyRequestHandler      reqHandler           = new CustomProxyRequestHandler();
  CustomProxyResponseHandler     respHandler          = new CustomProxyResponseHandler();
  CustomWebSocketCreationHandler wsockCreationHandler = new CustomWebSocketCreationHandler();
  
  _api.proxy().registerRequestHandler(reqHandler);
  _api.proxy().registerResponseHandler(respHandler);
  _api.proxy().registerWebSocketCreationHandler(wsockCreationHandler);
}

//-----------------------------------------------------------------------------
/**
 * Registers a custom scan check with the Montoya API.
 * This method is only for registration purposes.
 * Registering a scan check allows Burp Suite's active and passive scans
 * to make calls to this extension's custom {@link burp.api.montoya.scanner.ScanCheck ScanChecks}.
 */
private void _registerScanChecks(){
  CustomScanCheck scanChk = new CustomScanCheck();
  
  _api.scanner().registerScanCheck(scanChk);
}

//-----------------------------------------------------------------------------
/**
 * Registers a custom {@link burp.api.montoya.scanner.audit.insertionpoint.AuditInsertionPointProvider AuditInsertionPointProvider}
 * with the Burp Suite. This allows the extension to define custom locations within
 * HTTP requests where payloads can be inserted during scanning.<br>
 * <br>
 * Custom insertion points are useful for targeting specific parts of
 * requests that are not covered by Burp Suite's built-in insertion points.
 * See also {@link burp.api.montoya.scanner.audit.insertionpoint.AuditInsertionPoint AuditInsertionPoint}.
 */
private void _registerInsertionPntProvider(){
  CustomInsertionPointProvider provider = new CustomInsertionPointProvider();
  
  _api.scanner().registerInsertionPointProvider(provider);
}


}
////////////////////////////////////////
// END CLASS CustomBurpExtension
////////////////////////////////////////