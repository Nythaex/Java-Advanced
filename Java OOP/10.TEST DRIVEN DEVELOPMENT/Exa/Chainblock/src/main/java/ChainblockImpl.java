import java.util.*;
import java.util.stream.Collectors;


public class ChainblockImpl implements Chainblock {
    Map<Integer, Transaction> transactions;


    public ChainblockImpl() {
        this.transactions = new HashMap<>();
    }

    public int getCount() {
        return transactions.size();
    }

    public void add(Transaction transaction) {
        this.transactions.put(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        Transaction n = transactions.values().stream().filter(s -> s.getId() == transaction.getId()).findFirst().orElse(null);
        return n != null;
    }

    public boolean contains(int id) {
        Transaction n = transactions.values().stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        return n != null;
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        getById(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        transactions.remove(id);
    }

    public Transaction getById(int id) {
        Transaction n = transactions.values().stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        if (n == null) {
            throw new IllegalArgumentException();
        }
        return n;
    }


    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> n = transactions.values().stream().filter(s -> s.getStatus().toString().equals(status.toString())).sorted((s1, s2) -> Double.compare(s2.getAmount(), s1.getAmount())).collect(Collectors.toList());
        if (n.size()==0) {
            throw new IllegalArgumentException();
        }
        return n;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> checkedStatus = transactions.values().stream().filter(s -> s.getStatus().toString().equals(status.toString())).sorted((s1,s2)->Double.compare(s1.getAmount(), s2.getAmount())).map(s->s.getFrom()).collect(Collectors.toList());
        if (checkedStatus.size()==0) {
            throw new IllegalArgumentException();
        }
        return checkedStatus;

    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> checkedStatus = transactions.values().stream().filter(s -> s.getStatus().toString().equals(status.toString())).sorted((s1,s2)->Double.compare(s1.getAmount(), s2.getAmount())).map(s->s.getTo()).collect(Collectors.toList());
        if (checkedStatus.size()==0) {
            throw new IllegalArgumentException();
        }
        return checkedStatus;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        List<Transaction> expected =  transactions.values().stream().sorted((s1,s2)->{
            if (s1.getAmount()==s2.getAmount()){
                return Integer.compare(s1.getId(), s2.getId());
            }
            return Double.compare(s2.getAmount(), s1.getAmount());
        })
                .collect(Collectors.toList());
        return expected;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> expected = transactions.values().stream().filter(s1->s1.getFrom().toString().equals(sender)).sorted((s1,s2)->Double.compare(s2.getAmount(), s1.getAmount()))
                .collect(Collectors.toList());
        if(expected.size()==0){
            throw new IllegalArgumentException();
        }
        return expected;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> expected =transactions.values().stream().filter(s1->s1.getTo().equals(receiver)).sorted((s1,s2)->{
            if (s1.getAmount()==s2.getAmount()){
                return Integer.compare(s1.getId(), s2.getId());
            }
            return Double.compare(s2.getAmount(), s1.getAmount());
        })
                .collect(Collectors.toList());
        if (expected.size()==0){
            throw new IllegalArgumentException();
        }

        return expected;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> expected = transactions.values().stream().filter(s1->{
            if (s1.getStatus().toString().equals(status.toString())&&s1.getAmount()<=amount){
                return true;
            }
            return  false;
        }).sorted((s1,s2)->{
            return Double.compare(s2.getAmount(), s1.getAmount());
        }).collect(Collectors.toList());
        if (expected.size()==0){
            throw new IllegalArgumentException();
        }
        return expected;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> expected = transactions.values().stream().filter(s1 -> {
            if (s1.getFrom().equals(sender) && s1.getAmount()>amount) {
                return true;
            }
            return false;
        }).sorted((s1, s2) -> {
            return Double.compare(s2.getAmount(), s1.getAmount());
        }).collect(Collectors.toList());
        if (expected.size()==0){
            throw new IllegalArgumentException();
        }
        return expected;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> expected =transactions.values().stream().filter(s1 -> {
            boolean checker=s1.getTo().equals(receiver)&&s1.getAmount()>=lo&&s1.getAmount()<hi;
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
        if (expected.size()==0){
            throw new IllegalArgumentException();
        }
        return expected;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> expected = transactions.values().stream().filter(s1 -> {
            boolean checker=s1.getAmount()>=lo&&s1.getAmount()<=hi;
            if (checker){
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        if (expected.size()==0){
            throw new IllegalArgumentException();
        }
        return expected;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
