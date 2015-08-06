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
    ImageView ivCardThumbnail;
    TextView tvCardTitle;
    TextView tvCardAuthor;
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
        tvCardTitle = (TextView) parent.findViewById(R.id.tvCardTitle);
        tvCardAuthor = (TextView) parent.findViewById(R.id.tvCardAuthor);
        ivCardThumbnail = (ImageView) parent.findViewById(R.id.ivCardThumbnail);

        if(tvCardAuthor != null) {
            tvCardAuthor.setText(author);
        }

        if(tvCardTitle != null) {
            tvCardTitle.setText(title);
        }

        Picasso.with(mContext).load(thumbnail).into(ivCardThumbnail);
    }
}
