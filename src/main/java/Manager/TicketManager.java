package Manager;

import Repository.TicketManagerRepository;
import domain.AviaTicketSales;

import java.util.Arrays;

public class TicketManager {
    private final TicketManagerRepository repository;

    public TicketManager(TicketManagerRepository repository) {
        this.repository = repository;
    }

    public AviaTicketSales[] findAll(String from, String to) {
        AviaTicketSales[] result = new AviaTicketSales[0];
        for (AviaTicketSales ticket : repository.findAll()) {
            if (ticket.getFrom().equalsIgnoreCase(from) && ticket.getTo().equalsIgnoreCase(to)) {
                AviaTicketSales[] tmp = new AviaTicketSales[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
