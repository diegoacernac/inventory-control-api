package com.cibertec.inventorycontrolapi.services;

import com.cibertec.inventorycontrolapi.entities.HomeOption;

import java.util.List;

public interface HomeOptionService {
    List<HomeOption> findAll() throws Exception;
    List<HomeOption> findByUserType() throws Exception;
    List<HomeOption> findByMenuType(int menu) throws Exception;
    HomeOption findById(Long id) throws Exception;
    HomeOption save(HomeOption homeOption) throws Exception;
    HomeOption update(Long id, HomeOption homeOption) throws Exception;
    HomeOption delete(Long id) throws Exception;
}
