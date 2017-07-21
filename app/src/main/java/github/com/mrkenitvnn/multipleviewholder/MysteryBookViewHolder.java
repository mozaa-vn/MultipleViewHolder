package github.com.mrkenitvnn.multipleviewholder;

import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import github.com.mrkenitvnn.multipleviewholder.adapter.ItemViewHolder;

public class MysteryBookViewHolder extends ItemViewHolder<MysteryBookItem> {

    @BindView(R.id.text_view_name)
    TextView textViewName;

    @BindView(R.id.text_view_author)
    TextView textViewAuthor;

    @BindView(R.id.text_view_total_page)
    TextView textViewTotalPage;

    public MysteryBookViewHolder(ViewGroup parent, @LayoutRes int layoutId) {
        super(parent, layoutId);
        ButterKnife.bind(this, itemView);
    }


    @Override
    public void onBindItem(MysteryBookItem item) {
        super.onBindItem(item);

        textViewName.setText(TextUtils.isEmpty(item.mysteryBook().getBookName()) ? "" : item.mysteryBook().getBookName());
        textViewAuthor.setText(TextUtils.isEmpty(item.mysteryBook().getBookAuthor()) ? "" : item.mysteryBook().getBookAuthor());
        textViewTotalPage.setText( String.valueOf(item.mysteryBook().getTotalPage()) );

    }

}
