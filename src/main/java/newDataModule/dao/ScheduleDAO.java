package newDataModule.dao;

import newDataModule.entities.Schedule;
import newDataModule.entities.Schedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ScheduleDAO extends AbstractDAO<Schedule,Integer> {

    public ScheduleDAO(@NotNull final SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    private final Schedule empty = new Schedule();

    @Override
    public Schedule read(Integer id) {
        return read(id, empty);
    }

    @Override
    public List<Schedule> getList() {
        return getList(empty.getClass().getName());
    }
}
