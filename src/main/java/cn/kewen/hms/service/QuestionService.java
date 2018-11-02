package cn.kewen.hms.service;

import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Question;

/**
 * 班级 service
 */
public interface QuestionService {
    /**
     * 查询所有学生信息
     *
     * @param params
     * @param title
     * @return
     * @throws Exception
     */
    PageData<Question> findQuestions(PageParams params, String title) throws Exception;

    /**
     * 添加学生信息
     *
     * @return 如果添加成功则返回true，否则返回false
     * @throws Exception
     */
    int addQuestion(Question question) throws Exception;


    /**
     * 删除学生信息
     */
    int deleteQuestion(int s_id) throws Exception;


    /**
     * 回答问题
     *
     * @param question
     * @throws Exception
     */
    void answerQuestions(Question question) throws Exception;
}
