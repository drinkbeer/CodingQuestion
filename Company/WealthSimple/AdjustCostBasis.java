package WealthSimple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjustCostBasis
{
  private static final String[] TYPES = {"SELL", "BUY"};
  private static Map<String, OrderManager> MAP = new HashMap<>();

  private static class Order {
    private final String symbol;
    private final String type;
    private final double amount;
    private final int numOfShares;
    private final double USD2CAD;
    public Order(String symbol, String type, double amount, int numOfShares, double USD2CAD) {
      this.symbol = symbol;
      this.type = type;
      this.amount = amount;
      this.numOfShares = numOfShares;
      this.USD2CAD = USD2CAD;
    }
  }

  private static class OrderManager {
    private final String symbol;
    private double acb;
    private int numOfShares;
    public OrderManager(String symbol)
    {
      this.symbol = symbol;
      this.acb = 0.0;
      this.numOfShares = 0;
    }

    public void processOrder(Order o) {
      assert symbol.equals(o.symbol);

      if (TYPES[0].equals(o.type)) {
        // sell order
        processSellOrder(o);
      } else if (TYPES[1].equals(o.type)) {
        // buy order
        processBuyOrder(o);
      } else {
        throw new UnsupportedOperationException("Order type not supported, type: " + o.type);
      }
    }

    private void processSellOrder(Order o) {
      assert o.numOfShares <= numOfShares;
      acb -= o.numOfShares * avgCost();
      numOfShares -= o.numOfShares;
    }

    private void processBuyOrder(Order o) {
      numOfShares += o.numOfShares;
      acb += o.amount * o.numOfShares * o.USD2CAD;
    }

    public double calculateACB() {
      return acb;
    }

    private double avgCost() {
      return acb / numOfShares;
    }

    @Override
    public String toString()
    {
      return symbol +
             " $" + acb +
             " CAD (" + numOfShares +
             " shares)";
    }
  }

  private static void processOrder(Order o) {
    MAP.putIfAbsent(o.symbol, new OrderManager(o.symbol));
    MAP.get(o.symbol).processOrder(o);
  }

  private static void printAcb() {
    MAP.keySet()
        .forEach(
            key -> {
              OrderManager om = MAP.get(key);
              System.out.println(om);
            });
  }

  public static void main(String[] args) {
    List<Order> list = new ArrayList<>();
    list.add(new Order("XYZ", "BUY", 10, 100, 1.15));
    list.add(new Order("XYZ", "BUY", 14, 50, 1.10));
    list.add(new Order("XYZ", "SELL", 20, 60, 1.20));

    list.forEach(o -> processOrder(o));
    printAcb();
  }
}
