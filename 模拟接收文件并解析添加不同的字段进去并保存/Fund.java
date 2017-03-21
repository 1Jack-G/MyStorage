package zuoye;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author  Jack
 * @description  1）创建一个Fund类，导入文件格式如下：
 *003003,张三,A0001,10000,1.12
 *003003,李四,A0002,1000,1.12
 *003003,王五,A0003,12000,1.12
 *
 *2）计算基金申购人应该交割的资金
 *3）计算手续费，手续费最低不低于20元，按申购金额1%计算。处理过程要打印到标准输出
 *4）在申购后10天内，申请赎回不交手续费（后悔期）
 *5）把结果存入到文件里面,到出文件格式如下：
 *003003,张三,A0001,10000,1.12,112.00,2016/11/11
 *003003,李四,A0002,1000,1.12,20.00,2016/11/11
 *003003,王五,A0003,12000,1.12,120,2016/11/11
 * 
 */

public class Fund {

	private String fundId; // 基金编号
	private String customer; // 购买者名称
	private String customerNo; // 客户编号
	private int share; // 持有份额
	private double price; // 单价

	java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");

	/**
	 * 无参构造方法,赋初值
	 */
	public Fund() {
		this.fundId = "";
		this.customer = "";
		this.customerNo = "";
		this.share = 0;
		this.price = 0.0;
	}
	//带参构造方法
	public Fund(String fundId, String customer, String customerNo, int share, double price) {
		this.fundId = fundId;
		this.customer = customer;
		this.customerNo = customerNo;
		this.share = share;
		this.price = price;
	}


	public void strProcess() throws Exception {
//		File file = new File("c:\\test.txt");
//		BufferedReader br = new BufferedReader(new FileReader(file));
//		String strLine = null;
//		while ((strLine = br.readLine()) != null) {
//			String[] arr = strLine.split(",");
//			try {
//				Fund f = new Fund(arr[0], arr[1], arr[2], Integer.valueOf(arr[3]), Double.valueOf(arr[4]));
//				f.export();
//			} catch (ArrayIndexOutOfBoundsException e) {
//				System.out.println();
//			}
//		}
//
//		br.close();
		
		FileInputStream fis=new FileInputStream("c:\\test1.txt");
		InputStreamReader reader =new InputStreamReader(fis,"UTF-8");
		
		BufferedReader br=new BufferedReader(reader);
		String line = br.readLine();
		while (line != null) {
			String[] arr=line.split(",");
			Fund f=new Fund(arr[0], arr[1], arr[2], Integer.valueOf(arr[3]), Double.valueOf(arr[4]));
			f.export();
			line = br.readLine();// 读取下一行
		}
		fis.close();
		br.close();
		
	}

	// 计算交割的资金
	public double count() {
		return this.share * this.price;
	}

	// 计算手续费
	public double countPoundage() {
			double poundage = count() * 0.01;
			if ((poundage - 20) < 0.000001) {
//				System.out.println("手续费最低不低于20元。");
				return 20;
			} else {
				return poundage;
			}
	}
	//计算后悔期
	public String countRegretDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar nowTime = Calendar.getInstance();
		nowTime.add(Calendar.DATE, 10);
		return sdf.format(nowTime.getTime());
	}
	//导出文件
	public void export() throws Exception {
		File f = new File("c:\\test2.txt");
		FileInputStream fis=new FileInputStream("c:\\test2.txt");
		InputStreamReader reader = new InputStreamReader(fis,"UTF-8");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));//追加模式

		String str = this.fundId + "," + this.customer + "," + this.customerNo + "," + this.share + "," + this.price
				+ "," + df.format(countPoundage()) + "," + countRegretDate();
		System.out.println(str);
		bw.write(str);
		bw.newLine();
		bw.close();
	}
	
}
