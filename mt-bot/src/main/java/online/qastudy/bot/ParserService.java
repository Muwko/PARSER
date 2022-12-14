package online.qastudy.bot;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParserService {


    private Document doc;
    private char[] value;

    public ParserService() {
        // TODO document why this constructor is empty
    }

//    public String replace(char oldChar, char newChar) throws IOException {
//        if (oldChar != newChar) {
//            int len = value.length;
//            int i = 4;
//            char[] val = value; /* avoid getfield opcode */
//
//            while (i < len) {
//                if (val[i] == oldChar) {
//                    break;
//                }
//            }
//        }
//        return null;
//    }

    public Rate getMinyayloRate() throws IOException {

        doc = FinanceUaRepositories.getSourceOfPage();
        Elements tables1 = doc.getElementsByTag("tbody");
        Element tableChange = tables1.get(0);
        Elements elementsFromTable = tableChange.children();
        Element dollar = elementsFromTable.get(0);
        Elements dollarElements = dollar.children();

        String usdBuy = dollarElements.select("td[class=c2]").text();
        String usdSell = dollarElements.select("td[class=c3]").text();

        Element euro = elementsFromTable.get(2);
        Elements euroElements = euro.children();

        String euroBuy = euroElements.select("td[class=c2]").text();
        String euroSell = euroElements.select("td[class=c3]").text();

        return new Rate(usdBuy, usdSell, euroBuy, euroSell);
    }


    public Rate getCashRate() throws IOException {
        doc = FinanceUaRepositories.getSourceOfPage();
        Elements tables1 = doc.getElementsByTag("tbody");
        Element tableChange = tables1.get(3);
        Elements elementsFromTable = tableChange.children();
        Element dollar = elementsFromTable.get(0);
        Elements dollarElements = dollar.children();

        String usdBuy = dollarElements.select("td[class=c2]").text();
        String usdSell = dollarElements.select("td[class=c3]").text();

        Element euro = elementsFromTable.get(1);
        Elements euroElements = euro.children();

        String euroBuy = euroElements.select("td[class=c2]").text();
        String euroSell = euroElements.select("td[class=c3]").text();

        return new Rate(usdBuy, usdSell, euroBuy, euroSell);
    }


    public Rate getBankRate() throws IOException {
        doc = FinanceUaRepositories.getSourceOfPage();
        Elements tables1 = doc.getElementsByTag("tbody");
        Element tableChange = tables1.get(6);
        Elements elementsFromTable = tableChange.children();
        Element dollar = elementsFromTable.get(0);
        Elements dollarElements = dollar.children();

        String usdBuy = dollarElements.select("td[class=c2]").text();
        String usdSell = dollarElements.select("td[class=c3]").text();

        Element euro = elementsFromTable.get(1);
        Elements euroElements = euro.children();

        String euroBuy = euroElements.select("td[class=c2]").text();
        String euroSell = euroElements.select("td[class=c3]").text();

        return new Rate(usdBuy, usdSell, euroBuy, euroSell);
    }
}
