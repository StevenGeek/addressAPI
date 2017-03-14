package com.service.web.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class BeanListUtil {
    public static <T, D> List<D> getList(List<T> t, Class<D> clazz) throws InstantiationException, IllegalAccessException {
        List<D> m_DList = new ArrayList<>();
        for (T tSingle : t) {
            D dObject = clazz.newInstance();
            BeanUtils.copyProperties(tSingle, dObject);
            m_DList.add(dObject);
        }
        return m_DList;
    }
}
