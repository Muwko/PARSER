package online.qastudy.bot;

import online.qastudy.util.Const;
import org.apache.shiro.session.Session;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.session.TelegramLongPollingSessionBot;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

public class MuayThaiBot extends TelegramLongPollingSessionBot {

    public void onUpdateReceived(Update update) {

    }

    public void onUpdateReceived(Update update, Optional<Session> optional) {

    }

    public void sendNotification() {
        if (shouldISendNotification()) {
            SendMessage postToChanel = new SendMessage()
                    .setChatId(Const.CHAT_ID)
                    .setText(Const.MESSAGE);
            try {
                execute(postToChanel);
            } catch (TelegramApiException e) {

            }
        }

    }

    private boolean shouldISendNotification() {

        return false;
    }

    public String getBotUsername() {
        return Const.BOT_NAME;
    }

    public String getBotToken() {
        return Const.BOT_TOKEN;
    }
}
