import burp.api.montoya.MontoyaApi;
import burp.api.montoya.extension.ExtensionUnloadingHandler;
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
  _api             = montoyaApi;
  _menuContext     = new MenuProvider();
  
  _api.extension().setName("Boiler Plate");
  _api.logging().logToOutput("Extension Installed");
  _registerUnloader();
}

////////////////////////////////////////
// PRIVATE FIELDS
////////////////////////////////////////
private MontoyaApi   _api;
private MenuProvider _menuContext;


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


}
////////////////////////////////////////
// END CLASS BurpExtension
////////////////////////////////////////