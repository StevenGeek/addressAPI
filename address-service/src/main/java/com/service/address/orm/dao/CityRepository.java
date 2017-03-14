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
	City findById(String p_id);
}
