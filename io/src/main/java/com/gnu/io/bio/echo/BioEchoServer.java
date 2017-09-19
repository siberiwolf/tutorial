package com.gnu.io.bio.echo;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Echo server with bio, one client one thread
 * @author siberiwolf@hotmail.com on 2017/9/19
 */
public class BioEchoServer {
    public static void main(String[] args) throws Exception {
        int port = 8080;

        if (args != null && args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            for (;;) {
                /**
                 * blocked at accept
                 "main" #1 prio=5 os_prio=0 tid=0x000000000294e800 nid=0x1b4c runnable [0x0000000002a4f000]
                 java.lang.Thread.State: RUNNABLE
                 at java.net.DualStackPlainSocketImpl.accept0(Native Method)
                 at java.net.DualStackPlainSocketImpl.socketAccept(DualStackPlainSocketImpl.java:131)
                 at java.net.AbstractPlainSocketImpl.accept(AbstractPlainSocketImpl.java:409)
                 at java.net.PlainSocketImpl.accept(PlainSocketImpl.java:199)
                 - locked <0x000000076add6e00> (a java.net.SocksSocketImpl)
                 at java.net.ServerSocket.implAccept(ServerSocket.java:545)
                 at java.net.ServerSocket.accept(ServerSocket.java:513)
                 at com.gnu.io.bio.echo.BioEchoServer.main(BioEchoServer.java:22)
                 */
                Socket socket = serverSocket.accept();
                new Thread(new BioEchoServerHandler(socket)).start();
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
