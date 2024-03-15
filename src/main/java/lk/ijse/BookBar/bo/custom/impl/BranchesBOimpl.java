package lk.ijse.BookBar.bo.custom.impl;

import lk.ijse.BookBar.bo.custom.BranchesBO;
import lk.ijse.BookBar.dao.DAOFactory;
import lk.ijse.BookBar.dao.custom.BranchDAO;
import lk.ijse.BookBar.dto.BranchesDto;
import lk.ijse.BookBar.entity.Branches;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchesBOimpl implements BranchesBO {

    BranchDAO branchDAO = (BranchDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BRANCHES);


    @Override
    public boolean saveBranch(BranchesDto dto) throws SQLException {
        return branchDAO.save(new Branches(dto.getId(),dto.getBranchName(),dto.getStaff(),dto.getManager(),dto.getAddress()));
    }
    @Override
    public boolean updateBranch(BranchesDto dto) throws SQLException, ClassNotFoundException {
        return branchDAO.update(new Branches(dto.getId(),dto.getBranchName(),dto.getStaff(),dto.getManager(),dto.getAddress()));
    }
    @Override
    public boolean deleteBranch(String id) throws SQLException, ClassNotFoundException {
        return branchDAO.delete(id);
    }
    @Override
    public BranchesDto searchBranch(String id) throws SQLException, ClassNotFoundException {
        Branches branches = branchDAO.search(id);
        if (branches != null){
            return new BranchesDto(branches.getId(),branches.getBranchName(),branches.getStaff(),branches.getManager(),branches.getAddress());
        }else {
            return null;
        }
    }
    @Override
    public List<BranchesDto> getAllBranches() throws SQLException, ClassNotFoundException {
        List<BranchesDto> branches = new ArrayList<>();
        List<Branches> list = branchDAO.getAll();
        for (Branches branch : list) {
            branches.add(new BranchesDto(branch.getId(), branch.getBranchName(), branch.getStaff(), branch.getManager(), branch.getAddress()));
        }
        return branches;
    }
    @Override
    public String generateNextBranchID() {
        return branchDAO.generateNextID();
    }
    @Override
    public String[] searchBranchID(String id) {
        return branchDAO.searchID(id);
    }
}
