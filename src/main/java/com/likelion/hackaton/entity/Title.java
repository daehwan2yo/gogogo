package com.likelion.hackaton.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "title",cascade = CascadeType.ALL)
    private City city;

    @Column
    @ColumnDefault("false")
    private boolean badge_1;

    @Column
    @ColumnDefault("false")
    private boolean badge_2;

    @Column
    @ColumnDefault("false")
    private boolean badge_3;

    @Column
    @ColumnDefault("false")
    private boolean badge_4;

    @Column
    @ColumnDefault("false")
    private boolean badge_5;

    @Column
    @ColumnDefault("false")
    private boolean badge_6;

    @Column
    @ColumnDefault("false")
    private boolean badge_7;

    @Column
    @ColumnDefault("false")
    private boolean badge_8;

    @Column
    @ColumnDefault("false")
    private boolean badge_9;

    public void initialize(){
        badge_1 = false;
        badge_2 = false;
        badge_3 = false;
        badge_4 = false;
        badge_5 = false;
        badge_6 = false;
        badge_7 = false;
        badge_8 = false;
        badge_9 = false;
    }

}
