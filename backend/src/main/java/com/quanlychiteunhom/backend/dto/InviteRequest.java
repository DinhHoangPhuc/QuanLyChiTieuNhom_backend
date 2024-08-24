package com.quanlychiteunhom.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InviteRequest {
    private int nhomId;
    private String inviter_username;
    private int maxUses;
}
