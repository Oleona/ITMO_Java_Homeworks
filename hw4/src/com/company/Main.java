package com.company;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        findLongestString();
        IsWordPalindrome("level");
        replaceByaka("Борис Заходер\n" +
                "Приятная встреча\n" +
                "Встретились Бяка и Бука.\n" +
                "Никто не издал ни звука.\n" +
                "Никто не подал и знака —\n" +
                "Молчали Бука и Бяка.\n" +
                "\n" +
                "И Бука\n" +
                "Думал со скукой:\n" +
                "«Чего он так смотрит — букой?»\n" +
                "А Бяка думал:\n" +
                "«Однако\n" +
                "Какой он ужасный\n" +
                "Бяка…»");

        findSubstringOccurrences("— Что такое красота? \n" +
                "— Это дом, где два кота. \n" +
                "— Что такое теснота? \n" +
                "— Это дом, где три кота. \n" +
                "- Что такое чистота? \n" +
                "- Это дом, где нет кота.\n" +
                "— Что такое пустота? \n" +
                "— Дом, где был — и нет кота.", "кот");

        invertWords("This is a test string");
       

    }

    // 1. Написать метод для поиска самой длинной строки.
    // Предположила, что строка это слово, а не фраза
    public static void findLongestString() {

        String[] animal = {"cat", "dog", "cow", "horse", "elephant", "rhino", "antelope", "macaque", "tiger", "kangaroo"};
        String longest1 = " ";
        String longest2 = " ";
        for (String animals : animal) {
            if (animals.length() > longest1.length()) {
                longest1 = animals;
            }
        }
        for (String animals : animal) {
            if (animals.length() == longest1.length() && !(animals.equalsIgnoreCase(longest1))) {
                //longest2=longest2.concat(animals);
                //longest2=animals;
                longest2 = String.join(" ", longest2, animals);
            }
        }
        System.out.println("First longest string: " + longest1);
        System.out.println("Strings have the same length: " + longest2);

    }
//2. Написать метод, который проверяет является ли слово палиндромом.

    public static void IsWordPalindrome(String test) {
        System.out.println("------------------------------------");
        StringBuilder stringBuilder = new StringBuilder(test);
        //Приходится переводить в строку, так как у нее есть метод сравнения без учета регистра
        String one = stringBuilder.reverse().toString();
        ;
        if (one.equalsIgnoreCase(test)) {
            System.out.println("This word " + test + " is palindrome");
        } else {
            System.out.println("This word " + test + " is  NOT a palindrome");
        }

    }

    //3. Напишите метод, заменяющий в тексте все вхождения слова «бяка» на «[вырезано цензурой]».
    public static void replaceByaka(String text) {
        System.out.println("------------------------------------");
        String input = text;
        String myStr = input.replaceAll("(\\w*)Бяка(\\w*)", "«[вырезано цензурой]»");
        System.out.println(myStr);

    }

    //4. Имеются две строки. Найти количество вхождений одной (являющейся подстрокой) в другую.
    public static void findSubstringOccurrences(String testString, String substring) {
        System.out.println("------------------------------------");
        String input = testString;
        int count = 0;
        Pattern pattern = Pattern.compile(substring);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            count++;
        }
        System.out.println("количество вхождений подстроки " + substring + " равно " + count);

    }

    //5. Напишите метод, который инвертирует слова в строке. D строке нет знаков препинания, и слова разделены пробелами.
    public static void invertWords(String testText){
        System.out.println("------------------------------------");
        StringBuilder strBuilder = new StringBuilder(testText);
        strBuilder.reverse();

        String[] words = strBuilder.toString().split(" ");
        for(String word : words){
        }
        strBuilder.setLength(0);
        for(int i=words.length-1;i>=0;i--){
            strBuilder.append(words[i]);
            strBuilder.append(" ");
        }
        System.out.println(strBuilder.toString());
    }

}



