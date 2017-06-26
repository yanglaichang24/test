package com.ylch.test.jdk_class_test.bio;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yanglaichang1 on 2017/6/23.
 */
public class ServiceDemo {

    public static void main(String[] args) throws IOException {
        int port = 5330;
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress("localhost",5330));
        Socket accept = server.accept();
        new ServiceDemo().new ServiceHander(accept).start();
    }

    class ServiceHander extends Thread implements Closeable{
      private Socket socket;
      public ServiceHander(Socket socket){
          this.socket = socket;
      }

        @Override
        public void run() {
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                System.out.println("service接收参数。。");
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
                BufferedInputStream input = new BufferedInputStream(inputStream);
                byte[] bt = new byte[1024];
                int read = input.read(bt);
                System.out.println("service接收参数完成");
                String s = new String(bt);
                System.out.println("resp " + s);
                System.out.println("index " + read);

                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                String resp = "ok....";
                bufferedOutputStream.write(resp.getBytes());
                bufferedOutputStream.flush();
                System.out.println("service发送resp完成");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void close() throws IOException {

        }
    }

}
