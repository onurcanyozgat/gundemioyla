package com.qpolla.poll.repository;

import com.qpolla.poll.data.entity.PollEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<PollEntity, Long> {}