package com.facebook.stetho.inspector.elements.android;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

abstract class ViewHighlightOverlays {

    private static class NoOpViewHighlightOverlays extends ViewHighlightOverlays {
        private NoOpViewHighlightOverlays() {
        }

        /* Access modifiers changed, original: 0000 */
        public void highlightView(View view, int mainColor) {
        }

        /* Access modifiers changed, original: 0000 */
        public void removeHighlight(View view) {
        }
    }

    @TargetApi(18)
    private static class ViewHighlightOverlaysJellybeanMR2 extends ViewHighlightOverlays {
        private static final int MARGIN_OVERLAY_COLOR = -1426797922;
        private static final int PADDING_OVERLAY_COLOR = -1430332746;
        private final HighlightDrawable[] mHighlightDrawables = new HighlightDrawable[]{this.mMainHighlightDrawable, new PaddingTopHighlightDrawable(), new PaddingBottomHighlightDrawable(), new PaddingRightHighlightDrawable(), new PaddingLeftHighlightDrawable(), new MarginTopHighlightDrawable(), new MarginBottomHighlightDrawable(), new MarginRightHighlightDrawable(), new MarginLeftHighlightDrawable()};
        private final MainHighlightDrawable mMainHighlightDrawable = new MainHighlightDrawable();

        static abstract class HighlightDrawable extends ColorDrawable {
            protected final Rect mMargins = new Rect();
            protected final Rect mPaddings = new Rect();

            HighlightDrawable(int color) {
                super(color);
            }

            /* Access modifiers changed, original: 0000 */
            public void highlightView(View view) {
                LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof MarginLayoutParams) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                    this.mMargins.left = marginLayoutParams.leftMargin;
                    this.mMargins.top = marginLayoutParams.topMargin;
                    this.mMargins.right = marginLayoutParams.rightMargin;
                    this.mMargins.bottom = marginLayoutParams.bottomMargin;
                } else {
                    this.mMargins.left = 0;
                    this.mMargins.top = 0;
                    this.mMargins.right = 0;
                    this.mMargins.bottom = 0;
                }
                this.mPaddings.left = view.getPaddingLeft();
                this.mPaddings.top = view.getPaddingTop();
                this.mPaddings.right = view.getPaddingRight();
                this.mPaddings.bottom = view.getPaddingBottom();
            }
        }

        static class MainHighlightDrawable extends HighlightDrawable {
            MainHighlightDrawable() {
            }

            /* Access modifiers changed, original: 0000 */
            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, 0, view.getWidth(), view.getHeight());
            }

            public void draw(Canvas canvas) {
                Rect newRect = canvas.getClipBounds();
                newRect.inset(-(this.mMargins.right + this.mMargins.left), -(this.mMargins.top + this.mMargins.bottom));
                canvas.clipRect(newRect, Op.REPLACE);
                super.draw(canvas);
            }
        }

        static class MarginBottomHighlightDrawable extends HighlightDrawable {
            MarginBottomHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            /* Access modifiers changed, original: 0000 */
            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, view.getHeight() - this.mMargins.bottom, view.getWidth(), view.getHeight());
            }

            public void draw(Canvas canvas) {
                canvas.translate(0.0f, (float) (this.mMargins.bottom + this.mMargins.top));
                super.draw(canvas);
            }
        }

        static class MarginLeftHighlightDrawable extends HighlightDrawable {
            MarginLeftHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            /* Access modifiers changed, original: 0000 */
            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, 0, this.mMargins.left, (view.getHeight() + this.mMargins.top) + this.mMargins.bottom);
            }

            public void draw(Canvas canvas) {
                canvas.translate((float) (-(this.mMargins.left + this.mMargins.right)), 0.0f);
                super.draw(canvas);
            }
        }

        static class MarginRightHighlightDrawable extends HighlightDrawable {
            MarginRightHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            /* Access modifiers changed, original: 0000 */
            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(view.getWidth() - this.mMargins.right, 0, view.getWidth(), (view.getHeight() + this.mMargins.top) + this.mMargins.bottom);
            }

            public void draw(Canvas canvas) {
                canvas.translate((float) this.mMargins.right, (float) (-(this.mMargins.top + this.mMargins.bottom)));
                super.draw(canvas);
            }
        }

        static class MarginTopHighlightDrawable extends HighlightDrawable {
            MarginTopHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            /* Access modifiers changed, original: 0000 */
            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, 0, view.getWidth(), this.mMargins.top);
            }

            public void draw(Canvas canvas) {
                canvas.translate(0.0f, (float) (-this.mMargins.top));
                super.draw(canvas);
            }
        }

        static class PaddingBottomHighlightDrawable extends HighlightDrawable {
            PaddingBottomHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            /* Access modifiers changed, original: 0000 */
            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(this.mPaddings.left, view.getHeight() - this.mPaddings.bottom, view.getWidth() - this.mPaddings.right, view.getHeight());
            }
        }

        static class PaddingLeftHighlightDrawable extends HighlightDrawable {
            PaddingLeftHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            /* Access modifiers changed, original: 0000 */
            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, 0, this.mPaddings.left, view.getHeight());
            }
        }

        static class PaddingRightHighlightDrawable extends HighlightDrawable {
            PaddingRightHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            /* Access modifiers changed, original: 0000 */
            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(view.getWidth() - this.mPaddings.right, 0, view.getWidth(), view.getHeight());
            }
        }

        static class PaddingTopHighlightDrawable extends HighlightDrawable {
            PaddingTopHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            /* Access modifiers changed, original: 0000 */
            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(this.mPaddings.left, 0, view.getWidth() - this.mPaddings.right, this.mPaddings.top);
            }
        }

        ViewHighlightOverlaysJellybeanMR2() {
        }

        /* Access modifiers changed, original: 0000 */
        public void highlightView(View view, int mainColor) {
            this.mMainHighlightDrawable.setColor(mainColor);
            for (HighlightDrawable drawable : this.mHighlightDrawables) {
                drawable.highlightView(view);
                view.getOverlay().add(drawable);
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void removeHighlight(View view) {
            for (ColorDrawable drawable : this.mHighlightDrawables) {
                view.getOverlay().remove(drawable);
            }
        }
    }

    public abstract void highlightView(View view, int i);

    public abstract void removeHighlight(View view);

    ViewHighlightOverlays() {
    }

    static ViewHighlightOverlays newInstance() {
        if (VERSION.SDK_INT >= 18) {
            return new ViewHighlightOverlaysJellybeanMR2();
        }
        return new NoOpViewHighlightOverlays();
    }
}
