package cn.homyit.website.controller;



import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.service.StudyDirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author homyit
 * @since 2022-10-11
 */
@RestController
@RequestMapping("/direction")
public class StudyDirectionController {

    @Autowired
    StudyDirectionService studyDirectionService;

    /**
     * 查看所有学习方向及目录
     * 返回数据studyDirectionDto
     */
    @GetMapping("/list")
    public Result getDirection(){
        return studyDirectionService.getDirectory();
    }

    /**
     * 增加方向
     */
    @PostMapping("/addD")
    public Result addDirection(String type){
        return studyDirectionService.addDirection(type);
    }

    /**
     * 增加学习的方式
     * 为某一个方向
     */
    @PostMapping("/addW")
    public Result addWay(Integer id,String type){
        return studyDirectionService.addWay(id,type);
    }

    /**
     * 删除某一个方向
     */
    @DeleteMapping("deleteW/{id}")
    public Result deleteWay(@PathVariable("id") Integer id){
      studyDirectionService.removeById(id);
      return Result.success();
    }

    /**
     *
     */



}
