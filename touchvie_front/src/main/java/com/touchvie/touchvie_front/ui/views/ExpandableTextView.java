package com.touchvie.touchvie_front.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.touchvie.touchvie_front.R;
import com.touchvie.touchvie_front.ui.listeners.ExpandableListener;

/**
 * User: Bazlur Rahman Rokon
 * Date: 9/7/13 - 3:33 AM
 */
public class ExpandableTextView extends TextView {
    private static final int DEFAULT_TRIM_LENGTH = 220;
    private static final int DEFAULT_TRIM_LENGTH_TABLET = 480;
    private static final String ELLIPSIS = " ...";

    private CharSequence originalText;
    private CharSequence trimmedText;
    private BufferType bufferType;
    private boolean trim = true;
    private int trimLength;
    private boolean isExpandable=true;
    private boolean isClickable=true;
    private ExpandableListener listener;

    /**
     * Instantiates a new Expandable text view.
     *
     * @param context the context
     */
    public ExpandableTextView(Context context) {
        this(context, null);
    }

    /**
     * Instantiates a new Expandable text view.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public ExpandableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView);
        if (context.getResources().getBoolean(R.bool.isTablet)) {
            this.trimLength = typedArray.getInt(R.styleable.ExpandableTextView_trimLength, DEFAULT_TRIM_LENGTH_TABLET);
        } else {
            this.trimLength = typedArray.getInt(R.styleable.ExpandableTextView_trimLength, DEFAULT_TRIM_LENGTH);
        }

        this.isExpandable=typedArray.getBoolean(R.styleable.ExpandableTextView_expandable, true);
        typedArray.recycle();

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isExpandable || !isClickable){
                    return;
                }
                trim = !trim;
                setText();
                requestFocusFromTouch();
                listener.onActionDone(trim);
            }
        });
    }

    public void changeStatus(){

        trim = !trim;
        setText();
        requestFocusFromTouch();
        listener.onActionDone(trim);

    }
    public void setExpandableListener(ExpandableListener listener){
        this.listener=listener;
    }

    public void setIsClickable(boolean clickable){
        this.isClickable=clickable;
    }

    public void setExpandable(boolean expandable){
        this.isExpandable=expandable;
    }

    private void setText() {
        if(getDisplayableText()==null)
            return;
        super.setText(Html.fromHtml(getDisplayableText().toString()), bufferType);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    private CharSequence getDisplayableText() {
        return trim ? trimmedText : originalText;
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        originalText = text;
        trimmedText = getTrimmedText(text);
        bufferType = type;
        setText();
    }

    private CharSequence getTrimmedText(CharSequence text) {
        if (originalText != null && originalText.length() > trimLength) {
            return new SpannableStringBuilder(originalText, 0, trimLength + 1).append(ELLIPSIS);
        } else {
            return originalText;
        }
    }

    /**
     * Gets original text.
     *
     * @return the original text
     */
    public CharSequence getOriginalText() {
        return originalText;
    }

    /**
     * Gets trim length.
     *
     * @return the trim length
     */
    public int getTrimLength() {
        return trimLength;
    }

    /**
     * Sets trim length.
     *
     * @param trimLength the trim length
     */
    public void setTrimLength(int trimLength) {
        this.trimLength = trimLength;
        trimmedText = getTrimmedText(originalText);
        setText();
    }
}
