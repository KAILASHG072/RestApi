package BikeRepair.Controller.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Repair_Customer")
@Setter
@Getter
public class UserData implements UserDetails {
    @Id
    private String username;

    private String password;

    private String brand_name;

    private String model_name;

    private String manufacturing_year;

    @OneToOne(mappedBy = "user")
    private FileDB file;

    @JsonIgnore
    @ManyToMany(mappedBy = "users_set")
    private Set<MechanicData> assignedmechanics =new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
