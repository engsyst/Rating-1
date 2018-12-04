package ua.nure.indplan.service.autoplaning.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.nure.indplan.dao.autoplaning.DisciplineAttributeDao;
import ua.nure.indplan.entity.autoplaning.DisciplineAttribute;
import ua.nure.indplan.service.autoplaning.DisciplineAttributeService;

import java.util.List;

@Service
public class DisciplineAttributeServiceImpl implements DisciplineAttributeService {

    @Autowired
    private DisciplineAttributeDao dao;

    @Override
    public List<DisciplineAttribute> findAll() {
        return dao.findAll();
    }
}
