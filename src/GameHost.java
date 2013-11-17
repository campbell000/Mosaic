

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class GameHost 
{
	static int [][] gameData = new int [8][8];
	static final int PORT = 9999;
	
	public static void main(String [] args)
	{
        try 
        {
            ServerSocket hostSocket = new ServerSocket(PORT);
            Socket clientSocket = hostSocket.accept();
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        	
            out.println("say something");
            //Main Server Loop
            while (true) 
            {

                String clientMessage = in.readLine();
                int col = Character.getNumericValue(clientMessage.charAt(0));
                int row = Character.getNumericValue(clientMessage.charAt(2));
                gameData[row][col] = 1;
                
                String s = "";
                for(int i=0; i<8; i++){
                    for(int j=0; j<8; j++){
                        s += (String.format("%1s", gameData[i][j]));
                    }
                }
                out.println(s);
            }
        }catch(Exception e){System.out.println("NOPE"); e.printStackTrace();} 
	}
}
