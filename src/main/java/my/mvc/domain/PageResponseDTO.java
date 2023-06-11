package my.mvc.domain;

import java.util.List;
import lombok.Builder;
import lombok.Data;

// 제네릭 타입 <E> 를 사용해서 다양한 타입의 데이터 목록을 지정
@Data
public class PageResponseDTO<E> {

    // 페이지당 항목들의 목록 저장
    private List<E> list;

    // 총 항목수를 저장하는 변수
    private long total;

    // 생성자 builderMethodName = "withAll"
    @Builder(builderMethodName =  "withAll")
    public PageResponseDTO(List<E> list, long total ){
        this.list = list;
        this.total = total;
    }

}
