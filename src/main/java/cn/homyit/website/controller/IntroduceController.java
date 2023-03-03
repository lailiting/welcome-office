package cn.homyit.website.controller;


import cn.homyit.website.entity.DO.Image;
import cn.homyit.website.entity.DO.Introduce;
import cn.homyit.website.entity.dto.IntroduceDto;
import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.service.FileService;
import cn.homyit.website.service.ImageService;
import cn.homyit.website.service.IntroduceService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author homyit
 * @since 2022-08-19
 */
@Slf4j
@RestController
@RequestMapping("/introduce")
public class IntroduceController {
    @Autowired

    IntroduceService introduceService;

    @Autowired
    FileService fileService;

    @Autowired
    ImageService imageService;

    /**
     *修改工作室文字介绍
     */
    @PostMapping("/updateG")
    public Result updateIntroduce(@RequestBody IntroduceDto introduceDto){
        return introduceService.updateIntroduce(introduceDto);
    }


    /**
     *修改工作室环境介绍
     */
    @PostMapping("/updateH")
    public Result updateHIntroduce(@RequestBody IntroduceDto introduceDto){
        return introduceService.updateHIntroduce(introduceDto);
    }

    /**
     *修改工作室环境介绍
     */
    @PostMapping("/updateC")
    public Result updateCIntroduce(@RequestBody IntroduceDto introduceDto){
        return introduceService.updateCIntroduce(introduceDto);
    }
    /**
     * 增加发展介绍
     */
    @PostMapping("/add")
    public Result addF(@RequestBody Introduce introduce){
        return introduceService.addFIntroduce(introduce);
    }

    /**
     * 修改发展介绍
     * @param introduce
     * @return
     */
    @PostMapping("/updateF")
    public Result updateF(@RequestBody Introduce introduce){
        introduceService.updateById(introduce);
        return Result.success(introduce);

    }

    /**
     * 删除
     */
    @PostMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        introduceService.removeById(id);
        Image image1=imageService.getOne(new LambdaQueryWrapper<Image>().eq(Image::getIntroduceId,id));
        if(image1!=null) imageService.removeById(image1.getId());
        return Result.success();
    }


    /**
     * 查看介绍
     */
    @GetMapping("/view")
    public Result viewIntroduce(String type){
        return introduceService.viewIntroduce(type);
    }
}
