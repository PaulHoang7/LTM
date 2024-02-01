package LTM.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
public class Client {
	public static void main(String args[]) throws Exception, IOException
	{
		Socket soc;
		soc = new Socket("localhost",5555);
		DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
		DataInputStream dis = new DataInputStream(soc.getInputStream());
		dos.writeUTF("10");
		String receive = dis.readUTF();
		System.out.println(receive);
	}
	
}