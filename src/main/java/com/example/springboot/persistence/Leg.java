package com.example.springboot.persistence;

import com.example.springboot.persistence.base.BodyPart;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@Setter
@NoArgsConstructor
@DiscriminatorValue("LegBodyPart")
public class Leg extends BodyPart {
    protected Person person;

    public Leg(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    public Person getPerson() {
        return person;
    }
}
