package lk.ijse.BookBar.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberTm {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
}
