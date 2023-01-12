package com.example.springboot.persistence.base;

import com.example.springboot.persistence.Person;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator")
@Table(name = "body_part")
public abstract class BodyPart extends BaseEntity {
    protected Person person;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    public Person getPerson() {
        return person;
    }
}
