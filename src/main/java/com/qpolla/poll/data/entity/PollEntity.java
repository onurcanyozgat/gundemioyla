package com.qpolla.poll.data.entity;

import com.qpolla.comment.data.entity.CommentEntity;
import com.qpolla.poll.data.EnumPollCategory;
import com.qpolla.poll.data.EnumPollStatus;
import com.qpolla.user.data.entity.UserEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "polls")
@Entity
public class PollEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<OptionEntity> optionList = new ArrayList<>();

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CommentEntity> entryList = new ArrayList<>();

    @Column
    @Enumerated(EnumType.STRING)
    private EnumPollCategory category;

    @Column
    private long votingStartDate;

    @Column
    private long votingEndDate;

    @Column
    private long approvedDate;

    @Column
    @Enumerated(EnumType.STRING)
    private EnumPollStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity author;

    @Column
    private String url;

    @Column
    private byte[] image;

    @Column
    private int totalVoteCount;
}