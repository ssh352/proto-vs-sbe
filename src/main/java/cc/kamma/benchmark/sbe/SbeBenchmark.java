package cc.kamma.benchmark.sbe;

import cc.kamma.benchmark.domain.OrderBook;
import cc.kamma.benchmark.domain.OrderbookItem;
import cc.kamma.benchmark.proto.ProtoBenchmark;
import cc.kamma.benchmark.proto.ProtoOrderbook;
import com.google.protobuf.InvalidProtocolBufferException;
import org.agrona.concurrent.UnsafeBuffer;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@State(Scope.Benchmark)
public class SbeBenchmark {

    private ByteBuffer byteBuffer = ByteBuffer.allocateDirect(64 * 1024);
    private final UnsafeBuffer unsafeBuffer = new UnsafeBuffer(byteBuffer);

    private OrderBook orderBook = OrderBook.createBigOrderbook();

    private  final MessageHeaderDecoder MESSAGE_HEADER_DECODER = new MessageHeaderDecoder();
    private  final MessageHeaderEncoder MESSAGE_HEADER_ENCODER = new MessageHeaderEncoder();
    private  final SbeOrderbookDecoder ORDERBOOK_DECODER = new SbeOrderbookDecoder();
    private  final SbeOrderbookEncoder ORDERBOOK_ENCODER = new SbeOrderbookEncoder();


    private byte[] bytes = encode();
    private UnsafeBuffer bufferToRead = new UnsafeBuffer(bytes);


    @Benchmark
    public byte[] encode() {
        byteBuffer.clear();
        ORDERBOOK_ENCODER.wrapAndApplyHeader(unsafeBuffer, 0, MESSAGE_HEADER_ENCODER)
                .timestamp(orderBook.getTimestamp());
        SbeOrderbookEncoder.AsksEncoder asksEncoder = ORDERBOOK_ENCODER
                .asksCount(orderBook.getAsks().size());
        for (OrderbookItem ask : orderBook.getAsks()) {
            asksEncoder.next()
                    .askItem()
                    .price(ask.getPrice())
                    .size(ask.getSize())
                    .num(ask.getNum())
                    .liq(ask.getLiq());
        }

        SbeOrderbookEncoder.BidsEncoder bidsEncoder = ORDERBOOK_ENCODER
                .bidsCount(orderBook.getBids().size());
        for (OrderbookItem bid : orderBook.getBids()) {
            bidsEncoder.next()
                    .bidItem()
                    .price(bid.getPrice())
                    .size(bid.getSize())
                    .num(bid.getNum())
                    .liq(bid.getLiq());
        }

        int length = MessageHeaderEncoder.ENCODED_LENGTH + ORDERBOOK_ENCODER.encodedLength();
        byte[] arr = new byte[length];
        byteBuffer.get(arr, 0, length);
        return arr;
    }

    @Benchmark
    public OrderBook decode() {
        int offset = 0;
        MESSAGE_HEADER_DECODER.wrap(bufferToRead, 0);
        final int templateId = MESSAGE_HEADER_DECODER.templateId();
        final int actingBlockLength = MESSAGE_HEADER_DECODER.blockLength();
        final int actingVersion = MESSAGE_HEADER_DECODER.version();
        offset += MESSAGE_HEADER_DECODER.encodedLength();

        ORDERBOOK_DECODER.wrap(bufferToRead, offset, actingBlockLength, actingVersion);
        long timestamp = ORDERBOOK_DECODER.timestamp();
        SbeOrderbookDecoder.AsksDecoder asksDecoder = ORDERBOOK_DECODER.asks();
        int asksCount = asksDecoder.count();
        List<OrderbookItem> asks = new ArrayList<>(asksCount);
        for (SbeOrderbookDecoder.AsksDecoder ask : asksDecoder) {
            OrderbookItemDecoder item = ask.askItem();
            asks.add(new OrderbookItem(item.price(), item.size(), item.num(), item.liq()));
        }

        SbeOrderbookDecoder.BidsDecoder bidsDecoder = ORDERBOOK_DECODER.bids();
        int bidsCount = bidsDecoder.count();
        List<OrderbookItem> bids = new ArrayList<>(bidsCount);
        for (SbeOrderbookDecoder.BidsDecoder bid : bidsDecoder) {
            OrderbookItemDecoder item = bid.bidItem();
            bids.add(new OrderbookItem(item.price(), item.size(), item.num(), item.liq()));
        }

        return new OrderBook(timestamp, asks, bids);
    }

    public static void main(String[] args) throws RunnerException, InvalidProtocolBufferException {
        SbeBenchmark sbeBenchmark = new SbeBenchmark();
        System.out.println(sbeBenchmark.decode().equals(sbeBenchmark.orderBook));
        System.out.println(sbeBenchmark.decode().equals(sbeBenchmark.orderBook));
        System.out.println(sbeBenchmark.decode().equals(sbeBenchmark.orderBook));
        System.out.println(sbeBenchmark.decode().equals(sbeBenchmark.orderBook));
        System.out.println(sbeBenchmark.decode().equals(sbeBenchmark.orderBook));
        Options opt = new OptionsBuilder()
                .include(SbeBenchmark.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }
}
