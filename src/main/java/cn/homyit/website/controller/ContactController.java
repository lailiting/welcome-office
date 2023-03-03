package cn.homyit.website.controller;


import cn.homyit.website.entity.DO.Contact;
import cn.homyit.website.entity.vo.Result;
import cn.homyit.website.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author homyit
 * @since 2022-10-12
 */
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/view")
    public Result view(){
        Contact contact=contactService.getById(1);
        return Result.success(contact);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Contact contact){
        contactService.updateById(contact);
        return Result.success(contact);
    }
}
