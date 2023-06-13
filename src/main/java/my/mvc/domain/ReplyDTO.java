package my.mvc.domain;

import lombok.*;

import java.time.LocalDate;

// 댓글 구현에 관한 DTO
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDTO {
    private Long rno;
    private Long tno;
    private String reply;
    private String replyer;

    @Builder.Default
    private Long gno = 0L;
    private int step;
    private LocalDate replyDate;
}
