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
/**
 * <p>The <code>MenuProvider</code> class is responsible for creating and managing custom context menu items
 * within the Burp Suite user interface. This class implements the <code>ContextMenuItemsProvider</code> interface
 * to provide custom menu items based on the context of the selected HTTP request or response.</p>
 *
 * <p>When a user right-clicks on an HTTP request or response in Burp Suite, the <code>provideMenuItems</code> method
 * is called to determine which menu items should be displayed. This class also allows adding action listeners
 * to the menu items to define custom behavior when the menu items are clicked.</p>
 *
 * <p>Key responsibilities of this class include:</p>
 * <ul>
 *   <li>Creating menu items "Option 1" and "Option 2"</li>
 *   <li>Providing menu items based on the context of the selected HTTP request or response</li>
 *   <li>Allowing action listeners to be added to the menu items</li>
 *   <li>Storing the context of the selected HTTP request or response for further processing</li>
 * </ul>
 *
 * <p>This class provides a way to extend Burp Suite's context menu functionality by adding custom menu items
 * and defining their behavior.</p>
 *
 * @see burp.api.montoya.ui.contextmenu.ContextMenuItemsProvider
 * @see burp.api.montoya.ui.contextmenu.ContextMenuEvent
 * @see burp.api.montoya.ui.contextmenu.MessageEditorHttpRequestResponse
 */
public class MenuProvider implements ContextMenuItemsProvider {


////////////////////////////////////////
// PUBLIC METHODS
////////////////////////////////////////
//-----------------------------------------------------------------------------
/**
 * Constructs a new <code>MenuProvider</code> instance and initializes the menu items.
 */
public MenuProvider() {
  _option1 = new JMenuItem("Option 1");
  _option2 = new JMenuItem("Option 2");
}

//-----------------------------------------------------------------------------
/**
 * Provides custom menu items based on the context of the selected HTTP request or response.
 * This method is called by Burp Suite when the user right-clicks on an HTTP request or response.
 *
 * @param event the context menu event containing information about the selected HTTP request or response
 * @return a list of components representing the custom menu items to be displayed
 */
@Override
public List<Component> provideMenuItems(ContextMenuEvent event) {
  Optional<MessageEditorHttpRequestResponse> optional     = event.messageEditorRequestResponse();
  List<Component>                            menuItemList = new ArrayList<>();
  
  // Todo: Add your own custom logic.
  //  This code determines when a menu item is added.
  
  if(// Check if the optional contains a value and if the selection context is a request
    optional.isPresent() &&
    optional.get().selectionContext().equals(MessageEditorHttpRequestResponse.SelectionContext.REQUEST)
  ) {
    // If the selected context is a request, add "Option 1" to the menu
    menuItemList.add(_option1);
    // Store the selected HTTP request/response for further processing
    _reqResp = optional.get().requestResponse();
  }
  else { // If the selected context is not a request, store the first selected HTTP request/response
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