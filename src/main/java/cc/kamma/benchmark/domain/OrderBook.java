package cc.kamma.benchmark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
public class OrderBook {

    long timestamp;
    List<OrderbookItem> asks;
    List<OrderbookItem> bids;


    public static OrderBook createBigOrderbook() {
        long timestamp = System.currentTimeMillis();
        Random random = ThreadLocalRandom.current();
        List<OrderbookItem> asks = new ArrayList<>(1000);
        List<OrderbookItem> bids = new ArrayList<>(1000);

        for (int i = 0; i < 1000; i++) {
            OrderbookItem item = new OrderbookItem(random.nextDouble(), random.nextDouble(), random.nextInt(100), 3);
            asks.add(item);
        }

        for (int i = 0; i < 1000; i++) {
            OrderbookItem item = new OrderbookItem(random.nextDouble(), random.nextDouble(), random.nextInt(100), 3);
            bids.add(item);
        }

        return new OrderBook(timestamp, Collections.unmodifiableList(asks), Collections.unmodifiableList(bids));
    }

}
