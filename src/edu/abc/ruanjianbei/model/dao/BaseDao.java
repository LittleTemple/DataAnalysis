package edu.abc.ruanjianbei.model.dao;

public interface BaseDao {
	
	public Boolean add(Object o);
	public Boolean delete(Object o);
	public Boolean update(Object o);
	public Object list();
}
