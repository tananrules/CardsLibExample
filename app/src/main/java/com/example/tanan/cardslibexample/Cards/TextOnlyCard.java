package com.example.tanan.cardslibexample.Cards;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tanan.cardslibexample.R;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;

/**
 * Created by tanan on 5/8/15.
 */
public class TextOnlyCard extends Card {
    TextView tvCardTitle;
    TextView tvCardAuthor;
    String url;
    String title;
    String author;

    public TextOnlyCard(Context context, String url, String title, String author) {
        super(context, R.layout.text_only_card);
        this.url = url;
        this.title = title;
        this.author = author;
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
        tvCardTitle = (TextView) parent.findViewById(R.id.tvCardTitle);
        tvCardAuthor = (TextView) parent.findViewById(R.id.tvCardAuthor);

        if(tvCardAuthor != null) {
            tvCardAuthor.setText(author);
        }

        if(tvCardTitle != null) {
            tvCardTitle.setText(title);
        }
    }

    @Override
    public int getType() {
        return 1;
    }
}
