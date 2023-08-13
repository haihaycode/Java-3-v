package lab7;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {
	public static void main(String[] args) throws IOException {
	 String clientSentence;
     String capitalizedSentence;
     //Tạo sẵn socket ở cổng 6789
     ServerSocket welcomeSocket = new ServerSocket(1234);
     System.out.println("Server is connecting...");
     while (true) {
         //Đợi đến khi có socket từ client truyền đến
         Socket connectionSocket = welcomeSocket.accept();
         System.out.println("Server is connected!");
         //Nhận chuỗi từ Client truyền qua, và in hoa--> chuyển ngược lại cho Client
         //Tạo inputStream đính kèm vào Socket
         BufferedReader inFromClient = new BufferedReader(
                 new InputStreamReader(connectionSocket.getInputStream()));
         clientSentence = inFromClient.readLine();
         capitalizedSentence = clientSentence.toUpperCase() + '\n';
         //truyền chuỗi đã in hoa lại cho Client
         DataOutputStream outToClient = new DataOutputStream(
                 connectionSocket.getOutputStream());

         outToClient.writeBytes(capitalizedSentence);
}
}
}
