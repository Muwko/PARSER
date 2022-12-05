package bot;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.shiro.session.Session;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.session.TelegramLongPollingSessionBot;

public class ParserBot extends TelegramLongPollingSessionBot {
    public ParserBot() {
    }

    public void onUpdateReceived(Update update) {
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public void onUpdateReceived(Update update, Optional<Session> optional) {

    }

    public void sendNotification() {
        if (this.shouldISendNotification()) {
            SendMessage postToChanel = new SendMessage().setChatId("224392735").setText("text");

            try {
                this.execute(postToChanel);
            } catch (TelegramApiException var3){
            }
        }
    }

    private boolean shouldISendNotification() {
        return LocalDate.now().getDayOfWeek().equals(DayOfWeek.MONDAY) || LocalDate.now().getDayOfWeek().equals(DayOfWeek.WEDNESDAY);
    }

    public String getBotUsername() {
        return "ParserFinanceBot";
    }

    public String getBotToke() {
        return "5667265390:AAGY2F95jwMONF16pdM7ztyZIjlJE_lVVaU";
    }

    @Override
    public String getBotToken() {
        return null;
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }
}
