package cn.kewen.hms.pojo;

import java.util.List;

/**
 * 分页实体
 *
 * @author shen
 * @version 1.0.0
 * @since 2018/10/30
 */
public class PageData<T> extends PageParams {


    /**
     * 返回的数据
     */
    private List<T> data;


    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "PageData{" +
                "data=" + data +
                super.toString() +
                '}';
    }
}
