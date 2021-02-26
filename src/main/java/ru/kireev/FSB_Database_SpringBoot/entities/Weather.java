package ru.kireev.FSB_Database_SpringBoot.entities;

import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


@Data
public class Weather {

    private String temperature;
    private String windSpeed;
    private String humidity;
    private String pressure;

    public Weather() {

        try {
            Document document = Jsoup.connect("https://yandex.ru/pogoda/voronezh?utm_campaign=informer&utm_content=main_informer&utm_medium=web&utm_source=home&utm_term=main_number").get();
            temperature = "Воронеж " + document.getElementsByAttributeValue("class", "temp__value temp__value_with-unit").get(1).text() + " ℃";
            Elements weatherElements = document.getElementsByAttributeValue("class", "term__value");
            windSpeed = "Ветер " + weatherElements.get(2).text();
            humidity = "Влажность " + weatherElements.get(3).text();
            pressure = "Давление " + weatherElements.get(4).text();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Информация о погоде не доступна");
        }

    }
//    @Override
//    public String toString() {
//        return String.format("%s%n%s%n%s%n%s", "Воронеж " + temperature + " ℃", "Ветер " + windSpeed, "Влажность " + humidity, "Давление " + pressure);
//    }
}
