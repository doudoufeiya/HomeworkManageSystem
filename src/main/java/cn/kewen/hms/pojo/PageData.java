package cn.kewen.hms.pojo;

import java.util.List;

/**
 * 分页实体
 *
 * @author shen
 * @version 1.0.0
 * @since 2018/10/30
 */
public class PageData<T> {

    private Long total;
    private Integer nowPage;
    private List<T> data;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageData{" +
                "total=" + total +
                ", nowPage=" + nowPage +
                ", data=" + data +
                '}';
    }
}
