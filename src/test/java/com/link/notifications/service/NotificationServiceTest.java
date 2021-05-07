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
        //Arrange
        Notification testNoti = new Notification(1,1,1,1, "like", true, new Date());

        assertTrue(notificationService.addOne(testNoti));

        Mockito.verify(notificationDao).save(testNoti);
    }

    @Test
    void deleteOne() {
        Notification testNoti = new Notification(1,1,1,1, "like", true, new Date());

        assertTrue(notificationService.deleteOne(testNoti));

        Mockito.verify(notificationDao).delete(testNoti);
    }

    @Test
    void updateOne() {
        Notification testNoti = new Notification(1,1,1,1, "like", true, new Date());

        assertTrue(notificationService.updateOne(testNoti));

        Mockito.verify(notificationDao).save(testNoti);
    }

    @Test
    void markAllRead() {
        //Arrange
        Notification noti1 = new Notification(1,1,1,1, "like", false, new Date());
        Notification noti2 = new Notification(1,1,1,1, "like", false, new Date());
        Notification noti3 = new Notification(1,1,1,1, "like", false, new Date());

        List<Notification> testList = new ArrayList<>();
        testList.add(noti1);
        testList.add(noti2);
        testList.add(noti3);

        Mockito.when(notificationDao.findAllByTargetIdAndReadFalse(1)).thenReturn(testList);

        assertTrue(notificationService.markAllRead(1));

        Mockito.verify(notificationDao).findAllByTargetIdAndReadFalse(1);

        Mockito.verify(notificationDao, Mockito.times(3)).save(Mockito.any());

    }

    @Test
    void markOneAsRead() {
        Notification noti1 = new Notification(1,1,1,1, "like", false, new Date());
        Mockito.when(notificationDao.findById(1)).thenReturn(noti1);

        assertTrue(notificationService.markOneAsRead(1));

        Mockito.verify(notificationDao).save(noti1);

    }
}