package newDataModule.dao;

import newDataModule.entities.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import java.util.List;

public class TeacherDAO extends AbstractDAO<Teacher, Integer>{

    public TeacherDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    private final Teacher empty = new Teacher();

    @Override
    public Teacher read(Integer id) {
        return read(id, empty);
    }

    @Override
    public List<Teacher> getList() {
        return getList(empty.getClass().getName());
    }

}
