package lab7;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class demo2 {
	public static void main(String[] args) {
		InetAddress[] address;
		try {
			address = InetAddress.getAllByName("lms.poly.edu.vn");
			for (InetAddress inetAddress : address) {
				System.out.println(inetAddress);
			}
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}
	}
}
