package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Jack
 * @description TODO
 * @date 2017年1月10日 下午3:44:40
 */
public class TCPClient1 {
	public static void main(String[] args) throws Exception {
		Socket client = new Socket("192.168.10.167", 9999);

		OutputStream out = client.getOutputStream();
		DataOutputStream dataout = new DataOutputStream(out);
		DataInputStream dis = new DataInputStream(client.getInputStream());
		Thread.sleep(1000);

		// 发送数据
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("请输入内容");
			
			String str = in.nextLine();
			if (str.equals("exit")) {
				System.out.println("退出程序");
				break;
			} else {
				dataout.writeUTF(str); // 向服务端发消息
				dataout.flush();

				// DataInputStream dis = new
				// DataInputStream(client.getInputStream());// 接受数据
				System.out.println(dis.readUTF());

				// dis.close();
				// dataout.close();
			}
		}
		client.close();
	}
}
