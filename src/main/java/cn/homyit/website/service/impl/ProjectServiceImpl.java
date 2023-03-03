package cn.homyit.website.service.impl;

import cn.homyit.website.entity.DO.Project;
import cn.homyit.website.mapper.ProjcetMapper;
import cn.homyit.website.service.ProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjcetMapper, Project> implements ProjectService {
}
