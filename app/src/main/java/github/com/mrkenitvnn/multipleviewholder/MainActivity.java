package github.com.mrkenitvnn.multipleviewholder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import github.com.mrkenitvnn.multipleviewholder.entities.DryShampoo;
import github.com.mrkenitvnn.multipleviewholder.entities.MysteryBook;

public class MainActivity extends AppCompatActivity implements OnItemTimeLineClickListener{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    TimeLineAdapter adapter;
    List<DryShampoo> listShampoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        adapter = new TimeLineAdapter();
        adapter.setOnItemClickListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        DryShampoo shampoo1 = new DryShampoo();
        shampoo1.setShampooName("Shampoooo");
        shampoo1.setShampooWeight("99");
        adapter.addDryShampoo(shampoo1);

        listShampoo = new ArrayList<>();
        listShampoo.add(shampoo1);

        MysteryBook mysteryBook1 = new MysteryBook();
        mysteryBook1.setBookName("The Woman in White");
        mysteryBook1.setBookAuthor("Wilkie Collins");
        mysteryBook1.setTotalPage(569);
        adapter.addMysteryBook(mysteryBook1);
    }


    @OnClick(R.id.button_add)
    void onButtonAddTap () {
        adapter.addListShampoo(listShampoo);
    }

    @Override
    public void onItemDryShampooClick(DryShampoo dryShampoo) {
        Toast.makeText(this, "Weight = " + dryShampoo.getShampooWeight(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemMysteryBookClick(MysteryBook mysteryBook) {
        Toast.makeText(this, mysteryBook.getBookName(), Toast.LENGTH_SHORT).show();
    }

}
