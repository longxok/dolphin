package com.dolphin.user.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dolphin.common.model.SysRole;
import com.dolphin.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author zlt
 * 角色
 */
public interface SysRoleMapper extends SuperMapper<SysRole> {
	List<SysRole> findList(Page<SysRole> page, @Param("r") Map<String, Object> params);
}
