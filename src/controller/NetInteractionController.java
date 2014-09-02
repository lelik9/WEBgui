package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetInteractionController
{
	private int serverPort = 9123;
	private String serverHost = "localhost";
	
	private InputStream is;
	private InputStreamReader isr;
	private BufferedReader br;
    
	private PrintWriter printWriter;
	
	private static final String ECHO_MESSAGE = "echo";
	private static final String ECHO_OUTPUT = "ohce";
	
	private Socket socket;
	
	public NetInteractionController() {
		
		establishConnection();
	}
	
	private void establishConnection(){
		try {
			InetAddress address = InetAddress.getByName(this.serverHost);
			
			socket = new Socket(address, serverPort);
		} catch (UnknownHostException e) {
		    // FIXME add logging
			e.printStackTrace();
		} catch (IOException e) {
			// FIXME add logging
			e.printStackTrace();
		}
		
		try {
			is = socket.getInputStream();
		} catch (IOException e) {
			System.out.println("Socket in is broken!");
			e.printStackTrace();
		}
		
		isr = new InputStreamReader(is);
	    br = new BufferedReader(isr);
	    	
		try {
			printWriter = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			System.out.println("Socket out is broken!");
		}
	}
	
	public void sendMessageToServer(String message) {
		
		printWriter.println(message);
	}
			
	public int getServerPort() {
		return serverPort;
	}

	public String getServerHost() {
		return serverHost;
	}
}
