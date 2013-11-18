import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.*;

public class DatabaseTest
{
  public static void main( String args[] ) throws Exception
  {
	  DatabaseHelper dbh = new DatabaseHelper();
	  //dbh.createDatabase();
	  //dbh.addUser(new User("alex", "hunter2", "ascampbell@loyola.edu"));
	  dbh.dumpDatabase();
	  dbh.close();
	  /*
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);


      stmt = c.createStatement();
      
      String sql = "CREATE TABLE USERS " +
              "(ID INTEGER PRIMARY KEY," +
              " username       TEXT, " + 
              " password       TEXT," + 
              " javaBlob       TEXT) ";
      stmt.executeUpdate( sql );
             
      
      sql = "INSERT INTO USERS (username, password, javaBlob) " +
            "VALUES ('"+u.getUsername()+"','"+u.getPassword()+"', '"+Serializer.serialize(u)+"')";
      stmt.executeUpdate( sql );
      
      ResultSet rs = stmt.executeQuery( "SELECT * FROM USERS;" );
      
      while ( rs.next() ) {
         String username = rs.getString("username");
         System.out.println(username);
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      e.printStackTrace();
      System.exit(0);
    }
    System.out.println("Operation done successfully");
    */
  }
}