package model.proxy;

import burp.api.montoya.proxy.http.InterceptedResponse;
import burp.api.montoya.proxy.http.ProxyResponseHandler;
import burp.api.montoya.proxy.http.ProxyResponseReceivedAction;
import burp.api.montoya.proxy.http.ProxyResponseToBeSentAction;

////////////////////////////////////////
// CLASS CustomProxyResponseHandler
////////////////////////////////////////
public class CustomProxyResponseHandler implements ProxyResponseHandler{


//-----------------------------------------------------------------------------
@Override
public ProxyResponseReceivedAction handleResponseReceived(InterceptedResponse interceptedResponse){
  return null;
}

//-----------------------------------------------------------------------------
@Override
public ProxyResponseToBeSentAction handleResponseToBeSent(InterceptedResponse interceptedResponse){
  return null;
}


}
////////////////////////////////////////
// END CLASS CustomProxyResponseHandler
////////////////////////////////////////