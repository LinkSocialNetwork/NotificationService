package com.link.notifications.dao;

import com.link.notifications.model.Notification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class NotificationDaoTest {

    @Autowired
    private NotificationDao dao;

    //----------------------------------------------------------------------------------------------//

    @Test
    void findByTargetId() {
        List<Notification> dbNote = dao.findByTargetId(1);
        System.out.println(dbNote);

    }

    //----------------------------------------------------------------------------------------------//

    @Test
    void findAllByTypeAndTargetId() {
        List<Notification> dbNote = dao.findAllByTypeAndTargetId("like", 1);
        System.out.println(dbNote);
    }

    //----------------------------------------------------------------------------------------------//

    @Test
    void findAllByTargetIdAndReadFalse(){
        List<Notification> expected = new ArrayList<>();

        Notification n1 = new Notification();
        n1.setId(1);
        n1.setDate(new Date(0000 ,00,00,00,00,00));
        n1.setPostId(1);
        n1.setRead(false);
        n1.setTargetId(1);
        n1.setTriggeredId(2);
        n1.setType("liked");

        expected.add(n1);
        List<Notification> actual = dao.findAllByTargetIdAndReadFalse(1);
        assertEquals(expected, actual);
    }

}