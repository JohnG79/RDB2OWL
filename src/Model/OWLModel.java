/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.coode.owlapi.turtle.TurtleOntologyFormat;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.util.AutoIRIMapper;
import org.semanticweb.owlapi.vocab.XSDVocabulary;
import table.ForeignKey;
import table.NonPrime;
import table.Table;

public class OWLModel
{

    private static IRI baseIRI;
    private static IRI iri2;
    private OWLDataFactory dataFactory;
    private OWLOntologyManager owlManager;
    private OWLOntology ontology;

    public OWLModel()
    {

    }

    public void initialiseModel( String baseIRI ) throws OWLOntologyCreationException
    {
        OWLModel.baseIRI = IRI.create( baseIRI );
        dataFactory = OWLManager.getOWLDataFactory();

        owlManager = OWLManager.createOWLOntologyManager();
        owlManager.addIRIMapper( new AutoIRIMapper( new File( "materializedOntologies" ), true ) );

        ontology = owlManager.createOntology( OWLModel.baseIRI );
    }

    public void addClass( String className )
    {
        OWLClass newClass = dataFactory.getOWLClass( IRI.create( baseIRI + "#" + className ) );
        OWLAxiom newAxiom = dataFactory.getOWLDeclarationAxiom( newClass );
        owlManager.addAxiom( ontology, newAxiom );
    }

    public void addObjectProperty( String domainClassName, String propertyName, String rangeClassName )
    {
        //OWLObjectProperty newProperty = dataFactory.getOWLObjectProperty( IRI.create( baseIRI + "#" + propertyName ) );
        //OWLClass existingClass = dataFactory.getOWLClass( IRI.create( baseIRI + "#" + rangeClassName ) );

        //OWLAxiom newAxiom = dataFactory.getOWLObjectPropertyRangeAxiom( newProperty, existingClass );
        //owlManager.addAxiom( ontology, newAxiom );
        OWLClass newRangeClass = dataFactory.getOWLClass( IRI.create( baseIRI + "#" + rangeClassName ) );
        OWLObjectProperty newObjectProperty = dataFactory.getOWLObjectProperty( IRI.create( baseIRI + "#" + propertyName ) );
        Set<OWLObjectPropertyDomainAxiom> allDomainAxioms = ontology.getObjectPropertyDomainAxioms( newObjectProperty );
        OWLClass newDomainClass = dataFactory.getOWLClass( IRI.create( baseIRI + "#" + domainClassName ) );

        Iterator<OWLObjectPropertyDomainAxiom> PropertyDomainAxiom_itr;
        if ( ( PropertyDomainAxiom_itr = allDomainAxioms.iterator() ).hasNext() )
        {
            OWLObjectPropertyDomainAxiom propertyDomainAxiom;
            Set<OWLClass> existingDomainClasses = ( propertyDomainAxiom = PropertyDomainAxiom_itr.next() ).getClassesInSignature();

            owlManager.removeAxiom( ontology, propertyDomainAxiom );
            existingDomainClasses.add( newDomainClass );
            appendToObjectPropertyDomainAxiom( existingDomainClasses, propertyDomainAxiom, newObjectProperty );

            return;
        }

        addObjectPropertyDomainAxiom( newObjectProperty, dataFactory.getOWLClass( IRI.create( baseIRI + "#" + domainClassName ) ) );
        addObjectPropertyRangeAxiom( newObjectProperty, newRangeClass );
    }

    public void addDataProperty( String propertyName, String domainClassName, XSDVocabulary xsdVocabulary )
    {
        OWLDataProperty newDataProperty = dataFactory.getOWLDataProperty( IRI.create( baseIRI + "#" + propertyName ) );
        OWLDatatype newDatatype = dataFactory.getOWLDatatype( xsdVocabulary.getIRI() );

        Set<OWLDataPropertyDomainAxiom> allDomainAxioms = ontology.getDataPropertyDomainAxioms( newDataProperty );
        OWLClass newClass = dataFactory.getOWLClass( IRI.create( baseIRI + "#" + domainClassName ) );

        Iterator<OWLDataPropertyDomainAxiom> PropertyDomainAxiom_itr;
        if ( ( PropertyDomainAxiom_itr = allDomainAxioms.iterator() ).hasNext() )
        {
            OWLDataPropertyDomainAxiom propertyDomainAxiom;
            Set<OWLClass> existingDomainClasses = ( propertyDomainAxiom = PropertyDomainAxiom_itr.next() ).getClassesInSignature();

            owlManager.removeAxiom( ontology, propertyDomainAxiom );
            existingDomainClasses.add( newClass );
            appendToDataPropertyDomainAxiom( existingDomainClasses, propertyDomainAxiom, newDataProperty );

            Set<OWLDataPropertyRangeAxiom> allRangeAxioms = ontology.getDataPropertyRangeAxioms( newDataProperty );
            Iterator<OWLDataPropertyRangeAxiom> PropertyRangeAxiom_itr;
            if ( ( PropertyRangeAxiom_itr = allRangeAxioms.iterator() ).hasNext() )
            {
                OWLDataPropertyRangeAxiom propertyRangeAxiom;
                Set<OWLDatatype> existingDatatypes = ( propertyRangeAxiom = PropertyRangeAxiom_itr.next() ).getDatatypesInSignature();

                existingDatatypes.add( newDatatype );
                appendToDataPropertyRangeAxiom( existingDatatypes, propertyRangeAxiom, newDataProperty );
            }
            return;
        }

        addDataPropertyDomainAxiom( newDataProperty, dataFactory.getOWLClass( IRI.create( baseIRI + "#" + domainClassName ) ) );
        addDataPropertyRangeAxiom( newDataProperty, newDatatype );
    }

    private void addDataPropertyDomainAxiom( OWLDataProperty owlDataProperty, OWLClass owlClass )
    {
        OWLAxiom newAxiom = dataFactory.getOWLDataPropertyDomainAxiom( owlDataProperty, owlClass );
        owlManager.addAxiom( ontology, newAxiom );
    }

    private void addObjectPropertyDomainAxiom( OWLObjectProperty owlObjectProperty, OWLClass owlClass )
    {
        OWLAxiom newAxiom = dataFactory.getOWLObjectPropertyDomainAxiom( owlObjectProperty, owlClass );
        owlManager.addAxiom( ontology, newAxiom );
    }

    private void addDataPropertyRangeAxiom( OWLDataProperty owlDataProperty, OWLDatatype dataType )
    {
        OWLAxiom PropertyRangeAxiom = dataFactory.getOWLDataPropertyRangeAxiom( owlDataProperty, dataType );
        owlManager.addAxiom( ontology, PropertyRangeAxiom );
    }

    private void addObjectPropertyRangeAxiom( OWLObjectProperty owlObjectProperty, OWLClass rangeClass )
    {

        OWLAxiom PropertyRangeAxiom = dataFactory.getOWLObjectPropertyRangeAxiom( owlObjectProperty, rangeClass );
        owlManager.addAxiom( ontology, PropertyRangeAxiom );
    }

    private void appendToDataPropertyDomainAxiom( Set<OWLClass> owlClasses, OWLDataPropertyDomainAxiom existingAxiom, OWLDataProperty owlDataProperty )
    {
        OWLClassExpression oe = dataFactory.getOWLObjectUnionOf( owlClasses );
        owlManager.removeAxiom( ontology, existingAxiom );
        existingAxiom = dataFactory.getOWLDataPropertyDomainAxiom( owlDataProperty, oe );
        owlManager.addAxiom( ontology, existingAxiom );
    }

    private void appendToObjectPropertyDomainAxiom( Set<OWLClass> owlClasses, OWLObjectPropertyDomainAxiom existingAxiom, OWLObjectProperty owlObjectProperty )
    {
        OWLClassExpression oe = dataFactory.getOWLObjectUnionOf( owlClasses );
        owlManager.removeAxiom( ontology, existingAxiom );
        existingAxiom = dataFactory.getOWLObjectPropertyDomainAxiom( owlObjectProperty, oe );
        owlManager.addAxiom( ontology, existingAxiom );
    }

    private void appendToDataPropertyRangeAxiom( Set<OWLDatatype> existingOwlDatatypes, OWLDataPropertyRangeAxiom existingAxiom, OWLDataProperty owlDataProperty )
    {
        OWLDataRange owlDataRange = dataFactory.getOWLDataUnionOf( existingOwlDatatypes );
        owlManager.removeAxiom( ontology, existingAxiom );
        existingAxiom = dataFactory.getOWLDataPropertyRangeAxiom( owlDataProperty, owlDataRange );
        owlManager.addAxiom( ontology, existingAxiom );
    }

    public void serialiseModel( org.fife.ui.rsyntaxtextarea.RSyntaxTextArea syntaxArea ) throws OWLOntologyStorageException
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
        syntaxArea.setText( "" );
        owlManager.saveOntology( ontology, new TurtleOntologyFormat(), o );

    }

    public void print()
    {
        File file = new File( "C:\\Users\\John\\Documents\\NetBeans\\Projects\\Program\\output-files\\output.owl" );
        IRI documentIRI2 = IRI.create( file );
        try
        {
            owlManager.saveOntology( ontology, new TurtleOntologyFormat(), documentIRI2 );
        }
        catch ( OWLOntologyStorageException ex )
        {
            Logger.getLogger( OWLModel.class.getName() ).log( Level.SEVERE, null, ex );
        }
    }

    public void visit( Table table )
    {
        //System.out.println( "ADD CLASS: " + table );
        String className = table.getValueAt( 1 ).toString();
        //System.out.println( "ADD CLASS: " + className );
        addClass( className );
    }

    public void visit( NonPrime nonPrime )
    {
        String domainClassName = nonPrime.getParent().getValueAt( 1 ).toString();
        String propertyName = nonPrime.getValueAt( 1 ).toString();
        String datatypeName = nonPrime.getValueAt( 2 ).toString();
        System.out.println( "ADD DATA_PROPERTY: " + domainClassName + "   " + propertyName + "    " + getVocabulary( datatypeName ) );
        addDataProperty( propertyName, domainClassName, getVocabulary( datatypeName ) );
    }

    public void visit( ForeignKey foreignKey )
    {
        //foreignKey.setValueAt( foreignKey.getReferencedTableName(), 2 );
        String domainClassName = foreignKey.getParent().getValueAt( 1 ).toString();
        String propertyName = foreignKey.getValueAt( 1 ).toString();
        //Node rootNode = ( Node ) foreignKey.getParent().getParent();
        //Enumeration<? extends MutableTreeTableNode> tableNodes = rootNode.children();
        //Node ownerNode = getOwnerTableNode(tableNodes, foreignKey.getReferencedTableName());
        //String rangeClassName = ownerNode.getParent().getValueAt( 1 ).toString();
        String rangeClassName = foreignKey.getValueAt( 2 ).toString();
        System.out.println( "ADD OBJECT_PROPERTY: " + domainClassName + "   " + propertyName + "    " + rangeClassName );
        addObjectProperty( domainClassName, propertyName, rangeClassName );
    }/*
    private Node getOwnerTableNode( Enumeration<? extends MutableTreeTableNode> tableNodes, String referencedTableName )
    {   
        while ( tableNodes.hasMoreElements() )
        {
            Enumeration<? extends MutableTreeTableNode> columnNodes = tableNodes.nextElement().children();
            while( columnNodes.hasMoreElements() )
            {
                Node columnNode = ( Node ) columnNodes.nextElement();
                if(columnNode instanceof PrimaryKey)
                {
                    if(referencedTableName.equals(columnNode.getParent().getValueAt( 0 )) )
                        return columnNode;
                }

            } 
        }        

        return new PrimaryKey( new String[]
        {
            ">>ERROR_IN_getOwnerTableNode()", ">>ERROR_IN_getOwnerTableNode()"
        } );
    }*/

    private XSDVocabulary getVocabulary( String vocabularyName )
    {
        switch ( vocabularyName )
        {
            case "xsd:string":
            {
                return XSDVocabulary.STRING;
            }
            case "xsd:integer":
            {
                return XSDVocabulary.INTEGER;
            }
            case "xsd:decimal":
            {
                return XSDVocabulary.DECIMAL;
            }
            case "xsd:anyURI":
            {
                return XSDVocabulary.ANY_URI;
            }
            default:
            {
                return XSDVocabulary.ANY_TYPE;
            }
        }
    }
}
