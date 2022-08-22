import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumProducts = 0;
        String[] products = {"Хлеб", "Яблоки", "Молоко", "Сахар"}; // товары
        int[] prices = {50, 100, 200, 70}; // цена
        System.out.println("Список товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " цена = " + prices[i] + " руб./шт.");
        }
        int[] amountProduct = new int[products.length];
        int productNumber = 0;
        int productCount = 0;
        while (true) {
            System.out.println("Выберите товар и количество или введите 'end'");
            String = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            try {
                String[] parts = input.split(" ");
                if (parts.length != 2) {
                    System.out.println("Вы неправильно ввели номер товара и количество, " +
                            "надо вводить две цифры через пробел");
                    continue;
                }
                productNumber = Integer.parseInt(parts[0]) - 1; //ввод товара
                if ((productNumber + 1) > products.length || (productNumber + 1) <= 0) {
                    System.out.println("Вы вышли из списка подуктов, надо от 1 до " + products.length);
                    continue;
                }
                productCount = Integer.parseInt(parts[1]); // ввод количества товара
                if (productCount == 0) {
                    amountProduct[productNumber] = 0;
                }
                // System.out.println("Вы ввели отрицательное количество продукта, надо > 0");
                // continue;
                //}
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода символов, надо цифрами вводить");
                continue;
            }

            // текущая цена на товар
            amountProduct[productNumber] += productCount; // сумма введеного кол. продукта
        }

        //int currentPrice = prices[productNumber];

        for (int i = 0; i < products.length; i++) {
            if (amountProduct[i] < 0) {
                amountProduct[i] = 0;
            }
            int sumP = amountProduct[i] * prices[i]; // цена за один вид товара
            sumProducts += sumP;
        }// цена за все товары

        System.out.println("Ваша корзина:");
        for (int i = 0; i < products.length; i++) {
            if (amountProduct[i] > 0) {
                System.out.println(products[i] + " " + amountProduct[i] + " шт. " +
                        prices[i] + " руб/шт " + amountProduct[i] * prices[i] + " руб. в сумме");
            }
        }
        System.out.println("Итого: " + sumProducts + " руб.");
        System.out.println("До свидания! Ждём вас снова!");

    }
}
