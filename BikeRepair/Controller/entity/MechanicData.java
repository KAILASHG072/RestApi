package BikeRepair.Controller.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Repair_Mechanic")
@Setter
@Getter



public class MechanicData {
    @Id
    private String mechanic_name;

    private String number;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name="mechanics_customer",
   joinColumns = @JoinColumn(name = "mechanic_name"),inverseJoinColumns = @JoinColumn(name = "users_set"))
    private Set<UserData> users_set=new HashSet<>();


}
