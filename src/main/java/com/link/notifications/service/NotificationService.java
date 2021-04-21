package com.link.notifications.service;

import com.link.notifications.dao.NotificationDao;
import com.link.notifications.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service("notificationService")
public class NotificationService {

    NotificationDao dao;

    @Autowired
    public NotificationService(NotificationDao dao) {
        this.dao = dao;
    }

    //----------------------------------------------------------------------------------------------//

    /***
     *  <p>Calls dao to get a list of all notifications</p>
     * @return A list of all notifications
     */
    List<Notification> getAll(){
        return dao.findAll();
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Gets a list of all notifications for a specific user</p>
     * @param userId - The user id of the user to get notifications for
     * @return A list of notifications for a specific user
     */
    List<Notification> getAllByUser(int userId){
        return dao.findByTargetId(userId);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Gets a notification by its id</p>
     * @param id - The id of the notification to return
     * @return A notification that matches the provided id
     */
    Notification getOne(int id){
        return dao.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Returns a list of notifications of a specific type for a specific user</p>
     * @param type - The type of notification to return
     * @param id - The user to get notifications for
     * @return A list of notifications of a specific type for a specified user
     */
    List<Notification> getByType(String type, int id){
        return dao.finAllByType(type, id);
    }

    //----------------------------------------------------------------------------------------------//




}
