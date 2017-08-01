package com.gnu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Copy file byte by byte
 *
 * @author xuejiawei@lohogames.com on 2017-06-19
 */
public class CopyBytes {
    public static void main(String[] args) throws Exception {
        String dir = System.getProperty("user.dir");
        System.out.println(String.format("current execute dictionary %s", dir));

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("hello.txt");
            out = new FileOutputStream("copy.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
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
