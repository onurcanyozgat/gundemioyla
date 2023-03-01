package com.qpolla.repository;

import com.qpolla.data.entity.entry.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<EntryEntity, Long> {}