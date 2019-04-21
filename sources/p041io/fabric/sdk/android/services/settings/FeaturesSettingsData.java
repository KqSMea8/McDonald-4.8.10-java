package p041io.fabric.sdk.android.services.settings;

/* renamed from: io.fabric.sdk.android.services.settings.FeaturesSettingsData */
public class FeaturesSettingsData {
    public final boolean collectAnalytics;
    public final boolean collectLoggedException;
    public final boolean collectReports;
    public final boolean firebaseCrashlyticsEnabled;
    public final boolean promptEnabled;

    public FeaturesSettingsData(boolean promptEnabled, boolean collectLoggedException, boolean collectReports, boolean collectAnalytics, boolean firebaseCrashlyticsEnabled) {
        this.promptEnabled = promptEnabled;
        this.collectLoggedException = collectLoggedException;
        this.collectReports = collectReports;
        this.collectAnalytics = collectAnalytics;
        this.firebaseCrashlyticsEnabled = firebaseCrashlyticsEnabled;
    }
}
