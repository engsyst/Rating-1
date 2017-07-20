package ua.nure.indplan.service;

import java.util.List;

import ua.nure.indplan.entity.Permission;
import ua.nure.indplan.exeptions.DuplicatePermissionException;
import ua.nure.indplan.exeptions.PermissionNotFoundException;

public interface PermissionService {

	Permission getById(int id) throws PermissionNotFoundException;

	Permission getByPermissionname(String permissionname) throws PermissionNotFoundException;

	void add(Permission permission) throws DuplicatePermissionException;

	void update(Permission permission) throws PermissionNotFoundException;

	void delete(int id) throws PermissionNotFoundException;

	List<Permission> getAll();
}