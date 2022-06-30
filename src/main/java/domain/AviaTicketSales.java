package domain;

public class AviaTicketSales implements Comparable<AviaTicketSales> {
    private int id;
    // Стоимость билета
    private int price;
    // Время полета
    private int time;
    // Аэропорт вылета
    private String from;
    // Аэропорт прилета
    private String to;

    public AviaTicketSales() {
    }

    public AviaTicketSales(int id, int price, int time, String from, String to) {
        this.id = id;
        this.price = price;
        this.time = time;
        this.from = from;
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "AviaSales{" +
                "id=" + id +
                ", price=" + price +
                ", time=" + time +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }


    @Override
    public int compareTo(AviaTicketSales comparePrice) {
        return this.price - comparePrice.price;
    }
}
