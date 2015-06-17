package jason.app.jobfair.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class RoleImpl {
    @Id
    @Column(nullable = false)
    private String name;
    
    @Column
    private String label;
    
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

}
