package controller;

import java.util.ArrayList;
import java.util.List;

public class ListController {

  static List<String> resultList;

  public ListController() {
    this.resultList = new ArrayList<String>();
  }

  public static void addResult(String result){
    resultList.add(result);
  }

  public static void reset(){
    resultList = new ArrayList<String>();
  }

  public static List<String> getResultList() {
    return resultList;
  }

  public static void setResultList(List<String> resultList) {
    ListController.resultList = resultList;
  }

  public static void addLapResult() {

  }
}
