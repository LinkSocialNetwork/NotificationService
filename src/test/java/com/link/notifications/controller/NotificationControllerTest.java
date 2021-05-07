package com.link.notifications.controller;

import com.link.notifications.model.Notification;
import com.link.notifications.service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class NotificationControllerTest {

    @Autowired
    NotificationController notificationController;

    @Mock
    NotificationService notificationService;

    @BeforeEach
    void setUp() {notificationController = new NotificationController(notificationService);}

    //----------------------------------------------------------------------------------------------//

    @Test
    void getAll() {
        Notification not1 = new Notification();
        Notification not2 = new Notification();
        Notification not3 = new Notification();
        List<Notification> testList = new ArrayList<>();

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