package commands;

public class DeleteEquipment implements Interface {
    @Override
    public ResultOfCommand<String> execute() {
        System.out.println("Deleting works!");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
        return result;
    }
}
