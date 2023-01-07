package online.qastudy.service;

import online.qastudy.bot.MuayThaiBot;
import org.quartz.SchedulerException;

import java.io.IOException;
import java.util.TimerTask;

public class MTSchedulerService extends TimerTask{

    private final MuayThaiBot mtBot = new MuayThaiBot();

    @Override
    public void run() {
        try {
            mtBot.sendNotification();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

}
