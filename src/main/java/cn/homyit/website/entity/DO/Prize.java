package cn.homyit.website.entity.DO;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName(value="prize")
public class Prize extends Model<Prize> {
    @TableId(value="id")
    private Integer id;
    private String prize;
}
