package com.mcdonalds.app.ordering;

import android.os.Bundle;
import android.support.p000v4.app.FragmentTransaction;
import com.mcdonalds.app.p043ui.URLActionBarActivity;

public class ChoosePaymentActivity extends URLActionBarActivity {
    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(getContainerResource(), passIntentExtrasAsArgument(new ChoosePaymentFragment()));
        transaction.commit();
    }
}
