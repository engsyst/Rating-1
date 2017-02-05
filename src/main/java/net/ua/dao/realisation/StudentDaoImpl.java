package net.ua.dao.realisation;

import net.ua.dao.StudentDao;
import net.ua.entity.Group;
import net.ua.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl extends AbstractSessionDAO  implements StudentDao {

    @Override
    public List<Student> getAllStudents() {
        return getSession().createQuery("from Student").list();
    }

    @Override
    public void addStudent(Student student) {
        getSession().save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        getSession().delete(student);
    }

    @Override
    public Student getById(int id) {
        return (Student) getSession().get(Student.class, id);
    }

    @Override
    public void updateStudent(Student student) {
        getSession().update(student);
    }

    @Override
    public void addStudentGroup(Student student, Group group) {
        student.getGroup().add(group);
        getSession().update(student);
    }
}
