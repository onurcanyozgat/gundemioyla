package com.qpolla.user.data.entity;

import com.qpolla.role.data.entity.RoleEntity;
import com.qpolla.user.data.EnumUserStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "users")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
               inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private List<RoleEntity> roles = new ArrayList<>();

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