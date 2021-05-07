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

import javax.validation.constraints.AssertTrue;
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
        Date myDate;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 8);
        cal.set(Calendar.DATE, 24);
        cal.set(Calendar.YEAR, 2000);
        myDate=cal.getTime();
        Notification expected = new Notification(1,1,1,1, "like", true, myDate);

        Mockito.when(notificationDao.findById(1)).thenReturn(expected);

        Notification actual = notificationService.getOne(1);

        assertEquals(expected,actual);

    }

    @Test
    void getAllByUser() {
    }

    @Test
    void getOne() {
    }

    @Test
    void getByType() {
    }

    @Test
    void getUnread() {
    }

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