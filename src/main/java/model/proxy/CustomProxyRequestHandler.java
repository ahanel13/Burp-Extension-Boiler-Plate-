package model.proxy;

import burp.api.montoya.proxy.http.InterceptedRequest;
import burp.api.montoya.proxy.http.ProxyRequestHandler;
import burp.api.montoya.proxy.http.ProxyRequestReceivedAction;
import burp.api.montoya.proxy.http.ProxyRequestToBeSentAction;

////////////////////////////////////////
// CLASS CustomProxyRequestHandler
////////////////////////////////////////
public class CustomProxyRequestHandler implements ProxyRequestHandler{


//-----------------------------------------------------------------------------
@Override
public ProxyRequestReceivedAction handleRequestReceived(InterceptedRequest interceptedRequest){
  return null;
}

//-----------------------------------------------------------------------------
@Override
public ProxyRequestToBeSentAction handleRequestToBeSent(InterceptedRequest interceptedRequest){
  return null;
}


}
////////////////////////////////////////
// END CLASS CustomProxyRequestHandler
////////////////////////////////////////