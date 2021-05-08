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

    /**
     * tests to see if getAll() returns the full list of notifications it is passed
     */
    @Test
    void getAll_ReturnsExpectedValues_WhenCalled() {

        Notification not1 = new Notification();
        Notification not2 = new Notification();

        List<Notification> notList = new ArrayList<>();
        notList.add(not1);
        notList.add(not2);
        Mockito.when(notificationDao.findAll()).thenReturn(notList);
        assertArrayEquals(notList.toArray(), notificationService.getAll().toArray());
        Mockito.verify(notificationDao).findAll();

    }

    /**
     * tests to see if getAllByUser returns all notifications sent back by the DB
     */
    @Test
    void getAllByUser_ReturnsAllNotificationsAssociatedWithUser() {
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

    /**
     * tests if getOne() returns the specified value given to it by the DAO.
     */
    @Test
    void getOne_ReturnsNotificationFromDAO_WhenSuccessful() {
        Notification not1 = new Notification();
        not1.setId(1);

        Mockito.when(notificationDao.findById(1)).thenReturn(not1);

        assertEquals(not1, notificationService.getOne(1));

        Mockito.verify(notificationDao).findById(1);

    }

    /**
     * tests if getByType() returns the values returned by dao.findAllByTypeAndTargetId()
     */
    @Test
    void getByType_ReturnsNotificationsReturnedByTheDAO_WhenSuccessful() {
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

    /**
     * tests to see if getUnread() returns the values returned by dao.findAllByTargetIdAndReadFalse()
     */
    @Test
    void getUnread_ReturnsNotificationsReturnedByTheDAO_WhenSuccessful() {
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

    /**
     * tests to see if addOne() returns true after calling dao.save()
     */
    @Test
    void addOne_ReturnsTrueAndCallsDAO_WhenSuccessful() {
        //Arrange
        Notification testNoti = new Notification(1,1,1,1, "like", true, new Date());

        assertTrue(notificationService.addOne(testNoti));

        Mockito.verify(notificationDao).save(testNoti);
    }

    /**
     * tests to see if deleteOne() returns true after calling dao.delete()
     */
    @Test
    void deleteOne_ReturnsTrueAndCallsDAO_WhenSuccessful() {
        Notification testNoti = new Notification(1,1,1,1, "like", true, new Date());

        assertTrue(notificationService.deleteOne(testNoti));

        Mockito.verify(notificationDao).delete(testNoti);
    }

    /**
     * tests to see if updateOne() returns true after calling dao.save()
     */
    @Test
    void updateOne_ReturnsTrueAndCallsDAO_WhenSuccessful() {
        Notification testNoti = new Notification(1,1,1,1, "like", true, new Date());

        assertTrue(notificationService.updateOne(testNoti));

        Mockito.verify(notificationDao).save(testNoti);
    }

    /**
     * tests if markAllRead() returns true and calls the dao X times, where X is the amount of notifications
     * to change.
     */
    @Test
    void markAllRead_ReturnsTrueandCallsDAOXTimes_WhenSuccessful() {
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

    /**
     * tests if markOneAsRead returns true and calls dao.save() when successful
     */
    @Test
    void markOneAsRead_ReturnsTrueAndCallsDAO_WhenSuccessful() {
        Notification noti1 = new Notification(1,1,1,1, "like", false, new Date());
        Mockito.when(notificationDao.findById(1)).thenReturn(noti1);

        assertTrue(notificationService.markOneAsRead(1));

        Mockito.verify(notificationDao).save(noti1);

    }
}