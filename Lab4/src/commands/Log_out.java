package commands;

public class Log_out implements Interface {
    @Override
    public ResultOfCommand<String> execute()   {
        System.out.println("Logging out succeeded!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
        return result;
    }
}
