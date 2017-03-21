package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Jack
 * @description 创建多线程来实现控制台间的信息发送。先启动服务端（TCPServer）,在到客户端（TCPClient）控制台中去输入内容，
 *              服务端接收内容并给出反馈。
 * @date 2017年1月10日 下午3:37:33
 */
public class TCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9999);// 创建并绑定9999端口

		while (true) {
			Socket s = server.accept(); // 接收客户端连接 网络I/O终端,通信的连接
			System.out.println("a client connect");

			// 创建工作线程
			Worker wk = new Worker();
			wk.setClient(s);

			Thread tw = new Thread(wk);
			tw.start();

		}
	}
}

class Worker implements Runnable {
	Socket client;// 与主线程建立连接

	public void setClient(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			DataInputStream dis = new DataInputStream(client.getInputStream());
			// System.out.println(dis.readUTF());//接受从服务器发送的数据

			DataOutputStream dos = new DataOutputStream(client.getOutputStream());

			while (true) {
				if (client.isClosed()) {
					break;
				}
				String strCliMsg = dis.readUTF();
				System.out.println(strCliMsg);
				dos.writeUTF("亲,服务器已接收到数据"); // 向客户端回消息
				dos.flush();// 强制清空
				System.out.println("已回复客户端消息了哦");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
