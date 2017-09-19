package com.gnu.io.bio.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author siberiwolf@hotmail.com on 2017/9/19
 */
public class BioEchoServerHandler implements Runnable {
    private Socket socket;

    public BioEchoServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream());

            String body = null;
            for (;;) {
                /**
                 * blocked at read
                 "Thread-2" #20 prio=5 os_prio=0 tid=0x00000000213a0800 nid=0xe80 runnable [0x0000000021dce000]
                 java.lang.Thread.State: RUNNABLE
                 at java.net.SocketInputStream.socketRead0(Native Method)
                 at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
                 at java.net.SocketInputStream.read(SocketInputStream.java:170)
                 at java.net.SocketInputStream.read(SocketInputStream.java:141)
                 at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:284)
                 at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:326)
                 at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:178)
                 - locked <0x000000076bc5c820> (a java.io.InputStreamReader)
                 at java.io.InputStreamReader.read(InputStreamReader.java:184)
                 at java.io.BufferedReader.fill(BufferedReader.java:161)
                 at java.io.BufferedReader.readLine(BufferedReader.java:324)
                 - locked <0x000000076bc5c820> (a java.io.InputStreamReader)
                 at java.io.BufferedReader.readLine(BufferedReader.java:389)
                 at com.gnu.io.bio.echo.BioEchoServerHandler.run(BioEchoServerHandler.java:30)
                 at java.lang.Thread.run(Thread.java:745)
                 */
                body = in.readLine();
                if (body == null) {
                    break;
                }
                System.out.println(String.format("receive message %s", body));
                out.println(body);
            }
        } catch (Exception e) {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                in = null;
            }

            if (out != null) {
                out.close();
                out = null;
            }

            if (this.socket != null) {
                try {
                    this.socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.socket = null;
            }
        }
    }
}
