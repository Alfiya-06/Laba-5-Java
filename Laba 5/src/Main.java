import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задание 1. Работа с дробями");
        System.out.println("Введите числитель дроби:");
        int numerator = inputInt(scanner);
        System.out.println("Введите знаменатель дроби (не 0):");
        int denominator = inputNonZeroInt(scanner);

        Fraction fraction = new Fraction(numerator, denominator);
        System.out.println("Ваша дробь: " + fraction);
        System.out.println("Вещественное значение дроби: " + fraction.getDoubleValue());

        System.out.println("Задание 2. Кот мяукает");

        String name = null;
        while (name == null || name.trim().isEmpty()) {
            System.out.print("Введите имя кота: ");
            name = scanner.nextLine();
            if (name == null || name.trim().isEmpty()) {
                System.out.println("Ошибка: имя кота не может быть пустым. Попробуйте снова.");
            }
        }

        // Ввод количества мяуканий
        int count = -1;
        while (count <= 0) {
            System.out.print("Сколько раз кот должен мяукнуть? ");
            if (scanner.hasNextInt()) {
                count = scanner.nextInt();
                if (count <= 0) {
                    System.out.println("Ошибка: введите положительное число.");
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }

        Cat cat = new Cat(name);
        MeowCounter counter = new MeowCounter(cat);

        for (int i = 0; i < count; i++) {
            counter.meow();
        }
        System.out.println(counter);

        scanner.nextLine();

        // Задание 3. Слияние двух списков
        System.out.println("\nЗадание 3. Слияние упорядоченных списков L1 и L2");
        System.out.println("Введите элементы L1 через пробел (по возрастанию): ");
        List<Integer> L1 = readSortedList(scanner);
        System.out.println(L1);

        System.out.println("Введите элементы L2 через пробел (по возрастанию): ");
        List<Integer> L2 = readSortedList(scanner);
        System.out.println(L2);

        ListMerger merger = new ListMerger(L1, L2);
        merger.mergeIntoFirst();

        System.out.println(merger);


        System.out.println("Задание 5. Сколько разных русских букв в тексте?");

        String fileName = "C:/Users/aptra/IdeaProjects/MyFirstProject/Laba 5/src/text.txt";

        try {
            RussianLetter counters = new RussianLetter(fileName);
            counters.countLetters();

            System.out.println("Файл: " + fileName);
            System.out.println("Результат:");
            System.out.println(counters);

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        System.out.println("\nЗадание 6. Построение зеркальной очереди");

        System.out.println("Введите элементы списка через пробел: ");
        List<Integer> inputList = new ArrayList<>();
        while (inputList.isEmpty()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Ошибка: список не может быть пустым. Повторите ввод.");
                continue;
            }
            String[] parts = line.split("\\s+");
            try {
                for (String p : parts) {
                    inputList.add(Integer.parseInt(p));
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: в списке должны быть только числа. Попробуйте снова.");
                inputList.clear();
            }
        }

        QueueBuilder qb = new QueueBuilder(inputList);
        Queue<Integer> mirroredQueue = qb.buildMirroredQueue();

        System.out.println("Исходный список: " + inputList);
        System.out.println("Зеркальная очередь: " + mirroredQueue);



    }

    private static int inputInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите целое число.");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private static int inputNonZeroInt(Scanner scanner) {
        int value;
        do {
            value = inputInt(scanner);
            if (value == 0) System.out.println("Ошибка: число не может быть 0. Попробуйте снова.");
        } while (value == 0);
        return value;
    }

    // Метод чтения списка с проверкой
    private static List<Integer> readSortedList(Scanner scanner) {
        List<Integer> list = null;
        while (list == null) {
            try {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    System.out.println("Ошибка: строка пустая. Повторите ввод.");
                    continue;
                }
                list = new ArrayList<>();
                String[] parts = line.split("\\s+");

                for (String p : parts) {
                    list.add(Integer.parseInt(p));
                }

                // Проверка сортировки
                if (!isSorted(list)) {
                    System.out.println("Ошибка: список должен быть отсортирован по возрастанию!");
                    list = null;
                    continue;
                }

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: ввод содержит нечисловые данные. Повторите ввод.");
                list = null;
            }
        }
        return list;
    }

        // Проверка возрастания
        private static boolean isSorted (List < Integer > list) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < list.get(i - 1)) return false;
            }
            return true;
        }
    }