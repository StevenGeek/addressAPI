package com.service.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.address.business.IAddressBusiness;
import com.service.address.orm.bean.CityBean;

/**
 * 地址库api控制层
 * 
 * @date 2017年3月14日
 * @author steven
 */
@RestController
@RequestMapping("address/")
public class AddressController {
    @Autowired
    private IAddressBusiness c_addressBusiness;

    @RequestMapping("info")
    public ResponseEntity<List<CityBean>> queryCityInfo(@RequestParam(required = false) String p_parentId, @RequestParam(required = false) String p_cityId,
            @RequestParam(required = false) String p_grade) {
        return ResponseEntity.ok(c_addressBusiness.queryNextCityList(p_parentId));
    }
}
