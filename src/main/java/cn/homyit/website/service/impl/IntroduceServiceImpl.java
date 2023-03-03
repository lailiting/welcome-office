package cn.homyit.website.service.impl;

import cn.homyit.website.entity.DO.Image;
import cn.homyit.website.entity.DO.Introduce;
import cn.homyit.website.entity.dto.IntroduceDto;
import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.mapper.ImageMapper;
import cn.homyit.website.mapper.IntroduceMapper;
import cn.homyit.website.service.IntroduceService;
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
 * @since 2022-08-19
 */
@Service
public class IntroduceServiceImpl extends ServiceImpl<IntroduceMapper, Introduce> implements IntroduceService {

    @Autowired
    IntroduceMapper introduceMapper;

    @Autowired
    ImageMapper imageMapper;

    @Override
    public Result updateIntroduce(IntroduceDto introduceDto) {
        Introduce introduce=new Introduce();
        introduce.setContent(introduceDto.getContent());
        introduceMapper.update(introduce,new LambdaQueryWrapper<Introduce>().eq(Introduce::getType,"工作室介绍"));
        return Result.success(introduceDto);
    }

    @Override
    public Result viewIntroduce(String type) {
        if(type.equals("工作室介绍")){
            Introduce introduce=introduceMapper.selectOne(new LambdaQueryWrapper<Introduce>().eq(Introduce::getType,type));
            return Result.success(introduce);
        }
        else{
            List<Introduce> introduces=introduceMapper.selectList(new LambdaQueryWrapper<Introduce>().eq(Introduce::getType,type));
            List<IntroduceDto> introduceDtos=new ArrayList<>();
            for(Introduce introduce:introduces){
                List<Image> images=imageMapper.selectList(new LambdaQueryWrapper<Image>().eq(Image::getIntroduceId,introduce.getId()));
               List<String> imageList=new ArrayList<>();
                for(Image image:images){
                    imageList.add(image.getImageUrl());
                }
               IntroduceDto introduceDto= CopyUtil.copy(introduce,IntroduceDto.class);
                introduceDto.setImageList(imageList);
                introduceDtos.add(introduceDto);
            }
            return Result.success(introduceDtos);
        }

    }

    @Override
    public Result addFIntroduce(Introduce introduce) {
        introduceMapper.insert(introduce);
        return Result.success(introduce);
    }

    @Override
    public Result updateHIntroduce(IntroduceDto introduceDto) {
        Introduce introduce=new Introduce();
        introduce.setContent(introduceDto.getContent());
        introduceMapper.update(introduce,new LambdaQueryWrapper<Introduce>().eq(Introduce::getType,"工作室环境"));
        return Result.success(introduceDto);
    }

    @Override
    public Result updateCIntroduce(IntroduceDto introduceDto) {
        Introduce introduce=new Introduce();
        introduce.setContent(introduceDto.getContent());
        introduceMapper.update(introduce,new LambdaQueryWrapper<Introduce>().eq(Introduce::getType,"工作室成员介绍"));
        return Result.success(introduceDto);
    }
}
