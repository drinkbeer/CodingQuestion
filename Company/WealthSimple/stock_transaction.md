# Order Matching Engine (Candidate Description)

Create an order matching system that matches buy and sell orders on the stock market.

## Example scenarios:

If we are trading Wealthsimple stocks, with market symbol **WS**, we could have the following scenarios:

An order to:
**BUY** **50** shares of Wealthsimple (**WS**) at **$100**/share
can match an order to:
**SELL** **50** shares of Wealthsimple (**WS**) at **$100**/share

An order to:
**BUY** **50** shares of Wealthsimple (**WS**) at **$100**/share
can match an order to:
**SELL** **50** shares of Wealthsimple (**WS**) at **$95**/share

An order to:
**BUY 50** shares of Wealthsimple (**WS**) at **$100**/share
will not match an order to:
**SELL 50** shares of Wealthsimple (**WS**) at **$105**/share
because the seller didn't agree to sell for less than $105
and the buyer didn't agree to pay more than $100

## Requirements:

* Orders are stored in what we call an Order Book.
* When a new order is placed, we should try to match it against existing orders in our Order Book.
    * If a match is found, the matching order is removed from the Order Book. Print
      `“Match Found: source order: " + sourceOrder +" matched order: " + matchedOrder`
      where `sourceOrder` is the order just processed and `matchedOrder` is the order you found in the Order Book.
    *  If no match is found, the newly placed order is stored in the Order Book.
* Orders need to be matched with previous orders in the order book using the following rules:
    * SELL order needs to match with previous BUY order that has the highest price.
    * BUY order needs to match with previous SELL order that has the lowest price.
    * If the order matches multiple previous orders with the same price — it should be matched with the earliest one.
    * If the symbol matches, but quantity does not — no trade takes place and the new order is added to the book.
* This is a single threaded application. It is not possible for multiple orders to come in at the same time.
* Your solution should take as a parameter an `Order` that is the current order we want to find a match for.
* Treat input as a stream of orders: you only have access to one order at a time.

### Given Input:

Your program needs to process orders one-at-a-time and decide what to do with them:

```
List(
new Order("WS", "BUY",  100.00, 50),
new Order("WS", "BUY",  150.00, 45),
new Order("WS", "SELL",  100.00, 45),
new Order("BW", "SELL",  100.00, 25),
new Order("INF", "SELL",  100.00, 25),
new Order("INF", "BUY",  100.00, 25),
new Order("BW", "BUY",  100.00, 25),
).forEach(
  order -> processOrder(order)
)
```

### Output should be:

```
Match Found:
source order:  Order [symbol: WS | side: SELL | price: 100.00 | quantity: 45 ]
match order: Order [symbol: WS | side: BUY | price: 150.00 | quantity: 45 ]

Match Found:
source order:  Order [symbol: INF | side: BUY | price: 100.00 | quantity: 25 ]
match order: Order [symbol: INF | side: SELL | price: 100.00 | quantity: 25 ]

Match Found:
source order:  Order [symbol: BW | side: BUY | price: 100.00 | quantity: 25 ]
match order: Order [symbol: BW | side: SELL | price: 100.00 | quantity: 25 ]
```