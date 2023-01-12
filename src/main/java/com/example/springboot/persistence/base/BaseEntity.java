package com.example.springboot.persistence.base;

import lombok.Setter;

import javax.persistence.*;

@Setter
@MappedSuperclass
public abstract class BaseEntity {
    protected long id;
    protected String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }
}
