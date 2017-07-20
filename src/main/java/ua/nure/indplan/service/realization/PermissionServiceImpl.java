package ua.nure.indplan.service.realization;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.nure.indplan.dao.PermissionDAO;
import ua.nure.indplan.entity.Permission;
import ua.nure.indplan.exeptions.DuplicatePermissionException;
import ua.nure.indplan.exeptions.PermissionNotFoundException;
import ua.nure.indplan.service.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
	static Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

	@Autowired
	private PermissionDAO permissionDAO;

	@Override
	public void add(Permission permission) throws DuplicatePermissionException {
		permissionDAO.save(permission);
	}

	@Override
	public Permission getById(int id) throws PermissionNotFoundException {
		return permissionDAO.findOne(id);
	}

	@Override
	public Permission getByPermissionname(String permissionname) throws PermissionNotFoundException {
		return permissionDAO.findByPermissionnameIgnoreCase(permissionname);
	}

	@Override
	public void update(Permission permission) throws PermissionNotFoundException {
		permissionDAO.save(permission);
	}

	@Override
	public void delete(int id) throws PermissionNotFoundException {
		permissionDAO.delete(id);
	}

	@Override
	public List<Permission> getAll() {
		return permissionDAO.findAll();
	}
}
