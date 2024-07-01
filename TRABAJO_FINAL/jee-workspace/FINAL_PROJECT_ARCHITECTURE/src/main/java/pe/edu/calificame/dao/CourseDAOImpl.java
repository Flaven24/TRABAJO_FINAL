package pe.edu.calificame.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Course;

/**
 * Session Bean implementation class CourseDAOImpl
 */
@Stateless
@LocalBean
public class CourseDAOImpl implements CourseDAO {

	@PersistenceContext(unitName = "JPA_CALIFICAME")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public CourseDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Course> listAll() {
		List<Course> lista = em.createNamedQuery("Course.findAll").getResultList();
		return lista;
	}

	@Override
	public List<Course> findByName(String name) {
		TypedQuery<Course> list = em.createNamedQuery("Course.findByName", Course.class);
		list.setParameter("name",name);
		return list.getResultList();
	}
}
