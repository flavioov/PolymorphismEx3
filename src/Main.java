import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);
        List<Product> products = new ArrayList<>();


        System.out.print("Enter the number of products: ");
        int numberOfProducts = input.nextInt();

        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println("Product #" + (i + 1) + " data");
            System.out.print("Common, used or imported (c/u/i)? ");
            input.nextLine();
            String ch = input.nextLine();

            System.out.print("Name: ");
            String productName = input.nextLine();

            System.out.print("Price: ");
            double productPrice = input.nextDouble();

            switch (ch) {
                case "i":
                    System.out.print("Custom fee: ");
                    Product imported = new ImportedProduct(
                            productName,
                            productPrice,
                            input.nextDouble());
                    products.add(imported);

                    break;
                case "c": {
                    Product common = new Product(
                            productName,
                            productPrice);
                    products.add(common);

                    break;
                }
                case "u": {
                    System.out.print("Manufacture date (DD/MM/YYYY): ");

                    Product common = new UsedProduct(
                            productName,
                            productPrice,
                            simpleDateFormat.parse(input.next()));

                    products.add(common);
                    break;
                }
            }

        }

        System.out.println("\nPRICE TAG:");
        for (Product product :
                products) {
            System.out.println(product.priceTag());
        }
        System.out.println();
    }
}

