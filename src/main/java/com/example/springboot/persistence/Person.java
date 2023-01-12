package com.example.springboot.persistence;

import com.example.springboot.persistence.base.BaseEntity;
import com.example.springboot.persistence.base.BodyPart;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@NoArgsConstructor
@Table(name = "person")
public class Person extends BaseEntity {
    private Set<BodyPart> bodyParts = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<BodyPart> getBodyParts() {
        return bodyParts;
    }
}
