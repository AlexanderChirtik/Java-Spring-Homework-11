В связи с неполадками в Intellij Idea пришлось разделить микросервисы на отдельные проекты. 

На микросервисе webClient настоен API-Gateway(port: 8765) для сервисов listTasks(port: 8081) и listWorkers(port: 8082).

Prometheus и Grafana настоены и работают для listTasks и listWorkers, скриншот и файл prometheus.yml прилагаются.

**SDK:** openjdk-21

**Language level:** SDK default