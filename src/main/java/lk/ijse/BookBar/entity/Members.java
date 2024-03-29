package lk.ijse.BookBar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Members {

    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

}
