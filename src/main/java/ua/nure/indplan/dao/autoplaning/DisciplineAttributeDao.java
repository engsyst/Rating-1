package ua.nure.indplan.dao.autoplaning;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.autoplaning.DisciplineAttribute;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DisciplineAttributeDao extends CrudRepository<DisciplineAttribute, Integer> {

    @Override
    List<DisciplineAttribute> findAll();
}
