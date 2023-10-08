# JavaWebNotes
![](https://sun9-71.userapi.com/impg/bq-V3UKgogmWqX1dyVWsVZED6RxYlMVNLZ9ZPw/uhppUkwKJOU.jpg?size=1920x878&quality=96&sign=d23508b5b1e12f7430d220864aa9f241&type=album)
Web-приложение заметок на языке Java с использованием фреймворка Spring. Для хранения данных используется PosgreSQL.
## Установка
1) Для удобства запуска необходимо установить [IntelliJ IDEA 2023](https://www.jetbrains.com/ru-ru/idea/). Желательно использовать Java 17 версии;
2) Склонировать репозиторий на компьютер
```agsl
$ git clone https://github.com/Docaner/JavaWebNotes.git
```
3) Установить [PosgreSQL 15](https://www.postgresql.org/download/). После установки изменить конфиг подключения к базе данных внутри проекта. Документ `..src\main\resources\db.properties`:
```agsl
#========================================
# Данные для подключения СУБД PostgreSQL
#========================================
#IP-адрес
db.host=localhost
#Порт
db.port=5432
#База данных
db.base=notedb
#Пользователь
db.user=postgres
#Пароль
db.pass=postgres
#Таблица
db.table=postgres
```
4) Установить [Tomcat 10.1.13](https://tomcat.apache.org/download-10.cgi) или взять из проекта `../tomcat-server`. Внутри проекта указать путь до сервера. Для этого перейти в `Main menu -> Run -> Run...`. Выбрать `Edit configuration...`. Если в проекте уже указан путь до tomcat, то его необходимо удалить. Далее `Add new configuration -> Tomcat Server Local`. После нажать `Configure...` и указать путь до Tomcat. В конце необходимо нажать на `Fix`.
![](https://sun9-74.userapi.com/impg/JLFvEC0d5xlXCZnWi_6Tei-JzEQmoPwTebSANw/kW1O7x3MGik.jpg?size=1325x1021&quality=96&sign=3fb7b487ccbfe3b111bd7654f639eb64&type=album)
Выбрать `webnotes.war exploded`. Далее `Apply -> OK`. После можно запустить проект `Run`. 