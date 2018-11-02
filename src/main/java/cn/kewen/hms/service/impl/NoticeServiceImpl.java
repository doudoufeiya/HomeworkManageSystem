package cn.kewen.hms.service.impl;

import cn.kewen.hms.mapper.NoticeMapper;
import cn.kewen.hms.mapper.QuestionMapper;
import cn.kewen.hms.pojo.Notice;
import cn.kewen.hms.pojo.PageData;
import cn.kewen.hms.pojo.PageParams;
import cn.kewen.hms.pojo.Question;
import cn.kewen.hms.service.NoticeService;
import cn.kewen.hms.service.QuestionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

//接口注入，代替Spring配置文件
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
    //加载mapper文件
    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public PageData<Notice> findNotices(PageParams params, String title) throws Exception {
        if (params == null) {
            params = new PageParams();
        }

        Page page = PageHelper.startPage(params.getPageNumber().intValue(), params.getPageSize().intValue(), true);
        PageData<Notice> result = new PageData<>();
        result.setData(noticeMapper.findNotices(title));
        result.setPageNumber(page.getPageNum());
        result.setPageSize(params.getPageSize());
        result.setTotalRow(page.getTotal());
        result.setTotalPage(page.getPages());
        return result;
    }

    @Override
    public Notice findNoticeById(Integer n_id) throws Exception {
        if (n_id == null) {
            return null;
        }
        return noticeMapper.findNoticeById(n_id);
    }

    @Override
    public int addNotice(Notice notice) throws Exception {
        return noticeMapper.addNotice(notice);
    }


    @Override
    public int deleteNotice(Integer s_id) throws Exception {
        return noticeMapper.deleteNotice(s_id);
    }

    @Override
    public void editNotice(Notice notice) throws Exception {
        if (notice == null){
            return;
        }
        noticeMapper.updateNotice(notice);

    }


}
