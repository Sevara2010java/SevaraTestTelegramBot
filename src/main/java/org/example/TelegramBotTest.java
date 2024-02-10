package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;

import java.io.File;
import java.util.Locale;

public class TelegramBotTest extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "@SevaraBaxtiyorova_bot";
    }

    @Override
    public String getBotToken() {
        return "6475940733:AAHBsBGEpS0uLeT-LmAEA1IaCC0eqn3CKBY";
    }

    @Override
    public void onUpdateReceived(Update update) {

        String text1 = update.getMessage().getText();
        long UserChatId = update.getMessage().getChatId();

        if (text1.equals("/start")) {
            String text = "\uD83D\uDD17 Izlayapsiz, ammo topolmayapsiz\n" +
                    "\n" +
                    "@newlink_uz (https://t.me/+8EAg1KAVK1llNDFi) kanali - barcha foydalanuvchilar uchun cheksiz imkoniyatlar manzili. Kanal Sizga quyidagi afzalliklarni beradi:\n" +
                    "\n" +
                    "✔\uFE0FEng foydali linklar;\n" +
                    "✔\uFE0FEng foydali Web saytlar;\n" +
                    "✔\uFE0FEng foydali telegram botlar manzili.\n" +
                    "\n" +
                    "Vaqtingizni behuda izlashga sarflamang, yaxshisi, kanalga tashrif buyuring va qulayliklar ichida \" suzing\".\n" +
                    "\n" +
                    "⚡\uFE0F@newlink_uz (https://t.me/+8EAg1KAVK1llNDFi) - hammasi faqat Siz uchun!";

            String PhotoUrl = "C:\\Users\\HP SPEKTR\\Documents\\Sevaraning2Botti\\IMG\\Rasm.jpg";

            SendPhotoWithText(UserChatId, PhotoUrl, text);
        }
        }

        private void SendPhotoWithText (long chatId, String PhotoPath, String captionText){
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(String.valueOf(chatId));
            sendPhoto.setPhoto(new InputFile(new File(PhotoPath)));
            sendPhoto.setCaption(captionText);
            sendPhoto.setParseMode("HTML");

            try {
                execute(sendPhoto);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }
}

