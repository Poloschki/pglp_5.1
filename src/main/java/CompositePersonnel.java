import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CompositePersonnel implements Composite {
    protected List<Composite> enfantComposite = new ArrayList<>();


    @Override
    public void print() {
        for (Composite composite : enfantComposite) {
            composite.print();
        }
    }

    public void add(Composite composite) {
        enfantComposite.add(composite);
    }

    public void remove(Composite composite) {
        enfantComposite.remove(composite);
    }

    public void serialize(String filename, CompositePersonnel personnel) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(personnel);

            out.close();
            file.close();
        } catch (IOException exception) {
            System.out.println("Exception lors de la serialisation");
        }

    }

}
