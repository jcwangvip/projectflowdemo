package com.example.springbootdemo.restfuldemo.controller;

import com.example.springbootdemo.common.ResultVO;
import com.example.springbootdemo.restfuldemo.pojo.bean.UserEntity;
import com.example.springbootdemo.restfuldemo.pojo.vo.UserForm;
import com.example.springbootdemo.restfuldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户操作
 *
 * @author jiancheng
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "hello word";
    }


    /**
     * 新增
     *
     * @param userForm
     * @return
     */
    @PostMapping("/saveByResultVo")
    public ResultVO<UserEntity> saveByResultVo(@RequestBody UserForm userForm, int status) {
        ResultVO<UserEntity> resultVO = userService.saveByResultVo(userForm, status);
        return resultVO;
    }


    /**
     * 新增
     *
     * @param userForm
     * @return
     */
    @PostMapping("/save")
    public UserEntity save(@RequestBody UserForm userForm) {
        UserEntity save = userService.save(userForm);
        return save;
    }

    /**
     * 修改
     *
     * @param userForm
     * @return
     */
    @PutMapping("/update")
    public UserEntity update(@RequestBody UserForm userForm) {
        UserEntity updateUserEntity = userService.update(userForm);
        return updateUserEntity;
    }

    /**
     * 查询
     *
     * @return
     */
    @GetMapping("/findOneById")
    public UserEntity findOneById(Long id) {
        return userService.findOneById(id);
    }

    /**
     * 条件查询
     *
     * @return
     */
    @GetMapping("/findByUserForm")
    public List<UserEntity> findByUserForm(UserForm userForm) {
        return userService.findByUserForm(userForm);
    }


    /**
     * 删除
     *
     * @param id
     */
    @DeleteMapping("/delete")
    public void delete(Long id) {
        userService.delete(id);
    }


}
