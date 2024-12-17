package double_p.ptravel.module.train.dto;

import lombok.Data;

@Data
public class CreateTrainDto {
    private String name;
    private int capacity;
    private String status;
}
