package bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        //ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        postScheduler("2022-10-27 10:10:10");
        try {
            telegramBotsApi.registerBot(new ParserBot());
        } catch (TelegramApiException e) {
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

        time.schedule(schedulerService, startDate, 24 * 60 * 60 * 1000);
    }
}
