package com.qpolla.entry.data.entity;

import com.qpolla.entry.data.EnumEntryStatus;
import com.qpolla.poll.data.entity.PollEntity;
import com.qpolla.user.data.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "QEntry")
@Entity(name = "QEntry")
public class EntryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private EntryEntity parent;

    @ManyToOne(fetch = FetchType.LAZY)
    private PollEntity poll;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity author;

    @Column
    private long date;

    @Column
    @Enumerated(EnumType.STRING)
    private EnumEntryStatus status;

    @Column
    private String url;

    @Column
    private int downVoteCount;

    @Column
    private int upvoteCount;
}