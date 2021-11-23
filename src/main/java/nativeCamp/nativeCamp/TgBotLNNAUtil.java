package nativeCamp.nativeCamp;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TgBotLNNAUtil extends TelegramLongPollingBot {


    private String token = "1875785008:AAE7yjxejJgmem6iQBPDTf32X7U9kTe9CcQ";

    private Long chatId = -510644847l;


    @Override
    public String getBotUsername() { return "@LotteryNumNullAlarmBot"; }

    @Override
    public void onUpdateReceived(Update update) {
        // TODO 無接收功能
    }

    @Override
    public String getBotToken() { return token; }

    public Long getChatId() {
        return chatId;
    }
}
