package com.example.tanan.cardslibexample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tanan.cardslibexample.Cards.ImageAndTextCard;
import com.example.tanan.cardslibexample.Cards.TextOnlyCard;

import java.util.ArrayList;
import java.util.Iterator;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.recyclerview.internal.CardArrayRecyclerViewAdapter;
import it.gmariotti.cardslib.library.recyclerview.view.CardRecyclerView;
import retrofit.RestAdapter;

/**
 * Created by tanan on 5/8/15.
 */
public class PostsFragment extends Fragment {

    ArrayList<Card> cards;
    CardArrayRecyclerViewAdapter cardArrayRecyclerViewAdapter;
    CardRecyclerView cardRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new FetchPosts().execute();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_view, container, false);

        cardArrayRecyclerViewAdapter = new CardArrayRecyclerViewAdapter(getActivity(), getCards());
        cardRecyclerView = (CardRecyclerView) view.findViewById(R.id.card_recycler_view);
        cardRecyclerView.setHasFixedSize(false);
        cardRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if(cardRecyclerView != null) {
            cardRecyclerView.setAdapter(cardArrayRecyclerViewAdapter);
        }

        return view;
    }

    public ArrayList<Card> getCards() {
        return cards;
    };

    public class FetchPosts extends AsyncTask<Void, Void, PostObject>{

        @Override
        protected PostObject doInBackground(Void... params) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://blog.teamtreehouse.com")
                    .build();

            FetchPostsService fetchPostsService = restAdapter.create(FetchPostsService.class);

            return fetchPostsService.getPosts();
        }

        @Override
        protected void onPostExecute(PostObject postObject) {
            super.onPostExecute(postObject);
            ArrayList<Card> myCards = new ArrayList<>();

            Iterator itr = postObject.posts.iterator();
            while (itr.hasNext()) {
                final Post post = (Post) itr.next();
                if(post.thumbnail != null) {
                    ImageAndTextCard card = new ImageAndTextCard(getActivity(), post.url, post.title, post.author, post.thumbnail);

                    card.setOnClickListener(new Card.OnCardClickListener() {
                        @Override
                        public void onClick(Card card, View view) {
                            PostWebViewFragment postWebViewFragment = PostWebViewFragment.newInstance(post.url);
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.card_container, postWebViewFragment);
                            fragmentTransaction.commit();
                        }
                    });

                    myCards.add(card);
                } else {
                    TextOnlyCard card = new TextOnlyCard(getActivity(), post.url, post.title, post.author);
                    myCards.add(card);
                }
            }
            cardArrayRecyclerViewAdapter.addAll(myCards);
        }
    }

}
