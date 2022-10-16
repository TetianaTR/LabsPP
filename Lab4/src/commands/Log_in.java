package commands;

public class Log_in implements Interface {
    @Override
    public ResultOfCommand<String> execute()  {
        System.out.println("Log in Succeeded!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
        return result;
    }
}
