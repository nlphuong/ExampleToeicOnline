package com.pnguyen.command;

import com.pnguyen.core.dto.ListenGuidelineDTO;
import com.pnguyen.core.web.command.AbstractCommand;

public class ListenGuidelineCommand extends AbstractCommand<ListenGuidelineDTO> {
    public ListenGuidelineCommand() {
        this.pojo = new ListenGuidelineDTO();
    }
}
