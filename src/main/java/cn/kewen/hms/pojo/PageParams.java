package cn.kewen.hms.pojo;


/**
 * 分页参数
 *
 * @author shen
 * @version 1.0.0
 * @since 2018/10/30
 */
public class PageParams {

    public PageParams() {
        this(1, 10L);
    }

    public PageParams(Integer pageNumber, Long pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    /**
     * 页码
     */
    private Integer pageNumber;

    /**
     * 每页数量
     */
    private Long pageSize;

    /**
     * 总共椰树
     */
    private Integer totalPage;

    /**
     * 总共条数
     */
    private Long totalRow;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(Long totalRow) {
        this.totalRow = totalRow;
    }

    @Override
    public String toString() {
        return "PageParams{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalRow=" + totalRow +
                '}';
    }
}
