package tjsse20.covid19logisticsblockchain.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;
import tjsse20.covid19logisticsblockchain.entity.User;

import java.util.List;

@Repository
public interface UserMapper {

    User select(Integer id);
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void register(User user);
    List<User> selectByTel(String telephone);
    void update(User user);
}
