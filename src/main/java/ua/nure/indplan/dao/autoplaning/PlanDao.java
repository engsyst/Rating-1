package ua.nure.indplan.dao.autoplaning;

import org.springframework.data.repository.CrudRepository;

import ua.nure.indplan.entity.autoplaning.Plan;

public interface PlanDao extends CrudRepository<Plan, Integer> {

    @Override
    <S extends Plan> S save(S s);

    @Override
    Plan findOne(Integer integer);
}
