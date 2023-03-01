package com.qpolla.repository;

import com.qpolla.data.entity.poll.PollEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<PollEntity, Long> {}