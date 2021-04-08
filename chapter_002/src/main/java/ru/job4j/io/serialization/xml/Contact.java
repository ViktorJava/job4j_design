package ru.job4j.io.serialization.xml;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Класс контактных данных.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 07.04.2021
 */
@XmlElement(value = "contact")
public class Contact {
    @XmlAttribute
    private String phone;

    public Contact(String phone) {
        this.phone = phone;
    }

    public Contact() {
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}
