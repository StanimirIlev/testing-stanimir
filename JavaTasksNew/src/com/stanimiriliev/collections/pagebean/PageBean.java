package com.stanimiriliev.collections.pagebean;

import java.util.ArrayList;
import java.util.List;

/**
 * This class receive list and divide it to pages
 * @author Stanimir Iliev
 * @since 24.07.2017
 */
public class PageBean <T>{

    private class Page<T>{

        public final int count;// pages count
        private final int size;// items per page
        private final List<T> src;

        public Page(List<T> src, int pageSize){
            size = pageSize;
            this.src = src;
            count = (src.size() % size != 0) ? src.size() / size + 1 : src.size() / size;
        }

        /**
         * Get page at given index
         * @param index -> index of the page to return
         * @return list with the items of the desired page
         */
        public List<T> getPage(int index){
            List<T> output = new ArrayList<>();
            for(int i = index * size; i < index * size + size && i < src.size(); i++){
                output.add(src.get(i));
            }
            return output;
        }

    }

    private int pageIndex = -1;
    private Page<T> page;

    public PageBean(List<T> src, int pageSize){
        if(src == null || src.size() == 0 || pageSize <= 0)
            throw new IllegalArgumentException("This error may occur because of several things:\n" +
                    "Source list is null\nSource list is empty\nPage size is less than or equal to zero");
        page = new Page<>(src, pageSize);
    }

    /**
     * Go to the next page
     * @return list with the next n elements of the source list (n -> page size)
     */
    public List<T> next(){
        if(pageIndex < page.count - 1){
            return page.getPage(++pageIndex);
        }
        System.out.println("There is no next page!");
        return new ArrayList<>();
    }

    /**
     * Go to the previous page
     * @return list with the previous n elements of the source list (n -> page size)
     */
    public List<T> previous(){
        if(pageIndex > 0){
            return page.getPage(--pageIndex);
        }
        System.out.println("There is no previous page!");
        return new ArrayList<T>();
    }

    public boolean hasNext(){
        return pageIndex < page.count - 1;
    }

    public boolean hasPrevious(){
        return pageIndex > 0;
    }

    /**
     * Returns first page and make it current page
     * @return list with the first n elements of the source list (n -> page size)
     */
    public List<T> firstPage(){
        pageIndex = -1;
        return next();
    }

    /**
     * Returns last page and make it current page
     * @return list with the last n elements of the source list (n -> page size)
     */
    public List<T> lastPage(){
        pageIndex = page.count;
        return previous();
    }

    public int getCurrentPageNumber(){
        return pageIndex + 1;
    }
}
