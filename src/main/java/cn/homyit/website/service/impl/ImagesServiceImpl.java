package cn.homyit.website.service.impl;

import cn.homyit.website.entity.constant.SysConstant;
import cn.homyit.website.entity.DO.Images;

import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.exception.BizException;
import cn.homyit.website.exception.ExceptionCodeEnum;
import cn.homyit.website.mapper.ImagesMapper;
import cn.homyit.website.service.ImagesService;
import cn.homyit.website.util.EmptyUtils;
import cn.homyit.website.util.UuidUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class ImagesServiceImpl extends ServiceImpl<ImagesMapper, Images> implements ImagesService {

    @Autowired
    private  ImagesMapper imagesMapper;
    @Value("${file.save-path:}")
    private String savePath;

    @Value("${file.view:}")
    private String view;
    @Override
    public Result uploadImages(MultipartFile file,String type,Integer type_id) {
        try {
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : null;
            // 文件名非空校验
            System.out.println(savePath);
            if (EmptyUtils.basicIsEmpty(fileName)) {
                return new Result<>(500, "图片名不能为空");
            }
            // 大文件判定
            if (file.getSize() > SysConstant.MAX_SIZE) {
                return new Result<>(500, "图片过大，请使用大文件传输");
            }
            // 图片判定
            if (SysConstant.IMAGE_TYPE.contains(suffixName)) {
                return new Result<>(500, "非图片类型");
            }
            // 生成新文件名
            String newName = UuidUtils.uuid() + suffixName;
            // 重命名文件
            File newFile = new File(savePath, newName);
            // 如果该存储路径不存在则新建存储路径
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdirs();
            }
            // 文件写入
            file.transferTo(newFile);
            // 保存文件信息
            Images images = new Images().setImgUrl("http://114.115.136.191/img/"+newName).setType(type).setTypeId(type_id);
            imagesMapper.insert(images);
            return new Result(200, "上传成功");
        } catch (Exception e) {
            log.error("上传协议文件出错", e);
            throw new BizException(ExceptionCodeEnum.ERROR_PARAM);
        }
    }

    @Override
    public Result updateImages(MultipartFile file, String type, Integer type_id) {
        try {
            //先删除，再更新
            Images img=deleteImages(type,type_id);
            //两处复用，未单独写函数
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : null;
            // 文件名非空校验
            System.out.println(savePath);
            if (EmptyUtils.basicIsEmpty(fileName)) {
                return new Result<>(500, "图片名不能为空");
            }
            // 大文件判定
            if (file.getSize() > SysConstant.MAX_SIZE) {
                return new Result<>(500, "图片过大，请使用大文件传输");
            }
            // 图片判定
            if (SysConstant.IMAGE_TYPE.contains(suffixName)) {
                return new Result<>(500, "非图片类型");
            }
            // 生成新文件名
            String newName = UuidUtils.uuid() + suffixName;
            // 重命名文件
            File newFile = new File(savePath, newName);
            // 如果该存储路径不存在则新建存储路径
            if (!newFile.getParentFile().exists()) {
                newFile.getParentFile().mkdirs();
            }
            // 文件写入
            file.transferTo(newFile);
            img.setImgUrl(newName);
            imagesMapper.updateById(img);
            return new Result(200, "更新成功");
        }catch (Exception e) {
            log.error("上传协议文件出错", e);
            throw new BizException(ExceptionCodeEnum.ERROR_PARAM);
        }
    }

    @Override
    public Images deleteImages(String type,Integer type_id) {
        QueryWrapper<Images> wrapper = new QueryWrapper<>();
        wrapper.eq("type", type);
        wrapper.eq("type_id",type_id);
        Images images=imagesMapper.selectOne(wrapper);
        try{
        File file = new File(savePath, images.getImgUrl());
        if (file.exists()) {
            file.delete();//立即删除
        }
        }catch (Exception e){
            log.error("路径错误", e);
            throw new BizException(ExceptionCodeEnum.ERROR_PARAM);
        }
        return  images;
    }
}
