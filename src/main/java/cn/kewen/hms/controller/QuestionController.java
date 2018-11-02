package cn.kewen.hms.controller;

import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Question;
import cn.kewen.hms.service.QuestionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    private Logger logger = Logger.getLogger(QuestionController.class);


    @RequestMapping("findQuestions")
    public ModelAndView findQuestions(ModelAndView mav, PageParams params, HttpServletRequest request) throws Exception {
        String title = request.getParameter("title");
        PageData<Question> questions = questionService.findQuestions(params, title);
        logger.info("questions:" + questions);
        mav.addObject("questions", questions);
        mav.setViewName("jsp/question/question-list");
        return mav;
    }


    /**
     * 跳转到添加学生页面
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("addQuestionPage")
    public ModelAndView addStudentPage(ModelAndView mav) throws Exception {
        mav.setViewName("jsp/question/question-add");
        return mav;
    }

    @RequestMapping("findTeacherQuestions")
    public ModelAndView findTeacherQuestions(ModelAndView mav, PageParams params) throws Exception {
        PageData<Question> questions = questionService.findQuestions(params, );
        logger.info("questions:" + questions);
        mav.addObject("questions", questions);
        mav.setViewName("jsp/question/question-teacher");
        return mav;
    }

    @RequestMapping("gotoAnswerPage")
    public ModelAndView gotoAnswerPage(ModelAndView mav, Integer question_id) throws Exception {
        mav.addObject("question_id", question_id);
        mav.setViewName("jsp/question/question-edit");
        return mav;
    }

    @RequestMapping("answerQuestions")
    public void answerQuestions(ModelAndView mav, Question question, HttpSession session) throws Exception {
        question.setT_id(Integer.parseInt(session.getAttribute("t_id").toString()));
        questionService.answerQuestions(question);
//        logger.info("questions:" + questions);
//        mav.addObject("questions", questions);
//        mav.setViewName("jsp/question/question-teacher");
//        return mav;
    }


    /**
     * 删除学生
     *
     * @param mav
     * @param s_id
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteQuestion")
    public ModelAndView deleteStudent(ModelAndView mav, Integer s_id) throws Exception {
        if (s_id != null) {
            questionService.deleteQuestion(s_id);

        }
        PageData<Question> questions = questionService.findQuestions(null, );
        logger.info("questions:" + questions);
        mav.addObject("questions", questions);
        mav.setViewName("jsp/question/question-list");
        return mav;
    }


    /**
     * 添加学生
     *
     * @param question
     * @return
     * @throws Exception
     */
    @RequestMapping("addQuestion")
    public void addQuestion(Question question) throws Exception {
        ModelAndView mav = new ModelAndView();
        questionService.addQuestion(question);
    }


}
