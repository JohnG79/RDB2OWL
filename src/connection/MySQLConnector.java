package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class MySQLConnector
{

    private Connection connection;
    private String host;
    private String db_name;
    private String username;
    private String password;
    private JTextArea logTextArea;
    public MySQLConnector(JTextArea logTextArea)
    {
        this.logTextArea = logTextArea;
        log("LOADING DRIVER DATABASE");
        try
        {
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
            log("loading driver succeeded");
        }
        catch ( ClassNotFoundException | InstantiationException | IllegalAccessException ex )
        {
            log("loading driver failed");
            log( "SQLException: " + ex.getMessage() );
            log( "SQLState: " + ex.getLocalizedMessage() );
        }
    }

    public boolean connect( String host, String username, String password, String db_name )
    {
        this.host = host;
        this.db_name = db_name;
        this.username = username;
        this.password = password;
        log("CONNECTING TO DATABASE");
        try
        {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + this.host + ":" + "3306" + "/" + this.db_name + "?user=" + this.username + "&password=" + this.password
            );
            log("Connection succeeded");
            return true;
        }
        catch ( SQLException ex )
        {
            log("Connection Failed");
            log( "SQLException: " + ex.getMessage());
            log( "SQLState: " + ex.getSQLState());
            log( "VendorError: " + ex.getErrorCode());
            return false;
        }
    }

    public String getCurrentDatabaseName()
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement( "select database()" );
            return getFirstResult( statement.executeQuery() );
        }
        catch ( SQLException ex )
        {
            Logger.getLogger( MySQLConnector.class.getName() ).log( Level.SEVERE, null, ex );
            return new String();
        }
    }

    public ArrayList<String> getTableNames()
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement( "select distinct table_name from information_schema.key_column_usage where table_schema = ?" );
            statement.setString( 1, db_name );
            return parseResultSet( statement.executeQuery() );
        }
        catch ( SQLException ex )
        {
            Logger.getLogger( MySQLConnector.class.getName() ).log( Level.SEVERE, null, ex );
            return new ArrayList<>();
        }
    }

    public ArrayList<String> getPrimaryKeys( String tableName )
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement( "select column_name from information_schema.columns where table_name = ? and column_key = 'PRI' and table_schema = ?" );
            statement.setString( 1, tableName );
            statement.setString( 2, db_name );
            return parseResultSet( statement.executeQuery() );
        }
        catch ( SQLException ex )
        {
            Logger.getLogger( MySQLConnector.class.getName() ).log( Level.SEVERE, null, ex );
            return new ArrayList<>();
        }
    }

    public ArrayList<String> getForeignKeys( String tableName )
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement( "select column_name from information_schema.key_column_usage where table_name = ? and constraint_name != 'PRIMARY' and constraint_name != column_name and table_schema = ?" );
            statement.setString( 1, tableName );
            statement.setString( 2, db_name );
            return parseResultSet( statement.executeQuery() );
        }
        catch ( SQLException ex )
        {
            Logger.getLogger( MySQLConnector.class.getName() ).log( Level.SEVERE, null, ex );
            return new ArrayList<>();
        }
    }

    public ArrayList<String> removeForeignKeys( ArrayList<String> primaryKeys, String tableName )
    {
        ArrayList<String> foreignKeys = getForeignKeys( tableName );
        for ( String foreignKey : foreignKeys )
        {
            if ( primaryKeys.contains( foreignKey ) )
            {
                primaryKeys.remove( foreignKey );
            }
        }
        return primaryKeys;
    }

    public ArrayList<String> getNonKeys( String tableName )
    {
        try
        {
            PreparedStatement statement = connection.prepareStatement( "select column_name from information_schema.columns where table_name = ? and column_key != 'PRI' and column_key != 'MUL' and table_schema = ?"
            );
            statement.setString( 1, tableName );
            statement.setString( 2, db_name );
            return parseResultSet( statement.executeQuery() );
        }
        catch ( SQLException ex )
        {
            Logger.getLogger( MySQLConnector.class.getName() ).log( Level.SEVERE, null, ex );
            return new ArrayList<>();
        }
    }

    private ArrayList<String> parseResultSet( ResultSet resultSet ) throws SQLException
    {
        ArrayList<String> results = new ArrayList<>();
        while ( resultSet.next() )
        {
            results.add( resultSet.getString( 1 ) );
        }
        return results;
    }

    private String getFirstResult( ResultSet resultSet ) throws SQLException
    {
        if ( resultSet.next() )
        {
            return resultSet.getString( 1 );
        }
        return "";
    }

    public HashMap<String, String> getForeignKeys_( String tableName )
    {
        ArrayList<String> foreignKeyNames = getForeignKeys( tableName );
        HashMap<String, String> foreignKeys = new HashMap<>();
        for ( String foreignKeyName : foreignKeyNames )
        {
            try
            {
                PreparedStatement statement = connection.prepareStatement( "select referenced_table_name from information_schema.key_column_usage where table_name = ? and constraint_name != 'PRIMARY' and constraint_name != column_name and column_name = ? and table_schema = ?" );
                statement.setString( 1, tableName );
                statement.setString( 2, foreignKeyName );
                statement.setString( 3, db_name );
                String result = getFirstResult( statement.executeQuery() );
                foreignKeys.put( foreignKeyName, result );
            }
            catch ( SQLException ex )
            {
                Logger.getLogger( MySQLConnector.class.getName() ).log( Level.SEVERE, null, ex );
                return new HashMap<>();
            }
        }
        return foreignKeys;
    }

    public HashMap<String, ArrayList<String>> getForeignKeys__( String tableName )
    {
        ArrayList<String> foreignKeyNames = getForeignKeys( tableName );
        HashMap<String, ArrayList<String>> foreignKeys = new HashMap<>();
        for ( String foreignKeyName : foreignKeyNames )
        {
            try
            {
                PreparedStatement statement = connection.prepareStatement( "select referenced_table_name from information_schema.key_column_usage where table_name = ? and constraint_name != 'PRIMARY' and constraint_name != column_name and column_name = ? and table_schema = ?" );
                statement.setString( 1, tableName );
                statement.setString( 2, foreignKeyName );
                statement.setString( 3, db_name );
                String referencedTableName = getFirstResult( statement.executeQuery() );
                PreparedStatement statement2 = connection.prepareStatement( "select referenced_column_name from information_schema.key_column_usage where table_name = ? and constraint_name != 'PRIMARY' and constraint_name != column_name and column_name = ? and table_schema = ?" );
                statement2.setString( 1, tableName );
                statement2.setString( 2, foreignKeyName );
                statement2.setString( 3, db_name );
                String referencedColumnName = getFirstResult( statement2.executeQuery() );
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add( 0, referencedTableName );
                arrayList.add( 1, referencedColumnName );
                foreignKeys.put( foreignKeyName, arrayList );
            }
            catch ( SQLException ex )
            {
                Logger.getLogger( MySQLConnector.class.getName() ).log( Level.SEVERE, null, ex );
                return new HashMap<>();
            }
        }
        return foreignKeys;
    }
    private void log(String text)
    {
        logTextArea.append( ( new SimpleDateFormat( "yyyy.MM.dd.HH.mm.ss" ).format( new Date() ) ) + "\t" + text + "\n" );
    }
}
