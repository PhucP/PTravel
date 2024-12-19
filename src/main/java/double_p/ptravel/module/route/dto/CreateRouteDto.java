package double_p.ptravel.module.route.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateRouteDto {
    private double distance;
    private int duration;

    @NonNull
    private String originStationName;

    @NonNull
    private String destinationStationName;
}
