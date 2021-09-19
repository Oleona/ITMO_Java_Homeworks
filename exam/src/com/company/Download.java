package com.company;

import java.io.*;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.util.List;

public class Download extends Thread {
    String url;
    List<String> outFiles;
    private String arg;

    public Download(String url, List<String> outFiles, String argument) {
        this.url = url;
        this.outFiles = outFiles;
        this.arg = argument + "/";
    }

    public void run() {
        System.out.println("Загружается файл: " + outFiles.get(0) + " потоком "  + Thread.currentThread().getId());
        File folder = new File(arg);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        long startFileTime = System.nanoTime();

        try {
            URL urlConnect = new URL(url);
            InputStream in = new BufferedInputStream(urlConnect.openStream());
            FileOutputStream out = new FileOutputStream(arg + outFiles.get(0));
            byte[] buffer = new byte[1024];
            while(in.read(buffer) != -1) {
                out.write(buffer);
            }
            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < outFiles.size(); i++) {
            File source = new File(arg + outFiles.get(0));
            File dest = new File(arg + outFiles.get(i));
            try {
                Files.copy(source.toPath(), dest.toPath());
            } catch (FileAlreadyExistsException e){
                System.out.println("Файл с таким адресом уже скачан, сохранили с другим именем");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("Completed: " + Thread.currentThread().getId());
        long timeFile = ((System.nanoTime() - startFileTime)/ 1000000);
        // System.out.println(timeFile);
        double sec = ((timeFile / 1000.0) % 60);
        //System.out.printf("%.4f",seconds);
        double size = 0;
        File file = new File(arg + outFiles.get(0));
        if (file.exists()){
            size = (double) (((file.length() / 1024) * outFiles.size()))/ 1024;
                //System.out.println("Загружается файл : " + outFiles.get(0));
                System.out.printf("Файл " + outFiles.get(0) + " загружен: %.4f MB" + " за " + sec + " секунд\n", size );
            }
        Parser.sizeAll+=size;
        //System.out.println(Parser.sizeAll);
        Parser.secAll+=sec;
        }

    }

