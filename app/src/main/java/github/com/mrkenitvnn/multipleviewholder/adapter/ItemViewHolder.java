package github.com.mrkenitvnn.multipleviewholder.adapter;

import android.content.Context;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class ItemViewHolder<T extends Item> extends RecyclerView.ViewHolder {

    protected T item;
    protected Context mContext;

    public ItemViewHolder(ViewGroup parent, @LayoutRes int layoutId) {
        super(LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
        itemView.setTag(this);
        mContext = parent.getContext().getApplicationContext();
    }

    public T getItem(){
        return item;
    }

    @CallSuper
    public void onBindItem(T item){
        this.item = item;
    }

    @CallSuper
    public void onViewRecycled(){
        this.item = null;
    }
}
