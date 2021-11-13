package ru.job4j.lsp.phone;

/**
 * Класс абонента.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 13.11.2021
 */
public class Subscriber {

    protected PhoneNumber phoneNumber;

    public Subscriber(PhoneNumber phoneNumber) {
        validate(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        validate(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    protected void validate(PhoneNumber phoneNumber) {
        if (phoneNumber.getCountryCode() < 1 || phoneNumber.getCountryCode() > 999) {
            throw new IllegalArgumentException("Invalid country code!");
        }
        if (phoneNumber.getCityCode() < 1 || phoneNumber.getCityCode() > 999) {
            throw new IllegalArgumentException("Invalid city code!");
        }
        if (phoneNumber.getNumber() < 1 || phoneNumber.getNumber() > 999_999_999) {
            throw new IllegalArgumentException("Invalid number!");
        }
    }
}
