package cn.kewen.hms.mapper;

import cn.kewen.hms.pojo.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {

    /*
     * 显示所有班级信息
     */
    List<Question> findQuestions(@Param("title") String title) throws Exception;

    /**
     * @param c_id
     * @return
     * @throws Exception
     */
    List<Question> findQuestionById(String c_id) throws Exception;

    /*
     * 添加班级信息
     */
    int addQuestion(Question question) throws Exception;

    /*
     * 删除班级信息
     */
    int deleteQuestion(int c_id) throws Exception;


    /**
     * 回答问题
     *
     * @param question
     * @throws Exception
     */
    void answerQuestions(Question question) throws Exception;
}
