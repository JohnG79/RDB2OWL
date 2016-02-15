package table;

public abstract class Node extends org.jdesktop.swingx.treetable.AbstractMutableTreeTableNode
{

    public Node( Object[] objects )
    {
        super( objects );
    }

    @Override
    public Object getValueAt( int columnIndex )
    {
        return getUserObject()[ columnIndex ];
    }

    @Override
    public void setValueAt( Object value, int columnIndex )
    {
        getUserObject()[ columnIndex ] = value;
    }

    @Override
    public int getColumnCount()
    {
        return getData().length;
    }

    @Override
    public Object[] getUserObject()
    {
        return ( Object[] ) super.getUserObject();
    }

    @Override
    public boolean isEditable( int column )
    {
        return column != 0;

    }

    public Object[] getData()
    {
        return ( Object[] ) getUserObject();
    }
    

}
