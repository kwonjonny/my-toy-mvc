package my.mvc.dto;

import lombok.*;

import java.sql.Date;

// TblBoard
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private long tno;
    private String title;
    private String writer;
    private String content;
    private Date registDate;
    private Date updateDate;
}
