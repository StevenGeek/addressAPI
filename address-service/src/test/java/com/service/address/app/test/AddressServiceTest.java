package com.service.address.app.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.address.business.impl.AddressBusiness;
import com.service.address.orm.bean.CityBean;
import com.service.web.exception.InfoException;
import com.service.web.exception.ParameterException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {
    @Autowired
    private AddressBusiness c_addressService;

    @Test
    public void quertCityTest() {
        CityBean cityBean = c_addressService.queryCity("110000");
        Assert.assertArrayEquals(new String[] { "110000", "北京市" }, new String[] { cityBean.getCityId(), cityBean.getCityName() });
    }

    @Test
    public void baiduAddressQueryTest() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, ParameterException, InfoException {
        CityBean cityBean = c_addressService.fuzzyQueryCityInfo("上海火车站");
        Assert.assertArrayEquals(new String[] { "中华人民共和国", "310000", "闸北区", "上海市闸北区太阳山路" }, new String[] { cityBean.getCityName(),
                cityBean.getNextCity().getCityId(), cityBean.getNextCity().getNextCity().getNextCity().getCityName(), cityBean.getCompleteAddress() });
    }

    @Test
    public void baiduAddressQueryFailTest() {
        try {
            CityBean cityBean = c_addressService.fuzzyQueryCityInfo("4352345");
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException
                | ParameterException | InfoException e) {
            // TODO Auto-generated catch block
            Assert.assertArrayEquals(new String[] { "查询不到该地址" }, new String[] { e.getMessage() });
        }
    }

    @Test
    public void queryNextCityTest() throws InstantiationException, IllegalAccessException, ParameterException {
        List<CityBean> cityList = c_addressService.queryNextCityList("110000", null);
        Assert.assertArrayEquals(new String[] { "110000" }, new String[] { cityList.get(0).getParentId() });
    }

    @Test
    public void queryFirstCityTest() throws InstantiationException, IllegalAccessException, ParameterException {
        List<CityBean> cityList = c_addressService.queryNextCityList(null, "1");
        Assert.assertArrayEquals(new String[] { "1" }, new String[] { cityList.get(0).getGrade() });
    }

    @Test
    public void queryNextCityExceptionTest() {
        try {
            List<CityBean> cityList = c_addressService.queryNextCityList(null, null);
        } catch (InstantiationException | IllegalAccessException | ParameterException e) {
            // TODO Auto-generated catch block
            Assert.assertArrayEquals(new String[] { "when parentId is null, grade is mandatory" }, new String[] { e.getMessage() });
        }
    }

    @Test
    public void queryUpperCityTest() {
        CityBean cityBean = c_addressService.queryCity("110100");
        CityBean completeCityBean = c_addressService.queryCompleteCityInfo(cityBean);
        CityBean upperCityBean = c_addressService.queryCity(cityBean.getParentId());
        CityBean expectedCityBean = c_addressService.queryCity(upperCityBean.getParentId());
        expectedCityBean.setNextCity(upperCityBean);
        upperCityBean.setNextCity(cityBean);
        Assert.assertArrayEquals(
                new String[] { expectedCityBean.getCityId(), expectedCityBean.getNextCity().getCityId(), expectedCityBean.getNextCity().getCityId() },
                new String[] { completeCityBean.getCityId(), completeCityBean.getNextCity().getCityId(), completeCityBean.getNextCity().getCityId() });
    }
}
