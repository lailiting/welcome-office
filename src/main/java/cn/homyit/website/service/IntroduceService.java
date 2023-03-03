package cn.homyit.website.service;

import cn.homyit.website.entity.DO.Introduce;
import cn.homyit.website.entity.dto.IntroduceDto;
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
public interface IntroduceService extends IService<Introduce> {

    Result updateIntroduce(IntroduceDto introduceDto);

    Result viewIntroduce(String type);

    Result addFIntroduce(Introduce introduce);

    Result updateHIntroduce(IntroduceDto introduceDto);

    Result updateCIntroduce(IntroduceDto introduceDto);
}
