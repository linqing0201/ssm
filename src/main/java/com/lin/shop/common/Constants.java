package com.lin.shop.common;

public enum Constants {

	CURRENT_USER("2222") ,CURRENT_WEBSOCKET_USER("");
     
     
	    private String name ;
	    private int index ;
	     
	    private Constants( String name ){
	        this.name = name ;
	    }
	     
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public int getIndex() {
	        return index;
	    }
	    public void setIndex(int index) {
	        this.index = index;
	    }
}
