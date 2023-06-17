package my.mvc.mappers;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckTimeMapper {

    // MyBatis connection 확인을 위한 timeCheck
    String getTime();
}
