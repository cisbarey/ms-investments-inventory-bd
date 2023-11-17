package mx.com.actinver.ms.helpers;

import java.util.List;

public interface IEntityHelper<T,U> {
	
//	default U toEntity(T requestBean) {
//		return (new ModelMapper()).map(requestBean, getType());
//	}
//	
//	default T toBean(U entity) {
//		return (new ModelMapper()).map(entity, getType());
//	}
	public U toEntity(T requestBean);
	
	public List<U> toEntityAll(List<T> requestBean);
	
//	public List<U> toEntityHistoricalAll(List<T> requestBean);
	
	public T toBean(U entity);
	
//	public U updateEntityBean(U entity, T requestBean);
	
}
