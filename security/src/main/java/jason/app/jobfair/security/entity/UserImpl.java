package jason.app.jobfair.security.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class UserImpl {
    /** The author's email address */
    @Id
    @Column(nullable = false)
    private String username;
    
    @Column
    private String password;
    
    @Column
    private boolean enabled;
    
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    /** The blog entries posted by this user */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="USER_ROLES")
  
    private List<RoleImpl> roles;

    public List<RoleImpl> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleImpl> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
