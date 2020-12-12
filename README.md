Открытое API от SpaceX расположено по адресу

https://docs.spacexdata.com/?version=latest

1	Написать клиент API к разделам Rockets и Launches.
2	Написать RestApi c двумя методами
1.	Получить список rocketId из раздела Rockets
2.	Получить по rocketId все возможные Launches. Но показывать только mission_name, launch_year, links.
3	Сохранять в базу все запросы к RestAPI, сохраняя структуру ответов

Использовать можно springboot и стартеры нужные для разработки приложения, любую реализацию JPA, PostgreSql. Для сборки использовать Maven.
