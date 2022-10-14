import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParserService {

   static class CurrentylyRaid {

       CurrentylyRaid() throws IOException {
       }

        static FinanceUaRepositories financeUaRepositories = new FinanceUaRepositories();
        static Document doc;

    static {
     try {
      doc = FinanceUaRepositories.getPage();
     } catch (IOException e) {
      throw new RuntimeException(e);
     }
    }

    static Elements tables1 = doc.getElementsByTag("tbody");
        static  Element tableChange = tables1.get(0);
        static Elements elementsFromTable = tableChange.children();
        static Element dollar = elementsFromTable.get(0);
        static Elements dollarElements = dollar.children();

        static String usdBuy = dollarElements.select("td[class=c2]").text();
        static String usdSell = dollarElements.select("td[class=c3]").text();

        static Element euro = elementsFromTable.get(2);
        static Elements euroElements = euro.children();

        static String euroBuy = euroElements.select("td[class=c2]").text();
        static String euroSell = euroElements.select("td[class=c3]").text();


    }
}
