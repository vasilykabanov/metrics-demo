# metrics-demo

### Запуск:

``docker-compose up``

### Grafana:

При локальном запуске открыть в браузере адрес http://localhost:3000 <br>
Логин/пароль: admin (задан в docker-compose.yml). <br>

Нужно указать data source.
Для этого выбираем в меню:<br>
Configuration -> Data sources -> Add data source -> Prometheus -><br>
В поле URL прописываем http://host.docker.internal:9090 -> Save & test.

Далее нужно добавить дашборд.
Для этого выбираем в меню:<br>
Dashboards -> Import -> Upload JSON file -><br>
указываем json-файл, например *jvm-micrometer_rev9.json* -> Import.