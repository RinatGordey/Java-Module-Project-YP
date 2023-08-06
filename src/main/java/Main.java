import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счет?");
        int numberOfPerson;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                numberOfPerson = scanner.nextInt();
                if (numberOfPerson == 1) {
                    System.out.println("Нет смысла делить счёт - оплатите его сами");
                    break;
                } else if (numberOfPerson > 1) {
                    break;
                } else if (numberOfPerson < 1) {
                    System.out.println("Это некорректное число - введите число человек снова");
                }
            }
        }
        while (true) {
            double totalPrice = 0;
            String productList = "";
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите название товара\nили \"Завершить\" в случае завершения: ");
            String productName = scanner.nextLine();

            while(!productName.equalsIgnoreCase("Завершить")) {
                System.out.print("Введите стоимость товара: ");
                double productPrice = scanner.nextDouble();

                if (productPrice > 0) {
                    Product product = new Product(productName, productPrice);
                    totalPrice += productPrice;
                    productList += product.nameProduct + ", ";
                }
                System.out.print("Введите название товара\nили \"Завершить\" в случае завершения: ");
                productName = scanner.next();
            }
            System.out.println("Добавленные продукты: " + productList);

            double amountPerPerson = totalPrice / numberOfPerson;

            Ruble ending = new Ruble();

            String conclusion = "Каждому человеку нужно заплатить: %.2f %s";
            System.out.println(String.format(conclusion, amountPerPerson, ending.ending(amountPerPerson)));
            break;
        }

    }
}