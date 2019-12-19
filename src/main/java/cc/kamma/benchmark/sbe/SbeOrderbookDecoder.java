/* Generated SBE (Simple Binary Encoding) message codec */
package cc.kamma.benchmark.sbe;

import org.agrona.MutableDirectBuffer;
import org.agrona.DirectBuffer;

/**
 * Sbe Orderbook
 */
@SuppressWarnings("all")
public class SbeOrderbookDecoder
{
    public static final int BLOCK_LENGTH = 8;
    public static final int TEMPLATE_ID = 1;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final SbeOrderbookDecoder parentMessage = this;
    private DirectBuffer buffer;
    protected int initialOffset;
    protected int offset;
    protected int limit;
    protected int actingBlockLength;
    protected int actingVersion;

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

    public DirectBuffer buffer()
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

    public SbeOrderbookDecoder wrap(
        final DirectBuffer buffer,
        final int offset,
        final int actingBlockLength,
        final int actingVersion)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.initialOffset = offset;
        this.offset = offset;
        this.actingBlockLength = actingBlockLength;
        this.actingVersion = actingVersion;
        limit(offset + actingBlockLength);

        return this;
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

    public long timestamp()
    {
        return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
    }


    private final AsksDecoder asks = new AsksDecoder(this);

    public static long asksDecoderId()
    {
        return 3;
    }

    public static int asksDecoderSinceVersion()
    {
        return 0;
    }

    public AsksDecoder asks()
    {
        asks.wrap(buffer);
        return asks;
    }

    public static class AsksDecoder
        implements Iterable<AsksDecoder>, java.util.Iterator<AsksDecoder>
    {
        public static final int HEADER_SIZE = 4;
        private final SbeOrderbookDecoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        AsksDecoder(final SbeOrderbookDecoder parentMessage)
        {
            this.parentMessage = parentMessage;
        }

        public void wrap(final DirectBuffer buffer)
        {
            if (buffer != this.buffer)
            {
                this.buffer = buffer;
            }
            index = -1;
            final int limit = parentMessage.limit();
            parentMessage.limit(limit + HEADER_SIZE);
            blockLength = (int)(buffer.getShort(limit + 0, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
            count = (int)(buffer.getShort(limit + 2, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 24;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<AsksDecoder> iterator()
        {
            return this;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext()
        {
            return (index + 1) < count;
        }

        public AsksDecoder next()
        {
            if (index + 1 >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + blockLength);
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

        private final OrderbookItemDecoder askItem = new OrderbookItemDecoder();

        public OrderbookItemDecoder askItem()
        {
            askItem.wrap(buffer, offset + 0);
            return askItem;
        }

        public StringBuilder appendTo(final StringBuilder builder)
        {
            builder.append('(');
            builder.append("askItem=");
            final OrderbookItemDecoder askItem = askItem();
            if (askItem != null)
            {
                askItem.appendTo(builder);
            }
            else
            {
                builder.append("null");
            }
            builder.append(')');

            return builder;
        }
    }

    private final BidsDecoder bids = new BidsDecoder(this);

    public static long bidsDecoderId()
    {
        return 5;
    }

    public static int bidsDecoderSinceVersion()
    {
        return 0;
    }

    public BidsDecoder bids()
    {
        bids.wrap(buffer);
        return bids;
    }

    public static class BidsDecoder
        implements Iterable<BidsDecoder>, java.util.Iterator<BidsDecoder>
    {
        public static final int HEADER_SIZE = 4;
        private final SbeOrderbookDecoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        BidsDecoder(final SbeOrderbookDecoder parentMessage)
        {
            this.parentMessage = parentMessage;
        }

        public void wrap(final DirectBuffer buffer)
        {
            if (buffer != this.buffer)
            {
                this.buffer = buffer;
            }
            index = -1;
            final int limit = parentMessage.limit();
            parentMessage.limit(limit + HEADER_SIZE);
            blockLength = (int)(buffer.getShort(limit + 0, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
            count = (int)(buffer.getShort(limit + 2, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 24;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<BidsDecoder> iterator()
        {
            return this;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext()
        {
            return (index + 1) < count;
        }

        public BidsDecoder next()
        {
            if (index + 1 >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + blockLength);
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

        private final OrderbookItemDecoder bidItem = new OrderbookItemDecoder();

        public OrderbookItemDecoder bidItem()
        {
            bidItem.wrap(buffer, offset + 0);
            return bidItem;
        }

        public StringBuilder appendTo(final StringBuilder builder)
        {
            builder.append('(');
            builder.append("bidItem=");
            final OrderbookItemDecoder bidItem = bidItem();
            if (bidItem != null)
            {
                bidItem.appendTo(builder);
            }
            else
            {
                builder.append("null");
            }
            builder.append(')');

            return builder;
        }
    }

    public String toString()
    {
        SbeOrderbookDecoder decoder = new SbeOrderbookDecoder();
        decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

        return decoder.appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        final int originalLimit = limit();
        limit(initialOffset + actingBlockLength);
        builder.append("[SbeOrderbook](sbeTemplateId=");
        builder.append(TEMPLATE_ID);
        builder.append("|sbeSchemaId=");
        builder.append(SCHEMA_ID);
        builder.append("|sbeSchemaVersion=");
        if (parentMessage.actingVersion != SCHEMA_VERSION)
        {
            builder.append(parentMessage.actingVersion);
            builder.append('/');
        }
        builder.append(SCHEMA_VERSION);
        builder.append("|sbeBlockLength=");
        if (actingBlockLength != BLOCK_LENGTH)
        {
            builder.append(actingBlockLength);
            builder.append('/');
        }
        builder.append(BLOCK_LENGTH);
        builder.append("):");
        builder.append("timestamp=");
        builder.append(timestamp());
        builder.append('|');
        builder.append("asks=[");
        AsksDecoder asks = asks();
        if (asks.count() > 0)
        {
            while (asks.hasNext())
            {
                asks.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        builder.append(']');
        builder.append('|');
        builder.append("bids=[");
        BidsDecoder bids = bids();
        if (bids.count() > 0)
        {
            while (bids.hasNext())
            {
                bids.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        builder.append(']');

        limit(originalLimit);

        return builder;
    }
}
