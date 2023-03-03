package cn.homyit.website.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user")
public class SysUser {
  private static final long serialVersionUID = -40356785423868312L;
  @TableId(type = IdType.AUTO)
  private Long id;
  private Integer grade;
  private Integer role;
  private String username;
  private String password;
  @TableField(value = "student_number")
  private Long studentNumber;
}
