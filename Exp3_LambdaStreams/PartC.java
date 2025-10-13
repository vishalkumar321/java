
import java.util.*;
import java.util.stream.*;
import java.util.Comparator;
import java.util.Map.Entry;

class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("Name: %-10s | Price: %-8.2f | Category: %s", name, price, category);
    }
}

public class PartC {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 80000, "Electronics"),
            new Product("Phone", 50000, "Electronics"),
            new Product("TV", 60000, "Electronics"),
            new Product("Shirt", 1500, "Clothing"),
            new Product("Jeans", 2500, "Clothing"),
            new Product("Blender", 3500, "Appliances"),
            new Product("Microwave", 7500, "Appliances")
        );

        System.out.println("All Products:");
        products.forEach(System.out::println);

        // Group products by category
        System.out.println("\n--- Products Grouped by Category ---");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        grouped.forEach((category, list) -> {
            System.out.println("\nCategory: " + category);
            list.forEach(System.out::println);
        });

        // Find the most expensive product in each category
        System.out.println("\n--- Most Expensive Product in Each Category ---");
        Map<String, Optional<Product>> maxByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));
        maxByCategory.forEach((category, prod) -> 
            System.out.println(category + " -> " + prod.get().getName() + " (" + prod.get().getPrice() + ")")
        );

        // Calculate average price of all products
        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));
        System.out.printf("\nAverage Price of All Products: %.2f\n", avgPrice);
    }
}
