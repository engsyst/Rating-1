package ua.nure.indplan.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ua.nure.indplan.entity.Permission;

public interface PermissionDAO extends CrudRepository<Permission, Integer> {

	List<Permission> findAll();
	
	Permission findByPermissionnameIgnoreCase(String permissionname);
}