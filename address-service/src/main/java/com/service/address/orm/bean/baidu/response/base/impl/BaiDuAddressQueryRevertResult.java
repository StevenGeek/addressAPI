package com.service.address.orm.bean.baidu.response.base.impl;

import java.util.List;

import com.service.address.orm.bean.baidu.LocationBean;

/**
 * 百度地图api逆向解析返回结果
 * 
 * @date 2017年3月15日
 * @author steven
 */
public class BaiDuAddressQueryRevertResult {
    /**
     * 地理坐标
     */
    private LocationBean location;
    /**
     * 结构化地址信息
     */
    private String formatted_address;
    /**
     * 所在商圈信息，如 "人民大学,中关村,苏州街"
     */
    private String business;
    /**
     * 当前位置结合POI的语义化结果描述。
     */
    private String constant;
    /**
     * 类型化地址信息
     */
    private AddressComponent addressComponent;
    /**
     * 周边poi数组
     */
    private List<Pois> pois;

    public class AddressComponent {
        /**
         * 国家
         */
        private String country;
        /**
         * 省名
         */
        private String province;
        /**
         * 城市名
         */
        private String city;
        /**
         * 区县名
         */
        private String district;
        /**
         * 街道名
         */
        private String street;
        /**
         * 街道门牌号
         */
        private String street_number;
        /**
         * 行政区划代码
         */
        private String adcode;
        /**
         * 国家代码
         */
        private String country_code;
        /**
         * 和当前坐标点的方向，当有门牌号的时候返回数据
         */
        private String direction;
        /**
         * 和当前坐标点的距离，当有门牌号的时候返回数据
         */
        private String distance;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getStreet_number() {
            return street_number;
        }

        public void setStreet_number(String street_number) {
            this.street_number = street_number;
        }

        public String getAbcode() {
            return adcode;
        }

        public void setAbcode(String abcode) {
            this.adcode = abcode;
        }

        public String getCountry_code() {
            return country_code;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

    }

    public class Pois {
        /**
         * 地址信息
         */
        private String addr;
        /**
         * 数据来源
         */
        private String cp;
        /**
         * 和当前坐标点的方向
         */
        private String direction;
        /**
         * 离坐标点距离
         */
        private String distance;
        /**
         * poi名称
         */
        private String name;
        /**
         * poi类型，如’ 办公大厦,商务大厦’
         */
        private String poiType;
        /**
         * poi坐标{x,y}
         */
        private String point;
        /**
         * 电话
         */
        private String tel;
        /**
         * poi唯一标识
         */
        private String uid;
        /**
         * 邮编
         */
        private String zip;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getCp() {
            return cp;
        }

        public void setCp(String cp) {
            this.cp = cp;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPoiType() {
            return poiType;
        }

        public void setPoiType(String poiType) {
            this.poiType = poiType;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public AddressComponent getAddressComponent() {
        return addressComponent;
    }

    public void setAddressComponent(AddressComponent addressComponent) {
        this.addressComponent = addressComponent;
    }

    public List<Pois> getPois() {
        return pois;
    }

    public void setPois(List<Pois> pois) {
        this.pois = pois;
    }

}
