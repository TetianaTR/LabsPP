package commands;

public class SelectEquipment implements Interface {
    @Override
    public ResultOfCommand<String> execute() {
        System.out.println("Select equipment works!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
        return result;
    }
}
