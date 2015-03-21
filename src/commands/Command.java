package commands;

public interface Command<Params, Result> {
    public String run(Params params);
}