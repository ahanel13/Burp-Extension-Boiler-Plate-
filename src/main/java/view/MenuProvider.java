package view;

import burp.api.montoya.http.message.HttpRequestResponse;
import burp.api.montoya.ui.contextmenu.ContextMenuEvent;
import burp.api.montoya.ui.contextmenu.ContextMenuItemsProvider;
import burp.api.montoya.ui.contextmenu.MessageEditorHttpRequestResponse;

import javax.swing.JMenuItem;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

////////////////////////////////////////
// CLASS FerretMenuProvider
////////////////////////////////////////
public class MenuProvider implements ContextMenuItemsProvider {


////////////////////////////////////////
// PUBLIC METHODS
////////////////////////////////////////
//-----------------------------------------------------------------------------
public MenuProvider() {
  _option1 = new JMenuItem("Option 1");
  _option2 = new JMenuItem("Option 2");
}

//-----------------------------------------------------------------------------
@Override
public List<Component> provideMenuItems(ContextMenuEvent event) {
  Optional<MessageEditorHttpRequestResponse> optional     = event.messageEditorRequestResponse();
  List<Component>                            menuItemList = new ArrayList<>();
  
  // Todo: Add your own custom logic.
  //  This code determines when a menu item is added.
  if(
    optional.isPresent() &&
    optional.get().selectionContext().equals(MessageEditorHttpRequestResponse.SelectionContext.REQUEST)
  ) {
    menuItemList.add(_option1);
    _reqResp = optional.get().requestResponse();
  }
  else {
    _reqResp = event.selectedRequestResponses().get(0);
  }
  
  menuItemList.add(_option2);
  _reqRespEditor = optional;
  _event         = event;
  
  return menuItemList;
}

//-----------------------------------------------------------------------------
public void addActionListenerToOption1(ActionListener l){
  _option1.addActionListener(l);
}

//-----------------------------------------------------------------------------
public void addActionListenerToOption2(ActionListener l){
  _option2.addActionListener(l);
}

//-----------------------------------------------------------------------------
public Optional<MessageEditorHttpRequestResponse> getReqRespEditor() {
  return _reqRespEditor;
}

//-----------------------------------------------------------------------------
public HttpRequestResponse getReqResp() {
  return _reqResp;
}

//-----------------------------------------------------------------------------
public ContextMenuEvent getEvent() {
  return _event;
}

////////////////////////////////////////
// PRIVATE FIELDS
////////////////////////////////////////
private final JMenuItem _option1;
private final JMenuItem _option2;

private Optional<MessageEditorHttpRequestResponse> _reqRespEditor;
private ContextMenuEvent    _event;
private HttpRequestResponse _reqResp;

}
////////////////////////////////////////
// CLASS FerretMenuProvider
////////////////////////////////////////