package com.link.notifications.controller;

import com.link.notifications.model.Notification;
import com.link.notifications.service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.NotReadablePropertyException;
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

        Mockito.when(notificationService.getAll()).thenReturn(testList);

        assertArrayEquals(testList.toArray(), notificationService.getAll().toArray());

        Mockito.verify(notificationService).getAll();
    }

    //----------------------------------------------------------------------------------------------//

    @Test
    void getOne() {
        Notification not1 = new Notification();

        Mockito.when(notificationService.getOne(1)).thenReturn(not1);

        assertEquals(not1, notificationController.getOne(1));

        Mockito.verify(notificationService).getOne(1);
    }

    //----------------------------------------------------------------------------------------------//

    @Test
    void getByType() {
        Notification notification1 = new Notification();
        notification1.setType("type1");
        Notification notification2 = new Notification();
        notification1.setType("type2");
        Notification notification3 = new Notification();
        notification1.setType("type2");

        List<Notification> expected = new ArrayList<>();
        expected.add(notification2);
        expected.add(notification3);

        Mockito.when(notificationService.getByType("type2", 1)).thenReturn(expected);

        assertArrayEquals(expected.toArray(), notificationController.getByType("type2", 1).toArray());

        Mockito.verify(notificationService).getByType("type2", 1);

    }

    //----------------------------------------------------------------------------------------------//

    @Test
    void getUnread() {
        Notification read = new Notification();
        read.setRead(true);
        read.setTargetId(1);
        Notification unread1 = new Notification();
        unread1.setRead(false);
        unread1.setTargetId(1);
        Notification unread2 = new Notification();
        unread2.setRead(false);
        unread2.setTargetId(1);

        List<Notification> expected = new ArrayList<>();
        expected.add(unread1);
        expected.add(unread2);



        Mockito.when(notificationService.getUnread(1)).thenReturn(expected);

        assertArrayEquals(expected.toArray(), notificationController.getUnread(1).toArray());

        Mockito.verify(notificationService).getUnread(1);


    }

    //----------------------------------------------------------------------------------------------//

    @Test
    void deleteOne() {
        Notification toBeDeleted = new Notification();
        toBeDeleted.setId(1);

        Mockito.when(notificationService.getOne(1)).thenReturn(toBeDeleted);


        assertTrue(notificationController.deleteOne(1));
        Mockito.verify(notificationService).deleteOne(toBeDeleted);


    }

    //----------------------------------------------------------------------------------------------//

    @Test
    void addOne() {
        Notification toBeAdded = new Notification();

        Mockito.when(notificationService.addOne(toBeAdded)).thenReturn(true);

        assertTrue(notificationController.addOne(toBeAdded));

        Mockito.verify(notificationService).addOne(toBeAdded);
    }

    //----------------------------------------------------------------------------------------------//

    @Test
    void clearAllUnread(){

        Mockito.when(notificationService.markAllRead(1)).thenReturn(true);

        assertTrue(notificationController.clearAllUnread(1));

        Mockito.verify(notificationService).markAllRead(1);
    }

    @Test
    void markAsRead(){
        Mockito.when(notificationService.markOneAsRead(1)).thenReturn(true);

        assertTrue(notificationController.markAsRead(1));

        Mockito.verify(notificationService).markOneAsRead(1);

    }

}