# restapi-postgres-crud-tutorial

Spring Boot＋Postgres＋MyBatisを用いたRESTfulなWeb APIを作成して，テーブルに対するCRUD処理を実装する<br>
参照記事：[Zenn](https://zenn.dev/numacci/articles/202101_java_restapi-postgres)

## 環境

- Java 11
- Gradle

## 起動方法

1. Start PostgreSQL

````
$ cd /path/to/project/root
$ docker-compose up -d
````

2. Start Spring application by bootRun

````
$ ./gradlew bootRun
````

3. Access to http://localhost:8080/api/customers
