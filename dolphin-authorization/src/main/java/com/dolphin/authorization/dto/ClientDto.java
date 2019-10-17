package com.dolphin.authorization.dto;

import com.dolphin.authorization.model.Client;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
public class ClientDto extends Client {
    private static final long serialVersionUID = 1475637288060027265L;

    private List<Long> permissionIds;

    private Set<Long> serviceIds;
}
