package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {

    /*
     * 显示所有班级信息
     */
    List<Notice> findNotices(@Param("n_title") String n_title) throws Exception;

    /**
     * @param c_id
     * @return
     * @throws Exception
     */
    Notice findNoticeById(Integer c_id) throws Exception;

    /*
     * 添加班级信息
     */
    int addNotice(Notice notice) throws Exception;

    /*
     * 删除班级信息
     */
    int deleteNotice(Integer n_id) throws Exception;


    void updateNotice(Notice notice) throws Exception;
}
