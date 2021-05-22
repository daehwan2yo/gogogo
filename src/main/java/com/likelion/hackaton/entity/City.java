package com.likelion.hackaton.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Builder
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
    @ColumnDefault("0")
    private int todo_1;

    @Column
    @ColumnDefault("0")
    private int todo_2;

    @Column
    @ColumnDefault("0")
    private int todo_3;

    @Column
    @ColumnDefault("0")
    private int todo_4;

    @Column
    @ColumnDefault("0")
    private int todo_5;

    @Column
    @ColumnDefault("0")
    private int todo_6;

    @Column
    @ColumnDefault("0")
    private int todo_7;

    @Column
    @ColumnDefault("0")
    private int todo_8;

    @Column
    @ColumnDefault("0")
    private int todo_9;


}
