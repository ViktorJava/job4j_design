package ru.job4j.io.socked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Класс реализации simple server, работающего по протоколу HTTP.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 01.04.2021
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9001)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                socket.setSoTimeout(5000);
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String[] msg;
                    String[] tmp;
                    String sss;
                    String answer = "Salam";
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("/?msg")) {
                            msg = str.split(" ");
                            tmp = msg[1].split("msg=", 2);
                            sss = tmp[1];
                            if (sss.equals("Hi")) {
                                answer = "Hello";
                            } else if (sss.equals("Bye")) {
                                answer = "Bye-bye";
                                server.close();
                            } else {
                                answer = sss;
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
