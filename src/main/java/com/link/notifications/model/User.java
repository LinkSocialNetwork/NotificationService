package com.link.notifications.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name="posts_users")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private int userID;

    @Column(name= "user_name", unique = true, nullable = false)
    private String userName;

    @ColumnDefault(value = "'/default_pp.png'")
    @Column(name= "profile_img_url", unique = false)
    private String profileImg;


}
