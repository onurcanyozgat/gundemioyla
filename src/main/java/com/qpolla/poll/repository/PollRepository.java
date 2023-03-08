package com.qpolla.poll.repository;

import com.qpolla.poll.data.entity.PollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<PollEntity, Long> {}