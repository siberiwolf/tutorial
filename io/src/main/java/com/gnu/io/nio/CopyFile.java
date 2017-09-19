package com.gnu.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用Channel和Buffer拷贝文件内容，可以和com.gun.io.CopyBytes比较
 *
 * @author siberiwolf@hotmail.com on 2017/9/10
 */
public class CopyFile {
    public static void main(String[] args) throws Exception {
        String dir = System.getProperty("user.dir");
        System.out.println(String.format("current execute dictionary %s", dir));

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("io\\src\\main\\resources\\hello.txt");
            out = new FileOutputStream("nio\\src\\main\\resources\\copy.txt");

            FileChannel inChannel = in.getChannel();
            FileChannel outChannel = out.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(128);

            for (; ; ) {
                buffer.clear();
                int r = inChannel.read(buffer);

                if (r == -1){
                    break;
                }

                buffer.flip();
                outChannel.write(buffer);
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
