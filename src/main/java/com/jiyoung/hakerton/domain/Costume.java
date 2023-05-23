package com.jiyoung.hakerton.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
public class Costume {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "costume_id")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String url;

    private String question;

    @Column(length = 10000000)
    private String info;

    private String hint;

    private String answer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "choice_id")
    private Choice choice;
}