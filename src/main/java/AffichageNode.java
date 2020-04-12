import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;


public class AffichageNode<T> implements Iterator<Composite> {
  private final Deque<Iterator<Composite>> iterators = new ArrayDeque<>();
  private final boolean profondeur;


  public AffichageNode(Composite composite, boolean profondeur) {
    this.iterators.add(Collections.singleton(composite).iterator());
    this.profondeur = profondeur;
  }


  @Override
  public boolean hasNext() {
    return !this.iterators.isEmpty();
  }

  @Override
  public Composite next() {
    Iterator<Composite> iterator = this.iterators.removeFirst();
    Composite composite = iterator.next();

    if (iterator.hasNext()) {
      this.iterators.addFirst(iterator);
    }

    if (composite instanceof CompositePersonnel) {
      if (!((CompositePersonnel) composite).enfantComposite.isEmpty()) {
        if (this.profondeur) {
          this.iterators.addFirst(((CompositePersonnel) composite).enfantComposite.iterator());
        } else {
          this.iterators.addLast(((CompositePersonnel) composite).enfantComposite.iterator());
        }
      }
    }

    return composite;

  }

  public void serialize(String filename, AffichageNode<T> affichageNode) {
    try {
      FileOutputStream file = new FileOutputStream(filename);
      ObjectOutputStream out = new ObjectOutputStream(file);

      out.writeObject(affichageNode);

      out.close();
      file.close();
    } catch (IOException exception) {
      System.out.println("Exception lors de la serialisation");
    }

  }


}