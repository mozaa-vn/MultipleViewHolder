package github.com.mrkenitvnn.multipleviewholder;

import android.view.View;
import android.view.ViewGroup;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import github.com.mrkenitvnn.multipleviewholder.adapter.Item;
import github.com.mrkenitvnn.multipleviewholder.adapter.ItemAdapter;
import github.com.mrkenitvnn.multipleviewholder.adapter.ItemViewHolder;
import github.com.mrkenitvnn.multipleviewholder.entities.DryShampoo;
import github.com.mrkenitvnn.multipleviewholder.entities.MysteryBook;

public class TimeLineAdapter extends ItemAdapter {

    OnItemTimeLineClickListener listener;

    @Retention(RetentionPolicy.SOURCE)
    @interface Type {
        int SHAMPOO_DRY = 1;
        int BOOK_MYSTERY = 2;
    }

    public TimeLineAdapter () {
        setReady(); // TODO don't forget it
        if (items == null) {
            items = new ArrayList<>();
        }
    }

    @Override
    public int getItemViewType(int position) {
        Item item = getItemAt(position);

        if (item instanceof DryShampooItem)
            return Type.SHAMPOO_DRY;

        if (item instanceof MysteryBookItem)
            return Type.BOOK_MYSTERY;

        throw new IllegalArgumentException("Not support item " + item);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewHolder viewHolder = null;

        switch (viewType) {
            case Type.SHAMPOO_DRY:
                viewHolder = new DryShampooViewHolder(parent, R.layout.item_dry_shampoo);
                final ItemViewHolder finalViewHolder = viewHolder;
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DryShampooItem item = (DryShampooItem)finalViewHolder.getItem();
                        listener.onItemDryShampooClick(item.dryShampoo());
                    }
                });
                break;

            case Type.BOOK_MYSTERY:
                viewHolder = new MysteryBookViewHolder(parent, R.layout.item_mystery_book);
                final ItemViewHolder finalViewHolder1 = viewHolder;
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MysteryBookItem item = (MysteryBookItem) finalViewHolder1.getItem();
                        listener.onItemMysteryBookClick(item.mysteryBook());
                    }
                });
                break;
        }

        return viewHolder;
    }

    public void setOnItemClickListener (OnItemTimeLineClickListener callback) {
        listener = callback;
    }


    public void addMysteryBook (MysteryBook book) {
        MysteryBookItem item = MysteryBookItem.instance(book);
        items.add(item);
        notifyDataSetChanged();
    }

    public void addDryShampoo (DryShampoo shampoo) {
        DryShampooItem item = DryShampooItem.instance(shampoo);
        items.add(item);
        notifyDataSetChanged();
    }

    public void addListShampoo (List<DryShampoo> list) {

        if (null == list || list.isEmpty()) {
            return;
        }

        List<Item> listItems = new ArrayList<>();
        DryShampooItem item;
        for (DryShampoo shampoo : list) {
            item = DryShampooItem.instance(shampoo);
            listItems.add(item);
        }

        items.addAll(listItems);
        notifyDataSetChanged();
    }

}
