package cn.kewen.hms.controller;

import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Question;
import cn.kewen.hms.service.QuestionService;
import cn.kewen.hms.service.StudentService;
import cn.kewen.hms.service.TeacherService;
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
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

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
    public ModelAndView findTeacherQuestions(ModelAndView mav, PageParams params, HttpServletRequest request) throws Exception {
        String title = request.getParameter("title");
        PageData<Question> questions = questionService.findQuestions(params, title);
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
        teacherService.incrementPoint(Integer.parseInt(session.getAttribute("t_id").toString()));
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
        PageData<Question> questions = questionService.findQuestions(null, null);
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
    public ModelAndView addQuestion(Question question, ModelAndView mav, HttpSession session) throws Exception {
        Object s_id = session.getAttribute("s_id");
        if (s_id != null) {
            studentService.incrementPoint(Integer.parseInt(s_id.toString()));
            question.setS_id(Integer.parseInt(s_id.toString()));
            questionService.addQuestion(question);
        }
        PageData<Question> questions = questionService.findQuestions(null, null);
        logger.info("questions:" + questions);
        mav.addObject("questions", questions);
        mav.setViewName("jsp/question/question-list");
        return mav;
    }

    /**
     * 删除学生
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("batchDeleteQuestion")
    public ModelAndView batchDeleteQuestion(ModelAndView mav, HttpServletRequest request) throws Exception {
        request.getParameterMap().forEach((s, strings) -> {
            try {
                questionService.deleteQuestion(Integer.parseInt(strings[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        PageData<Question> questions = questionService.findQuestions(null, null);
        logger.info("questions:" + questions);
        mav.addObject("questions", questions);
        mav.setViewName("jsp/question/question-list");
        return mav;
    }

}
