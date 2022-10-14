import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class FinanceUaRepositories {

    public static Document getPage()throws IOException {
        String url = "https://finance.ua/ru/currency";
        return Jsoup.parse(new URL(url), 3000);
    }

}
