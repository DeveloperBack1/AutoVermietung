package com.schneider.autovermitung;

//                                             Описание приложения:

//        Сервис аренды автомобилей будет включать следующие сущности:

//
//        Car - автомобиль, который можно взять в аренду.

//        Customer - клиент, который арендует автомобиль.

//        Rental - запись об аренде, связывающая клиента и автомобиль.
//

//Структура сущностей

//       1. Car
//
//    Long  id:                                 Уникальный идентификатор автомобиля.
//    String   model:                       Модель автомобиля.
//    String brand:                          Марка автомобиля.
//    double pricePerDay:               Цена аренды за день.
//    boolean available:                  Статус доступности.

//        2. Customer
//
//    Long id:                                    Уникальный идентификатор клиента.
//    String  name:                           Имя клиента.
//    String email:                            Электронная почта клиента.

//         3. Rental
//
//    Long id:                                     Уникальный идентификатор аренды.
//    private LocalDate startDate;    Дата начала аренды.
//    private LocalDate endDate;     Дата окончания аренды.
//    private double totalCost;         Общая стоимость аренды.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutoVermitungApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoVermitungApplication.class, args);
    }

}
