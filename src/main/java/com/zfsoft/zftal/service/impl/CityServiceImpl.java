package com.zfsoft.zftal.service.impl;

import com.zfsoft.zftal.mapper.City2Mapper;
import com.zfsoft.zftal.mapper.CityMapper;
import com.zfsoft.zftal.model.City;
import com.zfsoft.zftal.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Resource
    private CityMapper cityMapper;
    @Resource
    private City2Mapper city2Mapper;

    @Override
    public City getByProvinceId(Long provinceId) {
        return cityMapper.findByProvinceId(provinceId);
    }
    @Override
    public List<City> getAll() {
//        return cityMapper.findAll();
        return city2Mapper.selectAll();
    }
    @Override
    public String createCity(City city) {
        cityMapper.createCity(city);
        return "success";
    }
    @Override
    public void updateCity(City city) {
        cityMapper.updateCity(city);
    }
    @Override
    public void removeCity(String id) {
        cityMapper.deleteCity(id);
    }
}