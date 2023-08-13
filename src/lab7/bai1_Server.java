package lab7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class bai1_Server {
	public static void main(String[] args) {
		try {
			ServerSocket socketServer = new ServerSocket(1907);
			System.out.println("Đang đợi máy khách kết nối");
			Socket socket = socketServer.accept(); 
			
			DataInputStream Dis= new DataInputStream(socket.getInputStream()); //nhận data từ client
			DataOutputStream Dos= new DataOutputStream(socket.getOutputStream());//Trả data cho client 
			while(true) {
				//nhận từ client
				double a = Dis.readDouble();
				double b = Dis.readDouble();
				System.out.println("Server nhận 2 số"+a+","+b);
				//chuyển về client
				Dos.writeDouble(a+b);
				Dos.flush();
				
				
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
