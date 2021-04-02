package newDataModule.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity(name = "groups")
@NoArgsConstructor
@Table(name = "groups")
public class Group {

    @Id
    @Column(name = "id")
    private Integer groupId;

    public Integer getGroupId() { return groupId; }

    public void setGroupId(Integer groupId) { this.groupId = groupId; }

    @Column(name = "name")
    private String groupName;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Set<Schedule> schedules;
    public Set<Schedule> getSchedules() { return schedules; }

    public void setSchedules(Set<Schedule> schedules) { this.schedules = schedules; }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
