/**
 * Modified DateClient so that it requests a quote
 * from the quote server.
 */
 
import java.net.*;
import java.io.*;

public class QuoteClient
{
	public static void main(String[] args) throws IOException
	{
		try{
		// This client connects to the QuoteServer
		// on port 6017 and prints the quote

		Socket sock = new Socket("localhost", 6017);
		// we use the args[0] to get the IP address of the server which is the first argument when running the program

		InputStream in = sock.getInputStream();
		BufferedReader bin = new BufferedReader(new InputStreamReader(in));

		// read the date from the socket

		String line;
		while ((line = bin.readLine()) != null)
			System.out.println(line);

		// close the socket connection

		sock.close();
		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please enter the IP address of the server followed by the port number as the second argument when running the program");
		}
	}
}

