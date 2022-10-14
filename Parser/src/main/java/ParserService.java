import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParserService {

   class currentylyRaid {

        FinanceUaRepositories financeUaRepositories = new FinanceUaRepositories();
        Document doc = financeUaRepositories.getPage();
        Elements tables_1 = doc.getElementsByTag("tbody");
        Element table_Change = tables_1.get(0);
        Elements elements_from_table = table_Change.children();
        Element dollar = elements_from_table.get(0);
        Elements dollar_elements = dollar.children();

        String UsdBuy = dollar_elements.select("td[class=c2]").text();
        String UsdSell = dollar_elements.select("td[class=c3]").text();

        Element euro = elements_from_table.get(2);
        Elements euro_elements = euro.children();

        String euroBuy = euro_elements.select("td[class=c2]").text();
        String euroSell = euro_elements.select("td[class=c3]").text();

        currentylyRaid() throws IOException {
        }
    }
}
