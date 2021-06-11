
package texteditor;

import javax.swing.JFrame;


public class TextEditor {

   
    public static void main(String[] args) {
        // TODO code application logic here
        textEditorGUI obj= new textEditorGUI();
        obj.setBounds(0,0,700,800);
        obj.setTitle("SmartPad");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
