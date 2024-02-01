package LTM.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Server {
	
	public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            while (true){
                Socket clientSocket = serverSocket.accept();
                Thread t1 = new Thread(
                        ()->{
                            try{
                                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
                                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                                String receive = dis.readUTF();
                                int number = Integer.parseInt(receive);
                                boolean a = findFactors(number);
                                if(a)
                                {
                                	dos.writeUTF("Day la 1 so hoan hao");
                                }
                                else {
                                	dos.writeUTF("day khong phai la so hoan hao");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                );
                t1.start();
            }
}catch(Exception e)
        {
	
        }
}
	private static boolean findFactors(int num) {
		int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if(sum == num)
        {
        	return true;
        }
        else {
        	return false;
        }
    }
}