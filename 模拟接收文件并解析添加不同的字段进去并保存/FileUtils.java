package zuoye;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Jack
 * @description 封装一个从文本文件读取内容的方法
 * @date 2017年1月4日 下午2:17:37
 */
public class FileUtils {
	
	//把文本中的内容读出来放入流中
	public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
		InputStream is = new FileInputStream(filePath);
		String line;// 声明一个字符创用来保存每行读取的内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		// 进行读取
		line = reader.readLine();
		// 判断内容不为空
		while (line != null) {
			buffer.append(line).append("\n");// 读完一行就换行
			line = reader.readLine();// 读取下一行
		}
		reader.close();
		is.close();
	}

	//读取存放在流中的
	public static String readerFile(String filePath) throws IOException {
		StringBuffer sb = new StringBuffer();
		FileUtils.readToBuffer(sb, filePath);
		return sb.toString();
	}
}
