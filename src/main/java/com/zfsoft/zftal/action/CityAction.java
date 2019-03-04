package com.zfsoft.zftal.action;/**
 * Created by  Administrator on 2019-03-01 03:50 PM
 */


import com.zfsoft.zftal.model.City;
import com.zfsoft.zftal.service.CityService;
import com.zfsoft.zftal.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: demo
 *
 * @description: CityAction demo
 *
 * @author: Majing
 *
 * @create: 2019-03-01 15:50
 **/
//@Component
public class CityAction extends BaseAction {

    private static final long serialVersionUID = 1L;
    private List<City> cities;

    @Autowired
    private CityService cityService;

    @SuppressWarnings("unchecked")
    @Override
    public String execute() throws Exception {
        cities = cityService.getAll();
        getValueStack().set("cityList", JSONUtils.obj2json(cities));
        return SUCCESS;
    }

    public String getCityList(){
        cities = cityService.getAll();
        getValueStack().set("cityList", JSONUtils.obj2json(cities));
        return SUCCESS;
    }
}