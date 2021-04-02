package newDataModule.dao;

import newDataModule.entities.Group;
import newDataModule.entities.Lesson;
import newDataModule.entities.Lesson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class LessonDAO extends AbstractDAO<Lesson, Integer> {

    public LessonDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    private final Lesson empty = new Lesson();

    @Override
    public Lesson read(Integer id) {
        return read(id, empty);
    }

    @Override
    public List<Lesson> getList() {
        return getList(empty.getClass().getName());
    }
}
