import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumProducts = 0;
        String[] products = {"Хлеб", "Яблоки", "Молоко", "Сахар", "Макароны"}; // товары
        String[] saleProducts = {"Гречка", "Йогурт", "Колбаса"}; // товары по акции "3 по цене 2х"
        int[] prices = {50, 100, 200, 70, 45, 80, 65, 290}; // цены товаров
        System.out.println("Список товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " цена = " + prices[i] + " руб./шт.");
        }
        System.out.println("Список товаров для покупки по акции: 3 по цене 2-х");
        for (int i = 0; i < saleProducts.length; i++) {
            System.out.println((i + 1 + products.length) + ". " + saleProducts[i]
                    + " цена = " + prices[i + products.length] + " руб./шт.");
        }
        int[] amountProduct = new int[products.length + saleProducts.length];
        int productNumber = 0;
        int productCount = 0;
        while (true) {
            System.out.println("Выберите товар и количество или введите 'end'");
            String input = scanner.nextLine();
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
                if ((productNumber + 1) > (products.length + saleProducts.length) || (productNumber + 1) <= 0) {
                    System.out.println("Вы вышли из списка подуктов, надо от 1 до " + (products.length + saleProducts.length));
                    continue;
                }
                productCount = Integer.parseInt(parts[1]); // ввод количества товара
                if (productCount < 0) {
                    System.out.println("Вы ввели отрицательное количество продукта, надо > 0");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода символов, надо цифрами вводить");
                continue;
            }

            int currentPrice = prices[productNumber]; // текущая цена на товар
            amountProduct[productNumber] += productCount; // сумма введеного кол. продукта
            if (productNumber > products.length && amountProduct[productNumber] == 3) { // условие: 3 по цене 2х
                int sumP = productCount * currentPrice - currentPrice; // цена за выбранное колличество продукта по акции
                sumProducts += sumP; // общая цена
            } else {
                int sumP = productCount * currentPrice; // цена за выбранное колличество продукта без акции
                sumProducts += sumP; // общая цена
            }
        }
        System.out.println("Ваша корзина:");
        for (int i = 0; i < products.length; i++) {
            if (amountProduct[i] != 0) {
                System.out.println(products[i] + " "
                        + amountProduct[i] + " шт. "
                        + prices[i] + " руб/шт "
                        + amountProduct[i] * prices[i] + " руб. в сумме");
            }
        }
        System.out.println("Товары по акции: 3 по цене 2х");
        for (int i = 0; i < saleProducts.length; i++) {
            if (amountProduct[i + products.length] != 0) {
                System.out.println(saleProducts[i] + " "
                        + amountProduct[i + products.length] + " шт. "
                        + prices[i + products.length] + " руб/шт "
                        + amountProduct[i + products.length] * prices[i + products.length] + " руб. в сумме");
            }
        }
        System.out.println("Итого: " + sumProducts + " руб.");
        System.out.println("До свидания! Ждём вас снова!");
    }
}
