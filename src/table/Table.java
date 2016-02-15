package table;

public class Table extends ChildNode
{

    public Table( Object[] objects )
    {
        super( objects );
    }

    @Override
    public void acceptVisitor( Model.RDFModel model )
    {
        model.visit( this );
    }

    @Override
    public void acceptVisitor( Model.OWLModel model )
    {
        model.visit( this );
    }



}
