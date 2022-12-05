package bot;


import java.util.TimerTask;

public class MTSchedulerService extends TimerTask {
    private final ParserBot mtBot = new ParserBot();

    public MTSchedulerService() {
    }

    public void run() {
        this.mtBot.sendNotification();
    }
}
