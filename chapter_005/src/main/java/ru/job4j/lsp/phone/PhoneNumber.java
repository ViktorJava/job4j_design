package ru.job4j.lsp.phone;

/**
 * Модель данных телефонного номера.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 13.11.2021
 */
public class PhoneNumber {
    private int countryCode;

    private int cityCode;

    private int number;

    public PhoneNumber(int countryCode, int cityCode, int number) {
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.number = number;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public int getCityCode() {
        return cityCode;
    }

    public int getNumber() {
        return number;
    }
}
