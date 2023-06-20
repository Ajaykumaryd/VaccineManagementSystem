import jakarta.persistence.*;
import jdk.jfr.Enabled;

@Entity
@Table(name="users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;



}
