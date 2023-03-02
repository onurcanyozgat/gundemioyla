package com.qpolla.poll.repository;

import com.qpolla.poll.data.PollEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<PollEntity, Long> {}