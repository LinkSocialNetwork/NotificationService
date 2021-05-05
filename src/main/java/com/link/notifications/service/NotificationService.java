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
    public List<Notification> getAll(){
        return dao.findAll();
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Gets a list of all notifications for a specific user</p>
     * @param userId - The user id of the user to get notifications for
     * @return A list of notifications for a specific user
     */
    public List<Notification> getAllByUser(int userId){
        return dao.findByTargetId(userId);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Gets a notification by its id</p>
     * @param id - The id of the notification to return
     * @return A notification that matches the provided id
     */
    public Notification getOne(int id){
        return dao.findById(id);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Returns a list of notifications of a specific type for a specific user</p>
     * @param type - The type of notification to return
     * @param id - The user to get notifications for
     * @return A list of notifications of a specific type for a specified user
     */
    public List<Notification> getByType(String type, int id){
        return dao.findAllByTypeAndTargetId(type, id);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Calls dao to get a list of all unread notifications for a user</p>
     * @param userId - The id of the user to get notifications for
     * @return A list of unread notifications for the specified user
     */
    public List<Notification> getUnread(int userId){
        return dao.findAllByTargetIdAndReadFalse(userId);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Saves a notification to the database</p>
     * @param notification - The notification to add to the database
     * @return True for testing purposes
     */
    public boolean addOne(Notification notification){
        dao.save(notification);
        return true;
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Calls dao to delete a notification from the database</p>
     * @param notification - The notification to delete
     * @return A true value for testing
     */
    public boolean deleteOne(Notification notification){
        dao.delete(notification);
        return true;
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Updates a notifications details in the database</p>
     * @param notification - The notification to update
     * @return A true value for testing
     */
    public boolean updateOne(Notification notification){
        dao.save(notification);
        return true;
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * Marks all notifications as read for user
     * @param userId - Id of the user to mark notifications as read
     * @return True or false
     */
    public boolean markAllRead(int userId) {
        List<Notification> list = dao.findAllByTargetIdAndReadFalse(userId);
        for( Notification n : list){
            n.setRead(true);
            dao.save(n);
        }
        return true;
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * Marks one notification as read
     * @param notificationId - The id of the notification
     * @return true if save works
     */
    public boolean markOneAsRead(int notificationId) {
        Notification n = dao.findById(notificationId);
        n.setRead(true);
        return dao.save(n) != null;
    }

    //----------------------------------------------------------------------------------------------//


}
