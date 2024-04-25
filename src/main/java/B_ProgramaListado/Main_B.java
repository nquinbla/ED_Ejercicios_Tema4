package B_ProgramaListado;
public class Main_B {
    public static void main(String[] args) {
        TextFileWriter writer = new TextFileWriter("output.txt");
        Menu menu = new Menu(writer);
        menu.setVisible(true);
    }
}

