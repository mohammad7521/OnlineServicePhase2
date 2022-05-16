package com.example.onlineServiceProvider.service.impl;

import com.example.onlineServiceProvider.entity.base.BaseEntity;
import com.example.onlineServiceProvider.exception.NoSuchId;
import com.example.onlineServiceProvider.repository.BaseRepo;
import com.example.onlineServiceProvider.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.List;


@Service
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {



    private BaseRepo<T,Integer> baseRepo;



    public BaseServiceImpl(BaseRepo<T, Integer> baseRepo) {
        this.baseRepo = baseRepo;
    }

    @Override
    @Transactional
    public void add(T t) {
        t.setTime(new Time(System.currentTimeMillis()));
        t.setDate(new Date(System.currentTimeMillis()));
        baseRepo.save(t);
    }

    @Override
    @Transactional
    public void remove(T t) {
        if (!checkId(t.getId(),t)){
            throw new NoSuchId();
        }
        baseRepo.delete(t);
    }

    @Override
    @Transactional
    public void update(T t) {
        if (!checkId(t.getId(),t)){
            throw new NoSuchId();
        }
        baseRepo.save(t);
    }

    @Override
    @Transactional
    public T findById(T t,int id) {
        if (!checkId(id,t)){
            throw new NoSuchId();
        }
        return baseRepo.findById(id).get();
    }

    @Override
    @Transactional
    public List<T> findAll() {
        return baseRepo.findAll();
    }

    @Override
    public boolean checkId(int id, T t) {
        boolean flag = false;
        List<T> tList = findAll();

        for (T tItem: tList) {
            if (tItem.getId()==id) {
                flag = true;
                break;
            }
        }
        return flag;
    }


}
