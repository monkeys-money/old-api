# monkeys-money Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Structure of Project

### Java

Here is the place where have all implementations

```
.
└── br
    └── com
        └── monkeys_money
            ├── app
            │   ├── ExpenditureResource.java
            │   ├── InvestmentResource.java
            │   ├── ProfileResource.java
            │   ├── RevenueResource.java
            │   └── UserResource.java
            ├── cross
            │   └── DateConveter.java
            ├── domain
            └── infradb
                ├── dataprovider
                ├── model
                │   ├── Expenditure.java
                │   ├── Investment.java
                │   ├── Profile.java
                │   ├── Revenue.java
                │   └── User.java
                └── repository
                    ├── ExpenditureRepository.java
                    ├── InvestmentRepository.java
                    ├── ProfileRespository.java
                    ├── Repository.java
                    ├── RevenueRepository.java
                    ├── UserRespository.java
                    └── factory
                        └── ConnectionFactory.java
```

### Test

Here is the place where have all tests of the repositories save, and find;

```
.
└── java
    └── br
        └── com
            └── monkeys_money
                └── PersistenceResourceTest.java
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.