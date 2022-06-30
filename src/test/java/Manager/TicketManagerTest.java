package Manager;

import Repository.TicketManagerRepository;
import domain.AviaTicketSales;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketManagerRepository repository = new TicketManagerRepository();
    TicketManager manager = new TicketManager(repository);
    AviaTicketSales first = new AviaTicketSales(1, 3_390, 60, "KUF", "DME");
    AviaTicketSales second = new AviaTicketSales(2, 4_080, 60, "KUF", "LED");
    AviaTicketSales thirst = new AviaTicketSales(3, 4_000, 60, "KUF", "RTW");
    AviaTicketSales fourth = new AviaTicketSales(4, 13_340, 60, "KUF", "KHV");
    AviaTicketSales fifth = new AviaTicketSales(5, 2_585, 60, "KUF", "SVO");
    AviaTicketSales sixth = new AviaTicketSales(6, 2_900, 60, "KUF", "LED");

    @BeforeEach
    public void setup() {
        repository.save(first);
        repository.save(second);
        repository.save(thirst);
        repository.save(fourth);
        repository.save(fifth);

    }

    @Test //Тест сортировка по стоимости билета по возрастанию
    public void shouldSortByIdPrice() {
        AviaTicketSales[] expected = new AviaTicketSales[]{first, second, thirst};
        AviaTicketSales[] actual = new AviaTicketSales[]{first, thirst, second};
        Arrays.sort(expected);
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(expected));
    }

    @Test // Тест использование метода переопределения
    public void shouldEseOverridedMethod() {
        AviaTicketSales aviaSales = new AviaTicketSales();
        aviaSales.toString();
    }

    @Test // тест добавления еще одного элемента
    public void shouldAddOneMore() {
        repository.save(sixth);
        AviaTicketSales[] actual = repository.findAll();
        AviaTicketSales[] expected = new AviaTicketSales[]{first, second, thirst, fourth, fifth, sixth};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(expected));
    }

    @Test // Тест сортировка по времени
    public void shouldSortByTime() {
        AviaTicketSales[] actual = manager.findAll("KUF", "DME");
        AviaTicketSales[] expected = new AviaTicketSales[]{first};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(expected));
    }

    @Test // Тест неверный аэропорт вылета
    public void shouldWrongFrom() {
        AviaTicketSales[] actual = manager.findAll("", "RTW");
        AviaTicketSales[] expected = new AviaTicketSales[]{};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }

    @Test // Тест неверный аэропорт прилета
    public void shouldWrongTo() {
        AviaTicketSales[] actual = manager.findAll("KUF", "");
        AviaTicketSales[] expected = new AviaTicketSales[]{};
        assertArrayEquals(expected, actual);
        System.out.println(Arrays.toString(actual));
    }

    @Test // Тест удаление одного элемента
    public void shouldRemoveExist() {
        repository.removeById(4);
        assertEquals(repository.findAll().length, 4);
    }

    @Test // Тест сохранить элементы
    public void shouldSaveAndFindAll() {
        assertEquals(repository.findAll().length, 5);
    }
}