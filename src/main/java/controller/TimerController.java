package controller;

import view.MainWindow;
import view.TablePanel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class TimerController {
  private static TimerTask timerTask;
  private static Timer timer;

  static SimpleDateFormat sdf;
  static Long counterMS = 0L;
  static long period = 23;

  private static String result = "00:00:00.000";

  public TimerController() {
    sdf = new SimpleDateFormat("HH:mm:ss.SSS");
    sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
  }

  public static void start() {
    timerTask = new TimerTask() {
      @Override
      public void run() {
        onTimerCast();
      }
    };
    timer = new Timer();
    timer.schedule(timerTask, 0, period);
  }

  private static void onTimerCast() {
    result = sdf.format(counterMS);
    MainWindow.setLabelText(result);
    counterMS += period;
  }

  public static void stop(){
    MainWindow.setLabelText(result);
    ListController.addResult(result);
    TablePanel.setModel();
    timer.cancel();
  }

  public static void reset(){
    if(timer!=null){
      timer.cancel();
    }
    result = "00:00:00.000";
    counterMS = 0L;
  }

  public static void addLapResult() {
    ListController.addResult(result);
    TablePanel.setModel();
  }
}
