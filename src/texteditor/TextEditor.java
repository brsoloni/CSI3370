/*
    SmartPad, Copyright 2021
    Created by:
    Brent Soloniewicz
    Nathanial Matovski
    Ellis Mouton
    Mahmudur Rahman
    Xi Song
    Cameron Jordan
 */
package texteditor;

// ------ ------ Imports ------ ------
import javax.swing.JFrame;


public class TextEditor {

   
    public static void main(String[] args) {
        // Controller Logic
        textEditorGUI obj= new textEditorGUI();
        obj.setBounds(0,0,700,800);
        obj.setTitle("SmartPad");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
