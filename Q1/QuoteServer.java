/**
 * Quote server listening to port 6017.
 *
 */
 
import java.net.*;
import java.io.*;

public class QuoteServer
{
  public static void main(String[] args) throws IOException
  {
    String[] quotes = new String[12];
    quotes[0] = "You can't make up anything anymore. The world itself is a satire. All you're doing is recording it.";
    quotes[1] = "If your daily life seems poor, do not blame it; blame yourself, tell yourself that you are not poet enough to call forth its riches.";
    quotes[2] = "When someone wants to lose weight, they will do whatever it takes. They can’t do it for anyone else but themselves. It has to be for them alone. Without that understanding, they will fail.";
    quotes[3] = "Few things are more satisfying than seeing your own children have teenagers of their own.";
    quotes[4] = "I passionately hate the idea of being with it, I think an artist has always to be out of step with his time.";
    quotes[5] = "Worry is a misuse of imagination.";
    quotes[6] = "There is no such thing as an underestimate of average intelligence.";
    quotes[7] = "Few people are capable of expressing with equanimity opinions which differ from the prejudices of their social environment. Most people are even incapable of forming such opinions.";
    quotes[8] = "Nature has invented reproduction as a mechanism for life to move forward. As a life force that passes right through us and makes us a link in the evolution of life.";
    quotes[9] = "It's not foresight or hindsight we need. We need sight, plain and simple. We need to see what is right in front of us.";
    quotes[10] = "It’s the friends you can call up at four a.m. that matter.";
    quotes[11] = "I have a theory that if you give 100% all of the time, somehow things will work out in the end.";
  

    try{
      ServerSocket sock = new ServerSocket(6017);

      // now listen for connections
      while (true) {      
        System.out.println("Listening for connections...");

        Socket client = sock.accept();
        System.out.println("Connection found! Returning quote...");
        PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

        // write the Date to the socket
        pout.println(quotes[(int)(Math.random()*11)]);

        // close the socket and resume
        // listening for connections
        client.close();
      }
    }
    catch (IOException ioe) {
      System.err.println(ioe);
    }
  }
}
