package com.qpolla.entry.repository;

import com.qpolla.entry.data.entity.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<EntryEntity, Long> {}