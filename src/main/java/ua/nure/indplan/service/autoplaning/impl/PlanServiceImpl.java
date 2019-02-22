package ua.nure.indplan.service.autoplaning.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.nure.indplan.dao.autoplaning.PlanDao;
import ua.nure.indplan.entity.autoplaning.Plan;
import ua.nure.indplan.service.autoplaning.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanDao planDao;
    @Override
    public Plan savePlan(Plan plan) {
       return planDao.save(plan);
    }
}
