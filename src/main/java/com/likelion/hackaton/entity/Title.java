package com.likelion.hackaton.entity;

import javax.persistence.*;

@Entity
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "title")
    private City city;

    @Column
    private boolean badge_1;

    @Column
    private boolean badge_2;

    @Column
    private boolean badge_3;

    @Column
    private boolean badge_4;

    @Column
    private boolean badge_5;

    @Column
    private boolean badge_6;

    @Column
    private boolean badge_7;

    @Column
    private boolean badge_8;

    @Column
    private boolean badge_9;


}
