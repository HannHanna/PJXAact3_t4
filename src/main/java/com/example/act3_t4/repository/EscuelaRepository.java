package com.example.act3_t4.repository;

import com.example.act3_t4.model.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscuelaRepository extends JpaRepository<Escuela, Long> {
}