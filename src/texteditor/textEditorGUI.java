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
// ------ AWT Imports ------
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.awt.KeyboardFocusManager;
import java.awt.print.PrinterException;
// ------ IO Imports ------
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// ------ Swing Imports ------
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
// ------ Text Imports ------
import java.text.MessageFormat;
import java.util.HashMap;
// ------ Java Utilities Imports ------
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import org.jsoup.Jsoup;

// textEditorGUI class
public class textEditorGUI extends javax.swing.JFrame {
    // ------ ------ Variable Declarations ------ ------

    // ------ Save file variables ------
    private int numSavedSpaces = 0;
    private boolean saved = true;
    private boolean saveAsDone = false;
    private boolean sameLocation = false;
    private boolean splitsSaved = true;
    private boolean newDifLocation = false;
    String fileName; // Name of File
    private File f[] = new File[100];
    private String baseName = ""; //Default File Name
    private JFileChooser[] saveChooserArr = new JFileChooser[100];
    private StyledDocument docArr[] = new StyledDocument[100];
    private HTMLEditorKit kitArr[] = new HTMLEditorKit[100];
    private BufferedOutputStream stream[] = new BufferedOutputStream[100];
    private int option;

    // ------ JTextPane Variables ------
    int indVWS = 0;
    private JTextPane activePane;
    private javax.swing.JTextPane[] textArrV = new javax.swing.JTextPane[100];

    // ------ Cut, copy, paste variables ------
    private int dot;
    private char[] character;
    private AttributeSet attributes[];
    private String selection;
    private CutAction cutAction = null;
    private CopyAction copyAction = null;
    private PasteAction pasteAction = null;
    // Keystroke-Specific
    private KeyStroke cutKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK);
    private KeyStroke copyKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK);
    private KeyStroke pasteKeystroke = KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK);

    // ------ Highlighter variables ------
    private Color clrhighlit;
    private Color highlightColor = Color.YELLOW;
    
    //----Font color
    Color clrCrnt;
    Color fontColor = Color.BLACK;

    public textEditorGUI() {
        initComponents();
         // textPane.setContentType("text/html");
        textPane.requestFocusInWindow();
        textArrV[0] = textPane;

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
        pasteButton = new javax.swing.JButton();
        copyButton = new javax.swing.JButton();
        cutButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        highLightQuickButton = new javax.swing.JButton();
        highLightColorQuickButton = new javax.swing.JButton();
        clearHighLighterQuickButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        fontBoldButton = new javax.swing.JButton();
        fontUnderlineButton = new javax.swing.JButton();
        fontItalicButton = new javax.swing.JButton();
        fontNormalButton = new javax.swing.JButton();
        setFont = new javax.swing.JButton();
        setFontSize = new javax.swing.JButton();
        setFontColor = new javax.swing.JButton();
        clearFormatButton = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        formatLeft = new javax.swing.JButton();
        formatCenter = new javax.swing.JButton();
        formatRight = new javax.swing.JButton();
        clearSearchButton = new javax.swing.JButton();
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
        formatMenu = new javax.swing.JMenu();
        textMenu = new javax.swing.JMenu();
        colorMenu = new javax.swing.JMenu();
        headAndFootItem = new javax.swing.JMenuItem();
        highLightColorButton = new javax.swing.JMenuItem();
        clearFormatItem = new javax.swing.JMenuItem();
        toolMenu = new javax.swing.JMenu();
        wordCounterItem = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();
        aboutSmartPad = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        searchButton.setBackground(new java.awt.Color(204, 204, 204));
        searchButton.setText("Search");
        searchButton.setToolTipText("Search the document");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchContent.setToolTipText("Search the document");

        textPane.setBackground(new java.awt.Color(240, 240, 240));
        textPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        textPane.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(textPane);

        jToolBar.setBackground(new java.awt.Color(102, 102, 102));
        jToolBar.setBorder(null);
        jToolBar.setFloatable(false);
        jToolBar.setRollover(true);
        jToolBar.setMargin(new java.awt.Insets(0, 20, 0, 0));

        NewFileButton.setBackground(new java.awt.Color(51, 51, 51));
        NewFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/newFile.png"))); // NOI18N
        NewFileButton.setToolTipText("Create a new document");
        NewFileButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        NewFileButton.setFocusable(false);
        NewFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NewFileButton.setMargin(new java.awt.Insets(2, 34, 2, 14));
        NewFileButton.setMaximumSize(new java.awt.Dimension(30, 50));
        NewFileButton.setMinimumSize(new java.awt.Dimension(30, 40));
        NewFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        NewFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewFileButtonActionPerformed(evt);
            }
        });
        jToolBar.add(NewFileButton);

        openFileButton.setBackground(new java.awt.Color(51, 51, 51));
        openFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/document_open.png"))); // NOI18N
        openFileButton.setToolTipText("Open an existing document");
        openFileButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        openFileButton.setFocusable(false);
        openFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openFileButton.setMaximumSize(new java.awt.Dimension(35, 50));
        openFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        openFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileButtonActionPerformed(evt);
            }
        });
        jToolBar.add(openFileButton);

        HyperLinkQuickButton.setBackground(new java.awt.Color(51, 51, 51));
        HyperLinkQuickButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/save_file.png"))); // NOI18N
        HyperLinkQuickButton.setToolTipText("Save the current document");
        HyperLinkQuickButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        HyperLinkQuickButton.setFocusable(false);
        HyperLinkQuickButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        HyperLinkQuickButton.setMaximumSize(new java.awt.Dimension(35, 50));
        HyperLinkQuickButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        HyperLinkQuickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveToolbarItemActionPerformed(evt);
            }
        });
        jToolBar.add(HyperLinkQuickButton);
        jToolBar.add(jSeparator3);

        pasteButton.setBackground(new java.awt.Color(51, 51, 51));
        pasteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/paste.png"))); // NOI18N
        pasteButton.setToolTipText("Paste from clipboard");
        pasteButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        copyButton.setBackground(new java.awt.Color(51, 51, 51));
        copyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/copy.png"))); // NOI18N
        copyButton.setToolTipText("Copy the currently selected text");
        copyButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        cutButton.setBackground(new java.awt.Color(51, 51, 51));
        cutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/clipboard_cut.png"))); // NOI18N
        cutButton.setToolTipText("Cut the selected text");
        cutButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        highLightQuickButton.setBackground(new java.awt.Color(51, 51, 51));
        highLightQuickButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/highlight_black.png"))); // NOI18N
        highLightQuickButton.setToolTipText("Highlight the selected text");
        highLightQuickButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        highLightQuickButton.setFocusable(false);
        highLightQuickButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        highLightQuickButton.setMaximumSize(new java.awt.Dimension(39, 50));
        highLightQuickButton.setMinimumSize(new java.awt.Dimension(39, 50));
        highLightQuickButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        highLightQuickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highLightQuickButtonActionPerformed(evt);
            }
        });
        jToolBar.add(highLightQuickButton);

        highLightColorQuickButton.setBackground(new java.awt.Color(51, 51, 51));
        highLightColorQuickButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/highlight-color.png"))); // NOI18N
        highLightColorQuickButton.setToolTipText("Select the Highlighter color");
        highLightColorQuickButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        highLightColorQuickButton.setFocusable(false);
        highLightColorQuickButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        highLightColorQuickButton.setMaximumSize(new java.awt.Dimension(39, 50));
        highLightColorQuickButton.setMinimumSize(new java.awt.Dimension(39, 50));
        highLightColorQuickButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        highLightColorQuickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highLightColorQuickButtonActionPerformed(evt);
            }
        });
        jToolBar.add(highLightColorQuickButton);

        clearHighLighterQuickButton.setBackground(new java.awt.Color(51, 51, 51));
        clearHighLighterQuickButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/clear_highlight_black.png"))); // NOI18N
        clearHighLighterQuickButton.setToolTipText("Remove highlighting from selected text");
        clearHighLighterQuickButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        clearHighLighterQuickButton.setFocusable(false);
        clearHighLighterQuickButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clearHighLighterQuickButton.setMaximumSize(new java.awt.Dimension(39, 50));
        clearHighLighterQuickButton.setMinimumSize(new java.awt.Dimension(39, 50));
        clearHighLighterQuickButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clearHighLighterQuickButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearHighLighterQuickButtonActionPerformed(evt);
            }
        });
        jToolBar.add(clearHighLighterQuickButton);
        jToolBar.add(jSeparator2);

        fontBoldButton.setBackground(new java.awt.Color(51, 51, 51));
        fontBoldButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/text-bold.png"))); // NOI18N
        fontBoldButton.setToolTipText("Bold Text");
        fontBoldButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fontBoldButton.setFocusable(false);
        fontBoldButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fontBoldButton.setMaximumSize(new java.awt.Dimension(39, 50));
        fontBoldButton.setMinimumSize(new java.awt.Dimension(39, 50));
        fontBoldButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fontBoldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontBoldButtonActionPerformed(evt);
            }
        });
        jToolBar.add(fontBoldButton);

        fontUnderlineButton.setBackground(new java.awt.Color(51, 51, 51));
        fontUnderlineButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/text-underline.png"))); // NOI18N
        fontUnderlineButton.setToolTipText("Underline the selected text");
        fontUnderlineButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fontUnderlineButton.setFocusable(false);
        fontUnderlineButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fontUnderlineButton.setMaximumSize(new java.awt.Dimension(39, 50));
        fontUnderlineButton.setMinimumSize(new java.awt.Dimension(39, 50));
        fontUnderlineButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fontUnderlineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontUnderlineButtonActionPerformed(evt);
            }
        });
        jToolBar.add(fontUnderlineButton);

        fontItalicButton.setBackground(new java.awt.Color(51, 51, 51));
        fontItalicButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/text-italic.png"))); // NOI18N
        fontItalicButton.setToolTipText("Italicize the selected text");
        fontItalicButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fontItalicButton.setFocusable(false);
        fontItalicButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fontItalicButton.setMaximumSize(new java.awt.Dimension(39, 50));
        fontItalicButton.setMinimumSize(new java.awt.Dimension(39, 50));
        fontItalicButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fontItalicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontItalicButtonActionPerformed(evt);
            }
        });
        jToolBar.add(fontItalicButton);

        fontNormalButton.setBackground(new java.awt.Color(51, 51, 51));
        fontNormalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texteditor.Icons/text-normal.png"))); // NOI18N
        fontNormalButton.setToolTipText("Set the selected text to have no font styling");
        fontNormalButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fontNormalButton.setFocusable(false);
        fontNormalButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fontNormalButton.setMaximumSize(new java.awt.Dimension(39, 50));
        fontNormalButton.setMinimumSize(new java.awt.Dimension(39, 50));
        fontNormalButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fontNormalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontNormalButtonActionPerformed(evt);
            }
        });
        jToolBar.add(fontNormalButton);

        setFont.setText("Font");
        setFont.setFocusable(false);
        setFont.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setFont.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        setFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFontActionPerformed(evt);
            }
        });
        jToolBar.add(setFont);

        setFontSize.setText("Size");
        setFontSize.setFocusable(false);
        setFontSize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setFontSize.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar.add(setFontSize);

        setFontColor.setText("Color");
        setFontColor.setFocusable(false);
        setFontColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setFontColor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        setFontColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setFontColorActionPerformed(evt);
            }
        });
        jToolBar.add(setFontColor);

        clearFormatButton.setText("Clear Format");
        clearFormatButton.setFocusable(false);
        clearFormatButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clearFormatButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clearFormatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFormatButtonActionPerformed(evt);
            }
        });
        jToolBar.add(clearFormatButton);
        jToolBar.add(jSeparator5);

        formatLeft.setText("Align Left");
        formatLeft.setFocusable(false);
        formatLeft.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        formatLeft.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        formatLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formatLeftActionPerformed(evt);
            }
        });
        jToolBar.add(formatLeft);

        formatCenter.setText("Align Center");
        formatCenter.setFocusable(false);
        formatCenter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        formatCenter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        formatCenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formatCenterActionPerformed(evt);
            }
        });
        jToolBar.add(formatCenter);

        formatRight.setText("Align Right");
        formatRight.setFocusable(false);
        formatRight.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        formatRight.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        formatRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formatRightActionPerformed(evt);
            }
        });
        jToolBar.add(formatRight);

        clearSearchButton.setText("Clear Search");
        clearSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearSearchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchContent, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearSearchButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(clearSearchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        FileMenu.setText("File");

        newFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newFileItem.setText("New");
        newFileItem.setToolTipText("Create a new document");
        newFileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileItemActionPerformed(evt);
            }
        });
        FileMenu.add(newFileItem);

        openFileItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFileItem.setText("Open");
        openFileItem.setToolTipText("Open an existing document");
        openFileItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileItemActionPerformed(evt);
            }
        });
        FileMenu.add(openFileItem);

        saveItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveItem.setText("Save");
        saveItem.setToolTipText("Save the current document");
        saveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveItemActionPerformed(evt);
            }
        });
        FileMenu.add(saveItem);

        saveAsItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsItem.setText("Save As");
        saveAsItem.setToolTipText("Save as new document");
        saveAsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsItemActionPerformed(evt);
            }
        });
        FileMenu.add(saveAsItem);

        printItem.setText("Print");
        printItem.setToolTipText("Print the current document, including Header and Footer");
        printItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printItemActionPerformed(evt);
            }
        });
        FileMenu.add(printItem);

        exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        exitItem.setText("Exit");
        exitItem.setToolTipText("Close the program");
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
        undoItem.setToolTipText("Undo the previous action");
        undoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoItemActionPerformed(evt);
            }
        });
        EditMenu.add(undoItem);

        redoItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        redoItem.setText("Redo");
        redoItem.setToolTipText("Redo the previous Undo");
        redoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoItemActionPerformed(evt);
            }
        });
        EditMenu.add(redoItem);

        copyItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copyItem.setText("Copy");
        copyItem.setToolTipText("Copy the selected text");
        copyItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyItemActionPerformed(evt);
            }
        });
        EditMenu.add(copyItem);

        pasteItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        pasteItem.setText("Paste");
        pasteItem.setToolTipText("Paste from clipboard");
        pasteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteItemActionPerformed(evt);
            }
        });
        EditMenu.add(pasteItem);

        cutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cutItem.setText("Cut");
        cutItem.setToolTipText("Cut the selected text");
        cutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutItemActionPerformed(evt);
            }
        });
        EditMenu.add(cutItem);

        selectAllItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        selectAllItem.setText("Select All");
        selectAllItem.setToolTipText("Select all text in the document");
        selectAllItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllItemActionPerformed(evt);
            }
        });
        EditMenu.add(selectAllItem);

        jMenuBar1.add(EditMenu);

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
        highLightColorButton.setToolTipText("Select Highlighter color");
        highLightColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highLightColorButtonActionPerformed(evt);
            }
        });
        formatMenu.add(highLightColorButton);

        clearFormatItem.setText("Clear Formatting");
        clearFormatItem.setToolTipText("Clear formatting from selected text");
        formatMenu.add(clearFormatItem);

        jMenuBar1.add(formatMenu);

        toolMenu.setText("Tool");

        wordCounterItem.setText("Word Counter");
        wordCounterItem.setToolTipText("View the word count of your document");
        wordCounterItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordCounterItemActionPerformed(evt);
            }
        });
        toolMenu.add(wordCounterItem);

        jMenuBar1.add(toolMenu);

        aboutMenu.setText("About");
        aboutMenu.setToolTipText("View information about SmartPad");

        aboutSmartPad.setText("About SmartPad");
        aboutSmartPad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutSmartPadActionPerformed(evt);
            }
        });
        aboutMenu.add(aboutSmartPad);

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
        // Added warning prompt
        // If there is no words present in the current document, it doesn't warn you    
        String text = getFocusedComponent().getText();
        if (text.length() == 0) {
            getFocusedComponent().setText("");
            setTitle(fileName);
            saved = false;
            saveAsDone = false;
        } else {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new document?" + "\n" + "All unsaved changes will be lost.", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                // yes option
                getFocusedComponent().setText("");
                setTitle(fileName);
                saved = false;
                saveAsDone = false;
            } else {
                // no option
            }
        }
    }//GEN-LAST:event_newFileItemActionPerformed

    private void printItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printItemActionPerformed
        // Xi's feature
        try {

            String newfter = HeaderFooterFrame.newFooter;
            String newhder = HeaderFooterFrame.newHeader;
            MessageFormat footer = createFormat(newfter);
            MessageFormat header = createFormat(newhder);

            Boolean complete = textPane.print(header, footer);
            if (complete) {
                JOptionPane.showMessageDialog(null, "Done printing", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                //JOptionPane.showMessageDialog(null,"Job cancelled","Information",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PrinterException ex) {
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
        //Xi's feature
        getFocusedComponent().selectAll();
    }//GEN-LAST:event_selectAllItemActionPerformed

    private void openFileItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileItemActionPerformed
        //Xi's features
        FileDialog fileDialog = new FileDialog(textEditorGUI.this, "Open File", FileDialog.LOAD);
        fileDialog.setVisible(true);
        if (fileDialog.getFile() != null) {
            fileName = fileDialog.getDirectory() + fileDialog.getFile();
            setTitle(fileName);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
                textPane.setText(sb.toString());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File Not Found!");
        };
    }//GEN-LAST:event_openFileItemActionPerformed

    private void saveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveItemActionPerformed
        // Mahmudur's features
        if (saveAsDone == false) {
            saveAs();
        } else {
            save();
        }
    }//GEN-LAST:event_saveItemActionPerformed

    private void saveAsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsItemActionPerformed
        // Mahmudurs's features
        saveAs();
    }//GEN-LAST:event_saveAsItemActionPerformed

    private void NewFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewFileButtonActionPerformed
        // Added warning prompt
        // If there is no words present in the current document, it doesn't warn you    
        String text = getFocusedComponent().getText();
        if (text.length() == 0) {
            getFocusedComponent().setText("");
            setTitle(fileName);
            saved = false;
            saveAsDone = false;
        } else {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new document?" + "\n" + "All unsaved changes will be lost.", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                // yes option
                getFocusedComponent().setText("");
                setTitle(fileName);
                saved = false;
                saveAsDone = false;
            } else {
                // no option
            }
        }
    }//GEN-LAST:event_NewFileButtonActionPerformed

    private void wordCounterItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordCounterItemActionPerformed
        //Xi's feature
        String text = getFocusedComponent().getText();
        JOptionPane.showMessageDialog(this, "Total words: " + new StringTokenizer(text).countTokens());
    }//GEN-LAST:event_wordCounterItemActionPerformed

    private void headAndFootItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headAndFootItemActionPerformed
        //Xi‘s feature
        new HeaderFooterFrame().setVisible(true);
    }//GEN-LAST:event_headAndFootItemActionPerformed

    private void highLightColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highLightColorButtonActionPerformed
        // Xi's feature
        Color newColor = JColorChooser.showDialog(this, "Select Highlight Color", clrhighlit);
        highlightColor = newColor;
    }//GEN-LAST:event_highLightColorButtonActionPerformed

    private void highLightQuickButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highLightQuickButtonActionPerformed
        // Xi's feature
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        int selectedLength = end - start;
        StyledDocument style = textPane.getStyledDocument();
        AttributeSet oldset = style.getCharacterElement(end - 1).getAttributes();
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet s = sc.addAttribute(oldset, StyleConstants.Background, highlightColor);
        style.setCharacterAttributes(start, selectedLength, s, true);
    }//GEN-LAST:event_highLightQuickButtonActionPerformed

    private void saveToolbarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveToolbarItemActionPerformed
        // Mahmudur's features
        if (saveAsDone == false) {
            saveAs();
        } else {
            save();
        }
    }//GEN-LAST:event_saveToolbarItemActionPerformed

    private void clearHighLighterQuickButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearHighLighterQuickButtonActionPerformed
        // Xi's feature
        int start = textPane.getSelectionStart();
        int end = textPane.getSelectionEnd();
        int selectedLength = end - start;
        StyledDocument style = textPane.getStyledDocument();
        AttributeSet oldest = style.getCharacterElement(end - 1).getAttributes();
        StyleContext sc = StyleContext.getDefaultStyleContext();
        Color backgroundClr = textPane.getBackground();
        AttributeSet s = sc.addAttribute(oldest, StyleConstants.Background, backgroundClr);
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

    private void aboutSmartPadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutSmartPadActionPerformed
        // Cam
        JOptionPane.showMessageDialog(this, "SmartPad, Copyright 2021" + "\n" + "Created By: " + "\n" + "Brent Soloniewicz" + "\n" + "Nathanial Matovski" + "\n" + "Ellis Mouton" + "\n" + "Mahmudur Rahman" + "\n" + "Cameron Jordan" + "\n" + "Xi Song");
    }//GEN-LAST:event_aboutSmartPadActionPerformed

    private void fontBoldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontBoldButtonActionPerformed
        // Cam
        //Font f1 = new Font(Font.SANS_SERIF, Font.BOLD, 11);
        //String selectedText = textPane.getSelectedText();
        //textPane.setFont(f1);
        textPane.setFont(textPane.getFont().deriveFont(Font.BOLD));
    }//GEN-LAST:event_fontBoldButtonActionPerformed

    private void fontUnderlineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontUnderlineButtonActionPerformed
        // TODO add your handling code here:          
        SimpleAttributeSet underline = new SimpleAttributeSet();
        StyleConstants.setUnderline(underline, Boolean.TRUE);
        StyledDocument doc = textPane.getStyledDocument();
        doc.setCharacterAttributes(0, doc.getLength(), underline, false);
    }//GEN-LAST:event_fontUnderlineButtonActionPerformed

    private void fontItalicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontItalicButtonActionPerformed
        // Cam
        //Font f1 = new Font(Font.SANS_SERIF, Font.ITALIC, 11);
        textPane.setFont(textPane.getFont().deriveFont(Font.ITALIC));
    }//GEN-LAST:event_fontItalicButtonActionPerformed

    private void openFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileButtonActionPerformed
        //Xi's features
        FileDialog fileDialog = new FileDialog(textEditorGUI.this, "Open File", FileDialog.LOAD);
        
        fileDialog.setVisible(true);
        if (fileDialog.getFile() != null) {
            fileName = fileDialog.getDirectory() + fileDialog.getFile();
            setTitle(fileName);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
                textPane.setText(html2text(sb.toString()));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File Not Found!");
        };
    }//GEN-LAST:event_openFileButtonActionPerformed

    private void fontNormalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontNormalButtonActionPerformed
        // Cam
        Font plain = new Font(Font.SANS_SERIF, Font.PLAIN , 11);
        textPane.setFont(plain);
    }//GEN-LAST:event_fontNormalButtonActionPerformed

    private void highLightColorQuickButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highLightColorQuickButtonActionPerformed
        // Cam
        Color newColor = JColorChooser.showDialog(this, "Select Highlight Color", clrhighlit);
        highlightColor = newColor;
    }//GEN-LAST:event_highLightColorQuickButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
       // Xi's feature
        if(searchContent.getText().equals("")){        
        }
        else
        highlight(getFocusedComponent(), searchContent.getText());
    }//GEN-LAST:event_searchButtonActionPerformed

    private void clearSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearSearchButtonActionPerformed
       // Xi's feature
        if (getFocusedComponent().getText() == null){
            
        } else {
            searchContent.setText("");
            removeHighlights(getFocusedComponent());
        }
    }//GEN-LAST:event_clearSearchButtonActionPerformed
       // Mahmudur's features
    private void formatLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formatLeftActionPerformed
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet left = new SimpleAttributeSet();
        StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
        doc.setParagraphAttributes(0, doc.getLength(), left, false);
    }//GEN-LAST:event_formatLeftActionPerformed

    private void formatCenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formatCenterActionPerformed
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }//GEN-LAST:event_formatCenterActionPerformed

    private void formatRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formatRightActionPerformed
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet right = new SimpleAttributeSet();
        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
        doc.setParagraphAttributes(0, doc.getLength(), right, false);
    }//GEN-LAST:event_formatRightActionPerformed

    private void setFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setFontActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setFontActionPerformed

    private void setFontColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setFontColorActionPerformed
       //Xi's feature
        int start = getFocusedComponent().getSelectionStart();
        int end = getFocusedComponent().getSelectionEnd();
        int selectedLength = end-start;
        StyledDocument style = getFocusedComponent().getStyledDocument();
        AttributeSet oldset = style.getCharacterElement(end-1).getAttributes();
        StyleContext sc = StyleContext.getDefaultStyleContext();
        fontColor = JColorChooser.showDialog(this, "Select Text Color", clrCrnt);
        AttributeSet s = sc.addAttribute(oldset, StyleConstants.Foreground, fontColor);
        style.setCharacterAttributes(start, selectedLength, s, true);
    }//GEN-LAST:event_setFontColorActionPerformed

    private void clearFormatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFormatButtonActionPerformed
       // Xi's feature
        int start = getFocusedComponent().getSelectionStart();
        int end = getFocusedComponent().getSelectionEnd();
        int selectedLength = end - start;
        if (selectedLength == 0){
            
        } else {
            Color backgroundClr = getFocusedComponent().getBackground();
            Font font = new Font("Tahoma", Font.PLAIN, 11);
            clearFormat(getFocusedComponent(), font, Color.black, backgroundClr, start);
        }
    }//GEN-LAST:event_clearFormatButtonActionPerformed

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
    private javax.swing.JMenuItem aboutSmartPad;
    private javax.swing.JButton clearFormatButton;
    private javax.swing.JMenuItem clearFormatItem;
    private javax.swing.JButton clearHighLighterQuickButton;
    private javax.swing.JButton clearSearchButton;
    private javax.swing.JMenu colorMenu;
    private javax.swing.JButton copyButton;
    private javax.swing.JMenuItem copyItem;
    private javax.swing.JButton cutButton;
    private javax.swing.JMenuItem cutItem;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JButton fontBoldButton;
    private javax.swing.JButton fontItalicButton;
    private javax.swing.JButton fontNormalButton;
    private javax.swing.JButton fontUnderlineButton;
    private javax.swing.JButton formatCenter;
    private javax.swing.JButton formatLeft;
    private javax.swing.JMenu formatMenu;
    private javax.swing.JButton formatRight;
    private javax.swing.JMenuItem headAndFootItem;
    private javax.swing.JMenuItem highLightColorButton;
    private javax.swing.JButton highLightColorQuickButton;
    private javax.swing.JButton highLightQuickButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator5;
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
    private javax.swing.JButton setFont;
    private javax.swing.JButton setFontColor;
    private javax.swing.JButton setFontSize;
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
                System.out.println("Sorry, this format is invalid.");
            }
        }
        return null;
        //To change body of generated methods, choose Tools | Templates.
    }
    

    public static String html2text(String html) {
        return Jsoup.parse(html).wholeText();
    }

    protected final JTextPane getFocusedComponent() {
        if (indVWS == 0) {
            activePane = textPane;
        } else {
            KeyboardFocusManager kfm = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            Component focused = kfm.getPermanentFocusOwner();
            if (focused instanceof JTextPane) {
                activePane = (JTextPane) focused;
            }
        }
        return activePane;
    }

    public void saveAs() {
        String name = "";
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
            if (sameLocation == false || i == 0) {
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
            if (sameLocation == true && i != 0) {
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

    public void save() {
        String name = "";
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
        for (int i = 0; i <= indVWS; i++) {
            docArr[i] = (StyledDocument) textArrV[i].getDocument();
            kitArr[i] = new HTMLEditorKit();

            if (i == 0) {
                try {
                    f[i].delete();
                    stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                    kitArr[i].write(stream[i], docArr[i], docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                    f[i] = new File(saveChooserArr[i].getSelectedFile().toString());
                } catch (FileNotFoundException e) {

                } catch (IOException e) {

                } catch (BadLocationException e) {

                }
                saved = true;
                splitsSaved = true;
            }
            if ((sameLocation == false && i != 0)) {
                saveChooserArr[i] = new JFileChooser();
                saveChooserArr[i].setSelectedFile(f[i]);

                if (option == JFileChooser.APPROVE_OPTION) {
                    try {
                        if ((i < numSavedSpaces)) { //&& ((indVWS + 1) == numSavedSpaces)){
                            f[i].delete();
                            stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                            kitArr[i].write(stream[i], docArr[i], docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                            f[i] = new File(saveChooserArr[i].getSelectedFile().toString());
                        } else {
                            // Save newly created workspaces
                            saveChooserArr[i].setMultiSelectionEnabled(false);
                            saveChooserArr[i].setDialogTitle("Save - Window " + i);
                            int newChoice = saveChooserArr[i].showSaveDialog(textEditorGUI.this);
                            if (newChoice == JFileChooser.APPROVE_OPTION) {
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
            if (sameLocation == true && i != 0) {
                try {
                    saveChooserArr[i] = new JFileChooser();
                    saveChooserArr[i].setSelectedFile(f[i]);
                    if (option == JFileChooser.APPROVE_OPTION) {
                        if (newDifLocation == false) {
                            if (i <= numSavedSpaces) {
                                name = baseName + i;
                                saveChooserArr[i].setSelectedFile(f[i] = new File(name));
                                f[i].delete();
                                stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                                kitArr[i].write(stream[i], docArr[i], docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                                f[i] = new File(saveChooserArr[i].getSelectedFile().toString());
                            } else {
                                // Save newly created workspaces
                                saveChooserArr[i].setMultiSelectionEnabled(false);
                                saveChooserArr[i].setDialogTitle("Save - Window " + numSavedSpaces);
                                int newChoice = saveChooserArr[i].showSaveDialog(textEditorGUI.this);
                                if (newChoice == JFileChooser.APPROVE_OPTION) {
                                    stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                                    kitArr[i].write(stream[i], docArr[i], docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                                    f[i] = new File(saveChooserArr[i].getSelectedFile().toString());
                                    numSavedSpaces++;
                                }
                            }
                            splitsSaved = true;
                            saved = true;
                        } else {
                            if ((i <= numSavedSpaces)) {
                                f[i].delete();
                                stream[i] = new BufferedOutputStream(new FileOutputStream(saveChooserArr[i].getSelectedFile().getAbsoluteFile()));
                                kitArr[i].write(stream[i], docArr[i], docArr[i].getStartPosition().getOffset(), docArr[i].getLength());
                                f[i] = new File(saveChooserArr[i].getSelectedFile().toString());
                            } else {
                                // Save newly created workspaces
                                saveChooserArr[i].setMultiSelectionEnabled(false);
                                saveChooserArr[i].setDialogTitle("Save - Window " + i);
                                int newChoice = saveChooserArr[i].showSaveDialog(textEditorGUI.this);
                                if (newChoice == JFileChooser.APPROVE_OPTION) {
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
 //Begin of "Search function" edited by Xi
    class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter{
        public MyHighlightPainter(Color color){
            super(color);
            }
        }
        Highlighter.HighlightPainter myHighlightPainter = new MyHighlightPainter(Color.cyan);
         
        public void removeHighlights(JTextComponent textComp){
            Highlighter hilite = textComp.getHighlighter();
            Highlighter.Highlight[] hilites = hilite.getHighlights();
             
            for(int i=0; i<hilites.length;i++){
                if(hilites[i].getPainter() instanceof MyHighlightPainter){
                    hilite.removeHighlight(hilites[i]);
                }
            }
        }
        public void highlight(JTextComponent textComp, String pattern){
             
            removeHighlights(textComp);
             
            try{
                Highlighter hilite = textComp.getHighlighter();
                Document doc =textComp.getDocument();
                String text = doc.getText(0, doc.getLength());
                int pos=0;
                 
                while((pos=text.toUpperCase().indexOf(pattern.toUpperCase(),pos))>=0){
                    hilite.addHighlight(pos, pos+pattern.length(), myHighlightPainter);
                    pos += pattern.length();
                }
            }
            catch(Exception e){
            }
        }
        //End of "Search Function" edited by Xi
        
        // Start of clear formatting (Xi)
    public void clearFormat(JTextPane jtp, Font font, Color c, Color bg, int start) {
        // Start with the current input attributes for the JTextPane. This
        // should ensure that we do not wipe out any existing attributes
        // (such as alignment or other paragraph attributes) currently
        // set on the text area.
        MutableAttributeSet attrs = jtp.getInputAttributes();
        // Set the font family, size, and style, based on properties of the Font object.
        StyleConstants.setFontFamily(attrs, font.getFamily());
        StyleConstants.setFontSize(attrs, font.getSize());
        StyleConstants.setItalic(attrs, false);
        StyleConstants.setBold(attrs, false);
        StyleConstants.setUnderline(attrs, false);
        StyleConstants.setStrikeThrough(attrs, false);
        // Set the font color
        StyleConstants.setForeground(attrs, c);
        StyleConstants.setBackground(attrs, bg);
        // Retrieve the pane's document object
        StyledDocument doc = jtp.getStyledDocument();

        // Replace the style for the entire document.
        doc.setCharacterAttributes(start, getFocusedComponent().getSelectedText().length(), attrs, true);
    }
    // End of clear formatting (Xi)
    
}
