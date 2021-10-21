package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <h2>Консольный чат</h2>
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 29.03.2021
 */
public class ConsoleChat {
    private final String dialogLog;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private static final String LS = System.lineSeparator();
    List<String> answersList = new ArrayList<>();
    List<String> dialogList = new ArrayList<>();

    public ConsoleChat(String dialogLog, String botAnswers) {
        this.dialogLog = dialogLog;
        this.botAnswers = botAnswers;
    }

    /**
     * Метод чтения файла с разговорными фразами бота.
     */
    public void readAnswers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            String line;
            while ((line = reader.readLine()) != null) {
                answersList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод записи диалога в файл.
     */
    public void dialogWriter() {
        try (BufferedWriter bw = new BufferedWriter(new
                FileWriter(dialogLog, StandardCharsets.UTF_8))) {
            for (String str: dialogList) {
                bw.write(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ядро чата.
     */
    public void run() {
        try (BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            readAnswers();
            String inputString = "";
            boolean enabledBot = true;
            do {
                inputString = br.readLine();
                dialogList.add(String.format("User: %s%s", inputString, LS));
                if (STOP.equals(inputString)) {
                    enabledBot = false;
                }
                if (CONTINUE.equals(inputString) || OUT.equals(inputString)) {
                    enabledBot = true;
                } else if (enabledBot) {
                    int i = new Random().nextInt(answersList.size());
                    String answer = answersList.get(i);
                    dialogList.add(String.format("Bot: %s%s", answer, LS));
                    System.out.println(answer);
                }
            } while (!(OUT.equals(inputString)));
            dialogWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.printf("Управление ботом: %s"
                        + "%s - выйти из чата%s"
                        + "%s - бот будет молчать%s"
                        + "%s - возобновить разговор",
                LS, OUT, LS, STOP, LS, CONTINUE
        );
        System.out.println();
        ConsoleChat cc = new ConsoleChat("chapter_002/data/dialog.log",
                "chapter_002/data/botAnswers.ban");
        cc.run();
    }
}
