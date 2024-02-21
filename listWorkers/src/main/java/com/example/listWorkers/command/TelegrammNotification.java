package com.example.listWorkers.command;

import com.example.listWorkers.model.NotificationType;
import com.example.listWorkers.model.Worker;
import org.springframework.stereotype.Component;

/**
 * Оповещение наблюдателей о добавлении нового работника через Telegram
 */
@Component
public class TelegrammNotification implements Notification {
    @Override
    public void send(Worker worker) {
        System.out.println("Отправлено уведоление через Телеграмм о добавлении " + worker.getName()
                + " на должность " + worker.getPost());
    }

    @Override
    public NotificationType getType() {
        return NotificationType.TELEGRAMM;
    }
}
