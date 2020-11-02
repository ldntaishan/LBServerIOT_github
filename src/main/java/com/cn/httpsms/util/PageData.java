package com.cn.httpsms.util;

import java.util.List;

/**
 * @author liu.songgao
 *         <p>创建时间: 2015年5月7日 下午1:58:40</p>
 *         <p>描述：分页工具类</p>
 * @version 1.0
 */
public class PageData {

    /**
     * 默认每页记录条数
     **/
    private static int defaultPageSize = 20;
    /**
     * 数据结果集
     **/
    private List<?> dataList;
    /**
     * 当前页码
     **/
    private int pageNumber = 0;
    /**
     * 下一页页码
     **/
    private int nextPageNumber = 0;
    /**
     * 上一页页码
     **/
    private int prevPageNumber = 0;
    /**
     * 每页记录条数
     **/
    private int pageSize = 0;
    /**
     * 页数
     **/
    private int pageCount = 0;
    /**
     * 总计结果集条数
     **/
    private int totalSize = 0;

    public PageData() {
    }

    public PageData(List<?> dataList) {
        this.dataList = dataList;
        this.totalSize = dataList.size();
        this.pageNumber = this.totalSize > 0 ? 1 : 0;
        this.pageCount = (totalSize % pageSize) != 0 ? (totalSize / pageSize) + 1 : totalSize / pageSize;
    }

    public PageData(List<?> dataList, int pageNumber, int totalSize) {
        this(dataList, defaultPageSize, pageNumber, totalSize);
    }

    public PageData(List<?> dataList, int pageSize, int pageNumber, int totalSize) {
        this.dataList = dataList;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.totalSize = totalSize;
        this.pageCount = (totalSize % pageSize) != 0 ? (totalSize / pageSize) + 1 : totalSize / pageSize;
    }

    public List<?> getDataList() {
        return dataList;
    }

    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getNextPageNumber() {
        return nextPageNumber;
    }

    public void setNextPageNumber(int nextPageNumber) {
        this.nextPageNumber = nextPageNumber;
    }

    public int getPrevPageNumber() {
        return prevPageNumber;
    }

    public void setPrevPageNumber(int prevPageNumber) {
        this.prevPageNumber = prevPageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

}
