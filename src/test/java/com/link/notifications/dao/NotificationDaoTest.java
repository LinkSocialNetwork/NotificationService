package com.link.notifications.dao;

import com.link.notifications.model.Notification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class NotificationDaoTest {

    @Autowired
    private NotificationDao dao;

    //----------------------------------------------------------------------------------------------//

    /**
     * tests if findByTargetId returns the correct Notifications based on a given targetId
     */
    @Test
    void findByTargetId_ReturnsNotificationWithSpecifiedId_WhenSuccessful() {

        List<Notification> expected = new ArrayList<>();
        Notification n1 = new Notification();
        n1.setId(3);
        n1.setDate(null);
        n1.setPostId(4);
        n1.setRead(false);
        n1.setTargetId(3);
        n1.setTriggeredId(6);
        n1.setType("liked");
        expected.add(n1);
        List<Notification> actual = dao.findByTargetId(3);
        assertEquals(expected,actual);

    }
    //----------------------------------------------------------------------------------------------//

    /**
     * tests to see if findAllByTypeAndTargetId returns notifications with specfied TargetId and type
     */
    @Test
    void findAllByTypeAndTargetId_ReturnsNotificationsWithSpecifiedTypeAndId_WhenSuccessful() {
        List<Notification> expected = new ArrayList<>();
        Notification n1 = new Notification();
        n1.setId(2);
        n1.setDate(null);
        n1.setPostId(2);
        n1.setRead(false);
        n1.setTargetId(2);
        n1.setTriggeredId(3);
        n1.setType("commented");
        expected.add(n1);
        List<Notification> actual = dao.findAllByTypeAndTargetId("commented", 2);
        assertEquals(expected,actual);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * tests that findAllByTargetIdAndReadFalse() returns the unread messages of a particular user
     */
    @Test
    void findAllByTargetIdAndReadFalse_ReturnsUnreadNotificationsFromSpecificUser_WhenSuccessful(){
        List<Notification> expected = new ArrayList<>();

        Notification n1 = new Notification();
        n1.setId(1);
        n1.setDate(null);
        n1.setPostId(1);
        n1.setRead(false);
        n1.setTargetId(1);
        n1.setTriggeredId(2);
        n1.setType("liked");

        expected.add(n1);
        List<Notification> actual = dao.findAllByTargetIdAndReadFalse(1);
        assertEquals(expected, actual);
    }

    /**
     * tests that findById returns a Notification with a specified Id.
     */
    @Test
    void findById_ReturnsNotificationWithSpecifiedId_WhenSuccessful(){
        Notification expected = new Notification();
        expected.setId(1);
        expected.setDate(null);
        expected.setPostId(1);
        expected.setRead(false);
        expected.setTargetId(1);
        expected.setTriggeredId(2);
        expected.setType("liked");
        Notification actual = dao.findById(1);
        assertEquals(expected, actual);
    }

}