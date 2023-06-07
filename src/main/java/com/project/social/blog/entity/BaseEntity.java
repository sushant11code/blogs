package com.project.social.blog.entity;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    protected Long id;

    @Column(name="created")
    protected Date created;

    /**
     this update entry will be auto updated on updating an entry, for that we just need to add
     "on update CURRENT TIMESTAMP" in table create sql.

     No need to write extra code/overhead to handle update from app side.
     */
    @Column(name="updated")
    protected Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
