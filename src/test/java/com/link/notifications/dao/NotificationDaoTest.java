package com.link.notifications.dao;

import com.link.notifications.NotificationsApplication;
import com.link.notifications.model.Notification;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= NotificationsApplication.class)
@DataJpaTest
class NotificationDaoTest {

    @Autowired
    private NotificationDao dao;

    @Test
    void findByTargetId() {
        Notification n = new Notification();
            n.setTriggeredId(1);
            n.setTargetId(2);
            n.setRead(false);
            n.setType("like");

        dao.save(n);
        List<Notification> dbNote = dao.findByTargetId(2);

        Assert.assertNotNull(dbNote);
    }

    @Test
    void finAllByType() {
    }
}