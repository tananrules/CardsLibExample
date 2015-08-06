package com.example.tanan.cardslibexample.Cards;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tanan.cardslibexample.R;
import com.squareup.picasso.Picasso;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by tanan on 5/8/15.
 */
public class ImageAndTextCard extends Card {
    ImageView card_thumbnail_image;
    TextView card_title;
    TextView card_author;
    String url;
    String title;
    String author;
    String thumbnail;

    public ImageAndTextCard(Context context, String url, String title, String author, String thumbnail) {
        super(context, R.layout.image_text_card);
        this.url = url;
        this.title = title;
        this.author = author;
        this.thumbnail = thumbnail;
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
        card_title = (TextView) parent.findViewById(R.id.card_title);
        card_author = (TextView) parent.findViewById(R.id.card_author);
        card_thumbnail_image = (ImageView) parent.findViewById(R.id.card_thumbnail_image);

        if(card_author != null) {
            card_author.setText(author);
        }

        if(card_title != null) {
            card_title.setText(title);
        }

        Picasso.with(mContext).load(thumbnail).into(card_thumbnail_image);
    }
}
