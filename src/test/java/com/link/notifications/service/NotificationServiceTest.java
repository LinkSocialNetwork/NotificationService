package com.link.notifications.service;

import com.link.notifications.dao.NotificationDao;
import com.link.notifications.model.Notification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @Mock
    private NotificationDao notificationDao;

    private NotificationService notificationService;

    @BeforeEach
    void setUp() {
        notificationService = new NotificationService(notificationDao);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll() {
//        Date myDate;
//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.MONTH, 8);
//        cal.set(Calendar.DATE, 24);
//        cal.set(Calendar.YEAR, 2000);
//        myDate=cal.getTime();
//        Notification expected = new Notification(1,2,3,4, true, myDate);
//
//        Mockito.when(notificationDao.findById(1)).thenReturn(expected);
//
//        Notification actual = notificationService.getOne(1);
//
//        assertEquals(expected,actual);

        Notification not1 = new Notification();
        Notification not2 = new Notification();

        List<Notification> notList = new ArrayList<>();
        notList.add(not1);
        notList.add(not2);
        Mockito.when(notificationDao.findAll()).thenReturn(notList);
        assertArrayEquals(notList.toArray(), notificationService.getAll().toArray());
        Mockito.verify(notificationDao).findAll();

    }

    @Test
    void getAllByUser() {
        Notification not1 = new Notification();
        not1.setTargetId(1);
        Notification not2 = new Notification();
        not2.setTargetId(1);
        Notification not3 = new Notification();
        not3.setTargetId(2);


        List<Notification> notList = new ArrayList<>();
        notList.add(not1);
        notList.add(not2);
        Mockito.when(notificationDao.findByTargetId(1)).thenReturn(notList);
        assertArrayEquals(notList.toArray(), notificationService.getAllByUser(1).toArray());
        Mockito.verify(notificationDao).findByTargetId(1);

    }

    @Test
    void getOne() {
        Notification not1 = new Notification();
        not1.setId(1);

        Mockito.when(notificationDao.findById(1)).thenReturn(not1);

        assertEquals(not1, notificationService.getOne(1));

        Mockito.verify(notificationDao).findById(1);

    }

    @Test
    void getByType() {
        Notification not1 = new Notification();
        not1.setType("type1");
        not1.setTargetId(1);
        Notification not2 = new Notification();
        not2.setType("type1");
        not2.setTargetId(1);
        Notification not3 = new Notification();
        not3.setType("type2");
        not3.setTargetId(1);


        List<Notification> notList = new ArrayList<>();
        notList.add(not1);
        notList.add(not2);


        Mockito.when(notificationDao.findAllByTypeAndTargetId("type1", 1)).thenReturn(notList);
        assertArrayEquals(notList.toArray(), notificationService.getByType("type1", 1).toArray());
        Mockito.verify(notificationDao).findAllByTypeAndTargetId("type1", 1);
    }

    @Test
    void getUnread() {
        Notification not1 = new Notification();
        not1.setRead(false);
        not1.setTargetId(1);
        Notification not2 = new Notification();
        not2.setRead(false);
        not2.setTargetId(1);
        Notification not3 = new Notification();
        not3.setRead(true);
        not3.setTargetId(1);


        List<Notification> notList = new ArrayList<>();
        notList.add(not1);
        notList.add(not2);
        Mockito.when(notificationDao.findAllByTargetIdAndReadFalse(1)).thenReturn(notList);
        assertArrayEquals(notList.toArray(), notificationService.getUnread(1).toArray());
        Mockito.verify(notificationDao).findAllByTargetIdAndReadFalse(1);
    }
//
    @Test
    void addOne() {
    }

    @Test
    void deleteOne() {
    }

    @Test
    void updateOne() {
        Notification temp = new Notification();
        notificationService.updateOne(temp);
        Mockito.verify(notificationDao).save(temp);
    }

    @Test
    void markAllRead() {
    }

    @Test
    void markOneAsRead() {
    }
}