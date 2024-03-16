package lk.ijse.BookBar.bo.custom.impl;

import lk.ijse.BookBar.bo.custom.MembersBo;
import lk.ijse.BookBar.dao.DAOFactory;
import lk.ijse.BookBar.dao.custom.MembersDAO;
import lk.ijse.BookBar.dto.MemberDto;
import lk.ijse.BookBar.entity.Members;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembersBoImpl implements MembersBo {

    MembersDAO membersDAO = (MembersDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MEMBERS);

    @Override
    public boolean saveMember(MemberDto dto) throws SQLException {
        return membersDAO.save(new Members(dto.getId(),dto.getName(),dto.getEmail(),dto.getPhoneNumber(),dto.getEmail()));
    }

    @Override
    public boolean updateMember(MemberDto dto) throws SQLException, ClassNotFoundException {
        return membersDAO.update(new Members(dto.getId(),dto.getName(),dto.getEmail(),dto.getPhoneNumber(),dto.getEmail()));
    }

    @Override
    public boolean deleteMember(String id) throws SQLException, ClassNotFoundException {
        return membersDAO.delete(id);
    }

    @Override
    public MemberDto searchMember(String phoneNumber) throws SQLException, ClassNotFoundException {
        Members member = membersDAO.search(phoneNumber);
        if (member != null) {
            return new MemberDto(member.getId(), member.getName(), member.getPhoneNumber(), member.getEmail(), member.getAddress());
        } else {
            return null;
        }
    }

    @Override
    public String generateNextMemberID() {
        return membersDAO.generateNextID();
    }

    @Override
    public List<MemberDto> getAllMembers() throws SQLException, ClassNotFoundException {
        List<MemberDto> members = new ArrayList<>();
        List<Members> list = membersDAO.getAll();
        for (Members member : list) {
            members.add(new MemberDto(member.getId(),member.getName(),member.getPhoneNumber(),member.getEmail(),member.getAddress()));
        }
        return members;
    }
}
