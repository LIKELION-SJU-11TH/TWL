package board.example.demo.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    private Instant created_At;

    @LastModifiedDate
    @Column(updatable = true)
    private Instant modified_At;

    public Instant getCreatedAt() {
        return created_At;
    }

    public void setCreatedAt(Instant created_At) {
        this.created_At = created_At;
    }

    public Instant getUpdatedAt() {
        return modified_At;
    }

    public void setUpdatedAt(Instant modified_At) {
        this.modified_At = modified_At;
    }
}


