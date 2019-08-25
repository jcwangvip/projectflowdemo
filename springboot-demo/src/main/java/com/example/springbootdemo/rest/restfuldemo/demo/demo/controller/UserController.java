package com.example.springbootdemo.rest.restfuldemo.demo.demo.controller;

import com.example.springbootdemo.common.vo.ResultVO;
import com.example.springbootdemo.common.vo.ResultVOBuilder;
import com.example.springbootdemo.common.utils.ValidateUtils;
import com.example.springbootdemo.rest.restfuldemo.demo.demo.pojo.bean.UserEntity;
import com.example.springbootdemo.rest.restfuldemo.demo.demo.pojo.vo.UserForm;
import com.example.springbootdemo.rest.restfuldemo.demo.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户操作
 *
 * @author jiancheng
 */
@RestController
public class UserController {

    @Autowired
    private SysUserService userService;
    @Autowired
    private ResultVOBuilder resultVOBuilder;

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
    public ResultVO<UserEntity> save(@Valid @RequestBody UserForm userForm, BindingResult result) {
        ResultVO<String> resultVO = ValidateUtils.validate(resultVOBuilder, result);
        if (!resultVO.isSuccess()) {
            return resultVOBuilder.failure(resultVO);
        }
        UserEntity save = userService.save(userForm);
        return ResultVOBuilder.success(save);
    }

    @GetMapping("/saveById")
    public ResultVO<UserEntity> saveById(Long id) {
        UserEntity save = userService.saveById(id);
        return ResultVOBuilder.success(save);
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
