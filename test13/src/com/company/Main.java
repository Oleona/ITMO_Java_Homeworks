package com.company;
import com.google.gson.*;
//import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Подскажите, пожалуйста, в чем ошибка. Gson установила. Файлы классов делались на https://www.jsonschema2pojo.org/
    //В итоге работы они все пустые, хотя джейсон ответ получаем нормальный. Пыталась работать с одной конкретной статьей, а не поиском всех- тоже самое


    public class Continue {

        @SerializedName("sroffset")
        @Expose
        private Integer sroffset;
        @SerializedName("continue")
        @Expose
        private String _continue;

        /**
         * No args constructor for use in serialization
         *
         */
        public Continue() {
        }

        /**
         *
         * @param _continue
         * @param sroffset
         */
        public Continue(Integer sroffset, String _continue) {
            super();
            this.sroffset = sroffset;
            this._continue = _continue;
        }

        public Integer getSroffset() {
            return sroffset;
        }

        public void setSroffset(Integer sroffset) {
            this.sroffset = sroffset;
        }

        public String getContinue() {
            return _continue;
        }

        public void setContinue(String _continue) {
            this._continue = _continue;
        }

    }
    public class Example {

        @SerializedName("batchcomplete")
        @Expose
        private String batchcomplete;
        @SerializedName("continue")
        @Expose
        private Continue _continue;
        @SerializedName("query")
        @Expose
        private Query query;

        /**
         * No args constructor for use in serialization
         *
         */
        public Example() {
        }

        /**
         *
         * @param _continue
         * @param batchcomplete
         * @param query
         */
        public Example(String batchcomplete, Continue _continue, Query query) {
            super();
            this.batchcomplete = batchcomplete;
            this._continue = _continue;
            this.query = query;
        }

        public String getBatchcomplete() {
            return batchcomplete;
        }

        public void setBatchcomplete(String batchcomplete) {
            this.batchcomplete = batchcomplete;
        }

        public Continue getContinue() {
            return _continue;
        }

        public void setContinue(Continue _continue) {
            this._continue = _continue;
        }

        public Query getQuery() {
            return query;
        }

        public void setQuery(Query query) {
            this.query = query;
        }

    }
    public class Query {

        @SerializedName("searchinfo")
        @Expose
        private Searchinfo searchinfo;
        @SerializedName("search")
        @Expose
        private List<Search> search = null;

        /**
         * No args constructor for use in serialization
         *
         */
        public Query() {
        }

        /**
         *
         * @param search
         * @param searchinfo
         */
        public Query(Searchinfo searchinfo, List<Search> search) {
            super();
            this.searchinfo = searchinfo;
            this.search = search;
        }

        public Searchinfo getSearchinfo() {
            return searchinfo;
        }

        public void setSearchinfo(Searchinfo searchinfo) {
            this.searchinfo = searchinfo;
        }

        public List<Search> getSearch() {
            return search;
        }

        public void setSearch(List<Search> search) {
            this.search = search;
        }

    }
    public class Search {

        @SerializedName("ns")
        @Expose
        private Integer ns;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("pageid")
        @Expose
        private Integer pageid;
        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("wordcount")
        @Expose
        private Integer wordcount;
        @SerializedName("snippet")
        @Expose
        private String snippet;
        @SerializedName("timestamp")
        @Expose
        private String timestamp;

        /**
         * No args constructor for use in serialization
         *
         */
        public Search() {
        }

        /**
         *
         * @param snippet
         * @param wordcount
         * @param size
         * @param ns
         * @param title
         * @param pageid
         * @param timestamp
         */
        public Search(Integer ns, String title, Integer pageid, Integer size, Integer wordcount, String snippet, String timestamp) {
            super();
            this.ns = ns;
            this.title = title;
            this.pageid = pageid;
            this.size = size;
            this.wordcount = wordcount;
            this.snippet = snippet;
            this.timestamp = timestamp;
        }

        public Integer getNs() {
            return ns;
        }

        public void setNs(Integer ns) {
            this.ns = ns;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getPageid() {
            return pageid;
        }

        public void setPageid(Integer pageid) {
            this.pageid = pageid;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public Integer getWordcount() {
            return wordcount;
        }

        public void setWordcount(Integer wordcount) {
            this.wordcount = wordcount;
        }

        public String getSnippet() {
            return snippet;
        }

        public void setSnippet(String snippet) {
            this.snippet = snippet;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

    }
    public class Searchinfo {

        @SerializedName("totalhits")
        @Expose
        private Integer totalhits;

        /**
         * No args constructor for use in serialization
         *
         */
        public Searchinfo() {
        }

        /**
         *
         * @param totalhits
         */
        public Searchinfo(Integer totalhits) {
            super();
            this.totalhits = totalhits;
        }

        public Integer getTotalhits() {
            return totalhits;
        }

        public void setTotalhits(Integer totalhits) {
            this.totalhits = totalhits;
        }

    }


    public static void main(String[] args) throws IOException {

        System.out.println("Input search query");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        String url = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=" + URLEncoder.encode(s, StandardCharsets.UTF_8);
        URLConnection connection = new URL(url).openConnection();
        //InputStream response = connection.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());


     // scanner = new Scanner(response);
       // String responseBody = scanner.useDelimiter("\\A").next();
       // System.out.println(response);
       // System.out.println(responseBody);

  String jsonString = response.toString();
       // System.out.println(jsonString);
        Gson g = new Gson();
     Query query = g.fromJson(jsonString, Query.class);
for (Search search:query.search) {
    System.out.println(search);
}


    }
}
