package com.example.onlineServiceProvider.service;


import com.example.onlineServiceProvider.entity.base.BaseEntity;
import java.util.List;

public interface BaseService <T extends BaseEntity>  {


    public void add(T t);

    public void remove(T t);

    public void update(T t);

    public T findById(T t,int id);

    public List<T> findAll();

    public boolean checkId(int id,T t);


}
