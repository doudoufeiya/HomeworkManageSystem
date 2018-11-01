package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.QuestionMapper;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Question;
import cn.kewen.hms.service.QuestionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

//接口注入，代替Spring配置文件
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    //加载mapper文件
    @Resource
    private QuestionMapper questionMapper;

    @Override
    public PageData<Question> findQuestions(PageParams params) throws Exception {
        if (params == null) {
            params = new PageParams();
        }
        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<Question> result = new PageData<>();
        result.setData(questionMapper.findQuestions());
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

    @Override
    public int addQuestion(Question question) throws Exception {
        return questionMapper.addQuestion(question);
    }


    @Override
    public int deleteQuestion(int s_id) throws Exception {
        return questionMapper.deleteQuestion(s_id);
    }
}
