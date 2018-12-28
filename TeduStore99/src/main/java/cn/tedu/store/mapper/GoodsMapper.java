package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Goods;

public interface GoodsMapper {
	List<Goods> getList(@Param("where")String where,
			              @Param("orderBy")String orderBy,
			              @Param("offset")Integer offset,
			              @Param("count")Integer count);
   Goods findGoodsById(String id);
}
