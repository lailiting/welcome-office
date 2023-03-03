package cn.homyit.website.service;

import cn.homyit.website.entity.DO.Member;
import cn.homyit.website.entity.vo.Result;
import com.baomidou.mybatisplus.extension.service.IService;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author homyit
 * @since 2022-08-19
 */
@Service
public interface MemberService extends IService<Member> {

    Result addMember(Member member);

    Result deleteMember(Integer id);

    Result listMember(Integer pageNo, Integer pageSize);
}
