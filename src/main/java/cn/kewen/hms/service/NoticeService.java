package cn.kewen.hms.service;

import cn.kewen.hms.pojo.Notice;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Question;

/**
 * 班级 service
 */
public interface NoticeService {
    /**
     * 查询所有学生信息
     *
     * @param params
     * @param title
     * @return
     * @throws Exception
     */
    PageData<Notice> findNotices(PageParams params, String title) throws Exception;
    Notice findNoticeById(Integer n_id) throws Exception;

    /**
     * 添加学生信息
     *
     * @return 如果添加成功则返回true，否则返回false
     * @throws Exception
     */
    int addNotice(Notice notice) throws Exception;


    /**
     * 删除学生信息
     */
    int deleteNotice(Integer s_id) throws Exception;


    void editNotice(Notice notice) throws Exception;
}
