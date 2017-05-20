package ua.nure.indplan.dao;

import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.Work;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface WorkDao {

    List<Work> getAll();

    void addWork(Work work);

    Work getById(int id);

    void deleteWork(Work work);

    void updateWork(Work work);
}
