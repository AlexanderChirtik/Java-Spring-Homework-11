package com.example.listWorkers.service;

import com.example.listWorkers.command.Notification;
import com.example.listWorkers.model.NotificationType;
import com.example.listWorkers.model.Worker;
import com.example.listWorkers.repository.WorkerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Класс для взаимодействия с базой данных и использования её методов.
 */
@Service
@AllArgsConstructor
public class WorkerService {

    /**
     * Список, в который Spring подаст все Bean, которые имплементируют Notification
     */
    private final List<Notification> list;

    /**
     * Словарь с ключом NotificationType и значением интерфейса Notification
     */
    private Map<NotificationType, Notification> map;


    /**
     * В map передается stream листа с Bean, которые имплементируют Notification. В функции toMap первый аргумент -
     * это ключ, а именно тип оповещения наблюдателей. Второй аргумент указывает, что будет значением в map.
     * Function.identity() делает значением сам объект stream.
     * Затем по ключу достаем notification и вызываем у него метод send(), передавая в него нового работника.
     * @param worker
     */
    public void send(Worker worker) {
        map = list.stream().collect(Collectors.toMap(Notification::getType, Function.identity()));
        Notification notification = map.get(worker.getType());
        notification.send(worker);
    }


    /**
     * Объект интерфейса WorkerRepository, с помощью которого будут вызываться методы для работы с БД.
     */
    private final WorkerRepository repository;

    /**
     * Получение всех находящихся в БД работников.
     * @return Возвращает список всех работников благодаря методу findAll() интерфейса TaskRepository.
     */
    public List<Worker> getAllWorkers() {
        return repository.findAll();
    }

    /**
     * Добавление работника в список.
     * @param worker Принимает нового работника.
     */
    public void addWorker(Worker worker) {
        repository.save(worker);
    }

    /**
     * Поиск работника по указанному id.
     * @param id Принимает порядковый номер работника.
     * @return Для обработки возможного null возвращает класс Optional с вложенной в него задачей.
     */
    public Optional<Worker> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Удаление работника из списка по порядковому номеру.
     * @param id Принимает номер работника.
     */
    public void deleteWorker(Long id) {
        repository.deleteById(id);
    }


}
