package com.dolphin.user.service;

import com.dolphin.common.model.PageResult;
import com.dolphin.common.model.Result;
import com.dolphin.common.model.SysRole;
import com.dolphin.common.service.ISuperService;

import java.util.Map;

/**
* @author zlt
 */
public interface ISysRoleService extends ISuperService<SysRole> {
	void saveRole(SysRole sysRole);

	void deleteRole(Long id);

	/**
	 * 角色列表
	 * @param params
	 * @return
	 */
	PageResult<SysRole> findRoles(Map<String, Object> params);

	/**
	 * 新增或更新角色
	 * @param sysRole
	 * @return Result
	 */
	Result saveOrUpdateRole(SysRole sysRole);
}
