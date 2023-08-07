import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счет?");
        int numberOfPerson;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                numberOfPerson = scanner.nextInt();
                if (numberOfPerson == 1) {
                    System.out.println("Нет смысла делить счёт - оплатите его сами");
                    break;
                } else if (numberOfPerson > 1) {
                    break;
                } else if (numberOfPerson < 1) {
                    System.out.println("Это некорректное число - введите число человек снова");
                }
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели некорректное значение. Попробуйте снова");
            }
        }
        while (true) {
            double totalPrice = 0;
            String productList = "";
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите название товара\nили \"Завершить\" в случае завершения: ");
            String productName = scanner.nextLine();

                while(!productName.equalsIgnoreCase("Завершить")) {
                    if (productName.isEmpty()) {
                        System.out.println("Название товара не может быть пустым! Заполните поле: ");
                    } else {
                        System.out.print("Введите стоимость товара: ");
                        double productPrice;
                        try {
                            productPrice = scanner.nextDouble();
                            if (productPrice > 0) {
                                Product product = new Product(productName, productPrice);
                                totalPrice += productPrice;
                                productList += product.nameProduct + ", ";
                            } else {
                                System.out.println("Стоимость товара должна быть\nположительным числом. Заполните снова: ");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Вы ввели некорректное значение. Попробуйте снова: ");
                            scanner.nextLine();
                        }
                    }
                System.out.println("Введите название товара\nили \"Завершить\" в случае завершения: ");
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