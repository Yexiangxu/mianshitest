package com.example.administrator.mianshitest.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User:Lazy_xu
 * Data:2019/11/08
 * Description:
 * FIXME
 */
public class EchoServer {

    private final ServerSocket mServerSocket;

    public EchoServer(int port) throws IOException {
        mServerSocket = new ServerSocket(port);
    }

    public void run() throws IOException {
        Socket client = mServerSocket.accept();
        handleClient(client);
    }

    private void handleClient(Socket socket) throws IOException {
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        byte[] buffer = new byte[1024];
        int n;
        while ((n = in.read(buffer)) > 0) {
            out.write(buffer, 0, n);
        }
    }


    public static void main(String[] argv) {
        try {
            EchoServer server = new EchoServer(9877);
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

