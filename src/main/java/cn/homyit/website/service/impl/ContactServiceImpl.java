package cn.homyit.website.service.impl;

import cn.homyit.website.entity.DO.Contact;
import cn.homyit.website.mapper.ContactMapper;
import cn.homyit.website.service.ContactService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author homyit
 * @since 2022-10-12
 */
@Service
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements ContactService {

}
