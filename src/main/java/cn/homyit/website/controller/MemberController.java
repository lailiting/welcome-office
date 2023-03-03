package cn.homyit.website.controller;


import cn.homyit.website.entity.DO.Member;
import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.service.MemberService;
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
@RestController
@RequestMapping("/member")
public class MemberController {
        @Autowired
        MemberService memberService;

        /**
         * 添加成员
         */
        @PostMapping("/add")
        public Result addMember(@RequestBody Member member){
                return memberService.addMember(member);
        }

        /**
         * 删除
         */
        @DeleteMapping("/delete/{id}")
        public  Result deleteMember(@PathVariable("id") Integer id ){
                return memberService.deleteMember(id);
        }
        /**
         * 修改
         */
        @PostMapping("/update")
        public Result updateMember(@RequestBody Member member){
                memberService.updateById(member);
                return Result.success(member);
        }

        /**
         * 查看成员
         */
        @GetMapping("/list")
        public Result listMember(Integer pageNo,Integer pageSize){
                return memberService.listMember(pageNo,pageSize);
        }
}
