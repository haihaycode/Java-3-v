package lab7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class bai1_Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Máy Khách đang kết nối");
			Socket socket = new Socket("localhost", 1907);
			System.out.println("Máy Khách đã kết nối");
			DataOutputStream Dos = new DataOutputStream(socket.getOutputStream()); // Đẩy data đến Server
			DataInputStream Dis = new DataInputStream(socket.getInputStream());
			while (true) {
				System.out.println("nhập a :");
				Dos.writeDouble(sc.nextByte());// đẩy đi
				Dos.flush();
				System.out.println("nhập b :");
				Dos.writeDouble(sc.nextByte());// đẩy đi
				Dos.flush();

				System.out.println(Dis.readDouble());
				

				

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
