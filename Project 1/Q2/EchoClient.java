/**
 * An echo client. The client enters data to the server, and the
 * server echoes the data back to the client.
 */
import java.net.*;
import java.io.*;

public class  EchoClient
{
    public static void main(String[] args)
    { 
        try 
        {
            //Open socket
            Socket server = new Socket("localhost", 6017);
            //Read input
            BufferedReader read = new BufferedReader(new InputStreamReader(server.getInputStream()));
            //Return output stream
            PrintWriter write = new PrintWriter(server.getOutputStream(), true);
            BufferedReader cont = new BufferedReader(new InputStreamReader(System.in));
            String li;
            do 
            { 
                li = read.readLine();
                if ( li != null ) System.out.println(li);
                li = cont.readLine();
                write.println(li);
            } 
            //Continue while text does not contain 'exit'
            while ( !li.trim().equalsIgnoreCase(("exit")));
        } 
        //Exception handling
        catch (Exception f) 
        {
            System.out.println(f);
        }
    }
}