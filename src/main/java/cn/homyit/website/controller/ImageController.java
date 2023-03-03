package cn.homyit.website.controller;


import cn.homyit.website.entity.DO.Image;
import cn.homyit.website.entity.DO.StudyMessage;
import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.exception.ExceptionCodeEnum;
import cn.homyit.website.service.FileService;
import cn.homyit.website.service.ImageService;
import cn.homyit.website.service.StudyMessageService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author homyit
 * @since 2022-08-23
 */
@Slf4j
@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    FileService fileService;

    @Autowired
    ImageService imageService;

    @Autowired
    StudyMessageService studyMessageService;

    /**
     * 发展介绍增加或者修改图片
     */
    @PostMapping("/uploadF")
    public Result uploadF(Integer id, @RequestParam("file") MultipartFile file) {
        log.info("save file name {}", file.getOriginalFilename());
        String filePath = fileService.saveFile(file);
        Image image = new Image();
        image.setIntroduceId(id);
        image.setImageUrl(filePath);
        Image image1 = imageService.getOne(new LambdaQueryWrapper<Image>().eq(Image::getIntroduceId, id));
        if (image1 != null) {
            image.setId(image1.getId());
            imageService.updateById(image);
        } else imageService.save(image);
        return Result.success(filePath);
    }

    /**
     * 工作室日常或者环境添加图片
     */
    @PostMapping("/uploadR")
    public Result uploadR(Integer id, @RequestParam("file") MultipartFile file) {
        log.info("save file name {}", file.getOriginalFilename());
        String filePath = fileService.saveFile(file);

        if (filePath.trim() == null) return Result.error( ExceptionCodeEnum.ERROR_PARAM);
        Image image = new Image();
        image.setIntroduceId(id);
        image.setImageUrl(filePath);
        imageService.save(image);
        return Result.success(filePath);
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public Result delete(String imgUrl) {
        log.info(imgUrl);

        String newImg = imgUrl.replace(" ", "+");
        log.info(newImg);
        imageService.remove(new LambdaQueryWrapper<Image>().eq(Image::getImageUrl, newImg));
        return Result.success();
    }

    /**
     * 学习资料增加或者修改图片
     */
    @PostMapping("/uploadS")
    public Result uploadS(Integer id, @RequestParam("file") MultipartFile file) {
        log.info("save file name {}", file.getOriginalFilename());
        String filePath = fileService.saveFile(file);
       StudyMessage studyMessage=new StudyMessage();
       studyMessage.setImgUrl(filePath);
       studyMessage.setId(id);
       studyMessageService.updateById(studyMessage);
        return Result.success(filePath);
    }

}
