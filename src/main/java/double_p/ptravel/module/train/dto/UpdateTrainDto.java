package double_p.ptravel.module.train.dto;

import lombok.Data;

@Data
public class UpdateTrainDto {
    private String name;
    private String status;
    private int capacity;
}
