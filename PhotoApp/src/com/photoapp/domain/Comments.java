
package com.photoapp.domain;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Comments {

    @Expose
    private Integer count;
    @Expose
    private List<Datum_> data = new ArrayList<Datum_>();

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Datum_> getData() {
        return data;
    }

    public void setData(List<Datum_> data) {
        this.data = data;
    }

}
