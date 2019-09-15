package learn.http.tech.qihaizhi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpDemoServerLancher {

    private static final Integer HTTP_PORT = 80;

    public static void main(String[] args){

        try{
            //Create a Server socket on a port
            ServerSocket serverSocket = new ServerSocket(Constant.HTTP_PORT);
            System.out.println("HTTP Demo Server started!");
            //Listen on the port
            Socket socket;
            InputStream inputStream;
            while(true){
                socket = serverSocket.accept();
                //Get input stream from the port
                inputStream = socket.getInputStream();
                //Reading buffer
                byte[] buffer = new byte[Constant.DEFAULT_BUFFER_SIZE];
                StringBuilder stringBuilder = new StringBuilder();
                int len;
                while((len=inputStream.read(buffer))!=-1){
                    stringBuilder.append(new String(buffer,0,len,"UTF-8"));
                }
                String message = stringBuilder.toString();
                System.out.println("Recieved message from client: " + stringBuilder.toString());
                if(message!=null&&"SIGNAL:QUIT".equals(message)){
                    System.out.println("Quit Signal is detected! " +
                            "Server is going to shutdown!");
                    break;
                }
                OutputStream outputStream = socket.getOutputStream();
                String responseMessage = HttpStatusCode.HTTP_200.getStatusCode();
                outputStream.write(responseMessage.getBytes("UTF-8"));
                outputStream.flush();
                socket.shutdownOutput();
            }
            if(inputStream!=null){
                inputStream.close();
            }
            if(socket!=null){
                socket.close();
            }
            if(serverSocket!=null){
                serverSocket.close();
            }
            System.out.println("Server stops successfully!");
        }catch (IOException e){
            System.err.println("Fail to start the Demo Server!");
            e.printStackTrace();
        }


    }
}
