package double_p.ptravel.module.station.dto;

import lombok.Data;

@Data
public class CreateStationDto {
    private String name;
    private String code;
    private String city;
    private String address;
}

