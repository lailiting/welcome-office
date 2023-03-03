package cn.homyit.website.controller;

import cn.homyit.website.entity.DO.Images;
import cn.homyit.website.entity.dto.GetImagesDto;
import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.service.ImagesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public class ImgController {

    @Autowired
    private ImagesService imagesService;

    @ResponseBody
    @PostMapping("/uploadImg")
    public Result uploadImages(@RequestPart("file") MultipartFile file,String type,Integer type_id) {
        if (file.isEmpty()) {
            return new Result(500,"文件为空");
        }
        return imagesService.uploadImages(file,type,type_id);
    }
    
    @ResponseBody
    @GetMapping("/getImg")
    public Result getImages(@RequestBody GetImagesDto imagesDto) {
        QueryWrapper<Images> wrapper = new QueryWrapper<>();
        if (imagesDto.getType()!=null) wrapper.eq("type", imagesDto.getType());
        if (imagesDto.getType_id()!=null) wrapper.eq("type_id",imagesDto.getType_id());
        List<Images> list=imagesService.list(wrapper);
        return new Result(200, "查询成功",list);
    }

    @ResponseBody
    @PostMapping("/updateImg")
    public Result updateImages(@RequestPart("file") MultipartFile file,String type,Integer type_id) {
        if (file.isEmpty()) {
            return new Result(500,"文件为空");
        }
        return imagesService.updateImages(file,type,type_id);
    }

    @PostMapping("/deleteImg")
    public Result deleteImages(String tyep,Integer type_id) {
        imagesService.deleteImages(tyep, type_id);
        return new Result(200, "删除成功");
    }
}
