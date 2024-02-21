package com.example.listWorkers.controller;

import com.example.listWorkers.service.FileGateway;
import lombok.AllArgsConstructor;
import com.example.listWorkers.model.Worker;
import com.example.listWorkers.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Класс для взаимодействия с внешними пользователями.
 */
@RestController
@RequestMapping("/serviceB")
@AllArgsConstructor
public class WorkerController {

    /**
     * Экземпляр класса WorkerService для использования методов сервиса.
     */
    private final WorkerService service;

    /**
     * Реализация интерфейса FileGateway для вызова метода writeToFile()
     */
    private FileGateway fileGateway;


    /**
     * Обработка информации о новом работнике для внесения её в базу данных. Также внутри вызываются 2 метода:
     * service.send() и fileGateway.writeToFile() для отправки сообщения наблюдателям о добавлении нового работника
     * и записи данных о новом работнике в отдельный файл соответственно.
     * @param worker Принимает информацию о новом работнике в теле запроса.
     * @return Возвращает список всех работников для наглядной демонстрации, что новый работник был добавлен.
     */
    @PostMapping("/add")
    public List<Worker> addWorker(@RequestBody Worker worker) {
        service.addWorker(worker);
        service.send(worker);
        fileGateway.writeToFile(worker.getName() + ".txt", worker.toString());
        return service.getAllWorkers();
    }

    /**
     * Получение списка всех работников.
     * @return Возвращает список работников.
     */
    @GetMapping
    public List<Worker> getAllWorkers() {
        return service.getAllWorkers();
    }

    /**
     * Возвращение работника по его идентификационному номеру.
     * @param id Принимает номер работника из адресной строки запроса.
     * @return Возвращает работника.
     */
    @GetMapping("/{id}")
    public Optional<Worker> findWorkerById(@PathVariable Long id) {
        return service.findById(id);
    }

    /**
     * Удаление работника из списка по его id.
     * @param id Принимает номер работника из адресной строки запроса.
     * @return Возвращает информационное сообщение о том, что работник был удален.
     */
    @DeleteMapping("/{id}")
    public String deleteWorker(@PathVariable Long id) {
        service.deleteWorker(id);
        return "Worker deleted";
    }
}
