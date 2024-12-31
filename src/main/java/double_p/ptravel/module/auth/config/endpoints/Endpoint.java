package double_p.ptravel.module.auth.config.endpoints;

public class Endpoint {
    public static String[] publicEndpoints = {
            // user
            "/user/getUser/**",
            "/user/register",
            "/user/update/**",
            "/user/delete/**",
            "/user/search/**",

            // train
            "/train/getTrain/**",
            "/train/search/**",
            "/train/all",

            // station
            "/station/getStation/**",
            "/station/search/**",
            "/station/all",

            // seat
            "/seat/getSeat/**",
            "/seat/search/**",

            // route
            "/route/getRoute",
            "/route/all",
            "/route/search/**",
    };
    public static String[] privateEndpoints = {
            // use
            "/user/all",

            // train
            "/train/create",
            "/train/update/**",
            "/train/delete/**",

            // station
            "/station/create",
            "/station/update/**",
            "/ station/delete/**",

            // seat
            "/seat/create",
            "/seat/update/**",
            "/seat/delete/**",

            // route
            "/route/create",
            "/route/update/**",
            "/route/delete/**",
    };
}