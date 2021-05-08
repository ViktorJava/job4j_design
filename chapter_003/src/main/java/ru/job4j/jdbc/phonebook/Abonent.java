package ru.job4j.jdbc.phonebook;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 08.05.2021
 */
public class Abonent extends Entity {
    private int phone;
    private String lastname;

    public Abonent() {
    }

    public Abonent(int id, int phone, String lastname) {
        super(id);
        this.phone = phone;
        this.lastname = lastname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Abonent [id=" + id
                + ", phone=" + phone
                + ", lastname=" + lastname + "]";
    }
}
