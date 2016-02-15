package table;

import Model.OWLModel;
import Model.RDFModel;

public class PrimaryKey extends ChildNode
{

    public PrimaryKey( Object[] objects )
    {
        super( objects );
    }

    @Override
    public void acceptVisitor( RDFModel model )
    {
        model.visit( this );
    }

    @Override
    public void acceptVisitor( OWLModel model )
    {

    }

}
