
package com.denovo.Pages;

public class QuickPayWithSurchargeForm {

    private String isoPrimaryUN;
    private String iSOPrimaryPwd;
    private String merchantPrimaryUser;
    private String merchantPrimaryPwd;

    private String surchargeFeeTPN;
    private String tip;
    private String tax;
    private String fee;
    private String feeType;
    private String typePercentageOrDollar;
    private String cappedAt;
    private String percentageOfTxAmount;
    private String displayLabel;
    private String discloseFee;

    private String action;
    private String paymentType;
    private String transactionType;
    private String surchargeTpn;
    private String amount;
    private String Country;
    private String phone;
    private String email;
    private String cardNumber;
    private String expDate;

    private String expectedBaseAmt;
    private String expectedFeeAmt;
    private String expectedTotalAmt;



    public QuickPayWithSurchargeForm(String isoPrimaryUN, String iSOPrimaryPwd, String merchantPrimaryUser, String merchantPrimaryPwd, String surchargeFeeTPN, String tip, String tax, String fee, String feeType, String typePercentageOrDollar, String cappedAt, String percentageOfTxAmount, String displayLabel, String discloseFee, String action,
                                     String paymentType, String transactionType, String surchargeTpn, String amount, String country, String phone, String email, String cardNumber, String expDate, String expectedBaseAmt, String expectedFeeAmt, String expectedTotalAmt) {
        this.isoPrimaryUN = isoPrimaryUN;
        this.iSOPrimaryPwd = iSOPrimaryPwd;
        this.merchantPrimaryUser = merchantPrimaryUser;
        this.merchantPrimaryPwd = merchantPrimaryPwd;
        this.surchargeFeeTPN = surchargeFeeTPN;
        this.tip = tip;
        this.tax = tax;
        this.fee = fee;
        this.feeType = feeType;
        this.typePercentageOrDollar = typePercentageOrDollar;
        this.cappedAt = cappedAt;
        this.percentageOfTxAmount = percentageOfTxAmount;
        this.displayLabel = displayLabel;
        this.discloseFee = discloseFee;
        this.action = action;
        this.paymentType = paymentType;
        this.transactionType = transactionType;
        this.surchargeTpn = surchargeTpn;
        this.amount = amount;
        this.Country = country;
        this.phone = phone;
        this.email = email;
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.expectedBaseAmt = expectedBaseAmt;
        this.expectedFeeAmt = expectedFeeAmt;
        this.expectedTotalAmt=expectedTotalAmt;
    }


    public String getIsoPrimaryUN() {
        return isoPrimaryUN;
    }

    public void setIsoPrimaryUN(String isoPrimaryUN) {
        this.isoPrimaryUN = isoPrimaryUN;
    }

    public String getISOPrimaryPwd() {
        return iSOPrimaryPwd;
    }

    public void setISOPrimaryPwd(String iSOPrimaryPwd) {
        this.iSOPrimaryPwd = iSOPrimaryPwd;
    }

    public String getMerchantPrimaryUser() {
        return merchantPrimaryUser;
    }

    public void setMerchantPrimaryUser(String merchantPrimaryUser) {
        this.merchantPrimaryUser = merchantPrimaryUser;
    }

    public String getMerchantPrimaryPwd() {
        return merchantPrimaryPwd;
    }

    public void setMerchantPrimaryPwd(String merchantPrimaryPwd) {
        this.merchantPrimaryPwd = merchantPrimaryPwd;
    }

    public String getSurchargeFeeTPN() {
        return surchargeFeeTPN;
    }

    public void setSurchargeFeeTPN(String surchargeFeeTPN) {
        this.surchargeFeeTPN = surchargeFeeTPN;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getTypePercentageOrDollar() {
        return typePercentageOrDollar;
    }

    public void setTypePercentageOrDollar(String typePercentageOrDollar) {
        this.typePercentageOrDollar = typePercentageOrDollar;
    }

    public String getCappedAt() {
        return cappedAt;
    }

    public void setCappedAt(String cappedAt) {
        this.cappedAt = cappedAt;
    }

    public String getPercentageOfTxAmount() {
        return percentageOfTxAmount;
    }

    public void setPercentageOfTxAmount(String percentageOfTxAmount) {
        this.percentageOfTxAmount = percentageOfTxAmount;
    }


    public String getDisplayLabel() {
        return displayLabel;
    }

    public void setDisplayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
    }


    public String getDiscloseFee() {
        return discloseFee;
    }

    public void setDiscloseFee(String discloseFee) {
        this.discloseFee = discloseFee;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getSurchargeTpn() {
        return surchargeTpn;
    }

    public void getSurchargeTpn(String tpn) {
        this.surchargeTpn = tpn;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setSurchargeTpn(String surchargeTpn) {
        this.surchargeTpn = surchargeTpn;
    }

    public String getExpectedBaseAmt() {
        return expectedBaseAmt;
    }

    public void setExpectedBaseAmt(String expectedBaseAmt) {
        this.expectedBaseAmt = expectedBaseAmt;
    }

    public String getExpectedFeeAmt() {
        return expectedFeeAmt;
    }

    public void setExpectedFeeAmt(String expectedFeeAmt) {
        this.expectedFeeAmt = expectedFeeAmt;
    }

    public String getExpectedTotalAmt() {
        return expectedTotalAmt;
    }

    public void setExpectedTotalAmt(String expectedTotalAmt) {
        this.expectedTotalAmt = expectedTotalAmt;
    }

}

