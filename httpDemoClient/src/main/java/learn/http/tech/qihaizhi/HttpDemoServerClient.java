package learn.http.tech.qihaizhi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpDemoServerClient {

    public static void main(String[] args){
        try{

            Socket socket = new Socket(Constant.SERVER_IP,Constant.HTTP_PORT);
            OutputStream outputStream = socket.getOutputStream();
            String message = "你好";
            outputStream.write(message.getBytes("UTF-8"));
            outputStream.flush();
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            byte[] readerBuffer = new byte[Constant.DEFAULT_BUFFER_SIZE];
            int len;
            StringBuilder stringBuilder = new StringBuilder();
            while((len = inputStream.read(readerBuffer))!=-1){
                stringBuilder.append(new String(readerBuffer,0,len,"UTF-8"));
            }
            System.out.println("Server response: "+ stringBuilder.toString());
            outputStream.close();
            socket.close();
        }catch (IOException e){
            System.err.print("Fail to connect to server!");
            e.printStackTrace();
        }
    }
}
