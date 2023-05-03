package com.geekbrains.Interview.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "students")
@Data
@RequiredArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", unique = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @Column(name = "mark")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer mark;

}
