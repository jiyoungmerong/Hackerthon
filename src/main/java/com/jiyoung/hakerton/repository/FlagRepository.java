package com.jiyoung.hakerton.repository;

import com.jiyoung.hakerton.domain.Flag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlagRepository extends JpaRepository<Flag, Long> {
}
