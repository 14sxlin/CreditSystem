package dao;

import bean.Publish_Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by MirQ on 17/9/22.
 */
@Mapper
public interface PublishCourseDAO {
    String TABLE_NAME = " publish_course ";
    String INSERT_FIELDS = " course_id, tea_id, exp_num, real_num ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{course_id},#{tea_id},#{exp_num},#{real_num})"})
    int addPublishCourse(Publish_Course publishCourse);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    Publish_Course selectById(Publish_Course publishCourse);

    @Update({"update ", TABLE_NAME, " set exp_num=#{exp_num},real_num=#{real_num} where id=#{id}"})
    void updatePublishCourseById(Publish_Course publishCourse);

    // 查看所有开课 班级
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " limit #{offset}, #{limit}"})
    List<Publish_Course> selectAllPublishCourse(@Param("offset") int offset, @Param("limit") int limit);

}
