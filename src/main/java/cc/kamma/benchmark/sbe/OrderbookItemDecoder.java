/* Generated SBE (Simple Binary Encoding) message codec */
package cc.kamma.benchmark.sbe;

import org.agrona.DirectBuffer;

@SuppressWarnings("all")
public class OrderbookItemDecoder
{
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;
    public static final int ENCODED_LENGTH = 24;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private int offset;
    private DirectBuffer buffer;

    public OrderbookItemDecoder wrap(final DirectBuffer buffer, final int offset)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.offset = offset;

        return this;
    }

    public DirectBuffer buffer()
    {
        return buffer;
    }

    public int offset()
    {
        return offset;
    }

    public int encodedLength()
    {
        return ENCODED_LENGTH;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public static int priceEncodingOffset()
    {
        return 0;
    }

    public static int priceEncodingLength()
    {
        return 8;
    }

    public static int priceSinceVersion()
    {
        return 0;
    }

    public static double priceNullValue()
    {
        return Double.NaN;
    }

    public static double priceMinValue()
    {
        return 4.9E-324d;
    }

    public static double priceMaxValue()
    {
        return 1.7976931348623157E308d;
    }

    public double price()
    {
        return buffer.getDouble(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int sizeEncodingOffset()
    {
        return 8;
    }

    public static int sizeEncodingLength()
    {
        return 8;
    }

    public static int sizeSinceVersion()
    {
        return 0;
    }

    public static double sizeNullValue()
    {
        return Double.NaN;
    }

    public static double sizeMinValue()
    {
        return 4.9E-324d;
    }

    public static double sizeMaxValue()
    {
        return 1.7976931348623157E308d;
    }

    public double size()
    {
        return buffer.getDouble(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int numEncodingOffset()
    {
        return 16;
    }

    public static int numEncodingLength()
    {
        return 4;
    }

    public static int numSinceVersion()
    {
        return 0;
    }

    public static int numNullValue()
    {
        return -2147483648;
    }

    public static int numMinValue()
    {
        return -2147483647;
    }

    public static int numMaxValue()
    {
        return 2147483647;
    }

    public int num()
    {
        return buffer.getInt(offset + 16, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public static int liqEncodingOffset()
    {
        return 20;
    }

    public static int liqEncodingLength()
    {
        return 4;
    }

    public static int liqSinceVersion()
    {
        return 0;
    }

    public static int liqNullValue()
    {
        return -2147483648;
    }

    public static int liqMinValue()
    {
        return -2147483647;
    }

    public static int liqMaxValue()
    {
        return 2147483647;
    }

    public int liq()
    {
        return buffer.getInt(offset + 20, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    public String toString()
    {
        return appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        builder.append('(');
        builder.append("price=");
        builder.append(price());
        builder.append('|');
        builder.append("size=");
        builder.append(size());
        builder.append('|');
        builder.append("num=");
        builder.append(num());
        builder.append('|');
        builder.append("liq=");
        builder.append(liq());
        builder.append(')');

        return builder;
    }
}
