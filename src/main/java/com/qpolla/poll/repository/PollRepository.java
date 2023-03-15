package com.qpolla.poll.repository;

import com.qpolla.poll.data.EnumPollCategory;
import com.qpolla.poll.data.entity.PollEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<PollEntity, Long> {
    Page<PollEntity> findByCategory(EnumPollCategory category, PageRequest paging);
}