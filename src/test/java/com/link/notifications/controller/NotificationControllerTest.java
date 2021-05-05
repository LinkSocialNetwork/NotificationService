package com.link.notifications.controller;

import com.link.notifications.model.Notification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotificationControllerTest {

    @Autowired
    NotificationController notificationController;

    //----------------------------------------------------------------------------------------------//

    @Test
    void getAll() {
        List<Notification> list = notificationController.getAll(1);
        System.out.println(list);
    }

    //----------------------------------------------------------------------------------------------//

    @Test
    void getOne() {
        Notification notification = notificationController.getOne(1);
        System.out.println(notification);
    }

    //----------------------------------------------------------------------------------------------//

    @Test
    void getByType() {
    }

    //----------------------------------------------------------------------------------------------//

    @Test
    void getUnread() {
    }

    //----------------------------------------------------------------------------------------------//

    @Test
    void deleteOne() {
    }

    //----------------------------------------------------------------------------------------------//

    @Test
    void addOne() {
    }

    //----------------------------------------------------------------------------------------------//

}