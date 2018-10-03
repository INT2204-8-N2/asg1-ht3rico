/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 * 
 * @author HT3rico
 */
public class DictionaryComandLine {
    public void Run(){
        DictionaryManegement DM = new DictionaryManegement();
        DM.insertFromCommandline();
        DM.showAllWorlds();
    }
    public static void main(String [] args){
        DictionaryComandLine Test = new DictionaryComandLine();
        Test.Run();
    }
}
