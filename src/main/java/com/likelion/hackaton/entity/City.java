package com.likelion.hackaton.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<Account> accountList;

    @OneToOne
    @JoinColumn(name="title_id")
    private Title title;

    @Column(nullable = false,unique = true)
    private String name;

    @Column
    private int todo_1;

    @Column
    private int todo_2;

    @Column
    private int todo_3;

    @Column
    private int todo_4;

    @Column
    private int todo_5;

    @Column
    private int todo_6;

    @Column
    private int todo_7;

    @Column
    private int todo_8;

    @Column
    private int todo_9;



}
