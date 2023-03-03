package cn.homyit.website.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @program: inweb
 * @description:
 * @author: ZHANG
 * @create: 2022-08-19 15:39
 **/

@Data
@EqualsAndHashCode(callSuper = false)
public class IntroduceDto {

    private Integer id;

    private String title;

    private String type;

    private String content;

    private List<String> imageList;
}
