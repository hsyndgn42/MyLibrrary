package com.hd.mylibrary.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -5447272714513280439L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Long id;

    @Column(name = "CREATE_DATE", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String localDate = creationDate.format(formatter);
        return LocalDateTime.parse(localDate, formatter);
    }

    /*
        set creation date before insert
     */
    @PrePersist
    public void setCreationDate() {
        this.creationDate = LocalDateTime.now();
    }

    public LocalDateTime getUpdateDate() {
        if (updateDate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String localDate = updateDate.format(formatter);
            return LocalDateTime.parse(localDate, formatter);
        }
        return updateDate;
    }

    /*
        set creation date before update
     */
    @PreUpdate
    public void setUpdateDate() {
        this.updateDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id) &&
                creationDate.equals(that.creationDate) &&
                updateDate.equals(that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, updateDate);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
