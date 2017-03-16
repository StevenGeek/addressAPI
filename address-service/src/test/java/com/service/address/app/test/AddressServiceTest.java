package com.service.address.app.test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.address.business.impl.AddressBusiness;
import com.service.address.orm.bean.CityBean;
import com.service.web.exception.ParameterException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {
    @Autowired
    private AddressBusiness c_addressService;

    @Test
    public void test() {
        CityBean cityList = c_addressService.queryCity("100000");

        System.out.println(cityList);
    }

    @Test
    public void testBaiduAddressQuery() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, ParameterException {
        c_addressService.fuzzyQueryCityInfo("龙耀路");
    }
}
