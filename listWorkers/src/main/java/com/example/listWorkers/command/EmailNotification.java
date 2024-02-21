package com.example.listWorkers.command;

import com.example.listWorkers.model.NotificationType;
import com.example.listWorkers.model.Worker;
import org.springframework.stereotype.Component;

/**
 * Оповещение наблюдателей о добавлении нового работника по электронной почте
 */
@Component
public class EmailNotification implements Notification {
    @Override
    public void send(Worker worker) {
        System.out.println("Отправлено уведоление через электронную почту о добавлении " + worker.getName()
                + " на должность " + worker.getPost());
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }
}
