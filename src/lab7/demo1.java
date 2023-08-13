package lab7;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class demo1 {
	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostAddress());
			System.out.println(address.getHostName());
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}

	}
}
