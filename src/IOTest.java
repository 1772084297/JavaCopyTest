import java.io.*;
import java.util.Scanner;
//
//ʵ�ֻ����ĸ���ճ�����ܣ�����ʾ��copyʱ��   2018/1/20
//ÿ�ζ�ȡһ���ֽڣ������ٶ�̫��
//���ƣ�ÿ�ζ�ȡһ���ֽ����� byte[1024]��byte[2048]����  2018/1/21
//��ʱ���ϴ���github

public class IOTest {
	public static void main(String[]args) {
	
		//��ʾ
		System.out.println("ʾ����\n"+"file:D:\\demo\\mydemo.jpg\n"+"copyfile:D:\\demo\\newDemo.jpg");
		

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
	
		//Ŀ���ļ������ڣ������ļ�
		if(!file.exists()) {
//			System.out.println("�ļ�������");
			System.exit(1);
		}
		
		//ճ���ļ�Ŀ¼�����ڣ�����Ŀ¼
		if(!copyfile.getParentFile().exists()) {
//			System.out.println("����Ŀ¼");
			copyfile.getParentFile().mkdirs();
		}
		
		try {
			InputStream in = new FileInputStream(file);
			OutputStream out = new FileOutputStream(copyfile);
			byte []data = new byte[1024];  //ÿ�ζ�ȡ1024�ֽ�
			int len =0;                                      //����ÿ�ζ�ȡ�ĸ���
			while((len = in.read(data))!=-1) {         //����ȡ���ַ�������data������
				out.write(data,0,len);
			}
			in.close();
			out.close();
			
			long finishtime = System.currentTimeMillis();
			System.out.println("������ɣ�����ʱ��Ϊ��"+(finishtime-startTime)+"ms");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
