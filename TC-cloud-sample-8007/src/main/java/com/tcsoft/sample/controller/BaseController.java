//package com.tcsoft.sample.controller;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.tcsoft.sample.entity.ResultData;
//import com.tcsoft.sample.utils.SampleUtilsConstant;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * 所有的controller的基类
// * @author WMY
// */
//public class BaseController<T extends ServiceImpl<? extends BaseMapper<K>, K>, K> {
//
//    public final T service;
//
//    public QueryWrapper<K> queryWrapper = null;
//
//    public BaseController(T t){
//        this.service = t;
//    }
//
//    public ResultData<List<K>> handleRequest(K k , String type, Map<String, Object> deletedMap){
//        ResultData<List<K>> resultData = new ResultData<>();
//        boolean flag = false;
//        if (type != null){
//            switch (type){
//                case SampleUtilsConstant.CREATE:
//                    flag = create(k);
//                    break;
//                case SampleUtilsConstant.DELETE:
//                    flag = delete(deletedMap);
//                    break;
//                case SampleUtilsConstant.MODIFY:
//                    flag = modify(k);
//                    break;
//                case SampleUtilsConstant.QUERY:
//                    List<K> list = query();
//                    if (list==null){
//                        flag = false;
//                    }else {
//                        resultData.setData(list);
//                        flag = true;
//                    }
//                default:
//                    break;
//            }
//        }
//        if (flag){
//            resultData.setCode(200);
//            resultData.setMessage("操作成功");
//        }else {
//            resultData.setCode(401);
//            resultData.setMessage("操作失败");
//        }
//        return resultData;
//    }
//
//    public boolean create(K k){
//        try {
//            return service.save(k);
//        }catch (Exception e){
//            return false;
//        }
//    }
//
//    public boolean delete(Map<String, Object> deletedMap){
//        try {
//            return service.removeByMap(deletedMap);
//        }catch (Exception e){
//            return false;
//        }
//    }
//
//    public boolean modify(K k){
//        try {
//            return service.updateById(k);
//        }catch (Exception e){
//            return false;
//        }
//    }
//
//    public List<K> query(){
//        try {
//            return service.list(queryWrapper);
//        }catch (Exception e){
//            return null;
//        }
//    }
//
//}
