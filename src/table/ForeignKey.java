package table;

import Model.OWLModel;
import Model.RDFModel;

public class ForeignKey extends ChildNode
{

    protected String referencedTableName;
    protected String referencedColumnName;

    public ForeignKey( Object[] objects, String referencedTableName, String referencedColumnName )
    {
        super( objects );
        this.referencedTableName = referencedTableName;
        this.referencedColumnName = referencedColumnName;
    }

    public String getReferencedTableName()
    {
        return referencedTableName;
    }
    public String getReferencedColumnName()
    {
        return referencedColumnName;
    }

    @Override
    public void acceptVisitor( RDFModel model )
    {
        model.visit( this );
    }

    @Override
    public void acceptVisitor( OWLModel model )
    {
        model.visit( this );
    }



}
