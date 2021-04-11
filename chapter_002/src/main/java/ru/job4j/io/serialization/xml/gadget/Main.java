package ru.job4j.io.serialization.xml.gadget;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * <h2>JAXB.</h2>
 * Отработка навыков маршалинга объекта в XML и десериализация.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 11.04.2021
 */
public class Main {
    public static void main(String[] args) throws Exception {
        final Phone phone = new Phone(true, 2020, new
                Spec(8, "SnapDragon"), "new", "broken");

        JAXBContext context = JAXBContext.newInstance(Phone.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(phone, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Phone result = (Phone) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
