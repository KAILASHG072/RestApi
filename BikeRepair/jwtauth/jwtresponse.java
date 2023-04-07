package BikeRepair.jwtauth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class jwtresponse {
    String token;
    public jwtresponse(){}

    public jwtresponse(String token){
        this.token=token;
    }

}
