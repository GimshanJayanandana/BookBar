package lk.ijse.BookBar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Branches {

    @Id
    private String id;
    private String branchName;
    private String staff;
    private String manager;
    private String address;

}
