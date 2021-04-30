package com.link.notifications.controller;

import com.link.notifications.model.Notification;
import com.link.notifications.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/notificationservice")
public class NotificationController {

    private NotificationService notificationServ;

    @Autowired
    public NotificationController(NotificationService notificationServ) {
        this.notificationServ = notificationServ;
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Gets all notifications for a specific user</p>
     * @param id - The user id of the user to get notifications for
     * @return A list of all notifications for the user
     */
    @GetMapping("/user/{id}")
    public List<Notification> getAll(@PathVariable int id){
        return notificationServ.getAllByUser(id);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>Gets one notification by its id</p>
     * @param id - The id of the notification to get
     * @return A notification that matches the id param
     */
    @GetMapping("/{id}")
    public Notification getOne(@PathVariable int id){
        return notificationServ.getOne(id);
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
        return notificationServ.getByType(type, id);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     *  <p>Gets a list of unread notifications for a specific user</p>
     * @param id - The user id of the user to get the notifications for
     * @return A list of unread notifications
     */
    @GetMapping("/user/{id}/unread")
    public List<Notification> getUnread(@PathVariable int id){
        return notificationServ.getUnread(id);
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p>deletes a notification by its id</p>
     * @param id - The id of the notification to delete
     * @return True for testing
     */
    @DeleteMapping("/{id}")
    public boolean deleteOne(@PathVariable int id){
        Notification n = notificationServ.getOne(id);
        notificationServ.deleteOne(n);
        return true;
    }

    //----------------------------------------------------------------------------------------------//

    /**
     * <p></p>
     * @param n
     * @return
     */
    @PostMapping("/")
    public boolean addOne(Notification n){
        return true;
    }
}
