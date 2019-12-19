/* Generated SBE (Simple Binary Encoding) message codec */
package cc.kamma.benchmark.sbe;

import org.agrona.MutableDirectBuffer;
import org.agrona.DirectBuffer;

/**
 * Sbe Orderbook
 */
@SuppressWarnings("all")
public class SbeOrderbookEncoder
{
    public static final int BLOCK_LENGTH = 8;
    public static final int TEMPLATE_ID = 1;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final SbeOrderbookEncoder parentMessage = this;
    private MutableDirectBuffer buffer;
    protected int initialOffset;
    protected int offset;
    protected int limit;

    public int sbeBlockLength()
    {
        return BLOCK_LENGTH;
    }

    public int sbeTemplateId()
    {
        return TEMPLATE_ID;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public String sbeSemanticType()
    {
        return "";
    }

    public MutableDirectBuffer buffer()
    {
        return buffer;
    }

    public int initialOffset()
    {
        return initialOffset;
    }

    public int offset()
    {
        return offset;
    }

    public SbeOrderbookEncoder wrap(final MutableDirectBuffer buffer, final int offset)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.initialOffset = offset;
        this.offset = offset;
        limit(offset + BLOCK_LENGTH);

        return this;
    }

    public SbeOrderbookEncoder wrapAndApplyHeader(
        final MutableDirectBuffer buffer, final int offset, final MessageHeaderEncoder headerEncoder)
    {
        headerEncoder
            .wrap(buffer, offset)
            .blockLength(BLOCK_LENGTH)
            .templateId(TEMPLATE_ID)
            .version(SCHEMA_VERSION);

        return wrap(buffer, offset + MessageHeaderEncoder.ENCODED_LENGTH);
    }

    public int encodedLength()
    {
        return limit - offset;
    }

    public int limit()
    {
        return limit;
    }

    public void limit(final int limit)
    {
        this.limit = limit;
    }

    public static int timestampId()
    {
        return 2;
    }

    public static int timestampSinceVersion()
    {
        return 0;
    }

    public static int timestampEncodingOffset()
    {
        return 0;
    }

    public static int timestampEncodingLength()
    {
        return 8;
    }

    public static String timestampMetaAttribute(final MetaAttribute metaAttribute)
    {
        switch (metaAttribute)
        {
            case EPOCH: return "";
            case TIME_UNIT: return "";
            case SEMANTIC_TYPE: return "";
            case PRESENCE: return "required";
        }

        return "";
    }

    public static long timestampNullValue()
    {
        return -9223372036854775808L;
    }

    public static long timestampMinValue()
    {
        return -9223372036854775807L;
    }

    public static long timestampMaxValue()
    {
        return 9223372036854775807L;
    }

    public SbeOrderbookEncoder timestamp(final long value)
    {
        buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }


    private final AsksEncoder asks = new AsksEncoder(this);

    public static long asksId()
    {
        return 3;
    }

    public AsksEncoder asksCount(final int count)
    {
        asks.wrap(buffer, count);
        return asks;
    }

    public static class AsksEncoder
    {
        public static final int HEADER_SIZE = 4;
        private final SbeOrderbookEncoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;

        AsksEncoder(final SbeOrderbookEncoder parentMessage)
        {
            this.parentMessage = parentMessage;
        }

        public void wrap(final MutableDirectBuffer buffer, final int count)
        {
            if (count < 0 || count > 65534)
            {
                throw new IllegalArgumentException("count outside allowed range: count=" + count);
            }

            if (buffer != this.buffer)
            {
                this.buffer = buffer;
            }

            index = -1;
            this.count = count;
            final int limit = parentMessage.limit();
            parentMessage.limit(limit + HEADER_SIZE);
            buffer.putShort(limit + 0, (short)(int)24, java.nio.ByteOrder.LITTLE_ENDIAN);
            buffer.putShort(limit + 2, (short)(int)count, java.nio.ByteOrder.LITTLE_ENDIAN);
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 24;
        }

        public AsksEncoder next()
        {
            if (index + 1 >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + sbeBlockLength());
            ++index;

            return this;
        }

        public static int askItemId()
        {
            return 4;
        }

        public static int askItemSinceVersion()
        {
            return 0;
        }

        public static int askItemEncodingOffset()
        {
            return 0;
        }

        public static int askItemEncodingLength()
        {
            return 24;
        }

        public static String askItemMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "";
                case TIME_UNIT: return "";
                case SEMANTIC_TYPE: return "";
                case PRESENCE: return "required";
            }

            return "";
        }

        private final OrderbookItemEncoder askItem = new OrderbookItemEncoder();

        public OrderbookItemEncoder askItem()
        {
            askItem.wrap(buffer, offset + 0);
            return askItem;
        }
    }

    private final BidsEncoder bids = new BidsEncoder(this);

    public static long bidsId()
    {
        return 5;
    }

    public BidsEncoder bidsCount(final int count)
    {
        bids.wrap(buffer, count);
        return bids;
    }

    public static class BidsEncoder
    {
        public static final int HEADER_SIZE = 4;
        private final SbeOrderbookEncoder parentMessage;
        private MutableDirectBuffer buffer;
        private int count;
        private int index;
        private int offset;

        BidsEncoder(final SbeOrderbookEncoder parentMessage)
        {
            this.parentMessage = parentMessage;
        }

        public void wrap(final MutableDirectBuffer buffer, final int count)
        {
            if (count < 0 || count > 65534)
            {
                throw new IllegalArgumentException("count outside allowed range: count=" + count);
            }

            if (buffer != this.buffer)
            {
                this.buffer = buffer;
            }

            index = -1;
            this.count = count;
            final int limit = parentMessage.limit();
            parentMessage.limit(limit + HEADER_SIZE);
            buffer.putShort(limit + 0, (short)(int)24, java.nio.ByteOrder.LITTLE_ENDIAN);
            buffer.putShort(limit + 2, (short)(int)count, java.nio.ByteOrder.LITTLE_ENDIAN);
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 24;
        }

        public BidsEncoder next()
        {
            if (index + 1 >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + sbeBlockLength());
            ++index;

            return this;
        }

        public static int bidItemId()
        {
            return 6;
        }

        public static int bidItemSinceVersion()
        {
            return 0;
        }

        public static int bidItemEncodingOffset()
        {
            return 0;
        }

        public static int bidItemEncodingLength()
        {
            return 24;
        }

        public static String bidItemMetaAttribute(final MetaAttribute metaAttribute)
        {
            switch (metaAttribute)
            {
                case EPOCH: return "";
                case TIME_UNIT: return "";
                case SEMANTIC_TYPE: return "";
                case PRESENCE: return "required";
            }

            return "";
        }

        private final OrderbookItemEncoder bidItem = new OrderbookItemEncoder();

        public OrderbookItemEncoder bidItem()
        {
            bidItem.wrap(buffer, offset + 0);
            return bidItem;
        }
    }

    public String toString()
    {
        return appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        SbeOrderbookDecoder writer = new SbeOrderbookDecoder();
        writer.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

        return writer.appendTo(builder);
    }
}
