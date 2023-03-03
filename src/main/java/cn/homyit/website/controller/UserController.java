package cn.homyit.website.controller;

import cn.homyit.website.entity.DO.SysUser;
import cn.homyit.website.entity.dto.UpdatePWDDto;
import cn.homyit.website.entity.dto.UserLoginDTO;
import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.service.UserService;
import cn.homyit.website.util.JwtUtil;
import cn.homyit.website.util.RedisCache;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author 州牧
 * @description 用户接口类
 * @since 2022-08-15 21:46
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisCache redisCache;

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDTO user){
        userService.login(user);
        redisCache.setCacheObject("office-web:"+user.getStudentNumber(),user);
        String jwt = JwtUtil.createJWT(user.getStudentNumber().toString());
        return Result.success(jwt);
    }

    //修改密码
    @PostMapping("/updatePWD")
    public Result updatePWD(@RequestBody UpdatePWDDto updatePWDDto){
        userService.updatePWD(updatePWDDto);
        return Result.success();
    }

    //退出登录
    @GetMapping("/logout/{studentNumber}")
    public Result logout(@PathVariable Long studentNumber){
        userService.logout(studentNumber);
        return Result.success();
    }

}
