package com.singular.sportsbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.singular.sportsbook.entity.SportsBook;

@Repository
public interface SportsBookRepository extends JpaRepository<SportsBook, Long> {
}
