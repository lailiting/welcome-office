package cn.homyit.website.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 州牧
 * @description 更新密码实体类
 * @since 2022-08-25 12:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePWDDto {

    private Long id;

    private String password;

    private String newPassword;
}
