package cn.homyit.website.service;

import cn.homyit.website.entity.DO.StudyMessage;
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
public interface StudyMessageService extends IService<StudyMessage> {

    Result getList(Integer directionId, Integer wayId, Integer pageNo, Integer pageSize);
}
