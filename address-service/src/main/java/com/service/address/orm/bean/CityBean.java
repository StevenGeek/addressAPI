package com.service.address.orm.bean;

import java.io.Serializable;

/**
 * 三级地址业务类
 * 
 * @author steven
 *
 */
public class CityBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1540306193720623L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 城市Id
     */
    private String cityId;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 城市分级
     */
    private String grade;
    /**
     * 父节点
     */
    private String parentId;
    /**
     * 简评
     */
    private String simpleSpell;
    /**
     * 全拼
     */
    private String spell;
    /**
     * 下级城市
     */
    private CityBean nextCity;
    /**
     * 完整地址
     */
    private String completeAddress;

    /**
     * 
     * @author steven
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @author steven
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @author steven
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @author steven
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 
     * @author steven
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @author steven
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 
     * @author steven
     * @return the parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @author steven
     * @param parentId the parentId to set
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 
     * @author steven
     * @return the simpleSpell
     */
    public String getSimpleSpell() {
        return simpleSpell;
    }

    /**
     * @author steven
     * @param simpleSpell the simpleSpell to set
     */
    public void setSimpleSpell(String simpleSpell) {
        this.simpleSpell = simpleSpell;
    }

    /**
     * 
     * @author steven
     * @return the spell
     */
    public String getSpell() {
        return spell;
    }

    /**
     * @author steven
     * @param spell the spell to set
     */
    public void setSpell(String spell) {
        this.spell = spell;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CityBean [id=" + id + ", cityName=" + cityName + ", grade=" + grade + ", parentId=" + parentId + ", simpleSpell=" + simpleSpell + ", spell="
                + spell + "]";
    }

    public CityBean getNextCity() {
        return nextCity;
    }

    public void setNextCity(CityBean nextCity) {
        this.nextCity = nextCity;
    }

    public String getCompleteAddress() {
        return completeAddress;
    }

    public void setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

}
