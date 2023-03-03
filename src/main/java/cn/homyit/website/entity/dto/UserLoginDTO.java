package cn.homyit.website.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 州牧
 * @description 登录实体类
 * @since 2022-08-15 21:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {
    private Long studentNumber;
    private String password;
}
