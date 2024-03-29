package online.qastudy.service;

public class Rate {
    private String usdBuy;
    private String usdSell;
    private String euroBuy;
    private String euroSell;
    private String nameCoin;
    private String priceCoin;

    public Rate(String usdBuy, String usdSell, String euroBuy, String euroSell) {
        this.usdBuy = usdBuy;
        this.usdSell = usdSell;
        this.euroBuy = euroBuy;
        this.euroSell = euroSell;

    }


    public Rate(String nameCoin, String priceCoin) {
        this.nameCoin = nameCoin;
        this.priceCoin = priceCoin;
    }

    @Override
    public String toString() {
        return "" +
                "Долар купівля = " + usdBuy + '\n' +
                "Долар продажа = " + usdSell + '\n' +
                "Євро купівля = " + euroBuy + '\n' +
                "Євро продажа = " + euroSell + '\n' +
                " " + nameCoin + priceCoin;
    }

    public String getUsdBuy() {
        return usdBuy;
    }

    public void setUsdBuy(String usdBuy) {
        this.usdBuy = usdBuy;
    }

    public String getUsdSell() {
        return usdSell;
    }

    public void setUsdSell(String usdSell) {this.usdSell = usdSell;}

    public String getEuroBuy() {
        return euroBuy;
    }

    public void setEuroBuy(String euroBuy) {
        this.euroBuy = euroBuy;
    }

    public String getEuroSell() {
        return euroSell;
    }

    public void setEuroSell(String euroSell) {
        this.euroSell = euroSell;
    }




    public String getNameCoin() {return nameCoin; }

    public void setNameCoin(String nameCoin) {
        this.nameCoin = nameCoin;
    }

    public String getPriceCoin() {return priceCoin; }

    public void setPriceCoin(String priceCoin) {this.priceCoin = priceCoin;
    }
}
