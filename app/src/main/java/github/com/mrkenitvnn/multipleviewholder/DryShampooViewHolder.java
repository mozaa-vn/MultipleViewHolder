package github.com.mrkenitvnn.multipleviewholder;

import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import github.com.mrkenitvnn.multipleviewholder.adapter.ItemViewHolder;


public class DryShampooViewHolder extends ItemViewHolder<DryShampooItem> {

    @BindView(R.id.text_view_name)
    TextView textViewName;

    @BindView(R.id.text_view_weight)
    TextView textViewWeight;


    public DryShampooViewHolder(ViewGroup parent, @LayoutRes int layoutId) {
        super(parent, layoutId);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void onBindItem(DryShampooItem item) {
        super.onBindItem(item);

        textViewName.setText(TextUtils.isEmpty(
                item.dryShampoo().getShampooName()) ? "" : item.dryShampoo().getShampooName());
        textViewWeight.setText(TextUtils.isEmpty(
                item.dryShampoo().getShampooWeight()) ? "" : item.dryShampoo().getShampooWeight());
    }

}
