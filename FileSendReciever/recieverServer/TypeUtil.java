import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class TypeUtil {

    public static byte[] convertToBytes(int value, int length, ByteOrder order)

    {

    	byte[] byteArray;
    	if(length == 2)
    	{
    		byteArray = new byte[2];
    	}
    	else
    	{
    		byteArray = new byte[4];
    	}
       

        int shift = 0;

        for (int i = 0; i < byteArray.length;

             i++) {



            if (order == ByteOrder.BIG_ENDIAN)

                shift = (byteArray.length - 1 - i) * 8; // 24, 16, 8, 0

            else

                shift = i * 8; // 0,8,16,24



            byteArray[i] = (byte) (value >>> shift);

        }

        return byteArray;



    }
    /**

     * Doesn't use ByeBuffer class from java.nio package

     *

     * @param byteArray byte array

     * @param order     ByteOrder

     * @return integer represented by those bytes

     */

    public static int constructIntFromByteArray(byte[] byteArray, ByteOrder order)

    {
        int result = 0;

        int shift = 0;

        for (int i = 0; i < byteArray.length; i++) {

            if (order == ByteOrder.BIG_ENDIAN)

                shift = (byteArray.length - 1 - i) * 8; // 24, 16, 8, 0

            else

                shift = i * 8; // 0,8,16,24

            result = (byteArray[i] & 0x000000FF) << shift | result;

        }

        return result;

    }



    /**

     * Uses ByeBuffer class from java.nio package

     *

     * @param value integer to be converted to byte array

     * @param order ByteOrder

     * @return byte array

     */

    public static byte[] convertToBytesUsingByteBuffer(int value, ByteOrder order)

    {

        ByteBuffer buffer = ByteBuffer.allocate(4); // in java, int takes 4 bytes.

        buffer.order(order);

        return buffer.putInt(value).array();

    }



    /**

     * Uses ByeBuffer class from java.nio package

     *

     * @param byteArray byte array

     * @param order     ByteOrder

     * @return integer represented by those bytes

     */

    public static int constructIntFromByteArrayUsingByteBuffer(byte[] byteArray, ByteOrder order)

    {

        ByteBuffer buffer = ByteBuffer.wrap(byteArray);

        buffer.order(order);

        return buffer.getInt();

    }



}
