import org.junit.Test;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.Vector;

public class UdpTest {
    @Test
    public void runUdp() throws IOException {
        //recive();
        send();
    }
    public static  void  send() throws IOException {
        DatagramSocket ds =new DatagramSocket();
        byte[] buf ="这是UDP发送端".getBytes();
        DatagramPacket dp =new DatagramPacket(
                buf,buf.length, InetAddress.getByName("192.168.1.254"),10000);
        System.out.println(dp.getAddress()+" "+dp.getPort());
        ds.send(dp);
        ds.close();
    }

    public static  void recive(){
        try {
            DatagramSocket ds = new DatagramSocket(10000);
            byte[] buf =new byte[1024];
            DatagramPacket dp =new DatagramPacket(buf,buf.length);
            ds.receive(dp);//将发送端发送的数据包接收到接收端的数据包中
            String ip = dp.getAddress().getHostAddress();//获取发送端的ip
            String data = new String(dp.getData(),0,dp.getLength());//获取数据
            int port = dp.getPort();//获取发送端的端口号
                System.out.println(ip+":"+data+":"+port);
            ds.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void lock(){
      List<Integer> numberList = new Vector<Integer>();
        long begin = System.currentTimeMillis();
        int count = 0;
        int startnum = 0;
        while(count<10000000){
            numberList.add(startnum);
            startnum+=2;
            count++;
            }
            long end = System.currentTimeMillis();
            System.out.println(end-begin);

    }
}
