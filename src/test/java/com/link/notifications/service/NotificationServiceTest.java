package com.link.notifications.service;

import com.link.notifications.dao.NotificationDao;
import com.link.notifications.model.Notification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

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
        Notification expected = new Notification(1,2,3,4, true, myDate);

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