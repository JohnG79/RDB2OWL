package table;

import Model.OWLModel;
import Model.RDFModel;

public class CombinedKey extends ForeignKey
{

    public CombinedKey( Object[] objects, String referencedTableName, String referencedColumnName )
    {
        super( objects, referencedTableName, referencedColumnName );
    }

    @Override
    public void acceptVisitor( RDFModel model )
    {
        model.visit( this );
    }

    @Override
    public void acceptVisitor( OWLModel model )
    {
        model.visit((ForeignKey)this);
    }
}
