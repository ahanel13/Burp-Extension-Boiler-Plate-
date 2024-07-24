package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

////////////////////////////////////////
// CLASS CustomSuiteTab
////////////////////////////////////////
public class CustomSuiteTab extends JPanel{

//-----------------------------------------------------------------------------
public CustomSuiteTab(){
  // Set up the panel
  setLayout(new BorderLayout());
  
  // Create a text area with the information
  JTextArea textArea = new JTextArea(
    "# Burp Extension Boilerplate\n" +
      "This extension setups listeners, insertion points, passive and active scan checks, etc... But does nothing.\n" +
      "This is intended to help testers start writing extensions without requiring all the setup."
  );
  
  // Set text area properties
  textArea.setEditable(false);
  textArea.setLineWrap(true);
  textArea.setWrapStyleWord(true);
  
  // Add the text area to a scroll pane
  JScrollPane scrollPane = new JScrollPane(textArea);
  
  // Add the scroll pane to the panel
  add(scrollPane, BorderLayout.CENTER);
}

}
////////////////////////////////////////
// END CLASS CustomSuiteTab
////////////////////////////////////////