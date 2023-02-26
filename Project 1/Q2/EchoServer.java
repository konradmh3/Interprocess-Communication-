/**
 * An echo server listening on port 6007. This server reads from the client
 * and echoes back the result. 
 */
import java.net.*;
import java.io.*;

public class EchoServer
{
    public static void main(String[] args)
    //Exception handling
    throws IOException 
    { 
        //Open socket
        ServerSocket server = new ServerSocket(6017);
        while (true) 
        { 
            Socket cli = server.accept();
            //Read input
            BufferedReader read = new BufferedReader(new InputStreamReader(cli.getInputStream()));
            //Return output stream
            PrintWriter write = new PrintWriter(cli.getOutputStream(), true);
            //Display text
            write.println("Echo program: Whatever you type will echo back. Enter exit when finished.");
            String li;
            do 
            { 
                li = read.readLine();
                System.out.println(li);
                if ( li != null ) write.println(li);
            } 
            //Continue while the text does not contain 'exit'
            while ( !li.trim().equalsIgnoreCase("exit") );
            //Close socket
            cli.close();
        } 
    } 
}
