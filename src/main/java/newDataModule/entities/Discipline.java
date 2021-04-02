package newDataModule.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.swing.*;
import java.util.List;


@Data
@Entity(name = "disciplines")
@NoArgsConstructor
@Table(name = "disciplines")
public class Discipline {

    @Id
    @Column(name = "id")
    private Integer idDiscipline;

    @Column(name = "name")
    private String disciplineName;

    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesson> lessons;

    public Integer getId() { return idDiscipline; }

    public void setId(Integer idDiscipline) { this.idDiscipline = idDiscipline; }

    public String getDisciplineName() { return disciplineName; }

    public void setDisciplineName(String disciplineName) { this.disciplineName = disciplineName; }
}
