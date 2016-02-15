package program;

import controller.Controller;
import java.awt.Color;
import java.awt.Font;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import ch.randelshofer.quaqua.BasicQuaquaLookAndFeel;
import ch.randelshofer.quaqua.QuaquaLookAndFeel;
import javax.swing.UnsupportedLookAndFeelException;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public class MainForm extends javax.swing.JFrame
{

    private final Controller controller;

    public MainForm() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, OWLOntologyCreationException
    {
        UIManager.setLookAndFeel(new QuaquaLookAndFeel());
        initComponents();
        outputTextArea.setSyntaxEditingStyle( SyntaxConstants.SYNTAX_STYLE_XML );
        this.controller = new Controller( outputTextArea, logTextArea );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jFileChooser1 = new javax.swing.JFileChooser();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputTextArea = new org.fife.ui.rsyntaxtextarea.RSyntaxTextArea();
        saveButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        host_textBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        username_textBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password_textBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        databaseName_textBox = new javax.swing.JTextField();
        connect_button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        port_textBox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        extract_button = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logTextArea = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        mapping_treeTable = new org.jdesktop.swingx.JXTreeTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        turtle_button = new javax.swing.JRadioButton();
        rdf_button = new javax.swing.JRadioButton();
        serialiseMappingButton = new javax.swing.JButton();
        serialiseOntologyButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        vocabNS_textBox2 = new javax.swing.JTextField();
        vocabNSPrefix_textBox2 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        vocabNS_textBox = new javax.swing.JTextField();
        vocabNSPrefix_textBox = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        vocabNS_textBox3 = new javax.swing.JTextField();
        vocabNSPrefix_textBox3 = new javax.swing.JTextField();

        jFileChooser1.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("R2RML (W3C Recommendation)");

        jSplitPane2.setDividerLocation(285);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        outputTextArea.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(outputTextArea);

        saveButton.setEnabled(false);
        saveButton.setLabel("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel12.setText("Output");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveButton))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(jPanel8);

        jSplitPane1.setDividerLocation(400);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Host");

        host_textBox.setText("localhost");
        host_textBox.setMaximumSize(new java.awt.Dimension(4, 2147483647));
        host_textBox.setMinimumSize(new java.awt.Dimension(4, 20));
        host_textBox.setName(""); // NOI18N
        host_textBox.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                host_textBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                host_textBoxMouseExited(evt);
            }
        });

        jLabel2.setText("Username");

        username_textBox.setText("root");
        username_textBox.setToolTipText("");
        username_textBox.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                username_textBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                username_textBoxMouseExited(evt);
            }
        });

        jLabel3.setText("Password");

        password_textBox.setText("root");
        password_textBox.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                password_textBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                password_textBoxMouseExited(evt);
            }
        });

        jLabel4.setText("Database Name");

        databaseName_textBox.setText("university");
        databaseName_textBox.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                databaseName_textBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                databaseName_textBoxMouseExited(evt);
            }
        });

        connect_button.setText("Connect");
        connect_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                connect_buttonActionPerformed(evt);
            }
        });

        jLabel5.setText("Port");

        port_textBox.setText("3306");
        port_textBox.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                port_textBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                port_textBoxMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(databaseName_textBox, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username_textBox)
                            .addComponent(host_textBox, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(password_textBox))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(port_textBox, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(connect_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(host_textBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(port_textBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(username_textBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password_textBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(databaseName_textBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connect_button))
                .addContainerGap())
        );

        connect_button.getAccessibleContext().setAccessibleDescription("");

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel7.setText("RDB Schema Extraction");

        extract_button.setText("Extract");
        extract_button.setEnabled(false);
        extract_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                extract_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(extract_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(extract_button)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setText("Database Connection");

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("Oracle");
        jRadioButton1.setActionCommand("");
        jRadioButton1.setEnabled(false);

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jRadioButton2.setLabel("MySQL");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Connection", jPanel5);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        logTextArea.setEditable(false);
        logTextArea.setColumns(20);
        logTextArea.setLineWrap(true);
        logTextArea.setRows(5);
        logTextArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(logTextArea);

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel11.setText("Log");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Log", jPanel2);

        jSplitPane1.setLeftComponent(jTabbedPane1);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Config_tab");

        jTabbedPane2.setPreferredSize(new java.awt.Dimension(846, 278));

        jPanel3.setEnabled(false);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel9.setText("Term Mapping");

        mapping_treeTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        mapping_treeTable.setShowVerticalLines(true);
        jScrollPane3.setViewportView(mapping_treeTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(turtle_button);
        turtle_button.setSelected(true);
        turtle_button.setText("Turtle");
        turtle_button.setEnabled(false);
        turtle_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                turtle_buttonActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdf_button);
        rdf_button.setText("RDF/XML");
        rdf_button.setEnabled(false);
        rdf_button.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rdf_buttonActionPerformed(evt);
            }
        });

        serialiseMappingButton.setText("R2RML Map");
        serialiseMappingButton.setEnabled(false);
        serialiseMappingButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                serialiseMappingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdf_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(turtle_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(serialiseMappingButton)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(turtle_button)
                    .addComponent(rdf_button)
                    .addComponent(serialiseMappingButton))
                .addContainerGap())
        );

        serialiseOntologyButton.setText("Ontology");
        serialiseOntologyButton.setEnabled(false);
        serialiseOntologyButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                serialiseOntologyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serialiseOntologyButton)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(serialiseOntologyButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Mapping", jPanel3);

        jPanel10.setEnabled(false);

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setText("Vocabulary Namespace Prefix");

        jLabel15.setText("Vocabulary Namespace");

        vocabNS_textBox2.setText("http://www.example.com/university");

        vocabNSPrefix_textBox2.setText("un");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vocabNS_textBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                    .addComponent(vocabNSPrefix_textBox2))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vocabNS_textBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(vocabNSPrefix_textBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setText("Base Namespace Prefix");
        jLabel10.setToolTipText("");

        jLabel8.setText("Base Namespace");
        jLabel8.setToolTipText("");

        vocabNS_textBox.setText("http://www.example.com/");

        vocabNSPrefix_textBox.setText("ex");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vocabNSPrefix_textBox)
                    .addComponent(vocabNS_textBox, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vocabNS_textBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(vocabNSPrefix_textBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setText("R2RML Namespace Prefix");
        jLabel16.setToolTipText("");

        jLabel17.setText("R2RML Namespace");

        vocabNS_textBox3.setText("http://www.w3.org/ns/r2rml");

        vocabNSPrefix_textBox3.setText("rr");
        vocabNSPrefix_textBox3.setToolTipText("");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16))
                .addGap(28, 28, 28)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vocabNSPrefix_textBox3)
                    .addComponent(vocabNS_textBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vocabNS_textBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(vocabNSPrefix_textBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Namespaces", jPanel10);

        jSplitPane1.setRightComponent(jTabbedPane2);

        jSplitPane2.setLeftComponent(jSplitPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void serialiseMappingButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_serialiseMappingButtonActionPerformed
    {//GEN-HEADEREND:event_serialiseMappingButtonActionPerformed
        controller.SerialiseR2RML( rdf_button.isSelected() ? 1 : 0 );
        saveButton.setEnabled( true );
    }//GEN-LAST:event_serialiseMappingButtonActionPerformed

    private void rdf_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rdf_buttonActionPerformed
    {//GEN-HEADEREND:event_rdf_buttonActionPerformed

    }//GEN-LAST:event_rdf_buttonActionPerformed

    private void turtle_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_turtle_buttonActionPerformed
    {//GEN-HEADEREND:event_turtle_buttonActionPerformed

    }//GEN-LAST:event_turtle_buttonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveButtonActionPerformed
    {//GEN-HEADEREND:event_saveButtonActionPerformed
        if ( jFileChooser1.showSaveDialog( this ) == JFileChooser.APPROVE_OPTION )
        {
            File file = jFileChooser1.getSelectedFile();
            if ( controller.save( file ) )
            {
                JOptionPane.showMessageDialog( null, "File Saved" );
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void extract_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_extract_buttonActionPerformed
    {//GEN-HEADEREND:event_extract_buttonActionPerformed
        controller.extractSchema();
        mapping_treeTable = controller.getTreeTable();
        jScrollPane3.setViewportView( mapping_treeTable );
        turtle_button.setEnabled( true );
        rdf_button.setEnabled( true );
        serialiseOntologyButton.setEnabled( true );
        serialiseMappingButton.setEnabled( true );
    }//GEN-LAST:event_extract_buttonActionPerformed

    private void connect_buttonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_connect_buttonActionPerformed
    {//GEN-HEADEREND:event_connect_buttonActionPerformed

        if ( controller.connect( host_textBox.getText(), username_textBox.getText(), password_textBox.getText(), databaseName_textBox.getText() ) )
        {
            extract_button.setEnabled( true );
            JOptionPane.showMessageDialog(null, "Connection Successful");
        }
    }//GEN-LAST:event_connect_buttonActionPerformed

    private void serialiseOntologyButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_serialiseOntologyButtonActionPerformed
    {//GEN-HEADEREND:event_serialiseOntologyButtonActionPerformed
        try
        {
            controller.serialiseOntology();
        }
        catch ( OWLOntologyCreationException | OWLOntologyStorageException ex )
        {
            Logger.getLogger( MainForm.class.getName() ).log( Level.SEVERE, null, ex );
        }
        saveButton.setEnabled( true );
    }//GEN-LAST:event_serialiseOntologyButtonActionPerformed

    private void host_textBoxMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_host_textBoxMouseEntered
    {//GEN-HEADEREND:event_host_textBoxMouseEntered
        host_textBox.setBackground( new Color( 249, 252, 177 ) );
        host_textBox.setFont( new Font(  host_textBox.getFont().toString(), Font.BOLD, 12 ) );
    }//GEN-LAST:event_host_textBoxMouseEntered

    private void host_textBoxMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_host_textBoxMouseExited
    {//GEN-HEADEREND:event_host_textBoxMouseExited
        host_textBox.setBackground( Color.white );
        host_textBox.setFont( new Font(  host_textBox.getFont().toString(), Font.PLAIN, 12 ) );
    }//GEN-LAST:event_host_textBoxMouseExited

    private void username_textBoxMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_username_textBoxMouseEntered
    {//GEN-HEADEREND:event_username_textBoxMouseEntered
        username_textBox.setBackground( new Color( 249, 252, 177 ) );
        username_textBox.setFont( new Font(  username_textBox.getFont().toString(), Font.BOLD, 12 ) );
    }//GEN-LAST:event_username_textBoxMouseEntered

    private void username_textBoxMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_username_textBoxMouseExited
    {//GEN-HEADEREND:event_username_textBoxMouseExited
        username_textBox.setBackground( Color.white );
        username_textBox.setFont( new Font(  username_textBox.getFont().toString(), Font.PLAIN, 12 ) );
    }//GEN-LAST:event_username_textBoxMouseExited

    private void password_textBoxMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_password_textBoxMouseEntered
    {//GEN-HEADEREND:event_password_textBoxMouseEntered
        password_textBox.setBackground( new Color( 249, 252, 177 ) );
        password_textBox.setFont( new Font(  password_textBox.getFont().toString(), Font.BOLD, 12 ) );
    }//GEN-LAST:event_password_textBoxMouseEntered

    private void password_textBoxMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_password_textBoxMouseExited
    {//GEN-HEADEREND:event_password_textBoxMouseExited
        password_textBox.setBackground( Color.white );
        password_textBox.setFont( new Font(  password_textBox.getFont().toString(), Font.PLAIN, 12 ) );
    }//GEN-LAST:event_password_textBoxMouseExited

    private void databaseName_textBoxMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_databaseName_textBoxMouseEntered
    {//GEN-HEADEREND:event_databaseName_textBoxMouseEntered
        databaseName_textBox.setBackground( new Color( 249, 252, 177 ) );
        databaseName_textBox.setFont( new Font(  databaseName_textBox.getFont().toString(), Font.BOLD, 12 ) );
    }//GEN-LAST:event_databaseName_textBoxMouseEntered

    private void databaseName_textBoxMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_databaseName_textBoxMouseExited
    {//GEN-HEADEREND:event_databaseName_textBoxMouseExited
         databaseName_textBox.setBackground( Color.white );
         databaseName_textBox.setFont( new Font(  databaseName_textBox.getFont().toString(), Font.PLAIN, 12 ) );
    }//GEN-LAST:event_databaseName_textBoxMouseExited

    private void port_textBoxMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_port_textBoxMouseEntered
    {//GEN-HEADEREND:event_port_textBoxMouseEntered
        port_textBox.setBackground( new Color( 249, 252, 177 ) );
        port_textBox.setFont( new Font(  port_textBox.getFont().toString(), Font.BOLD, 12 ) );
    }//GEN-LAST:event_port_textBoxMouseEntered

    private void port_textBoxMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_port_textBoxMouseExited
    {//GEN-HEADEREND:event_port_textBoxMouseExited
        port_textBox.setBackground( Color.white );
        port_textBox.setFont( new Font(  port_textBox.getFont().toString(), Font.PLAIN, 12 ) );
    }//GEN-LAST:event_port_textBoxMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton connect_button;
    private javax.swing.JTextField databaseName_textBox;
    private javax.swing.JButton extract_button;
    private javax.swing.JTextField host_textBox;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea logTextArea;
    private org.jdesktop.swingx.JXTreeTable mapping_treeTable;
    private org.fife.ui.rsyntaxtextarea.RSyntaxTextArea outputTextArea;
    private javax.swing.JTextField password_textBox;
    private javax.swing.JTextField port_textBox;
    private javax.swing.JRadioButton rdf_button;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton serialiseMappingButton;
    private javax.swing.JButton serialiseOntologyButton;
    private javax.swing.JRadioButton turtle_button;
    private javax.swing.JTextField username_textBox;
    private javax.swing.JTextField vocabNSPrefix_textBox;
    private javax.swing.JTextField vocabNSPrefix_textBox2;
    private javax.swing.JTextField vocabNSPrefix_textBox3;
    private javax.swing.JTextField vocabNS_textBox;
    private javax.swing.JTextField vocabNS_textBox2;
    private javax.swing.JTextField vocabNS_textBox3;
    // End of variables declaration//GEN-END:variables
}
