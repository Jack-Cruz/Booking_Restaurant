package com.booking.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(
        name="turns",
        uniqueConstraints = {
                @UniqueConstraint(name="turn_name_unique",
                        columnNames = "name")
        }
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Turn {
    @Id
    @SequenceGenerator(
            name="turn_sequence",
            sequenceName = "turn_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "turn_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;
    @Column(
            name="name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @ManyToOne
    @JoinColumn(
            name="restaurant_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="restaurant_turn_fk"
            )
    )
    private Restaurant restaurant;

}
