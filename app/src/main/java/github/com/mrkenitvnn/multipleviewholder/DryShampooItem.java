package github.com.mrkenitvnn.multipleviewholder;

import com.google.auto.value.AutoValue;
import github.com.mrkenitvnn.multipleviewholder.adapter.Item;
import github.com.mrkenitvnn.multipleviewholder.entities.DryShampoo;

@AutoValue
public abstract class DryShampooItem implements Item {


    public static DryShampooItem instance (DryShampoo shampoo) {
        return new AutoValue_DryShampooItem(shampoo);
    }

    public abstract DryShampoo dryShampoo();

}
