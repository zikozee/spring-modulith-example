package com.zee.modulith.eventaction;

import com.zee.modulith.eventaction.action.Action;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 14 May, 2024
 */

@Entity
@Getter
@Setter
@Table(indexes = {
        @Index(name = "actionIndex", columnList = "action,event_can", unique = true)
})
public class EventAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2, nullable = false)
    private Action action;
    @Column(name = "event_can", nullable = false)
    private String eventCanonicalName;
}
