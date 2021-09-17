package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        FrequencyDictionary();

        List<String> catBreeds = List.of("Mekong Bobtail", "Persian", "Abyssinian", "Somali", "Aegean", "Mekong Bobtail", "Balinese", "Abyssinian", "Bengal", "Mekong Bobtail", "Birman", "Bombay", "Burmese", "Balinese", "Somali", "Persian", "Cornish Rex", "Egyptian Mau", "Maine Coon", "Mekong Bobtail", "Bengal", "Persian", "Mekong Bobtail", "Ragdoll", "Siamese", "Siberian", "Persian", "Somali", "Mekong Bobtail");
        System.out.println(ReturnCollectionNoDuplicates(catBreeds));
        CompareTimeSelectedItems();
        PointsInTheGame();
        System.out.println("5. Метод получает на вход массив элементов типа К. Вернуть нужно объект Map<K, Integer>, где K — Значение из массива, а Integer\n" +
                "количество вхождений в массив:");
        Integer[] nums = {1, 2, 3, 5, 7, 12, 3, 5, 11, 1, 23, 2, 4, 5, 3, 7, 6, 4, 2, 1, 7, 7};
        String[] catsNames = {"Lans","Gosha","Malish","Zavka","Mario","Lanselot","Silva","Vens", "Rizii","Lans","Malish","Zavka"};
        System.out.println(arrayToMap(nums));
        System.out.println(arrayToMap(catsNames));

    }

    public static void FrequencyDictionary() throws IOException {
        System.out.println("1. Прочитать текст из файла и построить частотный словарь слов.\n" +
                "Выведете список слов (с частотами) упорядоченный по алфавиту.");
        BufferedReader reader = new BufferedReader(new FileReader("d:\\ITMO\\java\\Homeworks\\ITMO_Java_Homeworks\\hw12\\text.txt"));
        String line;
        List<String> lines1 = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines1.add(line);
        }
        String listString = String.join(", ", lines1);
        String[] words = listString.replaceAll("[^а-яА-Я ]", "").toLowerCase().split("\\s+");
        System.out.println(listString);
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        SortedMap<String, Integer> wordToCount = new TreeMap<>();
        for (String word : words) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }
        for (String word : wordToCount.keySet()) {
            System.out.println(word + " " + wordToCount.get(word));
        }
    }

    public static HashSet<String> ReturnCollectionNoDuplicates(List<String> collection) {
        System.out.println("2. Написать метод, который на входе получает коллекцию объектов, а возвращает коллекцию уже без дубликатов. ");
        return new HashSet<String>(collection);
    }

    public static void CompareTimeSelectedItems() {
        System.out.println("3. Напишите метод, который добавляет 1млн элементов в ArrayList и LinkedList. Напишите метод, " +
                "который выбирает из заполненного списка элемент наугад 100000 раз. Замерьте время, которое потрачено на это. " +
                "Сравните результаты, предположите, почему они именно такие.\n");


        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(random.nextInt(Integer.MAX_VALUE));
            linkedList.add(random.nextInt(Integer.MAX_VALUE));
        }
        long millis = System.nanoTime();
        ;
        for (int i = 0; i < 100000; i++) {
            arrayList.get((random.nextInt(1000000)));
        }
        System.out.println("Elapsed time in milliseconds for ArrayList: " + (System.nanoTime() - millis) / 1000000);
        millis = System.nanoTime();
        ;
        for (int i = 0; i < 1000; i++) {
            linkedList.get((random.nextInt(1000000)));
        }
        System.out.println("Elapsed time in milliseconds for LinkedList: " + (System.nanoTime() - millis) / 1000000);
        System.out.println("Выбор из LinkedList<>() происходит намного медленнее ( даже пришлось в задаче оставить тысячу вместо 100 тысяч," +
                " иначе не дождаться. Так происходит из-за того что LinkedList<>() это неиндексированная цепочка и операции доступа по индексу " +
                "производятся перебором с начала или конца  до нужного элемента. ");
    }

    static class User {

        private String name;

        public User(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof User)) {
                return false;
            }
            User user = (User) o;
            return user.name.equals(name);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }

    public static void PointsInTheGame() {
        System.out.println("4. Опишите класс User с одним полем name. Добавьте конструктор, сеттер и геттер.\n" +
                "\n" + "Создайте Map, в котором для каждого пользователя хранится количество очков, заработанных в какой-то игре \n" +
                "Напишите программу, которая считывает с консоли имя и показывает, сколько очков у такого пользователя. ");
        Map<User, Integer> users = new HashMap<User, Integer>();
        users.put(new User("Tom"), 12);
        users.put(new User("Mario"), 25);
        users.put(new User("Lans"), 27);
        users.put(new User("Inna"), 22);
        users.put(new User("Egor"), 29);
        users.put(new User("Nick"), 5);
        users.put(new User("Alice"), 11);
        //  for(Map.Entry< User,Integer> item : users.entrySet()){
        // System.out.printf("Key: %s  Value: %d \n", item.getKey().getName(), item.getValue());
        //  }
        System.out.println("Input name");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        int point = users.getOrDefault(new User(s), 0);
        System.out.println("Point of this user is:  " + point);

    }
    public static <K> Map<K, Integer> arrayToMap(K[] ks) {

        Map<K, Integer> map = new HashMap<>();
        Arrays.stream(ks).forEach(x -> map.put(x , map.computeIfAbsent(x, s -> 0) + 1));

        return map;
    }

}