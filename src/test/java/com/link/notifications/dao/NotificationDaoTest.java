package com.link.notifications.dao;

import com.link.notifications.config.NotificationsJpaConfig;
import com.link.notifications.model.Notification;
import com.link.notifications.service.NotificationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { NotificationsJpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
class NotificationDaoTest {

    @Resource
    private NotificationDao dao;

    @Autowired
    public NotificationDaoTest(NotificationDao dao) {
        this.dao = dao;
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    void findByTargetId(Notification n) {
        n = new Notification();
        n.setTriggeredId(1);
        n.setTargetId(2);
        n.setRead(false);
        n.setType("like");

        dao.save(n);
        dao.findByTargetId(2);
    }

    @Test
    void finAllByType() {
    }
}