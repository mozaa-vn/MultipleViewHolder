package github.com.mrkenitvnn.multipleviewholder.adapter;

import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public abstract class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder>{

    protected RecyclerView recyclerView;
    protected List<Item> items;
    protected boolean ready = false;

    public boolean isReady(){
        return ready;
    }
    /**
     * Change the items list.
     * @return true if have to call notify item changed, false if adapter already call notifyDataSetChanged()
     */
    public boolean setItem(List<Item> items){
        boolean firstTime = this.items == null;
        this.items = items;
        if(firstTime && ready)
            notifyDataSetChanged();
        return !firstTime && ready;
    }
    /**
     * Mark adapter is ready to show items.
     */
    protected void setReady(){
        if(!ready){
            ready = true;
            notifyDataSetChanged();
        }
    }

    public Item getItemAt(int position){
        return (position < 0 || position > getItemCount() - 1) ? null : items.get(position);
    }

    @Override
    public int getItemCount() {
        return items == null || !ready ? 0 : items.size();
    }

    @SuppressWarnings("unchecked")
    @Override
    @CallSuper
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = getItemAt(position);
        if(item != null)
            holder.onBindItem(item);
    }

    @Override
    @CallSuper
    public void onViewRecycled(ItemViewHolder holder) {
        super.onViewRecycled(holder);
        holder.onViewRecycled();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }



}
