package com.util;

import java.util.List;

/**
 * Title: <br>
 * <p>
 * Description: 分页查询方法<br>
 * <p>
 * Created by zengxianbing on 2016/4/18.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class Pager<E> {

    public static final int PAGE_SIZE_DEFAULT = 10;

    //结果集
    private List<E> list;

    //总记录数
    private int totalRecords=0;
    //总计有多少页
    private int totalPage=0;
    //当前页第一条数据在List中的位置,从0开始
    private int start=0;
    //每页多少条数据
    private int pageSize= PAGE_SIZE_DEFAULT;

    //第几页
    private int pageNo;
    public Pager(){

    }
    public Pager(List<E> list, int totalRecords, int pageSize, int pageNo) {
        this.list = list;
        this.pageSize = pageSize;
        setTotalRecords(totalRecords);
        setPageNo(pageNo);
    }


    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStart() {
        if(start<=0){
            start=(pageNo-1)*pageSize;
        }
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords=totalRecords;
        totalPage = (int) Math.ceil((totalRecords + pageSize - 1) / pageSize);
        start=(pageNo-1)*pageSize;
    }
    /**
     * 该页是否有下一页.
     */
    public boolean hasNextPage() {
        return pageNo < totalPage;
    }
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        if(pageNo>0) {
            start=(pageNo-1)*pageSize;
            this.pageNo = pageNo;
        }
    }

}
