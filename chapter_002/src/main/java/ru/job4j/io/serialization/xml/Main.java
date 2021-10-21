package ru.job4j.io.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 08.04.2021
 */
public class Main {
    /**
     * Получаем контекст для доступа к АПИ
     * <blockquote><pre>
     *  JAXBContext context = JAXBContext.newInstance(Person.class);
     * Создаем сериализатор
     * Marshaller marshaller = context.createMarshaller();
     * Указываем, что нам нужно форматирование
     * marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
     * Сериализуем
     * marshaller.marshal(person, writer);
     * Для десериализации нам нужно создать десериализатор
     * Unmarshaller unmarshaller = context.createUnmarshaller();
     * десериализуем
     * Person result = (Person) unmarshaller.unmarshal(reader);
     * </pre></blockquote>
     */
    public static void main(String[] args) throws Exception {
        Person person = new Person(false, 30,
                new Contact("11-111"), "Worker", "Married");
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Person result = (Person) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
