package com.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

	private static final int TIMEOUT=5000;
	private static final int MAXNUM=5;
	
	
	
	
	/**
	 * @param args
	 * @throws java.io.IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		
		
		
		
		String str_send="Hello UDPserver";
		
		byte[] buf=new byte[1024];
		
		DatagramSocket ds=new DatagramSocket(9000);
		
		InetAddress loc=InetAddress.getLocalHost();
		
		
		DatagramPacket dp_send=new DatagramPacket(str_send.getBytes(),
			str_send.length(),loc,3000	);
		
		DatagramPacket dp_receive=new DatagramPacket(buf,1024);
		
		
		ds.setSoTimeout(TIMEOUT);
		int tries=0;
		
		boolean receivedResponse=false;
		
		while(!receivedResponse&&tries<MAXNUM){
			ds.send(dp_send);
			
			
			try {
				ds.receive(dp_receive);
				
				if(!dp_receive.getAddress().equals(loc)){
					 throw new IOException("Received packet from an umknown source");
				}
				receivedResponse=true;
			} catch (Exception e) {
				 tries += 1;  
	                System.out.println("Time out," + (MAXNUM - tries) + " more tries..." ); 
			}
		}
		
		if(receivedResponse){
			  //如果收到数据，则打印出来  
            System.out.println("client received data from server：");  
            String str_receive = new String(dp_receive.getData(),0,dp_receive.getLength()) +   
                    " from " + dp_receive.getAddress().getHostAddress() + ":" + dp_receive.getPort();  
            System.out.println(str_receive);  
            //由于dp_receive在接收了数据之后，其内部消息长度值会变为实际接收的消息的字节数，  
            //所以这里要将dp_receive的内部消息长度重新置为1024  
            dp_receive.setLength(1024);  
		}else{
			  System.out.println("No response -- give up."); 
		}
		ds.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
