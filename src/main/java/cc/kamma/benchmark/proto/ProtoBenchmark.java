package cc.kamma.benchmark.proto;

import cc.kamma.benchmark.domain.OrderBook;
import cc.kamma.benchmark.domain.OrderbookItem;
import com.google.protobuf.InvalidProtocolBufferException;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@State(Scope.Benchmark)
public class ProtoBenchmark {

    private OrderBook orderBook = OrderBook.createBigOrderbook();
    private byte[] bytes = encode();

    @Benchmark
    public byte[] encode() {
        ProtoOrderbook.L2MarketData.Builder bookBuilder = ProtoOrderbook.L2MarketData.newBuilder();
        bookBuilder.setTimestamp(orderBook.getTimestamp());
        for (OrderbookItem ask : orderBook.getAsks()) {
            ProtoOrderbook.L2DepthLine.Builder depthLineBuilder = ProtoOrderbook.L2DepthLine.newBuilder();
            depthLineBuilder.setPrice(ask.getPrice());
            depthLineBuilder.setSize(ask.getSize());
            depthLineBuilder.setNumOfLiquid(ask.getLiq());
            depthLineBuilder.setNumOfOrder(ask.getNum());
            bookBuilder.addAsks(depthLineBuilder);
        }

        for (OrderbookItem bid : orderBook.getBids()) {
            ProtoOrderbook.L2DepthLine.Builder depthLineBuilder = ProtoOrderbook.L2DepthLine.newBuilder();
            depthLineBuilder.setPrice(bid.getPrice());
            depthLineBuilder.setSize(bid.getSize());
            depthLineBuilder.setNumOfLiquid(bid.getLiq());
            depthLineBuilder.setNumOfOrder(bid.getNum());
            bookBuilder.addAsks(depthLineBuilder);
        }

        return bookBuilder.build().toByteArray();
    }

    @Benchmark
    public ProtoOrderbook.L2MarketData decode() throws InvalidProtocolBufferException {
        return ProtoOrderbook.L2MarketData.parseFrom(bytes);
    }

    public static void main(String[] args) throws RunnerException, InvalidProtocolBufferException {
        Options opt = new OptionsBuilder()
                .include(ProtoBenchmark.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(5)
                .build();

        new Runner(opt).run();
    }
}
