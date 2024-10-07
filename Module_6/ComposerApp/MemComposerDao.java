package Module_6.ComposerApp;

import java.util.ArrayList;
import java.util.List;

public class MemComposerDao implements ComposerDao {
    private List<Composer> composers;

    // No-argument constructor with a default list of composers
    public MemComposerDao() {
        composers = new ArrayList<>();
        composers.add(new Composer(1, "Ludwig van Beethoven", "Classical"));
        composers.add(new Composer(2, "Johann Sebastian Bach", "Baroque"));
        composers.add(new Composer(3, "Wolfgang Amadeus Mozart", "Classical"));
        composers.add(new Composer(4, "Pyotr Ilyich Tchaikovsky", "Romantic"));
        composers.add(new Composer(5, "Frédéric Chopin", "Romantic"));
    }

    // Find all composers
    @Override
    public List<Composer> findAll() {
        return composers;
    }

    // Find a composer by ID
    @Override
    public Composer findBy(Integer id) {
        for (Composer composer : composers) {
            if (composer.getId() == id) {
                return composer;
            }
        }
        return null;  // Return null if not found
    }

    // Insert a new composer into the list
    @Override
    public void insert(Composer composer) {
        composers.add(composer);  // Correct syntax for adding a composer
    }
}
