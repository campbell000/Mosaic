import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
    
    
    //Returns false if the user already exists
    public boolean addUser(User u) throws Exception
    {
       stmt = c.createStatement();
       boolean isUnique = true;
       
       //Check if username already exists
       String sql = "SELECT * FROM USERS WHERE username = '"+u.getUsername()+"'";
       ResultSet result = stmt.executeQuery(sql);
       while (result.next())
         isUnique = false;
       
       if (isUnique)
       {
         sql = "INSERT INTO USERS (username, javaBlob) " +
                  "VALUES ('"+u.getUsername()+"','"+Serializer.serialize(u)+"')";
         
         stmt.executeUpdate( sql );
         c.commit();
       }
       stmt.close();
       c.commit();
       return isUnique;
    }
    
    //NOTE: returns null if user doesn't exist.
    public User getUser(String username, String password) throws Exception
    {
      stmt = c.createStatement();
      
      User u = null;
      String sql = "SELECT * FROM USERS WHERE username = '"+username+"'";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next())
      {
        User temp = (User) Serializer.deserialize(rs.getString("javaBlob"));
        if (temp.getPassword().equals(password))
        {
          u = temp;
          u.setIP(InetAddress.getLocalHost().getHostAddress());
          
        }
      }
      
      stmt.close();
      return u;
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
