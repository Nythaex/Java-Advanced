import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static junit.framework.Assert.*;


public class InstockTest {
    private Instock INSTOCK;

    @Before
    public void setUp() {
        INSTOCK = new Instock();
        INSTOCK.add(new Product("label_3", 122.23, 41));
        INSTOCK.add(new Product("label_1", 122.23, 14));
        INSTOCK.add(new Product("label_2", 0.23, 1));
    }

    @Test
    public void when_AddTwoElements() {

        assertEquals(3, INSTOCK.getCount());
    }

    @Test
    public void when_getCountWithZeroElements() {
        INSTOCK = new Instock();
        int count = INSTOCK.getCount();
        assertEquals(count, 0);
    }

    @Test
    public void when_getCountWithTwoElements() {
        int count = INSTOCK.getCount();
        assertEquals(count, 3);
    }

    @Test
    public void when_TryToFindDoesMapContainsKey() {
        INSTOCK.add(new Product("label_1", 0.23, 2));
        boolean contains = INSTOCK.contains(new Product("label_1", 0.23, 2));
        assertTrue(contains);
    }

    @Test
    public void when_TryToFindDoesMapContainsKeyFails() {
        boolean contains = INSTOCK.contains(new Product("label_21", 0.23, 2));
        assertFalse(contains);
    }

    @Test
    public void when_TryToFindProductByIndex() {
        Product first = new Product("label_3", 122.23, 41);

        INSTOCK.add(first);
        Product foundOne = INSTOCK.find(0);
        assertEquals(first, foundOne);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void when_TryToFindProductByIndexFails() {

        Product foundOne = INSTOCK.find(5);

    }

    @Test
    public void when_ChangeQuantityCorrectly() {
        INSTOCK.changeQuantity("label_1", 23);
        assertEquals(INSTOCK.find(1).quantity, 23);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_ChangeQuantityCorrectlyFails() {
        INSTOCK.changeQuantity("label_23", 23);

    }

    @Test
    public void when_TryToFindDoesMapContainsLabel() {
        Product first = new Product("label_3", 12.23, 4);
        INSTOCK.add(first);
        Product productByLabel = INSTOCK.findByLabel("label_3");
        assertEquals(first, productByLabel);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_TryToFindDoesMapContainsLabelFails() {
        Product first = new Product("label_3", 12.23, 4);
        INSTOCK.add(first);
        Product productByLabel = INSTOCK.findByLabel("label_23");

    }

    @Test
    public void when_GetFirst3ElementsByAlphabeticLabel() {

        Iterable<Product> elements = INSTOCK.findFirstByAlphabeticalOrder(3);
        List<Product> products = new ArrayList<>();
        List<String> productsNames = new ArrayList<>();
        elements.forEach(products::add);
        elements.forEach(s -> {
            productsNames.add(s.label);
        });
        for (int i = 0; i <= products.size() - 1; i++) {
            assertEquals(products.get(i).label, productsNames.get(i));
        }
    }

    @Test
    public void when_GetEmptyCollectionTryingToGet3Elements() {

        Iterable<Product> elements = INSTOCK.findFirstByAlphabeticalOrder(5);
        List<Product> products = new ArrayList<Product>();
        elements.forEach(products::add);
        assertTrue(products.isEmpty());
    }

    @Test
    public void when_getAllProductsInPriceRange() {

        Iterable<Product> elements = INSTOCK.findAllInRange(1, 122.23);
        List<Product> products = new ArrayList<>();
        List<String> productsNames = new ArrayList<>();
        elements.forEach(products::add);
        elements.forEach(s -> {
            productsNames.add(s.label);
        });
        for (int i = 0; i <= products.size() - 1; i++) {
            assertEquals(products.get(i).label, productsNames.get(i));
        }
    }

    @Test
    public void when_getAllProductsInPriceRangeWillReturnEmptyCollection() {

        Iterable<Product> elements = INSTOCK.findAllInRange(122.23, 10000);
        List<Product> products = new ArrayList<Product>();
        elements.forEach(products::add);
        assertTrue(products.isEmpty());
    }

    @Test
    public void when_getAllProductsWithGivenPrice() {

        Iterable<Product> elements = INSTOCK.findAllByPrice(122.23);
        List<Product> products = new ArrayList<>();
        List<String> productsNames = new ArrayList<>();
        elements.forEach(products::add);
        elements.forEach(s -> {
            productsNames.add(s.label);
        });
        for (int i = 0; i <= products.size() - 1; i++) {
            assertEquals(products.get(i).label, productsNames.get(i));
        }
    }

    @Test
    public void when_getAllProductsWithGivenPriceWillReturnEmptyCollection() {

        Iterable<Product> elements = INSTOCK.findAllByPrice(999);
        List<Product> products = new ArrayList<Product>();
        elements.forEach(products::add);
        assertTrue(products.isEmpty());
    }

    @Test
    public void when_GetFirst3ProductsWithHighestPrice() {

        Iterable<Product> elements = INSTOCK.findFirstMostExpensiveProducts(2);
        List<Product> products = new ArrayList<>();
        List<String> productsNames = new ArrayList<>();
        elements.forEach(products::add);
        elements.forEach(s -> {
            productsNames.add(s.label);
        });
        for (int i = 0; i <= products.size() - 1; i++) {
            assertEquals(products.get(i).label, productsNames.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_GetFirst3ProductsWithHighestPriceWillReturnEmptyCollection() {

        Iterable<Product> elements = INSTOCK.findFirstMostExpensiveProducts(4);

    }

    @Test
    public void when_findAllByQuantity() {

        Iterable<Product> elements = INSTOCK.findAllByQuantity(14);
        List<Product> products = new ArrayList<>();
        List<String> productsNames = new ArrayList<>();
        elements.forEach(products::add);
        elements.forEach(s -> {
            productsNames.add(s.label);
        });
        for (int i = 0; i <= products.size() - 1; i++) {
            assertEquals(products.get(i).label, productsNames.get(i));
        }
    }

    @Test
    public void when_findAllByQuantityWillReturnEmptyList() {
        Iterable<Product> elements = INSTOCK.findAllByQuantity(124);
        List<Product> products = new ArrayList<>();
        elements.forEach(products::add);
        assertTrue(products.isEmpty());
    }
    @Test
    public void when_getAllElements() {
    }
}