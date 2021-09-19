package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    Map<String, List<String>> map = new HashMap<>();
    static double sizeAll=0; // в методе main было не объявить статическую переменную, поэтому объявила здесь
    static double secAll=0;
    // накапливает общий размер скачанных файлов
    public List<String> parse(String dir) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(dir)));
        String line = bufferedReader.readLine();
        while (line != null){
            list.add(line);
            line = bufferedReader.readLine();
        }
        return list;
    }

    public void workWithMap(List<String> list){
        for (int i = 0; i < list.size(); i++){
            String[] str = list.get(i).split(" ");
            if (!map.containsKey(str[0])){
                map.put(str[0], new ArrayList<>());
            }
            map.get(str[0]).add(str[1]);

        }
      //  map.forEach((key, value) -> {
       //    System.out.println(key + " == " + value);
       // });
    }
}
