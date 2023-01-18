package online.qastudy.bot;

import online.qastudy.service.ParserService;
import online.qastudy.service.Rate;
import online.qastudy.util.Const;
import org.apache.shiro.session.Session;
import org.quartz.*;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.session.TelegramLongPollingSessionBot;

import java.io.IOException;

import java.util.Optional;


public class ParserBot extends TelegramLongPollingSessionBot {

    public void onUpdateReceived(Update update) {

    }

    public void onUpdateReceived(Update update, Optional<Session> optional) {

    }

    public void sendNotification() throws IOException, SchedulerException {
        {

            ParserService parser = new ParserService();

            Rate minyayloRate = parser.getMinyayloRate();
            Rate bankRate = parser.getBankRate();
            Rate cashRate = parser.getCashRate();

            System.out.println(minyayloRate);
            System.out.println(cashRate);
            System.out.println(bankRate);

            SendMessage postToChanel = new SendMessage()
                    .setChatId(Const.CHAT_ID)
                    .setText(MESSAGE);
            try {
                execute(postToChanel);
            } catch (TelegramApiException e) {

            }
        }

    }

    ParserService parser = new ParserService();

    Rate minyayloRate;
    {
        try {
            minyayloRate = parser.getMinyayloRate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Rate bankRate;
    {
        try {
            bankRate = parser.getBankRate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   Rate cashRate;
    {
        try {
            cashRate = parser.getCashRate();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public final String MESSAGE = String.format(
            "Курс валют на сьогодні по данним finance.ua" +"\n" + "\n" +
                    "Міняйло   " + "\n" + minyayloRate + "\n" +
                    "Готівковий Курс   " + "\n" + cashRate + "\n" +
                    "Між Банк   " + "\n" + bankRate);

    public String getBotUsername() {
        return Const.BOT_NAME;
    }

    public String getBotToken() {
        return Const.BOT_TOKEN;
    }


}
