package F_AgendaTlf;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;
    private static final String FILE_NAME = "contactos.dat";

    public Agenda() {
        contactos = new ArrayList<>();
        cargarContactos();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
        guardarContactos();
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    private void cargarContactos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            contactos = (List<Contacto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Ignorar, el archivo no existe aún
        }
    }

    private void guardarContactos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(contactos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}