package ru.job4j.io.serialization.json.gadget;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс сериализации объекта в json.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 13.04.2021
 */
public class Main {
    public static void main(String[] args) {
        /* JSONObject из json-строки */
        JSONObject jsonSpec = new JSONObject("{'ram': 1, 'cpu':'OldProcLTD'}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("old");
        list.add("broken");
        JSONArray jsonStatuses = new JSONArray(list);

        /* Объект сериализуем в json */
        final Phone phone = new Phone(false, 2021,
                new Spec(16, "Mediatek"), "new", "okay");

        /* JSONObject напрямую методом put */
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("available:", phone.isAvailable());
        jsonObject.put("year:", phone.getYear());
        jsonObject.put("spec", jsonSpec);
        jsonObject.put("statuses", jsonStatuses);
        /* Вывод в консоль JSONObject в виде json */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект phone в json-строку */
        System.out.println(new JSONObject(phone).toString());
    }
}
