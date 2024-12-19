package double_p.ptravel.module.seat.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateSeatDto {
    @NonNull
    private Long trainId;
    
    private int carriageNumber;
    private int number;
}
