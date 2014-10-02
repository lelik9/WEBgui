package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import util.YAMLConverter;

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
	
	private YAMLConverter yamlConverter = new YAMLConverter();
	private Yaml yaml = new Yaml();
	
	
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
		
		try
		{
			isr = new InputStreamReader(is, "UTF-8");
		} catch (UnsupportedEncodingException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	
public String receiveMessageFromServer() {
		
	    String message;
	    String returnMessage = "{";

		try {
			while(((message = br.readLine()) != null) && !("".equals(message)))
				{
					returnMessage = returnMessage.concat(message + ",");		
				}
		} catch (IOException e) {
			System.out.println("BufferReader is broken!");
			e.printStackTrace();
		}

		return returnMessage + "}";
	}

public Map<Integer, List<String>> getInfo(Map<String, Object> Data) 
{
	Yaml yaml  = new Yaml();
	
	String request = yaml.dump(Data);
	System.out.println("sended " + request);
	sendMessageToServer(request);
	
	Map<Integer, List <String>> data = new HashMap<Integer, List<String>>() ;
	String message = receiveMessageFromServer();
	System.out.println("received " + message);
	data.putAll((Map<Integer, List<String>>) yaml.load(message));			
	
	return data; 
}

}
