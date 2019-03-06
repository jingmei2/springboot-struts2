package com.zfsoft.zftal.action;/**
 * Created by  Administrator on 2019-03-01 03:50 PM
 */


import com.zfsoft.zftal.model.City;
import com.zfsoft.zftal.service.CityService;
import com.zfsoft.zftal.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;
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
@Controller
@RequestMapping("/user")
public class CityAction extends BaseAction {

//    @GetMapping("/")
//    public String index() {
//        return "redirect:/error";
//    }

    private static final long serialVersionUID = 1L;
    private List<City> cities;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public String[] getArryStr() {
        return arryStr;
    }

    public void setArryStr(String[] arryStr) {
        this.arryStr = arryStr;
    }

    //遍历数组,可以在 jsp 页面直接显示,但是需要增加 get set
    //页面上获取数据,可以 Struts 标签,也可以${xxx}
    //getValueStack也可以保存数据,提供给页面使用
    //getValueStack().set("cities", cities); getValueStack().set("cityList", JSONUtils.obj2json(cities));在页面需要json的时候，才转成json数据传到前台

    private String [] arryStr;

    @Autowired
    private CityService cityService;

    @SuppressWarnings("unchecked")
    @Override
    public String execute() throws Exception {
        cities = cityService.getAll();
        getValueStack().set("cityList", JSONUtils.obj2json(cities));
        return SUCCESS;
    }

    @Action(input="/query")
    public String getCityList(){

        arryStr =new String[]{"admin","loclku","kinqij","junsldu","uonyulu"};

        cities = cityService.getAll();
//        getValueStack().set("cities", cities);
        return SUCCESS;
    }
}