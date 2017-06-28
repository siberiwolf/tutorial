package com.gnu.io;

import java.io.*;

/**
 * copy file line by line
 * @author xuejiawei@lohogames.com on 2017-06-20
 */
public class CopyLines {
    public static void main(String[] args) throws Exception {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new FileReader("hello.txt"));
            out = new PrintWriter(new FileWriter("copy.txt"));
            String str;

            while ((str =(in.readLine())) != null) {
                out.println(str);
            }
        } finally {
            if (in != null) {
                in.close();
            }

            if (out != null) {
                out.close();
            }
        }
    }
}
