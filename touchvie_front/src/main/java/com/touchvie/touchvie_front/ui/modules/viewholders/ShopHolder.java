package com.touchvie.touchvie_front.ui.modules.viewholders;

import android.content.Context;
import android.view.View;

import com.squareup.picasso.Picasso;
import com.touchvie.backend.carddetail.CardDetail;
import com.touchvie.backend.carddetail.ProductData;
import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.modules.adapters.ShopAdapter;
import com.touchvie.touchvie_front.ui.modules.data.ShopRowData;

import java.util.ArrayList;

import static com.touchvie.backend.TypeOfProduct.FASHION;

/**
 * Created by Tagsonomy S.L. on 13/10/2016.
 */

public class ShopHolder extends HorizontalListHolder {

    public ShopHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void configure(CardDetail cardData, Picasso picasso, Context context) {

        super.configure(cardData, picasso, context);
        mTitle.setText(context.getResources().getString(R.string.shop));

        mSeeAll.setText(context.getResources().getString(R.string.shop_this));
        mSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: manage click.
            }
        });

        ArrayList<ShopRowData> data = new ArrayList<>(); //TODO: get the needed data from card data.
        if(cardData.getProducts()==null || cardData.getProducts().length<=0){
            return;
        }
        for(ProductData product : cardData.getProducts()){
            if(product.getCategory()==null || !FASHION.getName().equals(product.getCategory())){
                continue;
            }
            ShopRowData row= new ShopRowData();
            row.setImage(product.getImage());
            if(product.getPrice() !=null){
                row.setPrice(context.getResources().getString(R.string.price, product.getPrice()));
            }else{
                row.setPrice(null);
            }
            if(product.getPrice() !=null){
                row.setShop(product.getMerchant());
            }else{
                row.setShop(null);
            }
            data.add(row);
        }

        ShopAdapter adapter = new ShopAdapter(context,data);
        mList.setAdapter(adapter);

    }
}
