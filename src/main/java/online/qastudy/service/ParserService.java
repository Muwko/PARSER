package online.qastudy.service;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserService {


    private Document doc;

    public ParserService() {
        //TODO document why this constructor is empty
    }

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

    public Rate getCoinRate() throws IOException {

//        String url = "https://finance.ua/ua/crypto";
//        Document doc = Jsoup.connect(url).get();
        doc = FinanceUaRepositories.getSourceOfPageCrypto();

        Elements tableRows = doc.selectXpath("//*[@id=\"__next\"]/div/main/div[2]/div/table/tbody/tr");

        List<Rate> coins = new ArrayList<>();
        for (Element row : tableRows) {
            String nameCoin = row.select("p[class=CoinsListstyles__Name-sc-1c8245s-23 kVPjIs]").text();
            String priceCoin = row.select("td[class=CoinsListstyles__Price-sc-1c8245s-25 fYNuHQ]").text();
            coins.add(new Rate(nameCoin, priceCoin));
        }
        for (Rate coin : coins) {
            if (coin.getNameCoin().equals("Bitcoin") || coin.getNameCoin().equals("Ethereum") || coin.getNameCoin().equals("BNB")) {
                System.out.println(coin.getNameCoin() + ": " + coin.getPriceCoin());
            }
        }
        return (null);
    }
}
