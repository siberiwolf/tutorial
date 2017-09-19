package com.gnu.io.bio.echo;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author siberiwolf@hotmail.com on 2017/9/19
 */
public class BioThreadPoolEchoServer {
    public static void main(String[] args) throws Exception {
        int port = 8080;

        if (args != null && args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
//            ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
            ExecutorService executorService = Executors.newFixedThreadPool(2);

            for (;;) {
                Socket socket = serverSocket.accept();
                executorService.execute(new BioEchoServerHandler(socket));
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
