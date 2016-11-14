package command;

import java.util.Map;

public class CommandParser {
    private Map<Character, Command> protocol;

    public CommandParser(Map<Character, Command> roverProtocol) {
        this.protocol = roverProtocol;
    }

    public Command Parse(Character symbol) {
        if(protocol.containsKey(symbol)){
            return protocol.get(symbol);
        }
        return new CommandNotFound();
    }

}
