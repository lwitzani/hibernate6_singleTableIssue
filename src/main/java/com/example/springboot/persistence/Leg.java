package com.example.springboot.persistence;

import com.example.springboot.persistence.base.BodyPart;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Setter
@NoArgsConstructor
@DiscriminatorValue("LegBodyPart")
public class Leg extends BodyPart {
    public Leg(String name, Person person) {
        this.name = name;
        this.person = person;
    }
}
