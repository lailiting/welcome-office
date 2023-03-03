package cn.homyit.website.entity.dto;

import cn.homyit.website.entity.DO.StudyDirection;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @program: inweb
 * @description:
 * @author: ZHANG
 * @create: 2022-10-11 21:10
 **/

@Data
@EqualsAndHashCode(callSuper = false)
public class StudyDirectionDto {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String type;

    private Integer parentId;

    private List<StudyDirection> way;
}
