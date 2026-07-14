package pja.edu.pl.s30855.tpo12.auth;

import java.util.List;

public class RoleAssignmentDTO {
    private Long userId;
    private List<String> assignedRoles;

    public RoleAssignmentDTO(Long userId, List<String> assignedRoles){
        this.userId = userId;
        this.assignedRoles = assignedRoles;
    }

    public void setAssignedRoles(List<String> assignedRoles) {
        this.assignedRoles = assignedRoles;
    }

    public List<String> getAssignedRoles() {
        return assignedRoles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
