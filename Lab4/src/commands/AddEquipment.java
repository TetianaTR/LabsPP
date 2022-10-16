package commands;

public class AddEquipment implements Interface {
    @Override
    public ResultOfCommand<String> execute() {
        System.out.println("Adding works!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
        return result;
    }
}
