package online.qastudy.bot;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import java.io.IOException;

public class JobBot implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        MuayThaiBot mtBot2 = new MuayThaiBot();
        try {
            mtBot2.sendNotification();
        } catch (IOException | SchedulerException e) {
            throw new RuntimeException(e);
        }
    }


}
