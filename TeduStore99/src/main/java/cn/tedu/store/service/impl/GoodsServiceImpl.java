package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.tedu.store.entity.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	private List<Goods> getList(String where, String orderBy, Integer offset, Integer count) {
		return goodsMapper.getList(null, "priority DESC", 0, 4);
	}

	public List<Goods> getHotGoodsList() {
		return getList(null, "priorty DESC", 0, 4);
	}

	public Goods findGoodsById(String id) {
		Goods goods = goodsMapper.findGoodsById(id);
		if (goods != null) {
			return goods;
		} else {
			// 這裏需要拋出異常
			return null;
		}
	}

}
