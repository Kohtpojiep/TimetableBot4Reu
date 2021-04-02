package newDataModule.dao;

import newDataModule.entities.Discipline;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DisciplineDAO extends AbstractDAO<Discipline, Integer> {

    private final Discipline empty = new Discipline();

    public DisciplineDAO(SessionFactory sessionFactory) {
        super(sessionFactory);

    }

    @Override
    public Discipline read(Integer id) {
        return read(id, empty);
    }
    @Override
    public List<Discipline> getList() {
        return getList(empty.getClass().getName());
    }
}
