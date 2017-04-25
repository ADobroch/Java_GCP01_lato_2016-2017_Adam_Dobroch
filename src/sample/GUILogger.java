package sample;


public class GUILogger implements Logger {
    private static LogTab logTab;

    public GUILogger(LogTab logTab) {
        this.logTab = logTab;
    }



    @Override
    public void log(String status, Student student) {

        logTab.addData(status, student);

    }

    @Override
    public void log(String status) {

    }

    @Override
    public void log(String status, int Iteration) {

    }


}
