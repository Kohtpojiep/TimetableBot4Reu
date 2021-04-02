package newDataModule.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.Length;

import javax.persistence.*;


@Data
@Entity(name = "lessons")
@NoArgsConstructor
@Table(name = "lessons")
public class Lesson {

    @Id
    @Column(name = "id")
    private Integer idLesson;
    @Column(name = "schedule_id")
    private Integer idSchedule;
    @Column(name = "discipline_id")
    private Integer idDiscipline;
    @Column(name = "teacher_id")
    private Integer idTeacher;
    @Column(name = "lesson_num")
    private Integer lessonNum;
    @Column(name = "extra_info")
    private String extraInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_id", insertable = false, updatable = false)
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "discipline_id", insertable = false, updatable = false)
    private Discipline discipline;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Teacher teacher;

    public Teacher getTeacher(){
        return teacher;
    }
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public Integer getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(Integer idLesson) {
        this.idLesson = idLesson;
    }

    public Integer getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(Integer idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Integer getIdDiscipline() {
        return idDiscipline;
    }

    public void setIdDiscipline(Integer idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Integer getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(Integer lessonNum) {
        this.lessonNum = lessonNum;
    }

    public String getInformation() {
        return extraInfo;
    }

    public void setInformation(String information) {
        this.extraInfo = information;
    }


}
