package com.service.address.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.address.business.IAddressBusiness;
import com.service.web.ResponseEntity;
import com.service.web.exception.InfoException;
import com.service.web.exception.ParameterException;

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
    public ResponseEntity queryCityInfo(@RequestParam(required = false) String p_parentId, @RequestParam(required = false) String p_cityId,
            @RequestParam(required = false) String p_grade) throws InstantiationException, IllegalAccessException, ParameterException {
        if (StringUtils.isEmpty(p_cityId)) {
            return ResponseEntity.getEntity(c_addressBusiness.queryNextCityList(p_parentId, p_grade));
        } else {
            return ResponseEntity.getEntity(c_addressBusiness.queryCity(p_cityId));
        }
    }

    @RequestMapping("info/vague")
    public ResponseEntity fuzzyQueryCityInfo(@RequestParam(required = false, value = "address") String p_address) throws NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ParameterException, InfoException {
        return ResponseEntity.getEntity(c_addressBusiness.fuzzyQueryCityInfo(p_address));
    }
}
