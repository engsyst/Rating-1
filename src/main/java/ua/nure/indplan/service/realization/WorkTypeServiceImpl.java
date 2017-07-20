package ua.nure.indplan.service.realization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.WorkTypeDao;
import ua.nure.indplan.entity.WorkType;
import ua.nure.indplan.service.WorkTypeService;

public class WorkTypeServiceImpl implements WorkTypeService {

    @Autowired
    WorkTypeDao typeDao;

    @Override
    public List<WorkType> getAll() {
        return typeDao.findAll();
    }

    @Override
    public void add(WorkType type) {
        typeDao.save(type);
    }

    @Override
    public WorkType getById(int id) {
        return typeDao.findOne(id);
    }

//    @Override
//    public void delete(WorkType type) {
//        typeDao.delete(type);
//    }

    @Override
    public void update(WorkType type) {
        typeDao.save(type);
    }
}
