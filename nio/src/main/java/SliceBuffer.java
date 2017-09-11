import java.nio.ByteBuffer;

/**
 * 缓冲区分片
 * @author siberiwolf@hotmail.com on 2017/9/11
 */
public class SliceBuffer {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        // position is 10, limit is 10 after init
        for(int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }

        // change position and limit
        buffer.position(3);
        buffer.limit(6);

        // slice buffer share the lower level byte[] with buffer
        ByteBuffer sliceBuffer = buffer.slice();
        for (int i = 0; i < sliceBuffer.capacity(); i++) {
            byte temp = sliceBuffer.get();
            temp *= 5;
            sliceBuffer.put(i, temp);
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());
        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.get());
        }
    }
}
