package com.service.address.app.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.address.business.impl.AddressBusiness;
import com.service.address.orm.bean.CityBean;

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

}
