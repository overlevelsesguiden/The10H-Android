package dk.overlevelsesguiden.de10her;

import java.io.Serializable;

public class Document implements Serializable {

    private String title;

    private String date;
    private String time;

    private String h1;
    private String h2;
    private String h3;
    private String h4;
    private String h5;
    private String h6;
    private String h7;
    private String h8;
    private String h9;
    private String h10;

    public void setTitle(String title){
        this.title = title;
    }

    public void setDate(String date){
        this.date = date;
    }

    public void setTime(String time){
        this.time = time;
    }

    public void setH1(String h1){
        this.h1 = h1;
    }

    public void setH2(String h2){
        this.h2 = h2;
    }

    public void setH3(String h3){
        this.h3 = h3;
    }

    public void setH4(String h4){
        this.h4 = h4;
    }

    public void setH5(String h5){
        this.h5 = h5;
    }

    public void setH6(String h6){
        this.h6 = h6;
    }

    public void setH7(String h7){
        this.h7 = h7;
    }

    public void setH8(String h8){
       this.h8 = h8;
    }

    public void setH9(String h9){
        this.h9 = h9;
    }

    public void setH10(String h10){
        this.h10 = h10;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDate(){
        return this.date;
    }

    public String getTime(){
        return this.time;
    }

    public String getH1(){
        return this.h1;
    }

    public String getH2(){
        return this.h2;
    }

    public String getH3(){
        return this.h3;
    }

    public String getH4(){
        return this.h4;
    }

    public String getH5(){
        return this.h5;
    }

    public String getH6(){
        return this.h6;
    }

    public String getH7(){
        return this.h7;
    }

    public String getH8(){
        return this.h8;
    }

    public String getH9(){
        return this.h9;
    }

    public String getH10(){
        return this.h10;
    }

}
