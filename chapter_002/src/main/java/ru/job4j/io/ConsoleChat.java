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
    private static final String OUT = "закончить"; // программа прекращает работу
    private static final String STOP = "стоп"; // бот замолкает
    private static final String CONTINUE = "продолжить";
    private static final String LS = System.lineSeparator();

    public ConsoleChat(String dialogLog, String botAnswers) {
        this.dialogLog = dialogLog;
        this.botAnswers = botAnswers;
    }

    /**
     * Метод формирует список фраз полученных из файла и
     * возвращает случайную фразу из списка. Повторяемость фраз не учитывается.
     *
     * @return Случайная фраза.
     */
    public String getAnswerBot() {
        String answer = "";
        List<String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(botAnswers));
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            int i = new Random().nextInt(list.size());
            answer = list.get(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    /**
     * Ядро чата.
     */
    public void run() {
        try (BufferedReader bReader = new BufferedReader(new
                InputStreamReader(System.in, StandardCharsets.UTF_8));
             BufferedWriter bWriter = new BufferedWriter(new
                     FileWriter(dialogLog, StandardCharsets.UTF_8))) {
            String inputString = "";
            boolean flag = true;
            StringBuilder dialogString;
            while (!(OUT.equals(inputString))) {
                inputString = bReader.readLine();
                //TODO расход памяти.
                dialogString = new StringBuilder(String.format("User: %s%s", inputString, LS));
                if (STOP.equals(inputString)) {
                    flag = false;
                }
                if (CONTINUE.equals(inputString) || OUT.equals(inputString)) {
                    flag = true;
                } else if (flag) {
                    String answer = String.format("Bot: %s%s", getAnswerBot(), LS);
                    System.out.println(answer);
                    dialogString.append(answer);
                }
                bWriter.write(dialogString.toString());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
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
