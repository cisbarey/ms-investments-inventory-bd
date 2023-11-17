package mx.com.actinver.ms.services;

import javax.persistence.EntityManager;
import javax.persistence.Table;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.List;

public interface Create<T, U> {
	
	public T create(T requestBean);
	
	public T createAll(List<T> requestBean);


	default <T> String getTableName(EntityManager em, Class<T> entityClass) {
		/*
		 * Check if the specified class is present in the metamodel. Throws
		 * IllegalArgumentException if not.
		 */
		Metamodel meta = em.getMetamodel();
		EntityType<T> entityType = meta.entity(entityClass);

		// Check whether @Table annotation is present on the class.
		Table t = entityClass.getAnnotation(Table.class);

		// return String
		return (t == null) ? entityType.getName().toUpperCase() : t.name();
	}
}
