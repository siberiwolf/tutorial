package com.gnu.concurrent.lock;

/**
 * @author xuejiawei@jd.com
 * 2018-08-21
 */
public class SyncDemo {
    /* 0: aload_0
     1: dup
     2: astore_1
     3: monitorenter
     4: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
     7: ldc           #3                  // String sync print
     9: invokevirtual #4                  // Method java/io/PrintStream.pritln:(Ljava/lang/String;)V
    12: aload_1
    13: monitorexit
    14: goto          22
    17: astore_2
    18: aload_1
    19: monitorexit
    20: aload_2
    21: athrow
    22: return*/
    public void syncPrint() {
        synchronized (this) {
            System.out.println("sync print");
        }
    }
}
