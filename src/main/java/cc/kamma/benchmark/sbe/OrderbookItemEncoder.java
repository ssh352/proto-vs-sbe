/* Generated SBE (Simple Binary Encoding) message codec */
package cc.kamma.benchmark.sbe;

import org.agrona.MutableDirectBuffer;

@SuppressWarnings("all")
public class OrderbookItemEncoder
{
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;
    public static final int ENCODED_LENGTH = 24;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private int offset;
    private MutableDirectBuffer buffer;

    public OrderbookItemEncoder wrap(final MutableDirectBuffer buffer, final int offset)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.offset = offset;

        return this;
    }

    public MutableDirectBuffer buffer()
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

    public OrderbookItemEncoder price(final double value)
    {
        buffer.putDouble(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int sizeEncodingOffset()
    {
        return 8;
    }

    public static int sizeEncodingLength()
    {
        return 8;
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

    public OrderbookItemEncoder size(final double value)
    {
        buffer.putDouble(offset + 8, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int numEncodingOffset()
    {
        return 16;
    }

    public static int numEncodingLength()
    {
        return 4;
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

    public OrderbookItemEncoder num(final int value)
    {
        buffer.putInt(offset + 16, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public static int liqEncodingOffset()
    {
        return 20;
    }

    public static int liqEncodingLength()
    {
        return 4;
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

    public OrderbookItemEncoder liq(final int value)
    {
        buffer.putInt(offset + 20, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    public String toString()
    {
        return appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        OrderbookItemDecoder writer = new OrderbookItemDecoder();
        writer.wrap(buffer, offset);

        return writer.appendTo(builder);
    }
}
