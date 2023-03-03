package cn.homyit.website.controller;

import cn.homyit.website.entity.DO.Prize;
import cn.homyit.website.entity.dto.GetPrizeDto;
import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.service.impl.PrizeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrizeController {
    @Autowired
    private PrizeServiceImpl prizeService;

    @ResponseBody
    @PostMapping(value="/setPrize")
    public Result<String> setPrize(@RequestBody Prize prize){
        boolean flag =prizeService.save(prize);
        return flag ? new Result<>(200, "添加成功") : new Result<>(200, "添加失败");
    }

    @GetMapping (value="/getPrize")
    public Result<List<Prize>> getPrize(@RequestBody GetPrizeDto getPrizeDto) {
        System.out.println("as:"+getPrizeDto.getPageNo());
        IPage<Prize> IPage1 = new Page<>(getPrizeDto.getPageNo(), getPrizeDto.getPageSize());
        //查询条件(可选)
        QueryWrapper<Prize> wrapper = new QueryWrapper<>();
        if(getPrizeDto.getId()!=null)      wrapper.eq("id", getPrizeDto.getId());
        IPage<Prize> page= prizeService.page(IPage1, wrapper);
        List<Prize> prizes= page.getRecords();
        return new Result<>(200, "查询成功",prizes);
    }

    @PostMapping(value="/updatePrize")
    public Result<String> updatePrize(@RequestBody Prize prize){
        QueryWrapper<Prize> wrapper = new QueryWrapper<>();
        wrapper.eq("id", prize.getId());
        boolean flag =prizeService.update(prize,wrapper);
        return flag ? new Result<>(200, "更新成功") : new Result<>(200, "更新失败");
    }

    @PostMapping(value="/deletePrize")
    public Result<String> updatePrize(String id){
        QueryWrapper<Prize> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        boolean flag =prizeService.remove(wrapper);
        return flag ? new Result<>(200, "删除成功") : new Result<>(200, "删除失败");
    }


}
