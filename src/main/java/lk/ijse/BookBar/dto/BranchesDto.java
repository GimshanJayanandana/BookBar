package lk.ijse.BookBar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchesDto {
    private String id;
    private String branchName;
    private String staff;
    private String manager;
    private String address;
}
