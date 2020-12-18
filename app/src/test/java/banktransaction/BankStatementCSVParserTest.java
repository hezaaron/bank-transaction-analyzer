package banktransaction;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import banktransaction.model.BankTransaction;
import banktransaction.util.BankStatementCSVParser;
import banktransaction.util.BankStatementParser;

public class BankStatementCSVParserTest {
    private final BankStatementParser bankStatementParser = new BankStatementCSVParser();

    @Test
    void shouldParseOneCorrectLine() {
        final String line = "30/01/2017,-50,Tesco";
        
        final BankTransaction result = bankStatementParser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        
        assertEquals(expected.getDate(), result.getDate());
        assertEquals(expected.getAmount(), result.getAmount());
        assertEquals(expected.getDescription(), result.getDescription());
    }

    @Test
    void shouldParseAListOfCorrectLines() {
        final List<String> lines = Arrays.asList("30/01/2017,-50,Tesco", "30/01/2017,-100,Deliveroo");
        
        final List<BankTransaction> result = bankStatementParser.parseLinesFrom(lines);
        final List<BankTransaction> expected = Arrays.asList(new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco"),
                                                            new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "Deliveroo"));
        assertEquals(expected.get(0), result.get(0));
        assertEquals(expected.get(1).getAmount(), result.get(1).getAmount());
    }
}
