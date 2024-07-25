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
  return ProxyRequestReceivedAction.continueWith(interceptedRequest);
}

//-----------------------------------------------------------------------------
@Override
public ProxyRequestToBeSentAction handleRequestToBeSent(InterceptedRequest interceptedRequest){
  return ProxyRequestToBeSentAction.continueWith(interceptedRequest);
}


}
////////////////////////////////////////
// END CLASS CustomProxyRequestHandler
////////////////////////////////////////