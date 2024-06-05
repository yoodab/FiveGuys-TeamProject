package com.sparta.newspeed.repository;

import com.sparta.newspeed.entity.Peed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeedRepository extends JpaRepository<Peed, Long> {
    List<Peed> findAllByOrderByCreatedAtDesc();
}
