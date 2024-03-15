package lk.ijse.BookBar.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchesTm {
    private String id;
    private String branchName;
    private String staff;
    private String manager;
    private String address;
}
