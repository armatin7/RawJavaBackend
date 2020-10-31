package com.armatin.dto.UserDto;
import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -2435364533629533967L;

    private String username;
    
    private String password;
}
