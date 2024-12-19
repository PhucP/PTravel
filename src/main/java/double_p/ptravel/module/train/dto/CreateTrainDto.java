package double_p.ptravel.module.train.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateTrainDto {
    @NonNull
    private String name;

    private int capacity;
    private String status;
}
