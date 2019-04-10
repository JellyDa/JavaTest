

import java.io.*;
import java.net.*;

public class Sever extends Thread
{
    Socket ss;
	private static ServerSocket ss2;

    public Sever(Socket ss)
    {
        super();
        this.ss = ss;
    }
    public void run()
    {
        int length = 0;
        FileInputStream fis = null;
        DataOutputStream dos = null;
        byte[] sendByte = null;
        try
        {
            File file = new File("D:\\zhenquandatabase\\Show1.txt");
            System.out.println("服务器创建完毕");
            fis = new FileInputStream(file);
            dos = new DataOutputStream(ss.getOutputStream());
            sendByte = new byte[1024];
            System.out.println("准备发送");
            while((length = fis.read(sendByte)) > 0)
            {
                dos.write(sendByte, 0, length);
                dos.flush();
            }
            System.out.println("文件发送完毕");
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try
            {
                fis.close();
                dos.close();
                ss.close();

            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
    	ss2 = new ServerSocket(7779);
        while(true)
        {
            Socket clientSocket = ss2.accept();
            new Sever(clientSocket).start();
        }
    }
}
