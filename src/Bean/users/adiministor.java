package Bean.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Feng on 3/30/16.
 */
@Entity
@DiscriminatorValue("admin")
public class adiministor extends UserEntity {

}
