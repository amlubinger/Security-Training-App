package com.example.securitytrainingapp.ui.learning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.securitytrainingapp.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LearningFragment extends Fragment {

    private LearningViewModel learningViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        learningViewModel =
                ViewModelProviders.of(this).get(LearningViewModel.class);
        View root = inflater.inflate(R.layout.fragment_learning, container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.article_card_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Get the articles in a list. Temporarily using just string arrays with mock data.
        List<String[]> articles = new ArrayList<String[]>();
        String[] articleOne = new String[3];
        articleOne[0] = "Article One";
        articleOne[1] = "This is the description/summary of the first article.";
        articleOne[2] = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ultricies mi eget mauris pharetra et ultrices neque ornare aenean. Arcu dui vivamus arcu felis bibendum. In arcu cursus euismod quis. Elit sed vulputate mi sit amet. Elementum integer enim neque volutpat ac tincidunt vitae. Congue eu consequat ac felis donec et odio pellentesque diam. Sed euismod nisi porta lorem mollis aliquam ut. Risus pretium quam vulputate dignissim suspendisse in est. Felis bibendum ut tristique et egestas quis. Iaculis eu non diam phasellus vestibulum lorem sed risus ultricies. Quam elementum pulvinar etiam non quam lacus. Quis commodo odio aenean sed adipiscing diam donec adipiscing. Nulla posuere sollicitudin aliquam ultrices.\n" +
                "\n" +
                "Sit amet luctus venenatis lectus magna fringilla urna. Volutpat sed cras ornare arcu dui vivamus arcu. Donec pretium vulputate sapien nec sagittis aliquam. Eu scelerisque felis imperdiet proin fermentum leo vel orci. Velit egestas dui id ornare arcu. Pharetra pharetra massa massa ultricies mi quis hendrerit. At augue eget arcu dictum. Hac habitasse platea dictumst quisque sagittis purus sit amet. Ac placerat vestibulum lectus mauris ultrices eros in. Sed blandit libero volutpat sed cras ornare. Tempor orci dapibus ultrices in iaculis nunc. Viverra justo nec ultrices dui sapien eget mi proin sed.\n" +
                "\n" +
                "Pellentesque dignissim enim sit amet venenatis urna cursus eget. Scelerisque eleifend donec pretium vulputate sapien nec. Viverra suspendisse potenti nullam ac tortor vitae purus faucibus ornare. Tempus imperdiet nulla malesuada pellentesque. Dictumst quisque sagittis purus sit amet volutpat consequat mauris. Cursus risus at ultrices mi tempus imperdiet nulla. Feugiat vivamus at augue eget arcu dictum varius duis. Sit amet commodo nulla facilisi nullam vehicula. Sapien faucibus et molestie ac. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit scelerisque. Pharetra pharetra massa massa ultricies mi quis hendrerit dolor magna. Mauris sit amet massa vitae tortor condimentum lacinia quis vel. Amet facilisis magna etiam tempor orci.\n" +
                "\n" +
                "Habitant morbi tristique senectus et netus et malesuada fames. Mauris pellentesque pulvinar pellentesque habitant morbi tristique senectus. Interdum varius sit amet mattis vulputate enim. Tempus quam pellentesque nec nam. Sed euismod nisi porta lorem mollis aliquam ut. Est lorem ipsum dolor sit amet consectetur. Dolor purus non enim praesent elementum facilisis. Praesent tristique magna sit amet purus gravida quis. Ante metus dictum at tempor. Neque ornare aenean euismod elementum nisi quis. Feugiat nisl pretium fusce id. Morbi leo urna molestie at elementum. Justo donec enim diam vulputate. Elementum curabitur vitae nunc sed velit. Consequat interdum varius sit amet mattis vulputate enim. Ultrices dui sapien eget mi proin sed libero.\n" +
                "\n" +
                "Orci sagittis eu volutpat odio facilisis mauris sit amet. Ut etiam sit amet nisl. Nunc vel risus commodo viverra maecenas accumsan lacus. Facilisis leo vel fringilla est ullamcorper. Eleifend donec pretium vulputate sapien nec sagittis. Imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada. Ut placerat orci nulla pellentesque dignissim enim sit amet venenatis. Vitae aliquet nec ullamcorper sit amet risus nullam. Mi ipsum faucibus vitae aliquet nec ullamcorper sit amet risus. Aliquet enim tortor at auctor urna. Justo eget magna fermentum iaculis. A erat nam at lectus urna duis convallis convallis tellus. Volutpat blandit aliquam etiam erat velit scelerisque in dictum. Scelerisque in dictum non consectetur a erat nam at lectus. Eget nullam non nisi est sit amet. Dui nunc mattis enim ut tellus elementum. Sit amet luctus venenatis lectus. Habitant morbi tristique senectus et netus. Mattis vulputate enim nulla aliquet porttitor lacus.";
        String[] articleTwo = new String[3];
        articleTwo[0] = "Article Two";
        articleTwo[1] = "Here is another article summary! This will be a really great article for you to read. You will learn a lot.";
        articleTwo[2] = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. In fermentum posuere urna nec tincidunt praesent semper feugiat. Nunc sed id semper risus in hendrerit gravida rutrum quisque. In est ante in nibh mauris cursus. Gravida rutrum quisque non tellus. Diam vulputate ut pharetra sit amet aliquam id diam. Arcu non odio euismod lacinia at quis. Sagittis vitae et leo duis ut diam quam nulla. Arcu odio ut sem nulla pharetra diam. In est ante in nibh. Gravida rutrum quisque non tellus orci ac auctor augue mauris.\n" +
                "\n" +
                "Faucibus pulvinar elementum integer enim neque volutpat ac tincidunt. Dictumst vestibulum rhoncus est pellentesque elit ullamcorper dignissim cras. Bibendum enim facilisis gravida neque convallis a cras. Tortor posuere ac ut consequat semper. In nisl nisi scelerisque eu ultrices. Commodo nulla facilisi nullam vehicula ipsum a arcu cursus vitae. Ullamcorper eget nulla facilisi etiam. Pretium vulputate sapien nec sagittis. Varius morbi enim nunc faucibus a pellentesque sit amet. Dui id ornare arcu odio ut sem nulla.";
        String[] articleThree = new String[3];
        articleThree[0] = "Third Article";
        articleThree[1] = "Here is just one more article summary! Will this be the best article so far? There's only one way to find out! Check it out!";
        articleThree[2] = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. In eu mi bibendum neque egestas. Pulvinar sapien et ligula ullamcorper malesuada proin libero. Sit amet aliquam id diam maecenas ultricies mi eget. Id interdum velit laoreet id donec ultrices tincidunt arcu non. Donec ac odio tempor orci dapibus ultrices in. Lacus vel facilisis volutpat est velit. Aliquet eget sit amet tellus cras adipiscing enim eu turpis. Eleifend quam adipiscing vitae proin sagittis nisl rhoncus mattis rhoncus. Suspendisse sed nisi lacus sed viverra tellus in hac habitasse. Ultrices sagittis orci a scelerisque purus. Elit at imperdiet dui accumsan.\n" +
                "\n" +
                "Ipsum nunc aliquet bibendum enim facilisis gravida neque convallis a. In nulla posuere sollicitudin aliquam ultrices sagittis orci. Risus feugiat in ante metus dictum at. Est lorem ipsum dolor sit amet consectetur adipiscing elit pellentesque. Sit amet consectetur adipiscing elit. Posuere morbi leo urna molestie at elementum eu. Nisl purus in mollis nunc sed id. Aliquet eget sit amet tellus. Adipiscing enim eu turpis egestas pretium aenean. Iaculis at erat pellentesque adipiscing. Magna sit amet purus gravida quis blandit. Eget nullam non nisi est sit amet facilisis. At ultrices mi tempus imperdiet nulla. Tempus urna et pharetra pharetra massa massa ultricies mi quis. Vitae justo eget magna fermentum iaculis eu non. Suspendisse faucibus interdum posuere lorem ipsum dolor sit. In dictum non consectetur a erat nam.\n" +
                "\n" +
                "Quis ipsum suspendisse ultrices gravida. Ultricies tristique nulla aliquet enim tortor. Ultricies tristique nulla aliquet enim tortor at auctor. Pharetra pharetra massa massa ultricies mi quis. Consequat id porta nibh venenatis. Maecenas ultricies mi eget mauris pharetra et ultrices neque ornare. Accumsan lacus vel facilisis volutpat est velit egestas dui id. Proin fermentum leo vel orci porta non pulvinar neque. Id consectetur purus ut faucibus pulvinar elementum. Nulla facilisi cras fermentum odio. Feugiat scelerisque varius morbi enim nunc faucibus a pellentesque sit. Enim praesent elementum facilisis leo vel fringilla est. Odio ut sem nulla pharetra. Turpis tincidunt id aliquet risus feugiat. Nunc vel risus commodo viverra maecenas accumsan lacus vel. Elementum sagittis vitae et leo duis. Eu tincidunt tortor aliquam nulla facilisi cras fermentum odio eu. Amet mattis vulputate enim nulla. Nunc non blandit massa enim nec dui nunc. Consectetur libero id faucibus nisl tincidunt eget nullam.\n" +
                "\n" +
                "Phasellus faucibus scelerisque eleifend donec. Netus et malesuada fames ac turpis. Ultricies mi eget mauris pharetra et ultrices neque ornare aenean. Est ante in nibh mauris cursus mattis molestie. Turpis nunc eget lorem dolor sed viverra ipsum nunc. Massa eget egestas purus viverra accumsan in. Venenatis a condimentum vitae sapien pellentesque habitant morbi. Vitae turpis massa sed elementum tempus egestas sed sed. Fusce ut placerat orci nulla pellentesque dignissim enim sit amet. Ullamcorper morbi tincidunt ornare massa eget. Venenatis a condimentum vitae sapien pellentesque habitant. Proin nibh nisl condimentum id venenatis. Non curabitur gravida arcu ac tortor. Rhoncus aenean vel elit scelerisque mauris pellentesque pulvinar. Ipsum dolor sit amet consectetur adipiscing elit duis tristique sollicitudin. Metus dictum at tempor commodo ullamcorper. Sed vulputate odio ut enim.\n" +
                "\n" +
                "Pellentesque id nibh tortor id aliquet lectus proin nibh. Curabitur vitae nunc sed velit dignissim. Semper feugiat nibh sed pulvinar proin gravida hendrerit lectus. Iaculis eu non diam phasellus. Sodales neque sodales ut etiam sit amet nisl purus in. Cras sed felis eget velit aliquet sagittis id consectetur purus. Et egestas quis ipsum suspendisse ultrices gravida. Tellus in metus vulputate eu scelerisque felis. Volutpat ac tincidunt vitae semper quis lectus. Vitae congue eu consequat ac felis. Enim neque volutpat ac tincidunt vitae semper quis. Nisl vel pretium lectus quam id leo in vitae turpis. Et molestie ac feugiat sed lectus vestibulum mattis. Suspendisse sed nisi lacus sed viverra tellus in hac. Cursus turpis massa tincidunt dui ut ornare. Mauris vitae ultricies leo integer malesuada nunc. Lectus quam id leo in vitae turpis massa.\n" +
                "\n" +
                "Facilisis volutpat est velit egestas dui id ornare. Quis varius quam quisque id diam vel. Mus mauris vitae ultricies leo integer malesuada nunc vel. Lectus magna fringilla urna porttitor rhoncus dolor purus non enim. Faucibus et molestie ac feugiat sed lectus vestibulum mattis ullamcorper. Velit laoreet id donec ultrices. Purus gravida quis blandit turpis cursus. Mauris vitae ultricies leo integer malesuada nunc vel. Cras ornare arcu dui vivamus arcu. Curabitur gravida arcu ac tortor dignissim convallis aenean.\n" +
                "\n" +
                "Vulputate enim nulla aliquet porttitor. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit. Velit ut tortor pretium viverra suspendisse potenti nullam ac. Odio eu feugiat pretium nibh ipsum consequat nisl vel pretium. Convallis tellus id interdum velit laoreet id donec ultrices tincidunt. Orci dapibus ultrices in iaculis nunc sed augue lacus. Eget mauris pharetra et ultrices neque ornare aenean. Varius morbi enim nunc faucibus a pellentesque sit amet porttitor. Amet consectetur adipiscing elit duis tristique sollicitudin nibh sit amet. Interdum velit laoreet id donec ultrices. Faucibus turpis in eu mi bibendum neque. Neque sodales ut etiam sit amet nisl purus in. Nunc congue nisi vitae suscipit tellus mauris a diam maecenas. Sed id semper risus in hendrerit gravida rutrum quisque non. Eget nunc lobortis mattis aliquam faucibus purus. Proin libero nunc consequat interdum varius sit amet. Vitae sapien pellentesque habitant morbi tristique senectus et. Nascetur ridiculus mus mauris vitae ultricies leo integer.\n" +
                "\n" +
                "Aliquet eget sit amet tellus. Suspendisse faucibus interdum posuere lorem ipsum. Cursus eget nunc scelerisque viverra mauris in aliquam. Id volutpat lacus laoreet non curabitur gravida arcu ac tortor. Et magnis dis parturient montes nascetur ridiculus mus. Tempor nec feugiat nisl pretium. Ac auctor augue mauris augue neque. Ornare arcu odio ut sem nulla. Mus mauris vitae ultricies leo integer malesuada nunc vel. Massa tincidunt nunc pulvinar sapien. Ac feugiat sed lectus vestibulum mattis ullamcorper velit sed. In nulla posuere sollicitudin aliquam ultrices. Accumsan lacus vel facilisis volutpat. Non blandit massa enim nec dui nunc mattis enim ut. Id eu nisl nunc mi ipsum faucibus vitae aliquet. Etiam erat velit scelerisque in. Et molestie ac feugiat sed lectus.";
        articles.add(articleOne);
        articles.add(articleTwo);
        articles.add(articleThree);

        ArticleCardAdapter adapter = new ArticleCardAdapter(articles);
        recyclerView.setAdapter(adapter);

        BottomSheetBehavior<View> bottomSheet = BottomSheetBehavior.from(root.findViewById(R.id.article));
        bottomSheet.setState(BottomSheetBehavior.STATE_HIDDEN);

        return root;
    }
}
