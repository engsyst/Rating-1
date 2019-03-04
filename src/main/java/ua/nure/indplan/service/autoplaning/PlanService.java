package ua.nure.indplan.service.autoplaning;

import ua.nure.indplan.entity.autoplaning.Plan;

public interface PlanService {

    Plan savePlan(Plan plan);

    Plan getPlanById(int id);
}
