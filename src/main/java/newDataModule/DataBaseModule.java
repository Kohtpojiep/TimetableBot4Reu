package newDataModule;

import data.Schedule;

import java.util.List;

public class DataBaseModule implements DataAccess {


    @Override
    public void save(Schedule schedule) {

    }

    @Override
    public Schedule getOne(Schedule schedule) {
        return null;
    }

    @Override
    public List<Schedule> getListByDate(String date) {
        return null;
    }

    @Override
    public List<Schedule> getListByName(String name) {
        return null;
    }
}
