package com.gnu.io.bio;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * copy file character by character
 *
 * @author siberiwolf@hotmail.com on 2017-06-19
 */
public class CopyCharacters {
    public static void main(String[] args) throws Exception {
        FileReader in = null;
        FileWriter out = null;

        try {
            in = new FileReader("hello.txt");
            out = new FileWriter("copy.txt");
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
