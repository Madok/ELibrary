package com.zpo.elibrary.db.entity;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.zpo.elibrary.db.Role;

@Table("user")
public class User {

    @PrimaryKey("id")
    private Long id;

    @Column("name")
    private String name;

    @Column("password")
    private String password;

    @Column(value = "role")
    private Role role;

    public User() {
        super();
    }

    public User(final Long id, final String name, final String password) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "USER[id=" + id + ", name=" + name + "{role" + role.toString() + " }]";
    }
}
