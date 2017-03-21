/**
 * 
 */
package com.service.address.orm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.address.orm.model.City;

/**
 * @author steven
 *
 */
public interface CityRepository extends JpaRepository<City, String> {
    List<City> findByParentId(String p_parentId);

    List<City> findByGrade(String p_grade);

    City findById(Integer p_id);

    City findByCityId(String p_CityId);
}
