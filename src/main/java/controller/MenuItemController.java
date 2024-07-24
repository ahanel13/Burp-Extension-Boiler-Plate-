package controller;

import view.MenuProvider;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

////////////////////////////////////////
// CLASS MenuItemController
////////////////////////////////////////
public class MenuItemController{

//-----------------------------------------------------------------------------
public MenuItemController(MenuProvider contextMenu){
  _contextMenu = contextMenu;
  _addListener2Opt1();
  _addListener2Opt2();
}

private final MenuProvider _contextMenu;

//-----------------------------------------------------------------------------
private void _addListener2Opt1(){
  _contextMenu.addActionListenerToOption1(new AbstractAction(){
    @Override
    public void actionPerformed(ActionEvent e){
      // todo: when the menu item "Option 1" is clicked, perform some action
    }
  });
}

//-----------------------------------------------------------------------------
private void _addListener2Opt2(){
  _contextMenu.addActionListenerToOption2(new AbstractAction(){
    @Override
    public void actionPerformed(ActionEvent e){
      // todo: when the menu item "Option 2" is clicked, perform some action
    }
  });
}


}
////////////////////////////////////////
// END CLASS MenuItemController
////////////////////////////////////////