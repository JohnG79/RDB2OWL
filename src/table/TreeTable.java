package table;

import java.util.Arrays;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.treetable.DefaultTreeTableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import org.jdesktop.swingx.decorator.HighlightPredicate;
import org.jdesktop.swingx.decorator.ColorHighlighter;
import org.jdesktop.swingx.decorator.ComponentAdapter;

public class TreeTable
{

    private final String[] columnHeadings =
    {
        "Database Terms", "Ontology Terms", "Ontology Range"
    };
    private Node rootNode;
    private Node currentChildNode;
    private DefaultTreeTableModel tableModel;
    private JXTreeTable treeTable;

    public TreeTable()
    {
        this.rootNode = new RootNode( "root" );
    }

    // TEST
    public void addRoot( String string )
    {
        this.rootNode = new RootNode( string );
    }

    public Node getRootNode()
    {
        return rootNode;
    }
    //private int currentTableNumber = 1;
    //HashMap<Integer, Integer> tableAndColumnCount = new HashMap<>();
    private int rowCount = 1;
    ArrayList<Integer> tableRows = new ArrayList<>();
    ArrayList<Integer> foreignKeyRows = new ArrayList<>();


    public void addTable( String tableName )
    {
        objectComboBox.addItem( tableName.substring( 0, 1 ).toUpperCase() + tableName.substring( 1 ) );
        Node newNode = new Table( new String[]
        {
            tableName, tableName.substring( 0, 1 ).toUpperCase() + tableName.substring( 1 )
        } );
        this.rootNode.add( newNode );
        currentChildNode = newNode;
        tableRows.add( rowCount );
        rowCount++;
        //tableAndColumnCount.put( currentTableNumber, 0 );
        //currentTableNumber++;
    }

    public void addNonKey( String string )
    {
        Node newNode = new NonPrime( new String[]
        {
            string, string, ""
        } );
        currentChildNode.add( newNode );
        newNode.setValueAt( "xsd:string", 2 );

        rowCount++;
        //tableAndColumnCount.put( currentTableNumber, tableAndColumnCount.get( currentTableNumber ) + 1 );
    }

    public void addPrimaryKey( String string )
    {
        Node newNode = new PrimaryKey( new String[]
        {
            string, string
        } );
        currentChildNode.add( newNode );

        rowCount++;
        //tableAndColumnCount.put( currentTableNumber, tableAndColumnCount.get( currentTableNumber ) + 1 );
    }
    JComboBox objectComboBox = new JComboBox();

    public JXTreeTable getTreeTable()
    {
        this.tableModel = new DefaultTreeTableModel( rootNode, Arrays.asList( columnHeadings ) );
        
        this.treeTable = new JXTreeTable( tableModel )
        {



            @Override
            public void setFont( Font font )
            {
                super.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
            }
            @Override
            public TableCellEditor getCellEditor( int row, int column )
            {
                DefaultCellEditor editor;
                if ( column < 2 )
                {
                    JTextField textField = new JTextField();
                    editor = new DefaultCellEditor( textField );
                    editor.setClickCountToStart( 1 );
                    if ( tableRows.contains( row ) )
                    {
                        editor.addCellEditorListener( new CellEditorListener()
                        {
                            @Override
                            public void editingStopped( ChangeEvent e )
                            {
                                String oldText = objectComboBox.getItemAt( row - 1).toString();
                                String newText = editor.getCellEditorValue().toString();
                                objectComboBox.removeItemAt( row - 1 );
                                objectComboBox.insertItemAt( newText, row - 1 );

                                for ( Integer foreignKeyRow : foreignKeyRows )
                                {
                                    if ( treeTable.getValueAt( foreignKeyRow, 2 ).toString().equals( oldText ) )
                                    {
                                        treeTable.setValueAt( newText, foreignKeyRow, 2 );
                                    }
                                }
                            }

                            @Override
                            public void editingCanceled( ChangeEvent e )
                            {
                            }
                        } );
                    }
                    else if(foreignKeyRows.contains( row ))
                    {
                         editor.addCellEditorListener( new CellEditorListener()
                        {
                            private final String oldText = treeTable.getValueAt( row, 1 ).toString();
                            @Override
                            public void editingStopped( ChangeEvent e )
                            {

                                String newText = editor.getCellEditorValue().toString();

                                for ( Integer foreignKeyRow : foreignKeyRows )
                                {
                                    if ( treeTable.getValueAt( foreignKeyRow, 1 ).toString().equals( oldText ) )
                                    {
                                        treeTable.setValueAt( newText, foreignKeyRow, 1 );
                                    }
                                }

                            }

                            @Override
                            public void editingCanceled( ChangeEvent e )
                            {
                            }
                        } );                       
                    }
                        
                }
                else if ( foreignKeyRows.contains( row ) )
                {
                    System.out.println( "getCellEditor() called [objectComboBox]" );
                    editor = new DefaultCellEditor( objectComboBox );
                }
                else
                {
                    JComboBox comboBox = new JComboBox();
                    comboBox.addItem( "" );
                    comboBox.addItem( "xsd:anyURI" );
                    comboBox.addItem( "xsd:decimal" );
                    comboBox.addItem( "xsd:integer" );
                    comboBox.addItem( "xsd:string" );
                    editor = new DefaultCellEditor( comboBox );
                }
                return editor;
            }
        };

        class ReadOnlyHighlighter extends ColorHighlighter
        {

            private ReadOnlyHighlighter( HighlightPredicate highlightPredicate )
            {
                super( highlightPredicate );
            }

            @Override
            protected Component doHighlight( Component component, ComponentAdapter componentAdapter )
            {
                if ( !( new Color( 205, 205, 205 ) ).equals( component.getBackground() ) )
                {
                    component.setBackground( new Color( 205, 205, 205 ) );
                    //Font font = new Font( component.getFont().toString(), Font.BOLD, 12 );
                    //component.setFont( font );
                }
                return component;
            }
        }

        class ColumnHighlighter extends ColorHighlighter
        {

            private ColumnHighlighter( HighlightPredicate highlightPredicate )
            {
                super( highlightPredicate );
            }

            @Override
            protected Component doHighlight( Component component, ComponentAdapter componentAdapter )
            {
                if ( !( new Color( 205, 205, 205 ) ).equals( component.getBackground() ) )
                {
                    component.setBackground( ( new Color( 249, 252, 177 ) ) );
                    //Font font = new Font( component.getFont().toString(), Font.BOLD, 12 );
                    //component.setFont( font );
                }
                return component;
            }
        }
        class FolderHighlighter extends ColorHighlighter
        {

            private FolderHighlighter( HighlightPredicate highlightPredicate )
            {
                super( highlightPredicate );
            }

            @Override
            protected Component doHighlight( Component component, ComponentAdapter componentAdapter )
            {

                component.setBackground( new Color( 235, 235, 235 ) );

                return component;
            }
        }
        FolderHighlighter c3 = new FolderHighlighter( HighlightPredicate.IS_FOLDER );
        ReadOnlyHighlighter c1 = new ReadOnlyHighlighter( HighlightPredicate.READ_ONLY );
        ColumnHighlighter c2 = new ColumnHighlighter( HighlightPredicate.ROLLOVER_CELL );

        this.treeTable.setHighlighters( c3, c2, c1 );

        this.treeTable.setShowGrid(
                true, true );

        this.treeTable.setColumnControlVisible(
                true );

        this.treeTable.setRootVisible(
                true );

        this.treeTable.expandAll();
        this.treeTable.setSelectionBackground( Color.white );
        this.treeTable.setRowHeight( 25 );
        

        this.treeTable.getColumn( 1 ).setCellRenderer(
                new DefaultTableCellRenderer()
                {
                    @Override
                    public Component getTableCellRendererComponent( JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column )
                    {
                        DefaultTableCellRenderer renderer = ( DefaultTableCellRenderer ) super.getTableCellRendererComponent( table, value, isSelected, hasFocus, row, column );

                        renderer.setForeground( Color.black );

                        return this;
                    }
                }
        );
        this.treeTable.getColumn( 2 ).setCellRenderer(
                new DefaultTableCellRenderer()
                {
                    @Override
                    public Component getTableCellRendererComponent( JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column )
                    {
                        DefaultTableCellRenderer renderer = ( DefaultTableCellRenderer ) super.getTableCellRendererComponent( table, value, isSelected, hasFocus, row, column );

                        renderer.setForeground( Color.black );

                        return this;
                    }
                }
        );
        return this.treeTable;
    }



    public void addCombinedKey( String combinedKeyName, String referencedTableName, String referencedColumnName )
    {
        Node newNode = new CombinedKey( new String[]
        {
            combinedKeyName, combinedKeyName, ""
        }, referencedTableName, referencedColumnName );
        currentChildNode.add( newNode );
        newNode.setValueAt( referencedTableName.substring( 0, 1 ).toUpperCase() + referencedTableName.substring( 1 ), 2 );
        foreignKeyRows.add( rowCount );
        rowCount++;
        //tableAndColumnCount.put( currentTableNumber, tableAndColumnCount.get( currentTableNumber ) + 1 );
    }

    public void addForeignKey( String foreignKeyName, String referencedTableName, String referencedColumnName )
    {
        Node newNode = new ForeignKey( new Object[]
        {
            foreignKeyName, foreignKeyName, ""
        }, referencedTableName, referencedColumnName );
        currentChildNode.add( newNode );
        newNode.setValueAt( referencedTableName.substring( 0, 1 ).toUpperCase() + referencedTableName.substring( 1 ), 2 );
        foreignKeyRows.add( rowCount );
        rowCount++;
        //tableAndColumnCount.put( currentTableNumber, tableAndColumnCount.get( currentTableNumber ) + 1 );
    }
}
