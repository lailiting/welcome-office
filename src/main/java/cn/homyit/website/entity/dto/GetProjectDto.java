package cn.homyit.website.entity.dto;

import lombok.Data;

@Data
public class GetProjectDto {
    private String type;
    private Integer pageNo;
    private Integer pageSize;
}
