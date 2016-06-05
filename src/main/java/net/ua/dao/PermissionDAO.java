package net.ua.dao;

import java.util.List;

import net.ua.entity.Permission;
import net.ua.exeptions.DuplicatePermissionException;
import net.ua.exeptions.PermissionNotFoundException;

public interface PermissionDAO {

	public void addPermission(Permission permission) throws DuplicatePermissionException;

	public Permission getPermission(int id) throws PermissionNotFoundException;

	public Permission getPermission(String permissionName) throws PermissionNotFoundException;

	public void updatePermission(Permission permission) throws PermissionNotFoundException;

	public void deletePermission(int id) throws PermissionNotFoundException;

	public List<Permission> getPermissions();
}