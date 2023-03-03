package cn.homyit.website.controller;



import cn.homyit.website.entity.DO.StudyMessage;
import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.service.StudyMessageService;
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
@RequestMapping("/studyData")
public class StudyMessageController {
    @Autowired
    StudyMessageService studyMessageService;

    /**
     * 添加学习的资料
     */

    @PostMapping("/add")
    public Result addStudyData(@RequestBody StudyMessage studyMessage){
        studyMessageService.save(studyMessage);
        return Result.success(studyMessage);
    }

    /**
     * 删除某个学习资料
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteData(@PathVariable("id")Integer id){
        studyMessageService.removeById(id);
        return Result.success();
    }

    /**
     *查看学习资料
     */
    @GetMapping("/list")
    public Result viewStudyData(Integer directionId,Integer wayId,Integer pageNo,Integer pageSize){
        return studyMessageService.getList(directionId,wayId,pageNo,pageSize);
    }


}
