# Тестовое задание от Атомэнергопроекта

+ [О проекте](#О-проекте)
+ [Требования](#Требования)
+ [Технологии](#Технологии)
+ [Взаимодействие с приложением](#Взаимодействие-с-приложением)
+ [Контакты](#Контакты)

## О проекте

Сервис для расчета своей почасовой ставки.
Для определения количества расчетных дней используется сервис https://isdayoff.ru/

## Требования

+ Реализовать веб-сервис c UI, рассчитывающий почасовую ставку.
+ Валидировать входные данные
+ Сервис, должен принимать запросы по протоколу HTTP. Параметры запроса: год, месяц, месячная зарплата
+ Сервис должен возвращать ответ в формате JSON вида:

json
{
"year": 2021,
"month": "JANUARY",
"salary": 120000,
"hour_income": 586.13,
"workdays_month":20
}
+ Округление почасовой ставки должно быть до копеек.
+ Написать клиента для сервиса https://isdayoff.ru/
+ Реализовать кэширование ответов сервиса https://isdayoff.ru/
+ Составить тестовые запросы сервиса для Postman.
+ При выполнении задания не использовать Spring, Spring Boot, а реализовать front на JSP, back Java SE.

## Технологии

+ **Java 17**
+ **Maven 3.8**
+ **Lombok 1.18.30**
+ **Тестирование:** **Mockito 5.11**


## Взаимодействие с приложением
Для отправки запросов используйте Postman или аналог.
+ Успешный запрос:

![alt text](https://github.com/svoh86/AtomTest/blob/master/img/success.png)

+ Некорректный год:

![alt text](https://github.com/svoh86/AtomTest/blob/master/img/notValidYear.png)

+ Некорректный месяц:

![alt text](https://github.com/svoh86/AtomTest/blob/master/img/notValidMonth.png)

+ Некорректная зарплата:

![alt text](https://github.com/svoh86/AtomTest/blob/master/img/notValidSalary.png)


## Контакты

Свистунов Михаил Сергеевич

[![Telegram](https://img.shields.io/badge/Telegram-blue?logo=telegram)](https://t.me/svoh86)

Email: sms-86@mail.ru
