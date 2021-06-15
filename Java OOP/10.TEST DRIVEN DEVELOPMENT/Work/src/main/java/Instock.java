import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private Map<String, Product> products = new LinkedHashMap<>();

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public boolean contains(Product product) {
        return products.containsKey(product.label);
    }

    @Override
    public void add(Product product) {
        products.put(product.label, product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        if (products.containsKey(product)) {
            products.get(product).setQuantity(quantity);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Product find(int index) {
        List<Product> products = new LinkedList<>(this.products.values());
        if (products.size() > index) {
            return products.get(index);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Product findByLabel(String label) {
        if (products.containsKey(label)) {
            return products.get(label);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count>products.size()||count<products.size()){
         return new ArrayList<>();
        }
        return products.values().stream().sorted((s1,s2)->s1.label.compareTo(s2.label)).limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lower, double higher) {
        return products.values().stream().filter(s->s.price>lower&&s.price<=higher).sorted((s1,s2)->s1.label.compareTo(s2.label)).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return products.values().stream().filter(s->s.price==price).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count>products.size()){
            throw new IllegalArgumentException();
        }
        return  products.values().stream().sorted((s1,s2)->Double.compare(s2.price, s1.getPrice())).limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return products.values().stream().filter(s->s.quantity==quantity).collect(Collectors.toList());
    }

}
