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
    TextView card_title;
    TextView card_author;
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
        card_title = (TextView) parent.findViewById(R.id.card_title);
        card_author = (TextView) parent.findViewById(R.id.card_author);

        if(card_author != null) {
            card_author.setText(author);
        }

        if(card_title != null) {
            card_title.setText(title);
        }
    }

    @Override
    public int getType() {
        return 1;
    }
}
