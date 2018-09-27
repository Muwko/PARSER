package online.qastudy.service;

import online.qastudy.bot.MuayThaiBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class MTSchedulerService extends TimerTask{

    private final MuayThaiBot mtBot = new MuayThaiBot();

    @Override
    public void run() {
        mtBot.sendNotification();
    }

}
