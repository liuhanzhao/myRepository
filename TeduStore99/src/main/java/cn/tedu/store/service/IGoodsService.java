package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Goods;

public interface IGoodsService {
//搜索热销排行的前4
 public List<Goods> getHotGoodsList();
 //通過id找到Goods詳情
 public Goods findGoodsById(String id);
}
