

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient 
{
	public static void main(String[] args) throws IOException 
	{
	    String hostName = "144.126.106.17";
	    int portNumber = 9999;
	
	    try 
	    {
	        Socket hostSocket = new Socket(hostName, portNumber);
	        PrintWriter out = new PrintWriter(hostSocket.getOutputStream(), true);
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(hostSocket.getInputStream()));
	    
	        BufferedReader stdIn =
	            new BufferedReader(new InputStreamReader(System.in));
	        String fromServer;
	        String fromUser;
	
	        while (true) 
	        {
	        	fromServer = in.readLine();

	            System.out.println("Server: "+fromServer);
	            fromUser = stdIn.readLine();
	            if (fromUser != null) {
	                System.out.println("Me: " + fromUser);
	                out.println(fromUser);
	            }
	        }
	        
	    } catch (UnknownHostException e) {
	        System.err.println("Don't know about host " + hostName);
	        System.exit(1);
	    } catch (IOException e) {
	        System.err.println("Couldn't get I/O for the connection to " +
	            hostName);
	        e.printStackTrace();
	        System.exit(1);
	    }
	}
}
