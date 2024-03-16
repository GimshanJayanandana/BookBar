package lk.ijse.BookBar.bo.custom;

import lk.ijse.BookBar.bo.SuperBO;
import lk.ijse.BookBar.dto.MemberDto;

import java.sql.SQLException;
import java.util.List;

public interface MembersBo extends SuperBO {

    boolean saveMember(MemberDto dto) throws SQLException;

    boolean updateMember(MemberDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteMember(String id) throws SQLException, ClassNotFoundException;

    MemberDto searchMember(String id) throws SQLException, ClassNotFoundException;

    String generateNextMemberID();

    List<MemberDto> getAllMembers() throws SQLException, ClassNotFoundException;
}
