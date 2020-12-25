package com.pnguyen.command;

import com.pnguyen.core.dto.UserDTO;
import com.pnguyen.core.web.command.AbstractCommand;

public class UserCommand extends AbstractCommand<UserDTO> {
    public UserCommand(){
        this.pojo = new UserDTO();
    }

}
