package cc.kamma.benchmark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderbookItem {
    private double price;
    private double size;
    private int num;
    private int liq;
}
