package com.pl.musicRepository.repository;

import com.pl.musicRepository.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface historyRepository extends JpaRepository<History, Integer> {
}
