package com.gnu.io.bio.echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

            List<Socket> sockets = new ArrayList<>();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(;;) {
                        if (sockets != null && !sockets.isEmpty()) {
                            Iterator<Socket> iter = sockets.iterator();
                            while (iter.hasNext()) {
                                Socket connectedSocket = iter.next();
                                try {
                                    if (connectedSocket.getInputStream().available() > 0) {
                                        System.out.println("add readable socket to thread pool");
                                        executorService.execute(new BioThreadPoolEchoServerHandler(connectedSocket));
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        try {
                            TimeUnit.MILLISECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            Socket socket = null;
            for (;;) {
                socket = serverSocket.accept();
                sockets.add(socket);
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
