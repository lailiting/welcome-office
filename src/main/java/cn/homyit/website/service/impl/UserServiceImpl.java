package cn.homyit.website.service.impl;

import cn.homyit.website.entity.DO.SysUser;
import cn.homyit.website.entity.dto.UpdatePWDDto;
import cn.homyit.website.entity.dto.UserLoginDTO;
import cn.homyit.website.exception.BizException;
import cn.homyit.website.exception.ExceptionCodeEnum;
import cn.homyit.website.mapper.UserMapper;
import cn.homyit.website.service.UserService;
import cn.homyit.website.util.MyBeanUtils;
import cn.homyit.website.util.RedisCache;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author 州牧
 * @description 用户相关
 * @since 2022-08-15 21:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisCache redisCache;

    @Resource
    private UserMapper userMapper;
    @Override
    public void login(UserLoginDTO user) {
        SysUser sysUser = MyBeanUtils.copyBean(user, SysUser.class);
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        String password = DigestUtils.md5DigestAsHex(sysUser.getPassword().getBytes());
        System.out.println(password);
        wrapper.eq("password",password)
                .eq("student_number",sysUser.getStudentNumber());
        SysUser result = userMapper.selectOne(wrapper);
        if(Objects.isNull(result)){
            throw new BizException(ExceptionCodeEnum.LOGIN_ERROR);
        }
    }

    @Override
    public void updatePWD(UpdatePWDDto updatePWDDto) {
        SysUser result = userMapper.selectById(updatePWDDto.getId());
        if(Objects.isNull(result)){
            throw new BizException(ExceptionCodeEnum.LOGIN_ERROR);
        }
        if(!result.getPassword().equals(DigestUtils.md5DigestAsHex(updatePWDDto.getPassword().getBytes()))){
            throw new BizException(ExceptionCodeEnum.UPDATE_PWD_ERROR);
        }else{
            result.setPassword (DigestUtils.md5DigestAsHex(updatePWDDto.getNewPassword().getBytes()));
            userMapper.updateById(result);
        }
    }

    @Override
    public void logout(Long studentNumber) {
        redisCache.deleteObject("office-web:"+studentNumber);
    }
}
