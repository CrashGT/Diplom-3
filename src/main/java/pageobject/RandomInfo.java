package pageobject;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomInfo {
    private static Faker faker = new Faker(new Locale("en"));
    public static final String RANDOM_NAME = faker.name().fullName();
    public static final String RANDOM_EMAIL = faker.name().firstName() + faker.numerify("###") + "@mail.ru";
    public static final String RANDOM_PASSWORD = faker.numerify("#######");
}