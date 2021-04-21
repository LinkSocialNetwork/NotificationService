package com.link.notifications.controller;

import com.link.notifications.model.Notification;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class NotificationController {

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Gets all notifications for a specific user</p>
     * @param id - The user id of the user to get notifications for
     * @return A list of all notifications for the user
     */
    @GetMapping("/notifications/user/{id}")
    public List<Notification> getAll(@PathVariable int id){
        return null;
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Gets one notification by its id</p>
     * @param id - The id of the notification to get
     * @return A notification that matches the id param
     */
    @GetMapping("/notifications/{id}")
    public Notification getOne(@PathVariable int id){
        return null;
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Get all notifications of a specific type for a specific user</p>
     * @param type - The type of notification to return
     * @param id - The user id of the User to get the notifications for
     * @return A list of notifications of the specified type
     */
    @GetMapping("/notifications/user/{id}/type/{type}")
    public List<Notification> getByType(@PathVariable String type, @PathVariable int id){
        return null;
    }

    //----------------------------------------------------------------------------------------------//

    /**
     *  <p>Gets a list of unread notifications for a specific user</p>
     * @param id - The user id of the user to get the notifications for
     * @return A list of unread notifications
     */
    @GetMapping("/notifications/user/{id}")
    public List<Notification> getUnread(@PathVariable int id){
        return null;
    }

    //----------------------------------------------------------------------------------------------//

}
