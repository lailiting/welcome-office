package cn.homyit.website.service;

import cn.homyit.website.entity.DO.StudyDirection;
import cn.homyit.website.entity.vo.Result;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author homyit
 * @since 2022-10-11
 */
public interface StudyDirectionService extends IService<StudyDirection> {

    Result getDirectory();

    Result addDirection(String type);

    Result addWay(Integer id,String type);
}
