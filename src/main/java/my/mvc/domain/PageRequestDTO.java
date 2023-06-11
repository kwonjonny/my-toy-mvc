package my.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 화면에서 모든 리스트
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PageRequestDTO {

    // 현재 페이지 번호 저장
    @Builder.Default
    private int page = 1;

    // 페이지당 항목수 저장
    @Builder.Default
    private int size = 10;

    // septPage
    // page 가 0 이하인 경우는 기본값 1 강제 지정
    public void setPage(int page) {
        if(page <= 0){
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    // setSize
    // page 가 100 초과 이거나 0 이하일 경우 10 강제 지정
    public void setSize(int size) {
        if(size > 100 || size < 0){
            this.size = 10;
        } else {
            this.size = size;
        }
    }

    // Mysql 은 식이 안들어가서 DTO 에서 처리 후 ${skip}, ${size}로 처리
    public int getSkip(){
        return (this.page -1) * this.size;
    }

    // Database query 사용될 끝 인덱스를 계산하여 반환
    public int getEnd(){
        return this.page * this.size;
    }

    // 특정 페이지 범위 내에서 마지막 항목의 인덱스를 계산하여 반환
    public int getCountEnd() {

        int temp = (int) (Math.ceil(this.page/10.0)) * (10*size);

        return temp + 1;
    }
}