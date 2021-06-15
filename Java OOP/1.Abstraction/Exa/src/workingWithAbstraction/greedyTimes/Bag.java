package workingWithAbstraction.greedyTimes;

import java.util.*;

public class Bag {
       public class compare implements Comparator<Map.Entry>{

           @Override
           public int compare(Map.Entry s1, Map.Entry s2) {
               if (s1.getKey().equals(s2.getKey())) {
                  return Long.compare(Long.parseLong(s1.getValue().toString()), Long.parseLong(s2.getValue().toString()));
               }
               return s2.getKey().toString().compareTo(s1.getKey().toString());
           }
       }

    private long capacity;
    private Long gold;
    private Map<String, Long> gems;
    private Map<String, Long> cash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.gems = new TreeMap<>();
        this.cash = new TreeMap<>();
        this.gold = null;

    }

    public void add(String type, long itemValue) {
        if (capacity >= (getGold() == null ? 0 : getGold()) + this.gems.values().stream().mapToLong(l -> l).sum() + this.cash.values().stream().mapToLong(l -> l).sum() + itemValue) {
            if (type.length() == 3) {
                addCash(itemValue, type);
            } else if (type.toLowerCase().endsWith("gem")) {
                addGems(itemValue, type);
            } else if (type.toLowerCase().equals("gold")) {
                addGold(itemValue);
            }
        }
    }

    private void addGold(long itemValue) {
        if (getGold() == null) {
            setGold(0l);
        }
        setGold(getGold() + itemValue);
    }

    private void addCash(long itemValue, String type) {
        if (getGems().values().stream().mapToLong(l -> l).sum() >= getCash().values().stream().mapToLong(l -> l).sum() + itemValue) {
            if (getCash().containsKey(type)) {
                getCash().put(type, getCash().get(type) + itemValue);
            } else {
                getCash().put(type, itemValue);
            }
        }
    }

    private void addGems(long itemValue, String type) {
        if ((getGold() == null ? 0 : getGold()) >= getGems().values().stream().mapToLong(l -> l).sum() + itemValue) {
            if (gems.containsKey(type)) {
                getGems().put(type, getGems().get(type) + itemValue);
            } else {
                getGems().put(type, itemValue);
            }
        }
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    public Map<String, Long> getGems() {
        return gems;
    }

    public void setGems(Map<String, Long> gems) {
        this.gems = gems;
    }

    public Map<String, Long> getCash() {
        return cash;
    }

    public void setCash(Map<String, Long> cash) {
        this.cash = cash;
    }

}
