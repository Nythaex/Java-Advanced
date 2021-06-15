import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static junit.framework.TestCase.*;

public class ChainblockImplTest {
    ChainblockImpl TRANSACTIONS;

    @Before
    public void setup() {
        TRANSACTIONS = new ChainblockImpl();
        Transaction first = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Varna", "Sofia", 134.31);
        Transaction second = new TransactionImpl(2, TransactionStatus.FAILED, "Novi pazar", "Sofia", 22.3);
        TRANSACTIONS.add(first);
        TRANSACTIONS.add(second);
    }

    @Test
    public void when_getCount2() {
        assertEquals(2, TRANSACTIONS.getCount());
    }

    @Test
    public void when_whenAdd1Element() {
        Transaction third = new TransactionImpl(3, TransactionStatus.FAILED, "Novi pazar", "Sofia", 22.3);
        TRANSACTIONS.add(third);
        assertTrue(TRANSACTIONS.contains(third));
    }

    @Test
    public void when_containsByID() {
        assertTrue(TRANSACTIONS.contains(1));
    }

    @Test
    public void when_NotContainsByID() {
        assertFalse(TRANSACTIONS.contains(11));
    }

    @Test
    public void when_containsByInstance() {
        Transaction third = new TransactionImpl(3, TransactionStatus.FAILED, "Novi pazar", "Sofia", 22.3);
        TRANSACTIONS.add(third);
        assertTrue(TRANSACTIONS.contains(third));
    }

    @Test
    public void when_NotContainsByInstance() {
        Transaction third = new TransactionImpl(3, TransactionStatus.FAILED, "Novi pazar", "Sofia", 22.3);
        assertFalse(TRANSACTIONS.contains(third));
    }

    @Test
    public void when_changeTransactionStatusByID() {
        Transaction third = new TransactionImpl(3, TransactionStatus.FAILED, "Novi pazar", "Sofia", 22.3);
        TRANSACTIONS.add(third);
        TRANSACTIONS.changeTransactionStatus(3, TransactionStatus.SUCCESSFUL);
        assertEquals(third.getStatus().toString(), TransactionStatus.SUCCESSFUL.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_changeTransactionStatusByIDFails() {
        TRANSACTIONS.changeTransactionStatus(32, TransactionStatus.SUCCESSFUL);

    }

    @Test
    public void when_getByID() {
        Transaction third = new TransactionImpl(3, TransactionStatus.FAILED, "Novi pazar", "Sofia", 22.3);
        TRANSACTIONS.add(third);
        Transaction result = TRANSACTIONS.getById(3);
        assertEquals(third, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_getByIDFails() {
        TRANSACTIONS.getById(42);
    }

    @Test
    public void when_removeTransactionByID() {
        TRANSACTIONS.removeTransactionById(1);
        boolean contains = TRANSACTIONS.contains(1);
        assertFalse(contains);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_removeTransactionByIDFails() {
        TRANSACTIONS.removeTransactionById(14);
    }

    @Test
    public void when_getByTransactionStatusInDescendingOrderOfAmount() {
        Transaction third = new TransactionImpl(3, TransactionStatus.ABORTED, "Novi pazar", "Sofiaqw", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.ABORTED, "Novi pazsaar", "Soefia", 1);
        Transaction fifth = new TransactionImpl(5, TransactionStatus.ABORTED, "Novi pazaasfr", "faSofia", 12);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        TRANSACTIONS.add(fifth);
        List<Transaction> sortedAndFiltered = (List<Transaction>) TRANSACTIONS.getByTransactionStatus(TransactionStatus.ABORTED);
        List<Transaction> expectedList = new ArrayList<>();
        expectedList.add(third);
        expectedList.add(fifth);
        expectedList.add(fourth);
        for (int i = 0; i <= expectedList.size() - 1; i++) {
            assertEquals(expectedList.get(i), sortedAndFiltered.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_getByTransactionStatusInDescendingOrderOfAmountFails() {
        List<Transaction> sortedAndFiltered = (List<Transaction>) TRANSACTIONS.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void when_getAllSendersWithTransactionStatus() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Novi pazar", "Sofiaqw", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Novi pazar", "Soefia", 1);
        Transaction fifth = new TransactionImpl(5, TransactionStatus.ABORTED, "Novi pazarFails", "faSofia", 12);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        TRANSACTIONS.add(fifth);
        List<String> sortedAndFiltered = (List<String>) TRANSACTIONS.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Novi pazar");
        expectedList.add("Novi pazar");
        expectedList.add("Varna");
        for (int i = 0; i <= expectedList.size() - 1; i++) {
            assertEquals(expectedList.get(i), sortedAndFiltered.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_getAllSendersWithTransactionStatusFails() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Novi pazar", "Sofiaqw", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Novi pazar", "Soefia", 1);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        List<String> sortedAndFiltered = (List<String>) TRANSACTIONS.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }
    @Test
    public void when_getAllReceiversWithTransactionStatus() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Novi pazar", "Sofiaqw", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Novi pazar", "Soefia", 1);
        Transaction fifth = new TransactionImpl(5, TransactionStatus.ABORTED, "Novi pazarFails", "faSofia", 12);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        TRANSACTIONS.add(fifth);
        List<String> sortedAndFiltered = (List<String>) TRANSACTIONS.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> expected = TRANSACTIONS.transactions.values().stream().filter(s -> s.getStatus().toString().equals(TransactionStatus.SUCCESSFUL.toString())).sorted((s1,s2)->Double.compare(s1.getAmount(), s2.getAmount())).map(s->s.getTo()).collect(Collectors.toList());
        assertEquals(expected,sortedAndFiltered);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_getAllReceiversWithTransactionStatusFails() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Novi pazar", "Sofiaqw", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Novi pazar", "Soefia", 1);
        Transaction fifth = new TransactionImpl(5, TransactionStatus.ABORTED, "Novi pazarFails", "faSofia", 12);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        TRANSACTIONS.add(fifth);
        List<String> sortedAndFiltered = (List<String>) TRANSACTIONS.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void when_getAllOrderedByAmountDescendingThenById() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Novi pazar", "Sofiaqw", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Novi pazar", "Soefia", 23);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        List<Transaction> sorted = (List<Transaction>) TRANSACTIONS.getAllOrderedByAmountDescendingThenById();
        List<Transaction> expected = TRANSACTIONS.transactions.values().stream().sorted((s1, s2) -> {
            if (s1.getAmount() == s2.getAmount()) {
                return Integer.compare(s1.getId(), s2.getId());
            }
            return Double.compare(s2.getAmount(), s1.getAmount());
        })
                .collect(Collectors.toList());
        assertEquals(expected, sorted);
    }

    @Test
    public void when_getBySenderOrderedByAmountDescending() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Novi pazar", "Sofiaqw", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Novi pazar", "Soefia", 1);
        Transaction fifth = new TransactionImpl(5, TransactionStatus.ABORTED, "Novi pazarFails", "faSofia", 12);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        TRANSACTIONS.add(fifth);
        List<Transaction> sorted = (List<Transaction>) TRANSACTIONS.getBySenderOrderedByAmountDescending("Novi pazar");
        List<Transaction> expected = TRANSACTIONS.transactions.values().stream().filter(s1 -> s1.getFrom().toString().equals("Novi pazar")).sorted((s1, s2) -> Double.compare(s2.getAmount(), s1.getAmount()))
                .collect(Collectors.toList());
        assertEquals(expected, sorted);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_getBySenderOrderedByAmountDescendingFails() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Novi pazar", "Sofiaqw", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Novi pazar", "Soefia", 1);
        Transaction fifth = new TransactionImpl(5, TransactionStatus.ABORTED, "Novi pazarFails", "faSofia", 12);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        TRANSACTIONS.add(fifth);
        List<Transaction> sorted = (List<Transaction>) TRANSACTIONS.getBySenderOrderedByAmountDescending("Fail");
    }

    @Test
    public void when_getByReceiverOrderedByAmountThenById() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krio", "Sofia", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "belograd", "Sofia", 23);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        List<Transaction> sorted = (List<Transaction>) TRANSACTIONS.getByReceiverOrderedByAmountThenById("Sofia");
        List<Transaction> expected = TRANSACTIONS.transactions.values().stream().filter(s1 -> s1.getTo().equals("Sofia")).sorted((s1, s2) -> {
            if (s1.getAmount() == s2.getAmount()) {
                return Integer.compare(s1.getId(), s2.getId());
            }
            return Double.compare(s2.getAmount(), s1.getAmount());
        })
                .collect(Collectors.toList());
        assertEquals(expected, sorted);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_getByReceiverOrderedByAmountThenByIdFails() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krio", "SofiaFail", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "belograd", "Sofia", 23);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        List<Transaction> sorted = (List<Transaction>) TRANSACTIONS.getByReceiverOrderedByAmountThenById("kiustendil");

    }

    @Test
    public void when_getByTransactionStatusAndMaximumAmount() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krio", "SofiaFail", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "belograd", "Sofia", 22.99999);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        List<Transaction> sorted = (List<Transaction>) TRANSACTIONS.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 23);
        List<Transaction> expected = TRANSACTIONS.transactions.values().stream().filter(s1 -> {
            if (s1.getStatus().toString().equals(TransactionStatus.SUCCESSFUL.toString()) && s1.getAmount() <= 23) {
                return true;
            }
            return false;
        }).sorted((s1, s2) -> {
            return Double.compare(s2.getAmount(), s1.getAmount());
        }).collect(Collectors.toList());
        assertEquals(expected, sorted);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_getByTransactionStatusAndMaximumAmountFails() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krio", "SofiaFail", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "belograd", "Sofia", 22.99999);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        List<Transaction> sorted = (List<Transaction>) TRANSACTIONS.getByTransactionStatusAndMaximumAmount(TransactionStatus.UNAUTHORIZED, 23);

    }

    @Test
    public void when_getBySenderAndMinimumAmountDescending() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Varna", "SofiaFail", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Varna", "Sofia", 22.99999);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        List<Transaction> sorted = (List<Transaction>) TRANSACTIONS.getBySenderAndMinimumAmountDescending("Varna",22);
        List<Transaction> expected = TRANSACTIONS.transactions.values().stream().filter(s1 -> {
            if (s1.getFrom().equals("Varna") && s1.getAmount()>22) {
                return true;
            }
            return false;
        }).sorted((s1, s2) -> {
            return Double.compare(s2.getAmount(), s1.getAmount());
        }).collect(Collectors.toList());
        assertEquals(expected, sorted);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_getBySenderAndMinimumAmountDescendingFails() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Varna", "SofiaFail", 23);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Varna", "Sofia", 22.99999);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        List<Transaction> sorted = (List<Transaction>) TRANSACTIONS.getBySenderAndMinimumAmountDescending("Varna",134.31);
    }
    @Test
    public void when_getByReceiverAndAmountRange() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krio", "Sofia", 22.3);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "belograd", "Sofia", 23);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        List<Transaction> sorted = (List<Transaction>) TRANSACTIONS.getByReceiverAndAmountRange("Sofia",22.3,134.31);
        List<Transaction> expected = TRANSACTIONS.transactions.values().stream().filter(s1 -> {
          boolean checker=s1.getTo().equals("Sofia")&&s1.getAmount()>=22.3&&s1.getAmount()<134.31;
          if (checker){
              return true;
          }
          return false;
        }).sorted((s1, s2) -> {
            if (s1.getAmount() == s2.getAmount()) {
                return Integer.compare(s1.getId(), s2.getId());
            }
            return Double.compare(s2.getAmount(), s1.getAmount());
        })
                .collect(Collectors.toList());
        assertEquals(expected, sorted);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_getByReceiverAndAmountRangeFails() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krio", "Varna", 22.3);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "belograd", "Sofia", 23);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        List<Transaction> sorted = (List<Transaction>) TRANSACTIONS.getByReceiverAndAmountRange("Varna",1,22.3);

    }
    @Test
    public void when_getAllInAmountRange() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krio", "Varna", 22.3);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "belograd", "Sofia", 23);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        List<Transaction> sorted = (List<Transaction>) TRANSACTIONS.getAllInAmountRange(23,134.31);
        List<Transaction> expected = TRANSACTIONS.transactions.values().stream().filter(s1 -> {
            boolean checker=s1.getAmount()>=23&&s1.getAmount()<=134.31;
            if (checker){
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        assertEquals(expected, sorted);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_getAllInAmountRangeFails() {
        Transaction third = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krio", "Varna", 22.3);
        Transaction fourth = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "belograd", "Sofia", 23);
        TRANSACTIONS.add(third);
        TRANSACTIONS.add(fourth);
        List<Transaction> sorted = (List<Transaction>) TRANSACTIONS.getAllInAmountRange(-1,22);

    }
}