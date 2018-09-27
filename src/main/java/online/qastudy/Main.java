package online.qastudy;

import online.qastudy.bot.MuayThaiBot;
import online.qastudy.service.MTSchedulerService;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();

        TelegramBotsApi api = new TelegramBotsApi();
        postScheduler("2018-09-27 20:10:10");
        try {
            api.registerBot(new MuayThaiBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    private static void postScheduler(String firstStartDateAndTime) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timer time = new Timer();
        MTSchedulerService schedulerService = new MTSchedulerService();
        Date startDate = null;

        try {
            startDate = df.parse(firstStartDateAndTime);
        } catch (ParseException e) {
            e.getMessage();
        }

        time.schedule(schedulerService, startDate, 1);
    }
}
