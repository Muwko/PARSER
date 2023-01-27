package online.qastudy.service;

public class Rate {
    private String usdBuy;
    private String usdSell;
    private String euroBuy;
    private String euroSell;

    public Rate(String usdBuy, String usdSell, String euroBuy, String euroSell) {
        this.usdBuy = usdBuy;
        this.usdSell = usdSell;
        this.euroBuy = euroBuy;
        this.euroSell = euroSell;
    }

    @Override
    public String toString() {
        return "" +
                "Долар купівля = " + usdBuy + '\n' +
                "Долар продажа = " + usdSell + '\n' +
                "Євро купівля = " + euroBuy + '\n' +
                "Євро продажа = " + euroSell + '\n' +
                "";

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


}
