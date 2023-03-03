package cn.homyit.website.service.impl;

import cn.homyit.website.entity.DO.StudyDirection;
import cn.homyit.website.entity.dto.StudyDirectionDto;
import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.mapper.StudyDirectionMapper;
import cn.homyit.website.service.StudyDirectionService;
import cn.homyit.website.util.CopyUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author homyit
 * @since 2022-10-11
 */
@Service
public class StudyDirectionServiceImpl extends ServiceImpl<StudyDirectionMapper, StudyDirection> implements StudyDirectionService {

    @Autowired
    StudyDirectionMapper studyDirectionMapper;
    @Override
    public Result getDirectory() {
        List<StudyDirection> studyDirections= studyDirectionMapper.selectList(new LambdaQueryWrapper<StudyDirection>().eq(StudyDirection::getParentId,0));
        List<String> way=new ArrayList<>();

        List<StudyDirectionDto> studyDirectionDtos=new ArrayList<>();
        for(StudyDirection studyDirection:studyDirections){
            List<StudyDirection> studyDirectionList= studyDirectionMapper.selectList(new LambdaQueryWrapper<StudyDirection>().eq(StudyDirection::getParentId,studyDirection.getId()));
            StudyDirectionDto studyDirectionDto= CopyUtil.copy(studyDirection,StudyDirectionDto.class);
            studyDirectionDto.setWay(studyDirectionList);
            studyDirectionDtos.add(studyDirectionDto);
        }
        return Result.success(studyDirectionDtos);

    }

    @Override
    public Result addDirection(String type) {
        StudyDirection studyDirection=new StudyDirection();
        studyDirection.setType(type);
        studyDirection.setParentId(0);
        studyDirectionMapper.insert(studyDirection);
        return Result.success(studyDirection);

    }

    @Override
    public Result addWay(Integer id,String type) {
        StudyDirection studyDirection=new StudyDirection();
        studyDirection.setType(type);
        studyDirection.setParentId(id);
        studyDirectionMapper.insert(studyDirection);
        return Result.success(studyDirection);
    }
}
