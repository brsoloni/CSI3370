package texteditor;

import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.FileDialog;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.MNEMONIC_KEY;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit.CopyAction;
import javax.swing.text.DefaultEditorKit.CutAction;
import javax.swing.text.DefaultEditorKit.PasteAction;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLEditorKit;
import static sun.management.Agent.error;

public class textEditorGUI extends javax.swing.JFrame {
    String fileName;
    private Color clrhighlit;
    private Color highlightColor = Color.YELLOW;
    // Save file variables
    private int numSavedSpaces = 0;
    private boolean saved = true;
    private boolean saveAsDone = false;
    private boolean sameLocation = false;
    private boolean splitsSaved = true;
    private boolean newDifLocation = false;
    private File f[] = new File[100];
    private String baseName = "";
    private JFileChooser[] saveChooserArr = new JFileChooser[100];
    private StyledDocument docArr[] = new StyledDocument[100];
    private HTMLEditorKit kitArr[] = new HTMLEditorKit[100];
    private BufferedOutputStream stream[] = new BufferedOutputStream[100];
    private int option;
     int indVWS = 0;
     private JTextPane activePane;
     private javax.swing.JTextPane[] textArrV = new javax.swing.JTextPane[100];
    // Cut, copy, paste variables
    private int dot;
    private char[] character;
    private AttributeSet attributes[];
    private String selection;
    private CutAction cutAction = null;
    private CopyAction copyAction = null;
    private PasteAction pasteAction = null;
    private KeyStroke cutKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK);
    private KeyStroke copyKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK);
    private KeyStroke pasteKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK);
    public textEditorGUI() {
        initComponents();
        textPane.setContentType("text/html");
       // textPane.setText("<html>789645</html>"); //Your whole html here..
       
       
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        searchContent = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();
        jToolBar = new javax.swing.JToolBar();
        NewFileButton = new javax.swing.JButton();
        openFileButton = new javax.swing.JButton();
        HyperLinkQuickButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        copyButton = new javax.swing.JButton();
        pasteButton = new javax.swing.JButton();
        cutButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        highLightQuickButton = new javax.swing.JButton();
        clearHighLighterQuickButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        newFileItem = new javax.swing.JMenuItem();
        openFileItem = new javax.swing.JMenuItem();
        saveItem = new javax.swing.JMenuItem();
        saveAsItem = new javax.swing.JMenuItem();
        printItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        undoItem = new javax.swing.JMenuItem();
        redoItem = new javax.swing.JMenuItem();
        copyItem = new javax.swing.JMenuItem();
        pasteItem = new javax.swing.JMenuItem();
        cutItem = new javax.swing.JMenuItem();
        selectAllItem = new javax.swing.JMenuItem();
        insertMenu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        formatMenu = new javax.swing.JMenu();
        textMenu = new javax.swing.JMenu();
        colorMenu = new javax.swing.JMenu();
        headAndFootItem = new javax.swing.JMenuItem();
        highLightColorButton = new javax.swing.JMenuItem();
        clearFormatItem = new javax.swing.JMenuItem();
        toolMenu = new javax.swing.JMenu();
        wordCounterItem = new javax.swing.JMenuItem();
        splitWordsItem = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchButton.setText("Search");

        jScrollPane1.setViewportView(textPane);

        jToolBar.setRollover(true);

        NewFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/newFile.png"))); // NOI18N
        NewFileButton.setFocusable(false);
        NewFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NewFileButton.setMaximumSize(new java.awt.Dimension(30, 40));
        NewFileButton.setMinimumSize(new java.awt.Dimension(30, 40));
        NewFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        NewFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewFileButtonActionPerformed(evt);
            }
        });
        jToolBar.add(NewFileButton);

        openFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/document_open.png"))); // NOI18N
        openFileButton.setToolTipText("");
        openFileButton.setFocusable(false);
        openFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openFileButton.setMaximumSize(new java.awt.Dimension(35, 50));
        openFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(openFileButton);

        HyperLinkQuickButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/save_file.png"))); // NOI18N
        HyperLinkQuickButton.setFocusable(false);
        HyperLinkQuickButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        HyperLinkQuickButton.setMaximumSize(new java.awt.Dimension(35, 50));
        HyperLinkQuickButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        HyperLinkQuickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HyperLinkQuickButtonActionPerformed(evt);
            }
        });
        jToolBar.add(HyperLinkQuickButton);
        jToolBar.add(jSeparator3);

        copyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/copy.png"))); // NOI18N
        copyButton.setFocusable(false);
        copyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        copyButton.setMaximumSize(new java.awt.Dimension(35, 50));
        copyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });
        jToolBar.add(copyButton);

        pasteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/paste.png"))); // NOI18N
        pasteButton.setFocusable(false);
        pasteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pasteButton.setMaximumSize(new java.awt.Dimension(35, 50));
        pasteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pasteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteButtonActionPerformed(evt);
            }
        });
        jToolBar.add(pasteButton);

        cutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/clipboard_cut.png"))); // NOI18N
        cutButton.setFocusable(false);
        cutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cutButton.setMaximumSize(new java.awt.Dimension(35, 50));
        cutButton.setName(""); // NOI18N
        cutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutButtonActionPerformed(evt);
            }
        });
        jToolBar.add(cutButton);
        jToolBar.add(jSeparator1);

        highLightQuickButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/highlight_black.png"))); // NOI18N
        highLightQuickButton.setFocusable(false);
        highLightQuickButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        highLightQuickButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        highLightQuickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highLightQuickButtonActionPerformed(evt);
            }
        });
        jToolBar.add(highLightQuickButton);

        clearHighLighterQuickButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/clear_highlight_black.png"))); // NOI18N
        clearHighLighterQuickButton.setFocusable(false);
        clearHighLighterQuickButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clearHighLighterQuickButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clearHighLighterQuickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearHighLighterQuickButtonActionPerformed(evt);
            }
        });
        jToolBar.add(clearHighLighterQuickButton);
        jToolBar.add(jSeparator2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(searchContent, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        FileMenu.setText("File");

        newFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newFileItem.setText("New");
        newFileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileItemActionPerformed(evt);
            }
        });
        FileMenu.add(newFileItem);

        openFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFileItem.setText("Open");
        openFileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileItemActionPerformed(evt);
            }
        });
        FileMenu.add(openFileItem);

        saveItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveItem.setText("Save");
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed(evt);
            }
        });
        FileMenu.add(saveItem);

        saveAsItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsItem.setText("SaveAs");
        saveAsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsItemActionPerformed(evt);
            }
        });
        FileMenu.add(saveAsItem);

        printItem.setText("Print");
        printItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printItemActionPerformed(evt);
            }
        });
        FileMenu.add(printItem);

        exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        FileMenu.add(exitItem);

        jMenuBar1.add(FileMenu);

        EditMenu.setText("Edit");

        undoItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        undoItem.setText("Undo");
        undoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoItemActionPerformed(evt);
            }
        });
        EditMenu.add(undoItem);

        redoItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        redoItem.setText("Redo");
        redoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoItemActionPerformed(evt);
            }
        });
        EditMenu.add(redoItem);

        copyItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copyItem.setText("Copy");
        copyItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyItemActionPerformed(evt);
            }
        });
        EditMenu.add(copyItem);

        pasteItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        pasteItem.setText("Paste");
        pasteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteItemActionPerformed(evt);
            }
        });
        EditMenu.add(pasteItem);

        cutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cutItem.setText("Cut");
        cutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutItemActionPerformed(evt);
            }
        });
        EditMenu.add(cutItem);

        selectAllItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        selectAllItem.setText("Select All");
        selectAllItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllItemActionPerformed(evt);
            }
        });
        EditMenu.add(selectAllItem);

        jMenuBar1.add(EditMenu);

        insertMenu.setText("Insert");

        jMenuItem2.setText("Image");
        insertMenu.add(jMenuItem2);

        jMenuBar1.add(insertMenu);

        formatMenu.setText("Format");

        textMenu.setText("Text");
        formatMenu.add(textMenu);

        colorMenu.setText("Color");
        formatMenu.add(colorMenu);

        headAndFootItem.setText("Header and Footer");
        headAndFootItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headAndFootItemActionPerformed(evt);
            }
        });
        formatMenu.add(headAndFootItem);

        highLightColorButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        highLightColorButton.setText("Highlight Color");
        highLightColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highLightColorButtonActionPerformed(evt);
            }
        });
        formatMenu.add(highLightColorButton);

        clearFormatItem.setText("Clear Formatting");
        formatMenu.add(clearFormatItem);

        jMenuBar1.add(formatMenu);

        toolMenu.setText("Tool");

        wordCounterItem.setText("Word Counter");
        wordCounterItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordCounterItemActionPerformed(evt);
            }
        });
        toolMenu.add(wordCounterItem);

        splitWordsItem.setText("Split words");
        toolMenu.add(splitWordsItem);

        jMenuBar1.add(toolMenu);

        aboutMenu.setText("About");
        jMenuBar1.add(aboutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newFileItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileItemActionPerformed
       //Xi's features
     getFocusedComponent().setText("");
        setTitle(fileName);
        saved = false;
        saveAsDone = false;
    }//GEN-LAST:event_newFileItemActionPerformed

    private void printItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printItemActionPerformed
        try {
      
            String newfter = HeaderFooterFrame.newFooter;
            String newhder = HeaderFooterFrame.newHeader;          
            MessageFormat footer = createFormat(newfter);
            MessageFormat header = createFormat(newhder);
          
        
            
            Boolean complete= textPane.print(header,footer);
           if(complete){
                JOptionPane.showMessageDialog(null, "Done printing","Information",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                //JOptionPane.showMessageDialog(null,"Job cancelled","Information",JOptionPane.INFORMATION_MESSAGE);
            } } catch (PrinterException ex) {
            Logger.getLogger(textEditorGUI.class.getName()).log(Level.SEVERE, null, ex);
          
           
        }
    }//GEN-LAST:event_printItemActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        // Xi's features
        System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    private void undoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_undoItemActionPerformed

    private void redoItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redoItemActionPerformed

    private void copyItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyItemActionPerformed
        // Xi's feature
        textPane.copy();
    }//GEN-LAST:event_copyItemActionPerformed

    private void pasteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteItemActionPerformed
        // Xi's feature
        textPane.paste();
    }//GEN-LAST:event_pasteItemActionPerformed

    private void cutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutItemActionPerformed
        // Xi's features
        textPane.cut();
    }//GEN-LAST:event_cutItemActionPerformed

    private void selectAllItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectAllItemActionPerformed

    private void openFileItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileItemActionPerformed
       //Xi's features
       FileDialog fileDialog = new FileDialog(textEditorGUI.this, "Open File", FileDialog.LOAD);
       fileDialog.setVisible(true);
       if(fileDialog.getFile()!=null){
           fileName = fileDialog.getDirectory()+ fileDialog.getFile();
           setTitle(fileName);
       }
       try {
           BufferedReader reader =new BufferedReader(new FileReader(fileName));
           StringBuilder sb = new StringBuilder();
           
           String line = null;
           while((line = reader.readLine())!=null){
               sb.append(line+ "\n");
               textPane.setText(sb.toString());
           }
           reader.close();
           }
       
       catch (IOException e){
           System.out.println("File Not Found!");
};
    }//GEN-LAST:event_openFileItemActionPerformed

    private void saveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemActionPerformed
        // Xi's features
         if (saveAsDone == false){
            saveAs();
        } else {
            save();
        }
    }//GEN-LAST:event_saveItemActionPerformed

    private void saveAsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsItemActionPerformed
      // Xi's features
       saveAs();
    }//GEN-LAST:event_saveAsItemActionPerformed

    private void NewFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewFileButtonActionPerformed
           //Xi's features
     getFocusedComponent().setText("");
        setTitle(fileName);
        saved = false;
        saveAsDone = false;
    }//GEN-LAST:event_NewFileButtonActionPerformed

    private void wordCounterItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordCounterItemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_wordCounterItemActionPerformed

    private void headAndFootItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headAndFootItemActionPerformed
        //Xi‘s feature
       new HeaderFooterFrame().setVisible(true);
    }//GEN-LAST:event_headAndFootItemActionPerformed

    private void highLightColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highLightColorButtonActionPerformed
        // Xi's feature
        Color newColor =JColorChooser.showDialog(this,"Select Highlight Color", clrhighlit);        
        highlightColor = newColor;
    }//GEN-LAST:event_highLightColorButtonActionPerformed

    private void highLightQuickButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highLightQuickButtonActionPerformed
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        int selectedLength =end-start;
        StyledDocument style = textPane.getStyledDocument();
        AttributeSet oldset =style.getCharacterElement(end-1).getAttributes();
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet s = sc.addAttribute(oldset, StyleConstants.Background, highlightColor );
        style.setCharacterAttributes(start, selectedLength, s, true);
    }//GEN-LAST:event_highLightQuickButtonActionPerformed

    private void HyperLinkQuickButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HyperLinkQuickButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HyperLinkQuickButtonActionPerformed

    private void clearHighLighterQuickButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearHighLighterQuickButtonActionPerformed
        // Xi's feature
        int start =  textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        int selectedLength = end - start;
        StyledDocument style = textPane.getStyledDocument();
        AttributeSet oldest = style.getCharacterElement(end-1).getAttributes();
        StyleContext sc = StyleContext.getDefaultStyleContext();
        Color backgroundClr = textPane.getBackground();
        AttributeSet s =sc.addAttribute(oldest, StyleConstants.Background, backgroundClr);
        style.setCharacterAttributes(start, selectedLength, s, true);
    }//GEN-LAST:event_clearHighLighterQuickButtonActionPerformed

    private void pasteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteButtonActionPerformed
        // Xi's feature
        textPane.paste();
    }//GEN-LAST:event_pasteButtonActionPerformed

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonActionPerformed
         // Xi's feature
        textPane.copy();
    }//GEN-LAST:event_copyButtonActionPerformed

    private void cutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutButtonActionPerformed
         // Xi's features
        textPane.cut();
    }//GEN-LAST:event_cutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(textEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(textEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(textEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(textEditorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new textEditorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JButton HyperLinkQuickButton;
    private javax.swing.JButton NewFileButton;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenuItem clearFormatItem;
    private javax.swing.JButton clearHighLighterQuickButton;
    private javax.swing.JMenu colorMenu;
    private javax.swing.JButton copyButton;
    private javax.swing.JMenuItem copyItem;
    private javax.swing.JButton cutButton;
    private javax.swing.JMenuItem cutItem;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu formatMenu;
    private javax.swing.JMenuItem headAndFootItem;
    private javax.swing.JMenuItem highLightColorButton;
    private javax.swing.JButton highLightQuickButton;
    private javax.swing.JMenu insertMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JMenuItem newFileItem;
    private javax.swing.JButton openFileButton;
    private javax.swing.JMenuItem openFileItem;
    private javax.swing.JButton pasteButton;
    private javax.swing.JMenuItem pasteItem;
    private javax.swing.JMenuItem printItem;
    private javax.swing.JMenuItem redoItem;
    private javax.swing.JMenuItem saveAsItem;
    private javax.swing.JMenuItem saveItem;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchContent;
    private javax.swing.JMenuItem selectAllItem;
    private javax.swing.JMenuItem splitWordsItem;
    private javax.swing.JMenu textMenu;
    private javax.swing.JTextPane textPane;
    private javax.swing.JMenu toolMenu;
    private javax.swing.JMenuItem undoItem;
    private javax.swing.JMenuItem wordCounterItem;
    // End of variables declaration//GEN-END:variables
    
    private Object getTokit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private MessageFormat createFormat(String source) {
       if (source != null && source.length() > 0) {
            try {
                return new MessageFormat(source);
            } catch (IllegalArgumentException e) {
                error("Sorry, this format is invalid.");
            }
        }
        return null;
      //To change body of generated methods, choose Tools | Templates.
    }

   protected final JTextPane getFocusedComponent()
    {
        if (indVWS == 0){
            activePane = textPane;
        }else{
            KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            Component focused = kfm.getPermanentFocusOwner();
            if (focused instanceof JTextPane){
                activePane = (JTextPane) focused;
            }
        }
        return activePane;
    }
    
   public void saveAs(){
        String name="";
        f[0] = new File("");
        if (indVWS > 0) {
            int n = JOptionPane.showConfirmDialog(
                    jPanel1,
                    "Would you like to save all of your windows in the same place?",
                    "Saving All Windows to the Same Place",
                    JOptionPane.YES_NO_OPTION);

            if (n == JOptionPane.YES_OPTION) {
                sameLocation = true;
            }
        }
        for (int i = 0; i <= indVWS; i++) {
            docArr[i] = (StyledDocument) textArrV[i].getDocument();

            kitArr[i] = new HTMLEditorKit();
            if (sameLocation == false||i==0) {
                saveChooserArr[i] = new JFileChooser();
                saveChooserArr[i].setMultiSelectionEnabled(false);
                saveChooserArr[i].setDialogTitle("Save - Window " + i);
                option = saveChooserArr[i].showSaveDialog(textEditorGUI.this);

                if (option == JFileChooser.APPROVE_OPTION) {
                    try {
                        stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                        baseName = saveChooserArr[0].getSelectedFile().toString();
                        f[i] = saveChooserArr[i].getSelectedFile();
                        kitArr[i].write(stream[i], docArr[i], docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                        saveChooserArr[i].setSelectedFile(f[i]);
                    } catch (FileNotFoundException e) {

                    } catch (IOException e) {

                    } catch (BadLocationException e) {

                    }
                    saveAsDone = true;
                    numSavedSpaces++;
                    splitsSaved = true;
                    saved = true;
                }
            }
            if (sameLocation == true&&i!=0) {
                saveChooserArr[i] = new JFileChooser();
                name = baseName + i;
                saveChooserArr[i].setSelectedFile(f[i] = new File(name));
                if (option == JFileChooser.APPROVE_OPTION) {
                    try {
                        stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                        kitArr[i].write(stream[i], docArr[i], docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                    } catch (FileNotFoundException e) {

                    } catch (IOException e) {

                    } catch (BadLocationException e) {

                    }
                    saveAsDone = true;
                    numSavedSpaces++;
                    splitsSaved = true;
                    saved = true;
                }
            }
        }
    }
     public void save(){
        String name="";
        f[0] = new File("");
        if (splitsSaved == false && sameLocation == true && newDifLocation == false) {
            if (indVWS > 0) {
                int n = JOptionPane.showConfirmDialog(
                        jPanel1,
                        "Would you like to save all of your windows in the same place?",
                        "Saving All Windows to the Same Place",
                        JOptionPane.YES_NO_OPTION);

                if (n == JOptionPane.YES_OPTION) {
                    sameLocation = true;
                } else {
                    newDifLocation = true;
                }
            }
        }
        for (int i = 0; i <= indVWS; i++){
            docArr[i] = (StyledDocument) textArrV[i].getDocument();
            kitArr[i] = new HTMLEditorKit();

            if (i==0) {
                try {
                    f[i].delete();
                    stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                    kitArr[i].write(stream[i],docArr[i],docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                    f[i] = new File(saveChooserArr[i].getSelectedFile().toString());
                } catch (FileNotFoundException e){

                } catch (IOException e) {

                } catch (BadLocationException e) {

                }
                saved = true;
                splitsSaved = true;
            }
            if ((sameLocation == false && i != 0)){
                saveChooserArr[i] = new JFileChooser();
                saveChooserArr[i].setSelectedFile(f[i]);
                
                if (option == JFileChooser.APPROVE_OPTION) {
                    try {
                        if ((i < numSavedSpaces)){ //&& ((indVWS + 1) == numSavedSpaces)){
                            f[i].delete();
                            stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                            kitArr[i].write(stream[i], docArr[i], docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                            f[i] = new File(saveChooserArr[i].getSelectedFile().toString());
                        } else {
                            // Save newly created workspaces
                            saveChooserArr[i].setMultiSelectionEnabled(false);
                            saveChooserArr[i].setDialogTitle("Save - Window " + i);
                            int newChoice = saveChooserArr[i].showSaveDialog(textEditorGUI.this);
                            if (newChoice == JFileChooser.APPROVE_OPTION){
                                stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                                kitArr[i].write(stream[i], docArr[i], docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                                f[i] = saveChooserArr[i].getSelectedFile();
                                numSavedSpaces++;
                            }
                        }
                    } catch (FileNotFoundException e) {

                    } catch (IOException e) {

                    } catch (BadLocationException e) {

                    }
                    splitsSaved = true;
                    saved = true;
                }
            }
            if (sameLocation == true&&i!=0) {
                try {
                    saveChooserArr[i] = new JFileChooser();
                    saveChooserArr[i].setSelectedFile(f[i]);
                    if (option == JFileChooser.APPROVE_OPTION) {
                        if (newDifLocation == false) {
                            if (i <= numSavedSpaces){
                                name = baseName + i;
                                saveChooserArr[i].setSelectedFile(f[i]=new File(name));
                                f[i].delete();
                                stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                                kitArr[i].write(stream[i], docArr[i], docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                                f[i] = new File(saveChooserArr[i].getSelectedFile().toString());
                            } else {
                                // Save newly created workspaces
                                saveChooserArr[i].setMultiSelectionEnabled(false);
                                saveChooserArr[i].setDialogTitle("Save - Window " + numSavedSpaces);
                                int newChoice = saveChooserArr[i].showSaveDialog(textEditorGUI.this);
                                if (newChoice == JFileChooser.APPROVE_OPTION){
                                    stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                                    kitArr[i].write(stream[i], docArr[i], docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                                    f[i] = new File(saveChooserArr[i].getSelectedFile().toString());
                                    numSavedSpaces++;
                                }
                            }
                            splitsSaved = true;
                            saved = true;
                        } else {
                            if ((i <= numSavedSpaces)){
                                f[i].delete();
                                stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                                kitArr[i].write(stream[i], docArr[i], docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                                f[i] = new File(saveChooserArr[i].getSelectedFile().toString());
                            } else {
                                // Save newly created workspaces
                                saveChooserArr[i].setMultiSelectionEnabled(false);
                                saveChooserArr[i].setDialogTitle("Save - Window " + i);
                                int newChoice = saveChooserArr[i].showSaveDialog(textEditorGUI.this);
                                if (newChoice == JFileChooser.APPROVE_OPTION){
                                    stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                                    kitArr[i].write(stream[i], docArr[i], docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                                    f[i] = saveChooserArr[i].getSelectedFile();
                                    numSavedSpaces++;
                                }
                            }
                            splitsSaved = true;
                            saved = true;
                        }
                    }
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                } catch (BadLocationException e) {

                }
            }
        }
    }
}
