package my.mvc.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

// GenericType 으로 다른 곳 에서도 페이징을 쓸수있게 함
@Getter
@Setter
@ToString
public class PageResponseDTO<E> {

    private List<E> list;
    private int total;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(List<E> list , int total) {
        this.list = list;
        this.total = total;
    }
}
