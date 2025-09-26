# British Time Converter

A maven project Converts 24-hour time (e.g., "14:30") to British spoken form (e.g., "half past two").

## How to Use
Enter the time in the config.properties file

## How to Build
mvn clean install -Dmaven.test.skip=true
to run along with unit tests

## How to run
```bash
mvn clean package
java -jar target/time-converter.jar config.properties
