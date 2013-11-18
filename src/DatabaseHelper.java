import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.derby.iapi.sql.ResultSet;


public class DatabaseHelper 
{
    Connection c = null;
    Statement stmt = null;
    
    public DatabaseHelper()
    {
	    try {
	        Class.forName("org.sqlite.JDBC");
	        
	        c = DriverManager.getConnection("jdbc:sqlite:test.db");
	        c.setAutoCommit(false);
	
	    }catch(Exception e){System.out.println("Something went wrong");}
    }
    
    public void addUser(User u) throws Exception
    {
       stmt = c.createStatement();
       String sql = "INSERT INTO USERS (username, javaBlob) " +
                "VALUES ('"+u.getUsername()+"','"+Serializer.serialize(u)+"')";
       
       stmt.executeUpdate( sql );
       stmt.close();
       c.commit();
    }
    
    public void createDatabase() throws SQLException
    {
        stmt = c.createStatement();
        String sql = "CREATE TABLE USERS " +
                "(ID INTEGER PRIMARY KEY," +
                " username       TEXT, " + 
                " javaBlob       TEXT) ";
        stmt.executeUpdate( sql );
        stmt.close();
        c.commit();
    }
    
    public void dumpDatabase() throws Exception
    {
        stmt = c.createStatement();
        java.sql.ResultSet rs = stmt.executeQuery( "SELECT * FROM USERS;" );
        while ( rs.next() ) {
           String username = rs.getString("username");
           String  blob = rs.getString("javaBlob");
           User u = (User)Serializer.deserialize(blob);
           System.out.println(u.toString());
        }
        stmt.close();
    }
    
    public void close() throws SQLException
    {
        c.close();
    }
    
}
