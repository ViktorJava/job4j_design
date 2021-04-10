package ru.job4j.io.socked;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.io.log4j.UsageLog4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Класс реализации simple server, работающего по протоколу HTTP.<p>
 * Сервер, представляет собой, простого бота, который реагирует на<p>
 * команды клиента передаваемые в виде Get запроса: {@code GET /?msg=Hello HTTP/1.1}<p>
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 01.04.2021
 */
public class EchoServer {
    public static void main(String[] args) {
        final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                socket.setSoTimeout(3000);
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String answer = "Hi. I'm simple server.";
                    str = in.readLine();
                    while (!str.isEmpty()) {
                        System.out.println(str);
                        if (str.contains("/?msg")) {
                            String[] message = str.split(" ");
                            String[] splitMsg = message[1].split("msg=", 2);
                            String request = splitMsg[1];
                            if (request.equals("Hello")) {
                                answer = "Hi man!";
                            } else if (request.equals("Exit")) {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write("Server stopped...".getBytes());
                                server.close();
                                break; //Сервер закрыт, не обрабатываем оставшиеся запросы.
                            } else {
                                answer = request;
                            }
                        }
                        str = in.readLine();
                    }
                    if (!server.isClosed()) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write(answer.getBytes());
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("Исключения потоков ввода/вывода: ", e);
        }
    }
}
