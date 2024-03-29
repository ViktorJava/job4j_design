[Перейти на домашнюю страницу](../README.md)

# Блок 4 - OOD.
> Изученные темы в процессе прохождения блока.

## 0. Принципы Kiss, Dry и Yagni. 
* Руководствуясь принципами проектирования Kiss, Dry и Yagni: 
[разработаем класс для поиска максимального и минимального элемента](https://github.com/ViktorJava/job4j_design/issues/85)
* Что такое TDD. [Реализация сервиса кинотеатр через TDD.](https://github.com/ViktorJava/job4j_design/issues/85)
* [Шаблонизатор.](https://github.com/ViktorJava/job4j_design/issues/87)
* **BDD** краткое описание: 
> **Behaviour Driven Development** - поведенческая разработка. Разработка, ориентированная поведением.
> 
>  Тестирование однозначно улучшает качество программного продукта, а автоматическое тестирование улучшает качество тестирования. Для этого применяется **BDD** подход.
> 
>  **BDD** - предоставляет менеджерам и разработчикам общих инструментов для совместной разработки программного обеспечения. Предусматривает использование специальных инструментов для разработки. **BDD** - это расширенный **TDD** который использует **DSL** (предметно-ориентированный язык) использующий естественный язык (слова и предложения)
> 
>  **BDD** тесты – это простой текст, на человеческом языке, написанный в форме истории (сценария), описывающей некоторое поведение.
> 
>  Для **Java** существует такой фреймворк как **Cucumber**.

## 1. SRP - Single Responsibility Principle.
Принцип единственной ответственности.
* [3 примера нарушения SRP](https://github.com/ViktorJava/job4j_design/issues/88)
* [Отчеты](https://github.com/ViktorJava/job4j_design/issues/89)

## 2. OCP - Open Closed Principle.
Принцип открытости закрытости
* [3 примера нарушения принципа](https://github.com/ViktorJava/job4j_design/issues/91)
* [Поддержка форматом XML, JSON в генераторе отчетов](https://github.com/ViktorJava/job4j_design/issues/93)

## 3.  LSP - Liskov Substitution Principle.
 Принцип подстановки Лисков.
* [3 примера нарушения принципа](https://github.com/ViktorJava/job4j_design/issues/97)
    * [First Rule.](https://github.com/ViktorJava/job4j_design/issues/95) Пример нарушения первого контракта.
    * [Second Rule.](https://github.com/ViktorJava/job4j_design/issues/96) Пример нарушения второго контракта.
    * [Third Rule.](https://github.com/ViktorJava/job4j_design/issues/98) Пример нарушения третьего контракта.
* [Хранилище продуктов](https://github.com/ViktorJava/job4j_design/issues/99)
* [Парковка машин](https://github.com/ViktorJava/job4j_design/issues/100)

## 4. ISP - Interface Segregation Principle.
 Принцип разделения интерфейсов.
* [~~3 примера нарушения принципа~~]()
* [~~Создать меню~~]()

## 5. DIP - Dependency Inversion Principle.
Принцип инверсии зависимостей.
* [~~3 примера нарушения принципа~~]()
* Взять код из проекта [хранилище продуктов](https://github.com/ViktorJava/job4j_design/issues/99). Необходимо добавить [~~динамическое распределение продуктов.~~]()


## 6. Контрольные вопросы. SQL. JDBC.
1. Что такое SOLID?
2. Для чего используется JavaDoc?
3. Как писать JavaDoc?
4. Что такое Java code convention?
5. Расскажите про принципы составления Java класса.
6. Что такое SRP?
7. Расскажите о нарушениях принципа SRP.
8. Каковы последствия нарушения SRP?
9. Что такое OCP?
10. Расскажите о нарушениях принципа OCP.
11. Каковы последствия нарушения OCP?
12. Что такое LSP?
13. Расскажите о нарушениях принципа LSP.
14. Каковы последствия нарушения LSP?
15. Что такое ISP?
16. Расскажите о нарушениях принципа ISP.
17. Каковы последствия нарушения ISP?
18. Что такое DIP?
19. Расскажите о нарушениях принципа DIP.
20. Каковы последствия нарушения DIP?
21. Расскажите, что такое автоматизированное тестирование.
22. Как в Java осуществляется автоматизированное тестирование?
23. Что такое JUnit? Как использовать ее для тестирования?
24. Что такое функциональное тестирование и чем отличается оно от модульного?
25. Расскажите про принцип TDD.
26. Расскажите про принцип BDD.
27. Что такое тестирование черным, белым, серым ящиком?

### 6.1. Тестовое задание.
* [~~Крестики-нолики. Тестовое задание.~~]()

### 6.2. Доп.задание.
* [~~По результатам проверки знаний, ментором, наверняка будет предложено выполнить техническое задание~~.]()

## 7. Дополнительная литература.
В качестве дополнительной литературы, используется:
1) [SOLID](https://ru.wikipedia.org/wiki/SOLID_(объектно-ориентированное_программирование))
2) На английском: http://butunclebob.com/ArticleS.UncleBob.PrinciplesOfOod 
3) https://habrahabr.ru/post/208442/ 
4) Head First Объектно-ориентированный анализ и проектирование. Глава 8. 
 
## 8. Материалы по тестам.
* [Функциональное тестирование.](https://qalight.ua/ru/baza-znaniy/funktsionalnoe-testirovanie/)
Тестирование в соответствии с функциональными требованиями или бизнес-процессами. Причем под функциями или процессами здесь понимается то, что доступно и выполняется пользователем.
* [Функциональное тестирование.](https://ru.wikipedia.org/wiki/%D0%A4%D1%83%D0%BD%D0%BA%D1%86%D0%B8%D0%BE%D0%BD%D0%B0%D0%BB%D1%8C%D0%BD%D0%BE%D0%B5_%D1%82%D0%B5%D1%81%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5)
* [Юзабилити тестирование.](https://www.performance-lab.ru/juzabiliti-testirovanie)
Тестирование удобства использования интерфейса пользователя.
* [Мобильное тестирование.](https://qalight.ua/ru/baza-znaniy/testirovanie-mobilnyh-prilozhenij/)
Тестирование какого-либо функционала, который должен работать корректно в мобильном окружении.
* [Тестирование игр.](https://wikichi.ru/wiki/Game_testing)
Тестирование с целью нахождения багов в играх.
* [Кросс-браузерное тестирование.](http://www.itqc.ru/testing_branch/crossbrowser-testing.html)
Тестирование, направленное на проверку работы программы (сайтов, веб-приложений) в различных браузерах.
* [Тестирование пользовательского интерфейса.](https://qaevolution.ru/testirovanie-po/vidy-testirovaniya-po/testirovanie-polzovatelskogo-interfejsa/)
Тестирование корректности выполнения (не удобства) функций пользовательского интерфейса, например, при наведении кнопки она должна выделиться другим цветом.  
* [Регрессионное тестирование.](https://qalight.ua/ru/baza-znaniy/regressionnoe-testirovanie/)
Тестирование уже протестированного кода, который ранее проверял блок программы, а он изменился.
* [Тестирование дизайна.](https://qaevolution.ru/testovaya-dokumentaciya/test-dizajn/)
 QA практика проектирования тестов.
* [Автоматизированное тестирование.](https://junit.org/junit4/) UNIT тестирование.
    * [Hamcrest](http://hamcrest.org/JavaHamcrest/tutorial)
* [SEO – тестирование.](https://xbsoftware.ru/testirovanie-po/polnij-tsykl/seo-test/)
Тестирование сайтов с точки зрения SEO.
* [Приемочное тестирование.](https://qalight.ua/ru/baza-znaniy/priemochnoe-testirovanie/)
Тестирование, проводимое перед тем как готовое ПО попадает к пользователю.
* [Нагрузочное тестирование.](https://qalight.ua/ru/baza-znaniy/testirovanie-proizvoditelnosti/)
Тестирование поведения ПО, под определенном нагрузкой. Здесь также тестируется производительность.
* [Magento тестирование.](https://www.loadview-testing.com/ru/blog/%D1%82%D0%B5%D1%81%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5-%D0%BD%D0%B0%D0%B3%D1%80%D1%83%D0%B7%D0%BA%D0%B8-%D0%BF%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5-%D1%8D%D0%BB/)
Тестирование Magento приложений. Magento – это инструмент для создания интернет-магазинов.

## Лицензия

[MIT. Free Software!](https://github.com/ViktorJava/job4j/tree/master/LICENSE)

---

[Перейти на домашнюю страницу](../README.md)
