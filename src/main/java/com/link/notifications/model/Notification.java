package com.link.notifications.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "notifications")
public class Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="triggered_id", nullable=false)
    private int triggeredId;

    @Column(name="target_id", nullable=false)
    private int targetId;

    @Column(name="post_id", nullable=false)
    private int postId;

    @Column(name="type", nullable=false)
    private String type;

    @Column(name="read")
    @ColumnDefault("false")
    private boolean read;

    @Column(name="date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    private Date date;

}
