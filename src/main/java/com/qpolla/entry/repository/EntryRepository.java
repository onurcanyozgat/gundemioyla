package com.qpolla.entry.repository;

import com.qpolla.entry.data.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<EntryEntity, Long> {}