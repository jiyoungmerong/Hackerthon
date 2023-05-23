package com.jiyoung.hakerton.repository;


import com.jiyoung.hakerton.domain.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
}