package com.gnu.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * 过滤显示目录中的文件名
 *
 * @author siberiwolf@hotmail.com on 2017/9/13
 */
public class DirList {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("Useage java class [dir] [filterPattern]");
            return;
        }

        File dir = new File(args[0]);
        if (!dir.exists()) {
            System.out.println("dictionary not found");
            return;
        }

        String[] list = null;
        if (args.length < 2) {
            list = dir.list();
        } else {
            list = dir.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return Pattern.compile(args[1]).matcher(name).matches();
                }
            });
        }

        for (String item : list) {
            System.out.println(item);
        }
    }
}
