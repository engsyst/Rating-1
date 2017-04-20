package ua.nure.indplan.dao;

import java.util.List;

import ua.nure.indplan.entity.Permission;
import ua.nure.indplan.exeptions.DuplicatePermissionException;
import ua.nure.indplan.exeptions.PermissionNotFoundException;

public interface PermissionDAO {

	public void addPermission(Permission permission) throws DuplicatePermissionException;

	public Permission getPermission(int id) throws PermissionNotFoundException;

	public Permission getPermission(String permissionName) throws PermissionNotFoundException;

	public void updatePermission(Permission permission) throws PermissionNotFoundException;

	public void deletePermission(int id) throws PermissionNotFoundException;

	public List<Permission> getPermissions();
}