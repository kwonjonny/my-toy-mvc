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

    // 댓글 번호
    private Long rno;

    // FK tbl_todo tno
    private Long tno;

    // 댓글
    private String reply;

    // 댓글 사용자
    private String replyer;

    // 대댓글 번호
    @Builder.Default
    private Long gno = 0L;

    // 댓글 과 대댓글 여부
    private int step;

    // 댓글 작성 날짜
    private LocalDate replyDate;
}
