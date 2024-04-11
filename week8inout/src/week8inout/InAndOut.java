package week8inout;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;

class Student implements Serializable{
	private String name;
	private int age;
	private int grade;
	public Student(String name, int age, int grade) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade + "]";
	}
	
}

public class InAndOut {
	public static void main(String[] args) {
		System.out.println("hello");
//		byte[] buffer =new byte[1024];
//		try {
//			int len = System.in.read(buffer);
//			String s=new String(buffer,0,len);
//			System.out.println("读到了"+len+"字节");
//			System.out.println(s);
//			System.out.println("s的长度是："+s.length());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		byte[] buf =new byte[10];
		for(int i=0;i<buf.length;i++) {
			buf[i]=(byte)i;
		}
		try {
//			DataOutputStream out = new DataOutputStream(
//					new BufferedOutputStream(
//							new FileOutputStream("a.dat")));
//			FileOutputStream out =new FileOutputStream("a.dat");//二进制文件
			PrintWriter out = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream("a.txt"))));//文本文件
			//out.write(buf);
			int i=123456789;
//			out.writeInt(i);
			out.println(i);
			out.close();
//			DataInputStream in=new DataInputStream(
//					new BufferedInputStream(
//							new FileInputStream("a.dat")));
			BufferedReader in=new BufferedReader(
					new InputStreamReader(
							new FileInputStream("src/week8inout/InAndOut.java")));
			String line;
			while((line=in.readLine())!=null) {
				System.out.println(line);
			}
//			int j=in.readInt();
//			System.out.println(j);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		
		//socket
//		try {
//			Socket socket=new Socket(InetAddress.getByName("localhost"),12345);
//			PrintWriter out=new PrintWriter(
//					new BufferedWriter(
//							new OutputStreamWriter(
//									socket.getOutputStream())));//跟服务端建立连接 传输数据过去
//			out.println("HelloSocket");
//			out.flush();
//			BufferedReader in=new BufferedReader(
//					new InputStreamReader(
//							socket.getInputStream()));
//			String line;
//			line=in.readLine();
//			System.out.println(line);
//			out.close();
//			socket.close();
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		
		//对象串行化
		try {
			Student s1=new Student("john",18,5);
			System.out.println(s1);
			ObjectOutputStream out =new ObjectOutputStream(
					new FileOutputStream("obj.dat"));
			out.writeObject(s1);
			out.close();
			ObjectInputStream in=new ObjectInputStream(
					new FileInputStream("obj.dat"));
			Student s2=(Student)in.readObject();
			System.out.println(s2);
			in.close();
			System.out.println(s1==s2);//说明不是同一个对象，但是值一样
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
