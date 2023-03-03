package cn.homyit.website.service;

import cn.homyit.website.entity.DO.Images;
import cn.homyit.website.entity.vo.Result;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

public interface ImagesService extends IService<Images> {
    Result uploadImages(MultipartFile file,String type,Integer type_id);
    Result updateImages(MultipartFile file,String type,Integer type_id);
    Images deleteImages(String type,Integer type_id);
}
