package ru.job4j.io.socked;

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
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                socket.setSoTimeout(3000);
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String[] message;
                    String[] splitMsg;
                    String request;
                    String answer = "Hi. I'm simple server.";
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("/?msg")) {
                            message = str.split(" ");
                            splitMsg = message[1].split("msg=", 2);
                            request = splitMsg[1];
                            if (request.equals("Hello")) {
                                answer = "Hi man!";
                            } else if (request.equals("Exit")) {
                                answer = "Server stopped...";
                                server.close();
                            } else {
                                answer = request;
                            }
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());
                }
            }
        }
    }
}
