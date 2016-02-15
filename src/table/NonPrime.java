package table;

public class NonPrime extends ChildNode
{

    public NonPrime( Object[] objects )
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
