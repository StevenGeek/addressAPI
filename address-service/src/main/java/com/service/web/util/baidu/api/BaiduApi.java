package com.service.web.util.baidu.api;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.service.address.orm.bean.baidu.request.base.impl.BaiDuAddressLocationParam;
import com.service.address.orm.bean.baidu.request.base.impl.BaiduAddressLocationRevertParam;
import com.service.address.orm.bean.baidu.response.base.BaiduBaseResponse;
import com.service.address.orm.bean.baidu.response.base.impl.BaiDuAddressQueryResult;
import com.service.address.orm.bean.baidu.response.base.impl.BaiDuAddressQueryRevertResult;
import com.service.web.util.WebRequestUtil;

@Component
public class BaiduApi {

    public static BaiduBaseResponse<BaiDuAddressQueryResult> fuzzyQueryCity(String p_address, String ak, String url)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
        BaiDuAddressLocationParam param = new BaiDuAddressLocationParam();
        param.setAk(ak);
        param.setAddress(p_address);
        param.setOutput("json");
        // param.setCity("上海市");
        String resultString = WebRequestUtil.get(url, param);
        Gson gson = new Gson();
        BaiduBaseResponse<BaiDuAddressQueryResult> resultBean = gson.fromJson(resultString, new TypeToken<BaiduBaseResponse<BaiDuAddressQueryResult>>() {
        }.getType());
        return resultBean;
    }

    public static BaiduBaseResponse<BaiDuAddressQueryRevertResult> fuzzyRevertQueryCity(BaiduBaseResponse<BaiDuAddressQueryResult> paramBean, String ak,
            String url)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
        Gson gson = new Gson();
        BaiduAddressLocationRevertParam revertParam = new BaiduAddressLocationRevertParam();
        revertParam.setAk(ak);
        revertParam.setOutput("json");
        revertParam.setPois("0");
        revertParam.setLocation(paramBean.getResult().getLocation());
        String revertResult = WebRequestUtil.get(url, revertParam);
        BaiduBaseResponse<BaiDuAddressQueryRevertResult> reverResultBean = gson.fromJson(revertResult,
                new TypeToken<BaiduBaseResponse<BaiDuAddressQueryRevertResult>>() {
                }.getType());
        return reverResultBean;
    }
}
