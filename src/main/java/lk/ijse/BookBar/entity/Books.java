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
public class Books {

    @Id
    private int id;
    private String name;
    private String author;
    private String genre;
}
