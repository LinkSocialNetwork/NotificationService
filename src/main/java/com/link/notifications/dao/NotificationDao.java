package com.link.notifications.dao;

import com.link.notifications.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("notificationDao")
public interface NotificationDao extends JpaRepository<Notification, Integer> {


    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Gets a list of notifications for a specific user</p>
     * @param id - The id of the user to get the notifications for
     * @return A list of notifications for the specified user
     */
    List<Notification> findByTargetId(int id);

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Returns a list of notifications for a user of a specific type</p>
     * @param type - The type of notification to return
     * @param id - The user id to get notifications for
     * @return A list of notifications of a specific type for a specific user
     */
    List<Notification> finAllByType(String type, int id);

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Returns a list of all unread notifications for a specific user</p>
     * @param userId - The user id of the user to get notifications for
     * @return A list of unread notifications
     */
    List<Notification> findAllUnread(int userId);

    //----------------------------------------------------------------------------------------------//


}
