package dao;

import bean.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by MirQ on 17/9/22.
 */
@Mapper
public interface CourseDAO {
    String TABLE_NAME = " course ";
    String INSERT_FIELDS = " name, profession, necessary, duration, credit ";
    String SELECT_FIELDS = " id " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{name},#{profession},#{necessary},#{duration},#{credit})"})
    int addCourse(Course course);

    @Update({"update ", TABLE_NAME, " set name=#{name}, profession=#{profession}," +
             "necessary=#{necessary},duration=#{duration},credit=#{credit} where id=#{id}"})
    void updateCourse(Course course);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    Course selectCourseById(int id);

    //查看所有 课程
    @Select({"select", INSERT_FIELDS, " from ", TABLE_NAME, " limit #{offset}, #{limit}"})
    List<Course> selectAllPublishCourse(@Param("offset") int offset, @Param("limit") int limit);

}
