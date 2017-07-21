package github.com.mrkenitvnn.multipleviewholder;

import com.google.auto.value.AutoValue;
import github.com.mrkenitvnn.multipleviewholder.adapter.Item;
import github.com.mrkenitvnn.multipleviewholder.entities.MysteryBook;

@AutoValue
public abstract class MysteryBookItem implements Item {

    public static MysteryBookItem instance (MysteryBook book) {
        return new AutoValue_MysteryBookItem(book);
    }

    public abstract MysteryBook mysteryBook ();

}
