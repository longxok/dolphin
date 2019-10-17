package com.dolphin.search.client.client.feign;

import com.alibaba.fastjson.JSONObject;
import com.dolphin.common.constant.ServiceNameConstants;
import com.dolphin.common.model.PageResult;
import com.dolphin.search.client.client.feign.fallback.SearchServiceFallbackFactory;
import com.dolphin.search.client.model.SearchDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zlt
 */
@FeignClient(name = ServiceNameConstants.SEARCH_SERVICE, fallbackFactory = SearchServiceFallbackFactory.class, decode404 = true)
public interface SearchService {
    /**
     * 查询文档列表
     * @param indexName 索引名
     * @param searchDto 搜索Dto
     */
    @PostMapping(value = "/com/dolphin/search/client/{indexName}")
    PageResult<JSONObject> strQuery(@PathVariable("indexName") String indexName, @RequestBody SearchDto searchDto);
}
