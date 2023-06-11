package my.mvc.mappers;

import org.apache.ibatis.annotations.Mapper;

// TimeCheck 를 위한 mapper
@Mapper
public interface CheckTimeMapper {

    String getTime();
}
