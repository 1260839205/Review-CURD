package cn.aguo.review.domain;

import java.util.List;

/**
 * @Author 石成果
 * @Email 1260839205@qq.com
 * @Date 2021/3/30 上午10:26
 */
public class PageBean<T> {
    private int totalCount; //总记录数
    private int totalPageNumber; //总页码
    private int rows ; // 每页显示条数
    private int currentPageNumber; //当前页码
    private List<T> tList; //每页存储的数据

    public PageBean(int totalCount, int totalPageNumber, int rows, int currentPageNumber, List<T> tList) {
        this.totalCount = totalCount;
        this.totalPageNumber = totalPageNumber;
        this.rows = rows;
        this.currentPageNumber = currentPageNumber;
        this.tList = tList;
    }

    public PageBean() {
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPageNumber() {
        return totalPageNumber;
    }

    public void setTotalPageNumber(int totalPageNumber) {
        this.totalPageNumber = totalPageNumber;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public List<T> gettList() {
        return tList;
    }

    public void settList(List<T> tList) {
        this.tList = tList;
    }
}
