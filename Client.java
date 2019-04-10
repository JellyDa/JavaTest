
import java.io.*;
import java.net.*;
public class Client extends Thread {    
	public static void main(String[] args){
		 DataInputStream dis=null;
		 Socket socket =null;
		 FileOutputStream fos =null;
		 InputStreamReader ir = null;
		 BufferedReader br = null;
		 try {
			 int length=0;
			socket = new Socket("113.54.227.50",7779);
			byte[] getByte = new byte[1024];
			System.out.println("连接到服务器成功");
			File file = new File("D:\\zhengquanClientdata\\Show2.txt");
			  ir=new InputStreamReader(socket.getInputStream());
			    br=new BufferedReader(ir);			
			    dis = new DataInputStream(socket.getInputStream());
			    fos = new FileOutputStream(file);		
			    String str = null;
				int lineNumber = 0;
		           while((str = br.readLine()) != null) {
		   			lineNumber++;
					System.out.println(lineNumber + " " + str);
				}
	                   System.out.println("准备接收文件");
				while((length=dis.read(getByte))>0){				
					fos.write(getByte, 0, length);
					fos.flush();
				}
		            System.out.println("文件接收完毕");	       	        	        
			 }catch(IOException e){
				 e.getStackTrace();
			 }finally{
				 try {
					dis.close();
					fos.close();
				        socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			 }	
		 }
		 
		  	 
	}
