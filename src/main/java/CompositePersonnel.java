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
}
