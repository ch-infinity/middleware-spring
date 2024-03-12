package com.ch.mybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ch.mybatisplus.domain.TUser;
import com.ch.mybatisplus.service.TUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
/**
 * @author chenhong
 * date 2024/2/24
 **/
@RestController
public class UserController {

    @Resource
    private TUserService tUserService;

    @GetMapping("/findAll")
    public List<TUser> findAll(){
        List<TUser> list = tUserService.list();
        return list;
    }

    @GetMapping("/findByName")
    public List<TUser> findByName(@RequestParam(required = false) String name){
        List<TUser> list = tUserService.findByName(name);
        return list;
    }

    @GetMapping("/findPage")
    public Page<TUser> findPage(@RequestParam Integer pageNo,@RequestParam Integer pageSize){

        Page<TUser> tUserPage = tUserService.queryUser(pageNo, pageSize);
        return tUserPage;
    }


}
