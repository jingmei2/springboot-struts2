package com.zfsoft.zftal.controller;

import com.zfsoft.zftal.model.City;
import com.zfsoft.zftal.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 通过@PathVariable，例如/blogs/1
 * 通过@RequestParam，例如blogs?blogId=1
 * @ModelAttribute 获取post请求方法参数
 */

//@RestController
@Controller
public class CityRestController {
    @Resource
    private CityService cityService;

    /** 查询全部 */
    @RequestMapping("/cities")
    public List<City> toIndex(){
        return cityService.getAll();
    }

    /** 创建 */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCity(@ModelAttribute City body) {
        cityService.createCity(body);
        return "创建成功";
    }

    /** 更新 */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateCity(@ModelAttribute City body) {
        cityService.updateCity(body);
        return "更新成功!";
    }

    /** 删除 */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String removeCity(@PathVariable String id) {
        cityService.removeCity(id);
        return "更新成功!";
    }
}