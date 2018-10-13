/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back;

/**
 *
 * @author HT3rico
 */
public class word {
    public String spelling;
    public String explain;
    private int id;
    public word(int i,String s,String e){
        spelling =s;
        explain= e;
        id = i;
    }
    public word(){
    }
    
    public void setSpelling(String s) {
        this.spelling = s;
    }
    public String getSpelling() {
        return spelling;
    }

    public void setExplain(String e) {
        this.explain = e;
    }
    public String getExplain() {
        return explain;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}