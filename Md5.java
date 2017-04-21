/*md 5:Server*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

public class Server {
	
	
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		
		int port=2271;
		ServerSocket serverSocket=new ServerSocket(port);
		System.out.println("Server is Started!!\n");
		//listen multiple connection
		while(true)
		{
			
			Socket socket=serverSocket.accept();
			
			//to read data from socket
			InputStream ipstream=socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(ipstream));
			
			//to write data 
			OutputStream os=socket.getOutputStream();
			PrintWriter writer=new PrintWriter(os,true);
			
			String clientmsg=br.readLine();
			String hash=br.readLine();
			System.out.println("Client ::"+ clientmsg);
			System.out.println("Hash ::"+ hash);
			
			System.out.println("Message Verification Starts ....");
			
			MD md=new MD();
			
			String msg=md.hash(clientmsg);
			if(hash.equals(msg)){
				System.out.println("Message Verified!!");
				writer.println("Message Verified!!");	
			}
			else{
				System.out.println("Message Not Verified!!");
				writer.println("Message Not Verified!!");	
				
			}
			
			
			
			
			
			
		}
		
		
	}

}
===========================
/*md5:Client*/
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class client {

	
	
	public static void main(String[] args)throws Exception {
		
		
		Socket client=new Socket("localhost",2271);
		
		//to read
		InputStream inputStream=client.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
		
		
		//to write
		OutputStream stream=client.getOutputStream();
		PrintWriter writer=new PrintWriter(stream,true);
		
	
		MD md=new MD();
		
		String input=JOptionPane.showInputDialog("Enter Messsage");
		
		String msg=md.hash(input);
		
		writer.println(input);
		writer.println(msg);
		
		System.out.println(br.readLine());
	}
	
}
===================================
/*MD file*/
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD {
	
	
	
	public String hash(String message) throws NoSuchAlgorithmException {
		
		MessageDigest md=MessageDigest.getInstance("MD5");
		String data=message;
		byte[]mdata=data.getBytes();
		md.update(mdata);
		byte[]digest=md.digest();
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
          sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Digest(in hex format):: " + sb.toString());
		return sb.toString();
		
	}

}
==========================================
/*
step to execute
1.run Server program on 1st terminal
gescoe@node13:~/Desktop/src$ javac Server.java 
gescoe@node13:~/Desktop/src$ java Server
2.then open 2nd terminal
gescoe@node13:~/Desktop/src$ javac client.java 
gescoe@node13:~/Desktop/src$ java client
*/

