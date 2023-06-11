package my.mvc.domain;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private int tno;
    private String title;
    private String writer;
    private boolean complete;
    private Date date;
}
