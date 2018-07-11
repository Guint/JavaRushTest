package org.gvp.boookmanager.to;

public abstract class BaseTo {

    protected Long id;

    public BaseTo() {
    }

    public BaseTo(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

}
