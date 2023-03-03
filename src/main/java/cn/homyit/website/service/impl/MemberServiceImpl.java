package cn.homyit.website.service.impl;

import cn.homyit.website.entity.DO.Member;
import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.mapper.MemberMapper;
import cn.homyit.website.service.MemberService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author homyit
 * @since 2022-08-19
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Override
    public Result addMember(Member member) {
        this.save(member);
        return Result.success(member);

    }

    @Override
    public Result deleteMember(Integer id) {
        this.removeById(id);
        return Result.success();

    }

    @Override
    public Result listMember(Integer pageNo, Integer pageSize) {
        Page<Member> page=new Page<>(pageNo,pageSize);
        IPage<Member> iPage=memberMapper.selectPage(page,new QueryWrapper<Member>().orderByAsc("grade","id"));
        Map<String, Object> map = new HashMap();
        map.put("list",iPage.getRecords());
        map.put("total",iPage.getTotal());
        map.put("pages", iPage.getPages());
        return Result.success(map);
    }
}
