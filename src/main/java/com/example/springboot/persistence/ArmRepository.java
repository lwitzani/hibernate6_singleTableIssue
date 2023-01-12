package com.example.springboot.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmRepository extends JpaRepository<Arm, Long> {
}
