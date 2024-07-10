# testTask_NTT

# Spring приложение для управления организациями

### Запуск приложения
- Запустить PostgreSQL сервер.
- Создать базу данных с именем 'testTaskNTT'
- Или запустить Docker Desktop и в командной строке ввести команду: 
  **docker run --name testTaskNTT -e POSTGRES_DB=testTaskNTT -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres**
- Запустить в проекте TestTaskNttApplication
- Пройти по адресу http://localhost:8080/


### Данные администратора db:
- логин: postgres
- пароль: postgres
______________________________________________________

### *RestController*
________________________________________________

### Organization

**GET** "/api/organization" - get all organization;

**GET** "/api/organization/search" - get all organization by key;

**GET** "/api/organization/{id}" - get organization by id;


**POST** "/api/organization" - create organization;

**POST** "/api/organization/{id}/gendir/{gendirId}" - add adds a CEO to the organization;


**DELETE** "/api/organization/{id}" - delete organization;




### Branch organization

**GET** "/api/branchorg" - get all branch organization;

**GET** "/api/branchorg/search" - get all branch organization by key;

**GET** "/api/branchorg/{id}" - get branch organization by id;


**POST** "/api/branchorg" - create branch organization;

**POST** "/api/branchorg/{id}/headorg/{idheadorg}" - adds a manager to a branch of the organization;


**DELETE** "/api/branchorg/{id}" - delete branch organization;



### CEO

**GET** "/api/gendir" - get all CEO;

**GET** "/api/gendir/search" - get all CEO by key;

**GET** "/api/gendir/{id}" - get CEO by id;


**POST** "/api/gendir" - create CEO;


**DELETE** "/api/gendir/{id}" - delete CEO;


### Head organization

**GET** "/api/headorg" - get all head organization;

**GET** "/api/headorg/search" - get all head organization by key;

**GET** "/api/headorg/{id}" - get head organization by id;


**POST** "/api/headorg" - create head organization;


**DELETE** "/api/headorg/{id}" - delete head organization;




