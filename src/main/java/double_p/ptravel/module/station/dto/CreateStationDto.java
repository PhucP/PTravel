package double_p.ptravel.module.station.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateStationDto {
    @NonNull
    private String name;

    @NonNull
    private String code;

    @NonNull
    private String city;

    @NonNull
    private String address;
}

