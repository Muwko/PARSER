package online.qastudy;

import online.qastudy.bot.JobBot;
import online.qastudy.bot.ParserBot;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;


public class Main {

    public static void main(String[] args) throws SchedulerException {
        ApiContextInitializer.init();

        TelegramBotsApi api = new TelegramBotsApi();

        JobDetail jobBot = JobBuilder.newJob(JobBot.class).withIdentity("jobBot", "group1").build();
        Trigger t1 = TriggerBuilder.newTrigger().withIdentity("cronTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 48 15 * * ?")).build();
        Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
        scheduler1.start();
        scheduler1.scheduleJob(jobBot, t1);

        try {
            api.registerBot(new ParserBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

    }


}
