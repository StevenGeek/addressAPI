package com.service.address.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.address.business.IAddressBusiness;
import com.service.web.ResponseEntity;
import com.service.web.exception.InfoException;
import com.service.web.exception.ParameterException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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

    @RequestMapping(value = "info", method = RequestMethod.GET)
    @ApiOperation(value = "查询城市信息", notes = "1根据p_parentId查询下级城市列表，2查询一级城市列表，传入p_grade=1，3查询当前城市信息，传p_cityId")
    public ResponseEntity queryCityInfo(@RequestParam(required = false) @ApiParam(required = false, name = "p_parentId", value = "父级城市Id") String p_parentId,
            @RequestParam(required = false) @ApiParam(value = "城市Id") String p_cityId, @RequestParam(required = false) String p_grade)
            throws InstantiationException, IllegalAccessException, ParameterException {
        if (StringUtils.isEmpty(p_cityId)) {
            return ResponseEntity.getEntity(c_addressBusiness.queryNextCityList(p_parentId, p_grade));
        } else {
            return ResponseEntity.getEntity(c_addressBusiness.queryCity(p_cityId));
        }
    }

    @RequestMapping(value = "info/vague", method = RequestMethod.GET)
    @ApiOperation(value = "根据地址模糊搜索完整三级地址信息", notes = "尽可能输入省市级信息")
    public ResponseEntity fuzzyQueryCityInfo(@ApiParam(value = "地址信息") @RequestParam(required = false, value = "address") String p_address)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException,
            ParameterException, InfoException {
        return ResponseEntity.getEntity(c_addressBusiness.fuzzyQueryCityInfo(p_address));
    }
}
