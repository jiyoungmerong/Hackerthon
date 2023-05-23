package com.jiyoung.hakerton.repository;

import com.jiyoung.hakerton.domain.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandmarkRepository extends JpaRepository<Landmark, Long> {
}