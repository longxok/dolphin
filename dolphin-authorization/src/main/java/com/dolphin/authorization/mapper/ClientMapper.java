package com.dolphin.authorization.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dolphin.authorization.model.Client;
import com.dolphin.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zlt
 */
public interface ClientMapper extends SuperMapper<Client> {
    List<Client> findList(Page<Client> page, @Param("params") Map<String, Object> params);
}
