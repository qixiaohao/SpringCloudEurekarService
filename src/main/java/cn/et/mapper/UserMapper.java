/**
 * 
 */
package cn.et.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Qixiaohao
 * @version 1.0
 * 
 */

@Mapper
public interface UserMapper {
	@Insert("insert into users(u_name,u_password) values(#{username},#{password})")
	public void addUser(@Param("username") String username, @Param("password") String password);

	/**
	 * @param userId
	 * @param map
	 */
	@Update("update users set u_name=#{map.userName},u_password=#{map.password} where u_id=#{userId} ")
	public void updateUser(@Param("userId") String userId, @Param("map") Map map);

	/**
	 * @param userName
	 * @param password
	 */
	@Select("select * from users where u_name=#{userName} and u_password=#{password}")
	public Map loginUser(@Param("userName") String userName, @Param("password") String password);

	/**
	 * @param userId
	 * @param map
	 */
	@Delete("delete from users where u_id=#{userId}")
	public void deleteUser(@Param("userId") String userId);

}
