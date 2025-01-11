package pillihuaman.com.pe.lib.response;

import lombok.*;
import org.bson.types.ObjectId;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponseUser {
    private ObjectId id;
    private String alias;
    private ObjectId idSystem;
    private String mail;
    private String mobilPhone;
    private String user;
    private String username;
    private int enabled;
    private ObjectId idRol;
}

