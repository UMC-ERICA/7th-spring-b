package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MissionStatusDto {

    private String title;
    private String description;
    private Integer point;
    private String status;

}
