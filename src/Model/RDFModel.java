package Model;

import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import table.CombinedKey;
import table.ForeignKey;
import table.NonPrime;
import table.PrimaryKey;
import table.Table;

public class RDFModel
{
    private final com.hp.hpl.jena.rdf.model.Model model;
    private final String HASH = "#";
    private String R2RML_NS;
    private String R2RML_NS_P;
    private String VOCAB_NS;
    private String VOCAB_NS_P;
    private String BASE_NS;
    private String BASE_NS_P;
    private Property LOGCIAL_TABLE;
    private Property TABLE_NAME;
    private Property SUBJECT_MAP;
    private Property TEMPLATE;
    private Property CLASS;
    private Property PREDICATEOBJECT_MAP;
    private Property PREDICATE;
    private Property OBJECT_MAP;
    private Property COLUMN;
    private Resource TRIPLES_MAP_current;
    private Resource SUBJECT_MAP_current;
    private Resource PREDICATEOBJECT_MAP_current;
    private Resource OBJECT_MAP_current;
    private int TripleMap_count;
    private String rdfFormat;

    public RDFModel()
    {
        model = ModelFactory.createDefaultModel();
        TripleMap_count = 1;
    }

    public RDFModel( String R2RML_NS, String R2RML_NS_P, String VOCAB_NS, String VOCAB_NS_P, String BASE_NS )
    {
        model = ModelFactory.createDefaultModel();
        TripleMap_count = 1;
        this.R2RML_NS = R2RML_NS;
        this.R2RML_NS_P = R2RML_NS_P;
        this.VOCAB_NS = VOCAB_NS;
        this.VOCAB_NS_P = VOCAB_NS_P;
        this.BASE_NS = BASE_NS;
    }

    public void initialiseModel( String R2RML_NS, String R2RML_NS_P, String VOCAB_NS, String VOCAB_NS_P, String BASE_NS, int outputType )
    {
        this.R2RML_NS = R2RML_NS;
        this.R2RML_NS_P = R2RML_NS_P;
        this.VOCAB_NS = VOCAB_NS;
        this.VOCAB_NS_P = VOCAB_NS_P;
        this.BASE_NS = BASE_NS;

        model.setNsPrefix( this.R2RML_NS_P, this.R2RML_NS );
        model.setNsPrefix( this.VOCAB_NS_P, this.VOCAB_NS );

        LOGCIAL_TABLE = model.createProperty( model.getNsPrefixURI( this.R2RML_NS_P ), "logicalTable" );
        TABLE_NAME = model.createProperty( model.getNsPrefixURI( this.R2RML_NS_P ), "tableName" );
        SUBJECT_MAP = model.createProperty( model.getNsPrefixURI( this.R2RML_NS_P ), "subjectMap" );
        TEMPLATE = model.createProperty( model.getNsPrefixURI( this.R2RML_NS_P ), "template" );
        CLASS = model.createProperty( model.getNsPrefixURI( this.R2RML_NS_P ), "class" );
        PREDICATEOBJECT_MAP = model.createProperty( model.getNsPrefixURI( this.R2RML_NS_P ), "predicateObjectMap" );
        PREDICATE = model.createProperty( model.getNsPrefixURI( this.R2RML_NS_P ), "predicate" );
        OBJECT_MAP = model.createProperty( model.getNsPrefixURI( this.R2RML_NS_P ), "objectMap" );
        COLUMN = model.createProperty( model.getNsPrefixURI( this.R2RML_NS_P ), "column" );

        switch ( outputType )
        {
            case 0:
            {
                rdfFormat = "TTL";
                break;
            }
            default:
                rdfFormat = "RDF/XML-ABBREV";
        }
    }

    public void serialiseModel( org.fife.ui.rsyntaxtextarea.RSyntaxTextArea syntaxArea )
    {

        OutputStream o = new OutputStream()
        {

            @Override
            public void write( int b ) throws IOException
            {
                String s = String.valueOf( ( char ) b );
                syntaxArea.append( s );
            }

        };
        syntaxArea.setText("");
        model.write( o, rdfFormat, "/" );
    }

    public boolean save( File file )
    {
        FileOutputStream fileOutputStream;
        try
        {
            fileOutputStream = new FileOutputStream( file );
            model.write( fileOutputStream, rdfFormat, "/" );
            return true;
        }
        catch ( FileNotFoundException ex )
        {
            Logger.getLogger(RDFModel.class
                    .getName() ).log( Level.SEVERE, null, ex );
        }
        return false;
    }
    /* Double Dispatch */

    public void visit( Table node )
    {
        TRIPLES_MAP_current = model.createResource( HASH + "TriplesMap" + TripleMap_count );
        TripleMap_count++;
        TRIPLES_MAP_current.addProperty( LOGCIAL_TABLE,
                                         model.createResource()
                                         .addProperty( TABLE_NAME, node.getValueAt( 0 ).toString() ) );
        TRIPLES_MAP_current.addProperty( SUBJECT_MAP,
                                         SUBJECT_MAP_current = model.createResource() );
    }

    public void visit( NonPrime node )
    {
        TRIPLES_MAP_current.addProperty( PREDICATEOBJECT_MAP,
                                         PREDICATEOBJECT_MAP_current = model.createResource() );
        PREDICATEOBJECT_MAP_current.addProperty( PREDICATE, model.createResource( model.getNsPrefixURI( VOCAB_NS_P ) + node.getValueAt( 1 ).toString() ) );
        PREDICATEOBJECT_MAP_current.addProperty( OBJECT_MAP, OBJECT_MAP_current = model.createResource() );
        OBJECT_MAP_current.addProperty( COLUMN, node.getValueAt( 0 ).toString() );
    }

    public void visit( PrimaryKey node )
    {
        String className = node.getParent().getValueAt( 1 ).toString();
        SUBJECT_MAP_current.addProperty( TEMPLATE, BASE_NS + "/" + TRIPLES_MAP_current.getProperty( LOGCIAL_TABLE ).getProperty( TABLE_NAME ).getString() + "/{" + node.getValueAt( 0 ).toString() + "}" )
                .addProperty( CLASS, model.createResource( model.getNsPrefixURI( VOCAB_NS_P ) + className ) );
    }

    public void visit( CombinedKey node )
    {
        if ( SUBJECT_MAP_current.getProperty( CLASS ) != null )
        {
            SUBJECT_MAP_current.getProperty( CLASS ).remove();
        }

        String propertyString;
        if ( SUBJECT_MAP_current.getProperty( TEMPLATE ) != null )
        {
            propertyString = SUBJECT_MAP_current.getProperty( TEMPLATE ).getString();
        }
        else
        {
            propertyString = BASE_NS;
        }
        if ( SUBJECT_MAP_current.getProperty( TEMPLATE ) != null )
        {
            SUBJECT_MAP_current.getProperty( TEMPLATE ).remove();
        }
        propertyString = propertyString.concat( "/" + node.getReferencedTableName() + "={" + node.getReferencedColumnName() + "}" );
        SUBJECT_MAP_current.addProperty( TEMPLATE, propertyString );
        visit((ForeignKey)node);
    }

    public void visit( ForeignKey node )
    {
        TRIPLES_MAP_current.addProperty( PREDICATEOBJECT_MAP,
                                         PREDICATEOBJECT_MAP_current = model.createResource() );
        PREDICATEOBJECT_MAP_current.addProperty( PREDICATE, model.createResource( model.getNsPrefixURI( VOCAB_NS_P ) + node.getValueAt( 1 ) ) )
                .addProperty( OBJECT_MAP, OBJECT_MAP_current = model.createResource() );
        OBJECT_MAP_current.addProperty( TEMPLATE, BASE_NS + "/" + node.getReferencedTableName() + "/{" + node.getReferencedColumnName() + "}" );
    }
}
