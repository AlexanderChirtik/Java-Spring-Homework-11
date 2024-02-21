package com.example.listWorkers.command;

import com.example.listWorkers.model.NotificationType;
import com.example.listWorkers.model.Worker;
import org.springframework.stereotype.Component;

/**
 * Оповещение наблюдателей о добавлении нового работника через СМС
 */
@Component
public class SMSlNotification implements Notification {
    @Override
    public void send(Worker worker) {
        System.out.println("Отправлено уведоление через СМС о добавлении " + worker.getName()
                + " на должность " + worker.getPost());
    }

    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }
}
