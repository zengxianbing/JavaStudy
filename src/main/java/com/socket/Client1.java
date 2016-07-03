package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {

	/**
	 * @param args
	 * @throws java.io.IOException
	 * @throws java.net.UnknownHostException
	 */
	public static void main(String[] args) throws UnknownHostException,
			IOException {
		// TODO Auto-generated method stub

		Socket client = new Socket("127.0.0.1", 20006);
		client.setSoTimeout(10000);

		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));

		PrintStream out = new PrintStream(client.getOutputStream());

		BufferedReader buf = new BufferedReader(new InputStreamReader(
				client.getInputStream()));
		StringBuffer buf1=new StringBuffer();
		boolean flag = true;
		while (flag) {
			System.out.println("输入信息：");
			String str = input.readLine();
			out.println(str);
			if ("bye".equals(str)) {
				flag = false;
			} else {

				try {
					String echo = buf.readLine();
					System.out.println(echo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		
		
		input.close();
		if (client != null) {
			client.close();
		}

	}

}
