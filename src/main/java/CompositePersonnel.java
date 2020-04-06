import java.util.ArrayList;
import java.util.List;

public class CompositePersonnel implements Composite {
    private List<Composite> enfantComposite = new ArrayList<Composite>();


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
}
