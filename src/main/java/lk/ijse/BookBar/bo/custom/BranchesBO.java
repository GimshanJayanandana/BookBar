package lk.ijse.BookBar.bo.custom;

import lk.ijse.BookBar.bo.SuperBO;
import lk.ijse.BookBar.dto.BranchesDto;

import java.sql.SQLException;
import java.util.List;

public interface BranchesBO extends SuperBO {
    boolean saveBranch(BranchesDto dto) throws SQLException;

    boolean updateBranch(BranchesDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteBranch(String id) throws SQLException, ClassNotFoundException;

    BranchesDto searchBranch(String id) throws SQLException, ClassNotFoundException;

    List<BranchesDto> getAllBranches() throws SQLException, ClassNotFoundException;

    String generateNextBranchID();

    String[] searchBranchID(String id);
}
