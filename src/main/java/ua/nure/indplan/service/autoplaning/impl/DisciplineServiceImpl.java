package ua.nure.indplan.service.autoplaning.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.autoplaning.DisciplineDao;
import ua.nure.indplan.entity.autoplaning.Discipline;
import ua.nure.indplan.service.autoplaning.DisciplineService;

public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineDao disciplineDao;

    @Override
    public void saveDiscipline(Discipline discipline) {
        disciplineDao.save(discipline);
    }
}
