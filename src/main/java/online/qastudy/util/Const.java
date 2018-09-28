package online.qastudy.util;

import online.qastudy.service.ParserService;
import online.qastudy.service.Rate;
import java.io.IOException;

public final class Const {

    static ParserService parser = new ParserService();

    static Rate minyayloRate;

    static {
        try {
            minyayloRate = parser.getMinyayloRate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Rate bankRate;

    static {
        try {
            bankRate = parser.getBankRate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Rate cashRate;

    static {
        try {
            cashRate = parser.getCashRate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String MESSAGE = String.format(
            "Курс валют на сьогодні по данним finance.ua" +"\n" + "\n" +
                 "Міняйло   " + "\n" + minyayloRate + "\n" +
                 "Готівковий Курс   " + "\n" + cashRate + "\n" +
                 "Між Банк   " + "\n" + bankRate);
    public static final String BOT_NAME = "ParserFinanceBot";
    public static final String BOT_TOKEN = "5667265390:AAGY2F95jwMONF16pdM7ztyZIjlJE_lVVaU";
    public static final String CHAT_ID = "-760518500";

//    private Const() throws IOException {
//    }
}
