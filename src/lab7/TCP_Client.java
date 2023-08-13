package lab7;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCP_Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String sentence;
        String modifiedSentence;

        BufferedReader inFromUser
                = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 1234);
        System.out.println("Client is connecting..");
        
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("Nhap chuoi ky tu: ");
        sentence = inFromUser.readLine();

        outToServer.writeBytes(sentence + '\n');

        modifiedSentence = inFromServer.readLine();

        System.out.println("FROM SERVER: " + modifiedSentence);

        clientSocket.close();
	}
	
}
