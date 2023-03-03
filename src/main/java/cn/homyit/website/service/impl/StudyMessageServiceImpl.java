package cn.homyit.website.service.impl;

import cn.homyit.website.entity.DO.StudyMessage;
import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.mapper.StudyMessageMapper;
import cn.homyit.website.service.StudyMessageService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author homyit
 * @since 2022-10-11
 */
@Service
public class StudyMessageServiceImpl extends ServiceImpl<StudyMessageMapper, StudyMessage> implements StudyMessageService {
    @Autowired
    StudyMessageMapper studyMessageMapper;

    @Override
    public Result getList(Integer directionId, Integer wayId, Integer pageNo, Integer pageSize) {

        if(wayId==null){
            if(pageNo!=null&&pageSize!=null){
                Page<StudyMessage> page=new Page<>(pageNo,pageSize);
                IPage<StudyMessage> iPage=studyMessageMapper.selectPage(page,new LambdaQueryWrapper<StudyMessage>().eq(StudyMessage::getDirectionId,directionId));
                Map<String, Object> map = new HashMap();
                map.put("list",iPage.getRecords());
                map.put("total",iPage.getTotal());
                map.put("pages", iPage.getPages());
                return Result.success(map);
            }
            else{
                Map<String, Object> map = new HashMap();
                List<StudyMessage> studyMessages=studyMessageMapper.selectList(new LambdaQueryWrapper<StudyMessage>().eq(StudyMessage::getDirectionId,directionId));
                map.put("list",studyMessages);
                map.put("total",studyMessages.size());
                map.put("pages", 0);
                return Result.success(map);
            }
        }else{
            if(pageNo!=null&&pageSize!=null){
                Page<StudyMessage> page=new Page<>(pageNo,pageSize);
                IPage<StudyMessage> iPage=studyMessageMapper.selectPage(page,new LambdaQueryWrapper<StudyMessage>().eq(StudyMessage::getDirectionId,directionId).eq(StudyMessage::getWayId,wayId));
                Map<String, Object> map = new HashMap();
                map.put("list",iPage.getRecords());
                map.put("total",iPage.getTotal());
                map.put("pages", iPage.getPages());
                return Result.success(map);
            }else{
                Map<String, Object> map = new HashMap();
                List<StudyMessage> studyMessages=studyMessageMapper.selectList(new LambdaQueryWrapper<StudyMessage>().eq(StudyMessage::getDirectionId,directionId).eq(StudyMessage::getWayId,wayId));
                map.put("list",studyMessages);
                map.put("total",studyMessages.size());
                map.put("pages", 0);
                return Result.success(map);
            }

        }



    }
}
