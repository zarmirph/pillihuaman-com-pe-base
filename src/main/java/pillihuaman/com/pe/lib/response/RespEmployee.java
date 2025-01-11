package pillihuaman.com.pe.lib.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class RespEmployee {
    private String id;
    private String name;
    private String lastName;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private Date startDate;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private Date finishDate;
    private Integer totalHours;
    private String department;
    private Double salaryMonth;
    private Double salaryHours;
    private String typeDocument;
    private String document;
}
