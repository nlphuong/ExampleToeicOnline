package com.pnguyen.command;

import com.pnguyen.core.dto.UserDTO;
import com.pnguyen.core.web.command.AbstractCommand;

/*
    Logic model:
        command -> pojo -> DTO

*/

public class UserCommand extends AbstractCommand<UserDTO> {
    private String confirmPassword;

    public UserCommand(){
        this.pojo = new UserDTO();
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
