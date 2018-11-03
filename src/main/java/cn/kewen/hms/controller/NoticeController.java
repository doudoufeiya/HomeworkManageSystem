package cn.kewen.hms.controller;

import cn.kewen.hms.pojo.Notice;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.service.NoticeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    private Logger logger = Logger.getLogger(NoticeController.class);


    @RequestMapping("findNotices")
    public ModelAndView findNotices(ModelAndView mav, PageParams params, HttpServletRequest request) throws Exception {
        String n_title = request.getParameter("n_title");
        PageData<Notice> notices = noticeService.findNotices(params, n_title);
        logger.info("notices:" + notices);
        mav.addObject("notices", notices);
        mav.setViewName("jsp/notice/notice-list");
        return mav;
    }

    @RequestMapping("welcomeIndex")
    public ModelAndView welcomeIndex(ModelAndView mav, PageParams params, HttpServletRequest request) throws Exception {
        PageData<Notice> notices = noticeService.findNotices(params, null);
        logger.info("notices:" + notices);
        mav.addObject("notices", notices);
        mav.setViewName("welcome_index");
        return mav;
    }


    /**
     * 跳转到添加学生页面
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("addNoticePage")
    public ModelAndView addNoticePage(ModelAndView mav, @RequestParam(required = false) Integer n_id) throws Exception {
        mav.setViewName("jsp/notice/notice-add");
        mav.addObject("n_id", n_id);
        return mav;
    }

//    @RequestMapping("findTeacherResources")
//    public ModelAndView findTeacherQuestions(ModelAndView mav, PageParams params, HttpServletRequest request) throws Exception {
//        String r_name = request.getParameter("r_name");
//        PageData<Resource> resources = resourceService.findResources(params, r_name);
//        logger.info("resources:" + resources);
//        mav.addObject("resources", resources);
//        mav.setViewName("jsp/resource/resource-teacher");
//        return mav;
//    }

    @RequestMapping("gotoNoticePage")
    public ModelAndView gotoNoticePage(ModelAndView mav,
                                       @RequestParam(required = false) Integer n_id) throws Exception {
        mav.addObject("n_id", n_id);
        mav.addObject("notice", noticeService.findNoticeById(n_id));
        mav.setViewName("jsp/notice/notice-add");
        return mav;
    }

//    @RequestMapping("answerQuestions")
//    public void answerQuestions(ModelAndView mav, Question question, HttpSession session) throws Exception {
//        question.setT_id(Integer.parseInt(session.getAttribute("t_id").toString()));
//        resourceService.answerQuestions(question);
////        logger.info("questions:" + questions);
////        mav.addObject("questions", questions);
////        mav.setViewName("jsp/question/question-teacher");
////        return mav;
//    }


    /**
     * 删除学生
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteNotice")
    public ModelAndView deleteNotice(ModelAndView mav, Integer n_id) throws Exception {
        if (n_id != null) {
            noticeService.deleteNotice(n_id);

        }
        PageData<Notice> notices = noticeService.findNotices(null, null);
        logger.info("notices:" + notices);
        mav.addObject("notices", notices);
        mav.setViewName("jsp/notice/notice-list");
        return mav;
    }


    /**
     * 添加学生
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("addNotice")
    public ModelAndView addNotice(Notice notice, ModelAndView mav) throws Exception {
        if (notice.getN_id() == null) {
            noticeService.addNotice(notice);
        } else {
            noticeService.editNotice(notice);
        }
        return mav;
    }


    /**
     * 删除学生
     *
     * @param mav
     * @return
     * @throws Exception
     */
    @RequestMapping("batchDeleteNotice")
    public ModelAndView batchDeleteNotice(ModelAndView mav, HttpServletRequest request) throws Exception {
        request.getParameterMap().forEach((s, strings) -> {
            try {
                noticeService.deleteNotice(Integer.parseInt(strings[0]));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        PageData<Notice> notices = noticeService.findNotices(null, null);
        logger.info("notices:" + notices);
        mav.addObject("notices", notices);
        mav.setViewName("jsp/notice/notice-list");
        return mav;
    }

}
