package Repository;

import domain.AviaTicketSales;

public class TicketManagerRepository {
    private AviaTicketSales[] items = new AviaTicketSales[0];

    public void save(AviaTicketSales item) {
        int length = items.length + 1;
        AviaTicketSales[] tmp = new AviaTicketSales[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AviaTicketSales[] removeById(int id) {
        int length = items.length - 1;
        AviaTicketSales[] tmp = new AviaTicketSales[length];
        int index = 0;
        for (AviaTicketSales item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return tmp;
    }

    public AviaTicketSales[] findAll() {
        return items;
    }
}
