package com.zee.modulith.inventory.exposed;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 05 May, 2024
 */

@Getter
@Setter
@ToString
@Entity
@Table(indexes = @Index(name = "inventory_name_idx", columnList = "name"))
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;
    private long price;

}
