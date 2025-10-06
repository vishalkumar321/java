import java.util.*;

class Product {
    int id;
    int nameCode;
    double price;

    Product(int id, int nameCode, double price) {
        this.id = id;
        this.nameCode = nameCode;
        this.price = price;
    }

    void displayProductDetails() {
        System.out.println("Product ID: " + id);
        System.out.println("Product Name Code: " + nameCode);
        System.out.println("Product Price: ₹" + price);
    }
}

public class ProductMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        int nameCode = sc.nextInt();
        double price = sc.nextDouble();

        if (id <= 0 || price < 0) {
            System.out.println("Invalid Input");
            return;
        }

        Product p = new Product(id, nameCode, price);
        p.displayProductDetails();
    }
}
