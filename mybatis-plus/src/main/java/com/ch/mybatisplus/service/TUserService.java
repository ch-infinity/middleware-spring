package com.ch.mybatisplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ch.mybatisplus.domain.TUser;

import java.util.List;

/**
*
*/
public interface TUserService extends IService<TUser> {


    public List<TUser> findByName(String name);

    public Page<TUser> queryUser(Integer pageNo,Integer pageSize);

}
