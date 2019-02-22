package ua.nure.indplan.dao.autoplaning;

import org.springframework.data.repository.CrudRepository;

import ua.nure.indplan.entity.autoplaning.Discipline;

public interface DisciplineDao extends CrudRepository<Discipline, Integer> {

    @Override
    <S extends Discipline> S save(S s);
}
