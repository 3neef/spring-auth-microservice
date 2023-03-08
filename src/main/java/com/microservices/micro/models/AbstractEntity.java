package com.microservices.micro.models;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

import com.microservices.micro.utilities.SecurityUtils;

import jakarta.annotation.PreDestroy;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AbstractEntity implements Serializable {

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate = new Date();

    @Column
    private String createBy = SecurityUtils.getCurrentUserLogin() == null ? "System"
            : SecurityUtils.getCurrentUserLogin();

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate = null;

    @Column
    private String lastModifiedBy;
    @Column
    private boolean deleted;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    @Column
    private String deletedBy;

    @Column
    private String uid = UUID.randomUUID().toString();
    @Column(nullable = true)
    private long causerId;

    @PrePersist
    public void prePersist() {
        setCreateBy(
                SecurityUtils.getCurrentUserLogin() == null
                        ? "System"
                        : SecurityUtils.getCurrentUserLogin());
        setCreationDate(Date.from(ZonedDateTime.now().toInstant()));

    }

    @PreUpdate
    public void preUpdate() {
        setLastModifiedBy(
                SecurityUtils.getCurrentUserLogin() == null
                        ? "System"
                        : SecurityUtils.getCurrentUserLogin());
        setLastModifiedDate(Date.from(ZonedDateTime.now().toInstant()));
    }

    @PreRemove
    public void preRemove() {
        setDeletedBy(
                SecurityUtils.getCurrentUserLogin() == null
                        ? "System"
                        : SecurityUtils.getCurrentUserLogin());
        setDeletedDate(Date.from(ZonedDateTime.now().toInstant()));

    }

}
