package newDataModule.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Proxy(lazy=false)
@Data
@Entity(name = "schedules")
@NoArgsConstructor
@Table(name = "schedules")
public class Schedule {
    @Id
    @Column(name ="id")
    private Integer id;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "date")
    private Date date;

    @Column(name = "hashcode")
    private Integer hashcode;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesson> lessons;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Group group;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public Integer getGroupId() { return groupId; }

    public void setGroupId(Integer groupId) { this.groupId = groupId; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public Integer getHashcode() {
        return hashcode;
    }

    public void setHashcode(Integer hashcode) {
        this.hashcode = hashcode;
    }

    public Group getGroup(){ return group; }

    public void setGroup(Group group) { this.group = group; }
}
