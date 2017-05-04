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
    public List<Work> getAllCategories() {
        return workDao.getAllCategories();
    }

    @Override
    public void addWork(Work work) {
        workDao.addWork(work);
    }

    @Override
    public Work getById(int id) {
        return workDao.getById(id);
    }

    @Override
    public void deleteWork(Work work) {
        workDao.deleteWork(work);
    }

    @Override
    public void updateWork(Work work) {
        workDao.updateWork(work);
    }
}
