package com.zfsoft.zftal.service;

import com.zfsoft.zftal.model.City;
import java.util.List;

public interface CityService {

    City getByProvinceId(Long provinceId);

    List<City> getAll();

}
