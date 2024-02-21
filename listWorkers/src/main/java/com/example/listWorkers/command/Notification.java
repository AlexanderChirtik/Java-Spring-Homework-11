package com.example.listWorkers.command;

import com.example.listWorkers.model.NotificationType;
import com.example.listWorkers.model.Worker;

/**
 * Интерфейс уведомления наблюдателя
 */
public interface Notification {

    /**
     * Метод отправки сообщения о создании нового работника
     * @param worker Принимает данные о новом работнике
     */
    void send(Worker worker);


    /**
     * Метод определяет тип оповещения, который указан при добавлении работника
     * @return Возвращает тип оповещения
     */
    NotificationType getType();
}
