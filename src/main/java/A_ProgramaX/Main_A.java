package A_ProgramaX;

public class Main_A {
    public static void main(String[] args) {
        TextFileWriter writer = new TextFileWriter("output.txt");
        InputFrame frame = new InputFrame(writer);
        frame.setVisible(true);
    }
}
