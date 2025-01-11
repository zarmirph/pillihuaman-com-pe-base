package pillihuaman.com.pe.lib.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthenticationRequest {

    private String email;
  private String password;
}
