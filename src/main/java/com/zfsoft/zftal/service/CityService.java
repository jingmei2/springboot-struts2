/** service 接口 */

package com.zfsoft.zftal.service;

import com.zfsoft.zftal.model.City;

import java.util.List;

public interface CityService {
    City getByProvinceId(Long provinceId);

    List<City> getAll();

    String createCity(City city);
    void updateCity(City city);
    void removeCity(String id);
}
