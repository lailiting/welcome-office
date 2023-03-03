package cn.homyit.website.controller;

import cn.homyit.website.entity.DO.Images;
import cn.homyit.website.entity.DO.Prize;
import cn.homyit.website.entity.DO.Project;
import cn.homyit.website.entity.dto.GetProjectDto;
import cn.homyit.website.entity.dto.ReturnProDto;
import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.service.impl.ImagesServiceImpl;
import cn.homyit.website.service.impl.ProjectServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private ProjectServiceImpl projectService;

    @Autowired
    private ImagesServiceImpl imagesService;
    @ResponseBody
    @PostMapping(value="/setProject")
    public Result<String> setProject(@RequestBody Project project){
        boolean flag =projectService.save(project);
        return flag ? new Result<>(200, "添加成功") : new Result<>(200, "添加失败");
    }

    @GetMapping(value="/getProject")
    public Result<List<ReturnProDto>> getProject(@RequestBody GetProjectDto getProjectDto) {
        IPage<ReturnProDto> IPage1 = new Page<>(getProjectDto.getPageNo(), getProjectDto.getPageSize());
        //查询条件(可选)
        QueryWrapper<Project> wrapper = new QueryWrapper<>();
        if(getProjectDto.getType()!=null)      wrapper.eq("type", getProjectDto.getType());
        List<Project> projectList=projectService.list(wrapper);
        List<ReturnProDto> proDtos=null;
        for (int i = 0; i < projectList.size(); i++) {
            QueryWrapper<Images> wrapper2 = new QueryWrapper<>();
            wrapper2.eq("type", "Project");
            wrapper2.eq("type_id", i);
            ReturnProDto proDto=new ReturnProDto();
            proDto.setId(projectList.get(i).getId());
            proDto.setDesc(projectList.get(i).getDesc());
            proDto.setUrl(imagesService.getOne(wrapper2).getImgUrl());
            proDtos.add(proDto);
        }
        return new Result<>(200, "查询成功",proDtos);
    }

    @PostMapping(value="/updateProject")
    public Result<String> updatePrize(@RequestBody Project project){
        QueryWrapper<Project> wrapper = new QueryWrapper<>();
        wrapper.eq("id",project.getId());
        boolean flag =projectService.update(project,wrapper);
        return flag ? new Result<>(200, "更新成功") : new Result<>(200, "更新失败");
    }

    @PostMapping(value="/deleteProject")
    public Result<String> updatePrize(String id){
        QueryWrapper<Project> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        boolean flag =projectService.remove(wrapper);
        return flag ? new Result<>(200, "删除成功") : new Result<>(200, "删除失败");
    }
}
