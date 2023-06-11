package my.mvc.domain;

import lombok.*;


@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private long tno;
    private String title;
    private String writer;
    private String content;
    private String dueDate;
    private boolean complete;

}
