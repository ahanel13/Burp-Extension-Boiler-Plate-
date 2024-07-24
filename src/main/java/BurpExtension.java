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
// CLASS BurpExtension
////////////////////////////////////////
public class BurpExtension implements burp.api.montoya.BurpExtension{


////////////////////////////////////////
// PUBLIC METHODS
////////////////////////////////////////
//-----------------------------------------------------------------------------
@Override
public void initialize(MontoyaApi montoyaApi) {
  _api.logging().logToOutput("Enabling Extension");
  
  _api                   = montoyaApi;
  _menuContext           = new MenuProvider();
  _view                  = new CustomSuiteTab();
  _contextMenuController = new MenuItemController(_menuContext);
  
  _registerUnloader();
  _setExtensionName();
  _registerProxyClasses();
  _registerScanChecks();
  _registerInsertionPntProvider();
  _registerSuiteTab();
  
  _api.logging().logToOutput("Extension Enabled");
}

private void _registerSuiteTab(){
  _api.userInterface().registerSuiteTab(_EXT_NAME, _view);
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
  _api.extension().setName("Boiler Plate");
}

//-----------------------------------------------------------------------------
private void _registerProxyClasses(){
  CustomProxyRequestHandler      reqHandler           = new CustomProxyRequestHandler();
  CustomProxyResponseHandler     respHandler          = new CustomProxyResponseHandler();
  CustomWebSocketCreationHandler wsockCreationHandler = new CustomWebSocketCreationHandler();
  
  _api.proxy().registerRequestHandler(reqHandler);
  _api.proxy().registerResponseHandler(respHandler);
  _api.proxy().registerWebSocketCreationHandler(wsockCreationHandler);
}

//-----------------------------------------------------------------------------
private void _registerScanChecks(){
  CustomScanCheck scanChk = new CustomScanCheck();
  
  _api.scanner().registerScanCheck(scanChk);
}

//-----------------------------------------------------------------------------
private void _registerInsertionPntProvider(){
  CustomInsertionPointProvider provider = new CustomInsertionPointProvider();
  
  _api.scanner().registerInsertionPointProvider(provider);
}


}
////////////////////////////////////////
// END CLASS BurpExtension
////////////////////////////////////////