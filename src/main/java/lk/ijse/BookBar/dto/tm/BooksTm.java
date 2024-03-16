package lk.ijse.BookBar.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BooksTm {
    private String bookID;
    private String title;
    private String author;
    private String qty;
    private String branchName;
    private String branchID;
    private String genre;
}
