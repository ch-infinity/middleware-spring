package com.ch.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ch.mybatisplus.domain.TUser;
import com.ch.mybatisplus.mapper.TUserMapper;
import com.ch.mybatisplus.service.TUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
*
*/
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Override
    public List<TUser> findByName(String name) {
        LambdaQueryChainWrapper<TUser> lambdaQueryChainWrapper = lambdaQuery();
        List<TUser> list = lambdaQueryChainWrapper.eq(name != null ,TUser::getUname, name).list();
        return list;

    }

    @Override
    public Page<TUser> queryUser(Integer pageNo, Integer pageSize) {
        Page<TUser> page = new Page<>(pageNo, pageSize);
        return lambdaQuery().page(page);
    }

}
