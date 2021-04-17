package WealthSimple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Sell: lowest price first sell, so queue is sorted ascending, <$100, $101, $101, ...>
Buy: highest price first buy, so queue is sorted descending, <$100, $98, $97, ...>
*/
public class StockOrderMatchSystem {
  public static final String[] ORDER_TYPES = {"SELL", "BUY"};
  public static final HashMap<String, BookOrder> MAP = new HashMap<>();

  public static class BookOrder {
    private final String symbol;
    private final Queue<Order> sellQueue;
    private final Queue<Order> buyQueue;

    public BookOrder(String symbol) {
      this.symbol = symbol;
      sellQueue = new PriorityQueue<>(sellQueueComparator);
      buyQueue = new PriorityQueue<>(buyQueueComparator);
    }

    public Order process(Order o) {
      assert this.symbol.equals(o.symbol);

      if (ORDER_TYPES[1].equals(o.type)) {
        return processBuyOrder(o);
      } else if (ORDER_TYPES[0].equals(o.type)) {
        return processSellOrder(o);
      } else {
        throw new UnsupportedOperationException("Unsupported order type: " + o.type);
      }
    }

    private Order processBuyOrder(Order o) {
      assert ORDER_TYPES[1].equals(o.type);
      if (sellQueue.isEmpty()) {
        buyQueue.offer(o);
        return null;
      }

      List<Order> orders = new LinkedList<>();
      Order matchedOrder = null;
      while (!sellQueue.isEmpty()) {
        if (o.price < sellQueue.peek().price) {
          break;
        }

        Order smallestSellOrder = sellQueue.poll();
        if (smallestSellOrder.quantity != o.quantity) {
          orders.add(smallestSellOrder);
          continue;
        }

        // find a match
        matchedOrder = smallestSellOrder;
        break;
      }
      sellQueue.addAll(orders);

      // No match
      if (matchedOrder == null) {
        buyQueue.offer(o);
        return null;
      }

      return matchedOrder;
    }

    private Order processSellOrder(Order o) {
      assert ORDER_TYPES[0].equals(o.type);
      if (buyQueue.isEmpty()) {
        sellQueue.offer(o);
        return null;
      }

      List<Order> orders = new LinkedList<>();
      Order matchedOrder = null;
      while (!buyQueue.isEmpty()) {
        if (o.price > buyQueue.peek().price) {
          break;
        }

        Order largestBuyOrder = buyQueue.poll();
        if (largestBuyOrder.quantity != o.quantity) {
          orders.add(largestBuyOrder);
          continue;
        }

        // find a match
        matchedOrder = largestBuyOrder;
        break;
      }
      buyQueue.addAll(orders);

      if (matchedOrder == null) {
        // no match
        sellQueue.offer(o);
      }

      return matchedOrder;
    }

    private final Comparator<Order> sellQueueComparator =
        (o1, o2) -> {
          if (o1.price == o2.price) return Long.compare(o1.time, o2.time);
          return Double.compare(o2.price, o1.price);
        };

    private final Comparator<Order> buyQueueComparator =
        (o1, o2) -> {
          if (o1.price == o2.price) return Long.compare(o1.time, o2.time);
          return Double.compare(o1.price, o2.price);
        };
  }

  private static class Order {
    private final String symbol;
    private final String type;
    private final double price; // Sell order - ask price; Buy order - bid price
    private final int quantity;
    private final long time; // the time when the order is placed

    public Order(String symbol, String type, double price, int quantity) {
      this.symbol = symbol;
      this.type = type;
      this.price = price;
      this.quantity = quantity;
      this.time = System.currentTimeMillis();
    }

    @Override
    public String toString() {
      return "Order ["
          + "symbol: "
          + symbol
          + " | type: "
          + type
          + " | price: "
          + price
          + " | quantity: "
          + quantity
          + " ]";
    }
  }

  public static void processOrder(Order o) {
    MAP.putIfAbsent(o.symbol, new BookOrder(o.symbol));
    Order matchedOrder = MAP.get(o.symbol).process(o);
    if (matchedOrder != null) {
      System.out.println("Match Found: ");
      System.out.println("source order: " + o.toString());
      System.out.println("match order: " + matchedOrder.toString());
      System.out.println();
    }
  }

  public static void main(String[] args) {
    List<Order> orders = new LinkedList<>();
    orders.add(new Order("WS", "BUY", 100.00, 50));
    orders.add(new Order("WS", "BUY", 150.00, 45));
    orders.add(new Order("WS", "SELL", 100.00, 45));
    orders.add(new Order("BW", "SELL", 100.00, 25));
    orders.add(new Order("INF", "SELL", 100.00, 25));
    orders.add(new Order("INF", "BUY", 100.00, 25));
    orders.add(new Order("BW", "BUY", 100.00, 25));
    orders.add(new Order("WS", "SELL", 101.00, 50));
    orders.forEach(order -> processOrder(order));
  }
}
