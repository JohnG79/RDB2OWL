package controller;

import connection.MySQLConnector;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.jdesktop.swingx.JXTreeTable;
import org.jdesktop.swingx.treetable.MutableTreeTableNode;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import table.ChildNode;
import table.Node;
import table.TreeTable;

public class Controller
{

    private final MySQLConnector connector;
    private final TreeTable treeTable;
    private final Model.RDFModel rdfModel;
    private final Model.OWLModel owlModel;
    private final RSyntaxTextArea outputTextArea;
    private final JTextArea logTextArea;

    public Controller( RSyntaxTextArea outputTextArea, JTextArea logTextArea ) throws OWLOntologyCreationException
    {
        this.connector = new MySQLConnector( logTextArea );
        this.treeTable = new TreeTable();
        this.rdfModel = new Model.RDFModel();
        this.outputTextArea = outputTextArea;
        this.logTextArea = logTextArea;
        this.owlModel = new Model.OWLModel();
    }

    public boolean connect( String host, String user_name, String password, String db_name )
    {
        return connector.connect( host, user_name, password, db_name );
    }

    public void extractSchema()
    {
        log( "BUILDING PRELIMINARY MODEL" );
        treeTable.addRoot( connector.getCurrentDatabaseName() );
        log( "add root" );
        ArrayList<String> tableNames = connector.getTableNames();
        for ( String tableName : tableNames )
        {
            treeTable.addTable( tableName );
            log( "add table: " + tableName );
            ArrayList<String> primaryKeys = connector.getPrimaryKeys( tableName );
            ArrayList<String> nonKeys = connector.getNonKeys( tableName );

            HashMap<String, ArrayList<String>> foreignKeys__ = connector.getForeignKeys__( tableName );
            HashMap<String, ArrayList<String>> combinedKeys__ = new HashMap<>();

            for ( String primaryKeyName : primaryKeys )
            {
                if ( !foreignKeys__.keySet().contains( primaryKeyName ) )
                {
                    treeTable.addPrimaryKey( primaryKeyName );
                    log( "add primary key: " + primaryKeyName );
                }
                else
                {
                    combinedKeys__.put( primaryKeyName, foreignKeys__.get( primaryKeyName ) );
                    foreignKeys__.remove( primaryKeyName );
                }
            }
            for ( String foreignKeyName : foreignKeys__.keySet() )
            {
                treeTable.addForeignKey( foreignKeyName, foreignKeys__.get( foreignKeyName ).get( 0 ), foreignKeys__.get( foreignKeyName ).get( 1 ) );
                log( "add foreign key: " + foreignKeyName );
            }
            for ( String combinedKeyName : combinedKeys__.keySet() )
            {
                treeTable.addCombinedKey( combinedKeyName, combinedKeys__.get( combinedKeyName ).get( 0 ), combinedKeys__.get( combinedKeyName ).get( 1 ) );
                log( "add combined key: " + combinedKeyName );
            }
            for ( String nonPrime : nonKeys )
            {
                treeTable.addNonKey( nonPrime );
                log( "add non prime: " + nonPrime );
            }
        }
    }

    public JXTreeTable getTreeTable()
    {
        return treeTable.getTreeTable();
    }

    public void SerialiseR2RML( int isRDF )
    {
        log( "SERIALISING R2RML MAP" );
        rdfModel.initialiseModel( "http://www.w3.org/ns/r2rml", "rr", "http://example.com/ns", "ex", "http://www.base.com", isRDF );
        sendRDFModelToNodes( treeTable.getRootNode() );
        rdfModel.serialiseModel( outputTextArea );
    }

    private void sendRDFModelToNodes( Node currentNode )
    {
        Enumeration<? extends MutableTreeTableNode> children = currentNode.children();
        while ( children.hasMoreElements() )
        {
            ChildNode node = ( ChildNode ) children.nextElement();
            node.acceptVisitor( rdfModel );
            log( "old value         = " + node.getValueAt( 0 ) );
            log( "      new value  = " + node.getValueAt( 1 ) );
            sendRDFModelToNodes( node );
        }
    }

    private void sendOWLModelToNodes( Node currentNode )
    {
        Enumeration<? extends MutableTreeTableNode> children = currentNode.children();
        while ( children.hasMoreElements() )
        {
            ChildNode node = ( ChildNode ) children.nextElement();
            node.acceptVisitor( owlModel );
            log( "old value         = " + node.getValueAt( 0 ) );
            log( "      new value  = " + node.getValueAt( 1 ) );
            sendOWLModelToNodes( node );
        }
    }

    public boolean save( File file )
    {
        BufferedWriter fileOut;
        try
        {
            fileOut = new BufferedWriter( new FileWriter( file ) );
            outputTextArea.write( fileOut );
            return true;
        }
        catch ( IOException ex )
        {
            Logger.getLogger( Controller.class.getName() ).log( Level.SEVERE, null, ex );
        }
        return false;

    }

    private void log( String text )
    {
        logTextArea.append( ( new SimpleDateFormat( "yyyy.MM.dd.HH.mm.ss" ).format( new Date() ) ) + "\t" + text + "\n" );
    }

    public void serialiseOntology() throws OWLOntologyCreationException, OWLOntologyStorageException
    {
        log( "SERIALISING ONTOLOGY" );
        owlModel.initialiseModel( "http://www.university.com" );
        sendOWLModelToNodes( treeTable.getRootNode() );
        owlModel.serialiseModel( outputTextArea );
    }
}
