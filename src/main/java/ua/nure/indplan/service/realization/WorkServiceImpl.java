package ua.nure.indplan.service.realization;

import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.WorkDao;
import ua.nure.indplan.entity.Work;
import ua.nure.indplan.service.WorkService;

import java.util.List;

public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkDao workDao;

    @Override
    public List<Work> getAll() {
        return workDao.findAll();
    }

    @Override
    public void add(Work work) {
        workDao.save(work);
    }

    @Override
    public Work getById(int id) {
        return workDao.findOne(id);
    }

    @Override
    public void delete(Work work) {
        workDao.delete(work);
    }

    @Override
    public void update(Work work) {
        workDao.save(work);
    }
}
