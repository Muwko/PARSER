package online.qastudy.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class FinanceUaRepositories {

    public static Document getSourceOfPage() throws IOException {
        String url = "https://finance.ua/ru/currency";
        return Jsoup.parse(new URL(url), 3000);
    }

}
