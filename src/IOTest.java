import java.io.*;
import java.util.Scanner;
//
//实现基础的复制粘贴功能，并显示出copy时间   2018/1/20
//每次读取一个字节，拷贝速度太慢
//改善：每次读取一个字节数组 byte[1024]或byte[2048]即可  2018/1/21
//有时间上传到github

public class IOTest {
	public static void main(String[]args) {
	
		//提示
		System.out.println("示例：\n"+"file:D:\\demo\\mydemo.jpg\n"+"copyfile:D:\\demo\\newDemo.jpg");
		

		System.out.println("\ncopy");
		Scanner input = new Scanner(System.in);
		System.out.print("file: ");
		String filename = input.nextLine().trim();
		System.out.print("copyfile: ");
		String copyfilename = input.nextLine().trim();
		
		long startTime  = System.currentTimeMillis();
//		String filename = "D:"+File.separator+"demo"+File.separator+"mydemo.jpg",
//				copyfilename = "D:"+File.separator+"demo"+File.separator+"newDemo.jpg";
		

		File file = new File(filename);
		File copyfile = new File(copyfilename);
	
		//目标文件不存在，创建文件
		if(!file.exists()) {
//			System.out.println("文件不存在");
			System.exit(1);
		}
		
		//粘贴文件目录不存在，创建目录
		if(!copyfile.getParentFile().exists()) {
//			System.out.println("创建目录");
			copyfile.getParentFile().mkdirs();
		}
		
		try {
			InputStream in = new FileInputStream(file);
			OutputStream out = new FileOutputStream(copyfile);
			byte []data = new byte[1024];  //每次读取1024字节
			int len =0;                                      //保存每次读取的个数
			while((len = in.read(data))!=-1) {         //将读取的字符保存在data数组中
				out.write(data,0,len);
			}
			in.close();
			out.close();
			
			long finishtime = System.currentTimeMillis();
			System.out.println("拷贝完成，拷贝时间为："+(finishtime-startTime)+"ms");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
