package com.armatin.dto.UserDto;
import java.io.Serializable;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -2435364533629533967L;

    private String username;
    
    private String password;
}
