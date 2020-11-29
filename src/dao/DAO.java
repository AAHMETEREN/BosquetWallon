package dao;

import java.util.List;

import pojo.Personne;

public interface  DAO<T> {
	public  boolean create(T obj);
	
	public  boolean delete(T obj);
	
	public  boolean update(T obj);
	
	public  T find(T obj);
	
	public  List<T> findAll(T obj);

}

