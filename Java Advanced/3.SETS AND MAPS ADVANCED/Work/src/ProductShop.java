import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String, List<Product>> shops=new TreeMap<>();
        String command=scanner.nextLine();
        while (!command.equals("Revision")){
            String[] tokens=command.split(", ");
            String shop=tokens[0];
            String productName=tokens[1];
            double price=Double.parseDouble(tokens[2]);
            Product product=new Product(productName,price);
            List<Product> listOfProducts = shops.computeIfAbsent(shop, k -> new ArrayList<>());
            listOfProducts.add(product);
            command=scanner.nextLine();
        }
        for (Map.Entry<String, List<Product>> stringListEntry : shops.entrySet()) {
            System.out.println(stringListEntry.getKey()+"->");
            for (Product a:stringListEntry.getValue()
                 ) {
                System.out.printf("Product: %s, Price: %.1f%n",a.name,a.price);
            }
        }


    }
    static class Product{
        String name;
        double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
