import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Serializer 
{

	public static String serialize(Object o) throws Exception
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ObjectOutputStream oos = new ObjectOutputStream( baos );
	    oos.writeObject( o );
	    oos.close();
	    
	    return new String( Base64Coder.encode( baos.toByteArray() ) );
	}
	
	public static Object deserialize(String s) throws Exception
	{
        byte [] data = Base64Coder.decode(s);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        Object o  = ois.readObject();
        ois.close();
        return o;
	}
	
}
