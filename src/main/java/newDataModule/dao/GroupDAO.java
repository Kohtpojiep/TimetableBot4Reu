package newDataModule.dao;

import newDataModule.entities.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.validation.constraints.NotNull;
import java.util.List;


public class GroupDAO extends AbstractDAO<Group, Integer> {

    private Session session = null;
    private SessionFactory sessionFactory;

    public GroupDAO(@NotNull final SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
        session = sessionFactory.openSession();
    }

    private final Group empty = new Group();

    @Override
    public Group read(Integer id) {
        return read(id, empty);
    }

    @Override
    public List<Group> getList() {
        return getList(empty.getClass().getName());
    }

    public Group getByName(String name){
        Query query = session.createQuery("from groups as g where g.groupName = :paramName", Group.class);
        query.setParameter("paramName", name);
        query.setFirstResult(0);
        query.setMaxResults(1);
        return (Group) query.uniqueResult();
    }
}
