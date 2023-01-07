package online.qastudy;

import online.qastudy.bot.JobBot;
import online.qastudy.bot.MuayThaiBot;
import online.qastudy.service.MTSchedulerService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class Main {
    public static void main(String[] args) throws SchedulerException {
        ApiContextInitializer.init();

        TelegramBotsApi api = new TelegramBotsApi();

        JobDetail jobBot= JobBuilder.newJob(JobBot.class).withIdentity("jobBot", "group1").build();
        Trigger t1 = TriggerBuilder.newTrigger().withIdentity("cronTrigger","group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 13 11 * * ?")).build();
        Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
        scheduler1.start();
        scheduler1.scheduleJob(jobBot, t1);



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

        time.schedule(schedulerService, startDate, 24*60*60*1000);
    }
}
