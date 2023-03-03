package cn.homyit.website.service;

import cn.homyit.website.entity.dto.UpdatePWDDto;
import cn.homyit.website.entity.dto.UserLoginDTO;
import org.springframework.stereotype.Service;

/**
 * @author 州牧
 * @description
 * @since 2022-08-15 21:56
 */

public interface UserService {
    void login(UserLoginDTO user);

    void updatePWD(UpdatePWDDto updatePWDDto);

    void logout(Long studentNumber);
}
