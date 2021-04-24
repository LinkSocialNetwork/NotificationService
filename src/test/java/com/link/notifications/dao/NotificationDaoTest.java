package com.link.notifications.dao;

import com.link.notifications.model.Notification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.Assert.*;

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
    void findAllByTriggeredIdAndReadFalse(){
        List<Notification> dbNote = dao.findAllByTriggeredIdAndReadFalse(1);
        System.out.println(dbNote);
    }

}