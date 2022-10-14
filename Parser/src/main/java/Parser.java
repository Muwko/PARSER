import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.URL;
import java.io.IOException;


public class Parser {
   //private Document doc;

     private static Document getPage() throws IOException {
        String url = "https://finance.ua/ru/currency";
        return Jsoup.parse(new URL(url), 3000);
    }

    public static void main(String[] args) throws IOException {

        //Document doc = Jsoup.connect("https://finance.ua/ru/currency").get();
        FinanceUaRepositories financeUaRepositories = new FinanceUaRepositories();
        Document doc = financeUaRepositories.getPage();




        System.out.println("USD  " + ParserService.CurrentylyRaid.usdBuy + "   " + ParserService.CurrentylyRaid.usdSell );
        System.out.println("EURO " + ParserService.CurrentylyRaid.euroBuy + "   " + ParserService.CurrentylyRaid.euroSell);

    }
}







        /*
        //Налічний курс
        Elements tableCourse = page.select("table[class=b-market-table_currency-cash]");
        Elements names = tableCourse.select("tr[class=major]");
        Elements values = tableCourse.select("td[class=c2]");

        Elements namesEuro = tableCourse.select("tr[class=major major-last]");
        Elements valuesEuro = tableCourse.select("td[class=c2]");


        //M - Міняйло
        Elements tableCourseM = page.select("table[class=b-market-table_currency-order]");
        Elements namesM = tableCourse.select("tr[class=major]");
        Elements valuesM = tableCourse.select("td[class=c2]");

        Elements namesEuroM = tableCourse.select("tr[class=major]");
        Elements valuesEuroM = tableCourse.select("td[class=c2]");
        int index = 0;

        //МіжБанк
        Elements tableCourseI = page.select("table[class=b-market-tavle_currency-interbank table-layout-ukrdealing]");
        Elements namesI = tableCourse.select("tr[class=major]");
        Elements valuesI = tableCourse.select("td[class=c2]");


        Elements namesEuroI = tableCourse.select("tr[class=major]");
        Elements valuesEuroI = tableCourse.select("td[class=c2]");


        for (Element name : names) {
            String dollarBuy = name.select("td[class=c2]").text();
            String dollarSell = name.select("td[class=c3]").text();
            System.out.println("Dollar-Cash:     Purchase      Sale");
            System.out.println("                 " + dollarBuy + "       " + dollarSell);
        }

        for (Element name : namesEuro) {
            String euroBuy = name.select("td[class=c2]").text();
            String euroSell = name.select("td[class=c3]").text();
            System.out.println("   ");
            System.out.println("Euro-Cash:       Purchase      Sale");
            System.out.println("                 " + euroBuy + "       " + euroSell);
        }

        for (Element name : namesM) {
            String dollarBuy = name.select("td[class=c2]").text();
            String dollarSell = name.select("td[class=c3]").text();
            System.out.println("Cours Minyajlo");
            System.out.println("Dollar-Change:   Purchase      Sale");
            System.out.println("                 " + dollarBuy + "       " + dollarSell);
        }

        for (Element name : namesEuroM) {
            String euroBuy = name.select("td[class=c2]").text();
            String euroSell = name.select("td[class=c3]").text();
            System.out.println("   ");
            System.out.println("Euro-Change:     Purchase      Sale");
            System.out.println("                 " + euroBuy + "       " + euroSell);
        }
        for (Element name : namesI) {
            String dollarBuy = name.select("td[class=c2]").text();
            String dollarSell = name.select("td[class=c3]").text();
            System.out.println("Cours Interbank");
            System.out.println("Dollar-Change:   Purchase      Sale");
            System.out.println("                 " + dollarBuy + "       " + dollarSell);
        }

        for (Element name : namesEuroI) {
            String euroBuy = name.select("td[class=c2]").text();
            String euroSell = name.select("td[class=c3]").text();
            System.out.println("   ");
            System.out.println("Euro-Change:     Purchase      Sale");
            System.out.println("                 " + euroBuy + "       " + euroSell);
        }

    }
}

         */
