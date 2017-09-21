package com.gnu.io.bio.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author siberiwolf@hotmail.com on 2017/9/19
 */
public class BioEchoClient {
    public static void main(String[] args) {
        int id = (int)(Math.random() * 100000);

        int port = 8080;

        if (args != null && args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            socket = new Socket("127.0.0.1", port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            for (int i = 0; i < 5; i++) {
                String msg = String.format("%d send request %d", id, i);
                System.out.println(msg);
                out.println(msg);
                String resp = in.readLine();
                System.out.println(String.format("receive resp %s", resp));
                TimeUnit.SECONDS.sleep(3);
            }
        } catch (Exception e) {

        } finally {
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

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
