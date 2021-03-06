package com.mcdonalds.sdk.connectors.mwcustomersecurity.response;

import com.google.gson.annotations.SerializedName;

public class MWCustomerSecurityAuthenticationResponse<T> {
    @SerializedName("accessToken")
    private String accessToken;
    @SerializedName("details")
    private MWCustomerSecurityAuthenticationDetailsResponse details;
    @SerializedName("refreshToken")
    private String refreshToken;
    @SerializedName("status")
    private String status;
    @SerializedName("statusCode")
    private String statusCode;
    @SerializedName("statusDescription")
    private String statusDescription;

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public MWCustomerSecurityAuthenticationDetailsResponse getDetails() {
        return this.details;
    }

    public void setDetails(MWCustomerSecurityAuthenticationDetailsResponse details) {
        this.details = details;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return this.statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String toString() {
        return "MWCustomerSecurityAuthenticationResponse{status='" + this.status + '\'' + ", statusCode='" + this.statusCode + '\'' + ", statusDescription='" + this.statusDescription + '\'' + ", accessToken='" + this.accessToken + '\'' + ", refreshToken='" + this.refreshToken + '\'' + ", details=" + this.details + '}';
    }
}
