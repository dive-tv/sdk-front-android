package com.touchvie.touchvie_front.ui.adapters;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;

/**
 * This is a custom implementation extending FlexibleAdapter. {@code AbstractFlexibleItem} is
 * used as most common Item for ALL view types.
 * <p>Items are bound with <b>METHOD A</b> (new way): AutoMap is active, you <u>don't have to</u>
 * implement {@code getItemViewType, onCreateViewHolder, onBindViewHolder}.</p>
 * Check {@code OverallAdapter} for <b>METHOD B</b> (classic way).
 *
 * @see AbstractFlexibleItem
 */
public class CarouselExampleAdapter extends FlexibleAdapter<AbstractFlexibleItem> {

    private static final String TAG = CarouselExampleAdapter.class.getSimpleName();

    private AbstractFlexibleItem mUseCaseItem;

    public CarouselExampleAdapter(List<AbstractFlexibleItem> items) {
        //true = Items implement hashCode() and have stableIds!
        super(items, true);
    }

    @Override
    public void updateDataSet(List<AbstractFlexibleItem> items, boolean animate) {
        //NOTE: To have views/items not changed, set them into "items" before passing the final
        // list to the Adapter.

        //Overwrite the list and fully notify the change, pass false to not animate changes.
        //Watch out! The original list must a copy
        super.updateDataSet(items, animate);

        //Add example view
        //showLayoutInfo(true);
    }

    /**
     * This is a customization of the Layout that hosts the header when sticky.
     * The code works, but it is commented because not used (default is used).
     */
//	@Override
//	public ViewGroup getStickySectionHeadersHolder() {
//		FrameLayout frameLayout = new FrameLayout(mRecyclerView.getContext());
//		frameLayout.setLayoutParams(new ViewGroup.LayoutParams(
//				ViewGroup.LayoutParams.WRAP_CONTENT,//or MATCH_PARENT
//				ViewGroup.LayoutParams.WRAP_CONTENT));
//		((ViewGroup) mRecyclerView.getParent()).addView(frameLayout);//This is important otherwise the Header disappears!
//		return (ViewGroup) mInflater.inflate(R.layout.sticky_header_layout, frameLayout);
//	}

    /**
     * METHOD A - NEW! Via Model objects. In this case you don't need to implement this method!
     * METHOD B - You override and implement this method as you prefer (don't call super).
     */
//	@Override
//	public int getItemViewType(int position) {
//		//Not implemented: METHOD A is used
//	}

    /**
     * METHOD A - NEW! Via Model objects. In this case you don't need to implement this method!
     * METHOD B - You override and implement this method as you prefer (don't call super).
     */
//	@Override
//	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//		//Not implemented: METHOD A is used
//	}

    /**
     * METHOD A - NEW! Via Model objects. In this case you don't need to implement this method!
     * METHOD B - You override and implement this method as you prefer (don't call super).
     */
//	@Override
//	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//		//Not implemented: METHOD A is used
//	}
    @Override
    public String onCreateBubbleText(int position) {
        if (position == 0) {//This 'if' is for my example only
            //TODO FOR YOU: This is the normal line you should use: Usually it's the first letter
            return Integer.toString(position);
        }
        return super.onCreateBubbleText(position);
    }

}