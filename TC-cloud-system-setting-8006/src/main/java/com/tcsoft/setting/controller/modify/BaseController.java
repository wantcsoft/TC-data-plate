package com.tcsoft.setting.controller.modify;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tcsoft.setting.entity.ResultData;
import com.tcsoft.setting.utils.SettingUtilsConstant;
import java.util.List;
import java.util.Map;

/**
 * 所有的controller的基类
 * @author WMY
 */
public abstract class BaseController<T extends ServiceImpl<? extends BaseMapper<K>, K>, K, V> {

    public final T service;

    public QueryWrapper<K> queryWrapper = null;

    public BaseController(T t){
        this.service = t;
    }

    public ResultData<List<V>> handleRequest(K k ,String type, Map<String, Object> deletedMap){
        ResultData<List<V>> resultData = new ResultData<>();
        boolean flag = false;
        if (type != null){
            switch (type){
                case SettingUtilsConstant.CREATE:
                    flag = create(k);
                    break;
                case SettingUtilsConstant.DELETE:
                    flag = delete(deletedMap);
                    break;
                case SettingUtilsConstant.MODIFY:
                    flag = modify(k);
                    break;
                case SettingUtilsConstant.QUERY:
                    List<V> list = query();
                    if (list==null){
                        flag = false;
                    }else {
                        resultData.setData(list);
                        flag = true;
                    }
                default:
                    break;
            }
        }
        if (flag){
            resultData.setCode(200);
            resultData.setMessage("操作成功");
        }else {
            resultData.setCode(401);
            resultData.setMessage("操作失败");
        }
        return resultData;
    }

    public boolean create(K k){
        try {
            return service.save(k);
        }catch (Exception e){
            return false;
        }
    }

    public boolean delete(Map<String, Object> deletedMap){
        try {
            return service.removeByMap(deletedMap);
        }catch (Exception e){
            return false;
        }
    }

    public boolean modify(K k){
        try {
            return service.updateById(k);
        }catch (Exception e){
            return false;
        }
    }

    public List<V> query(){
        return null;
    }

}
