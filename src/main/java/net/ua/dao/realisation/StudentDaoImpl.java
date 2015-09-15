package net.ua.dao.realisation;

import net.ua.dao.StudentDao;
import net.ua.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

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
}
