package com.qpolla.data.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "QUser")
@Entity(name = "QUser")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String username;

    @Column
    private String mail;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private EnumUserType type;

    @Column
    @Enumerated(EnumType.STRING)
    private EnumUserStatus status;

    @Column
    private long registeredDate;

    @Column
    private long lastLoginDate;

    @Column
    private long banBeginDate;

    @Column
    private long banEndDate;

    @Column
    private String ip;

    @Column
    private byte[] avatar;

    @Column
    private String url;

    @Column
    private int pollCounter;
}