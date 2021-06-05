package com.denovo.Util;

import com.denovo.Util.Readerlib.Xls_Reader;

import java.util.ArrayList;

public class DataProviderClassForParams {

    public static Xls_Reader reader;

    public static ArrayList<Object[]> getReceiptData() {

        ArrayList<Object[]> setReceipt = new ArrayList<>();

        reader = new Xls_Reader("E:\\IntelljWorkspaces\\src\\main\\java\\com\\denovo\\ExcelData\\Params.xlsx");

        int tolrow = reader.getRowCount("Receipt");

        for (int rowNum = 2; rowNum <= tolrow; rowNum++) {
            String Header1 = reader.getCellData("Receipt", "Header 1", rowNum);
            String Header2 = reader.getCellData("Receipt", "Header 2", rowNum);
            String Header3 = reader.getCellData("Receipt", "Header 3", rowNum);
            String Header4 = reader.getCellData("Receipt", "Header 4", rowNum);
            String Disclaimer = reader.getCellData("Receipt", "Disclaimer", rowNum);
            String MerchantCopy = reader.getCellData("Receipt", "Merchant Copy", rowNum);
            String CustomerCopy = reader.getCellData("Receipt", "Customer Copy", rowNum);
            Object[] obj = {Header1, Header2, Header3, Header4, Disclaimer, MerchantCopy, CustomerCopy};
            setReceipt.add(obj);
        }
        return setReceipt;
    }

    public static ArrayList<Object[]> getTipandTax() {

        ArrayList<Object[]> setTipTax = new ArrayList<>();

        reader = new Xls_Reader("E:\\IntelljWorkspaces\\src\\main\\java\\com\\denovo\\ExcelData\\Params.xlsx");

        int tolrow = reader.getRowCount("TipTaxes");

        for (int rowNum = 2; rowNum <= tolrow; rowNum++) {
            String Tip = reader.getCellData("TipTaxes", "Tip", tolrow);
            String TipSug_Pap = reader.getCellData("TipTaxes", "TipSug_Pap", tolrow);
            String TipSug_Pos = reader.getCellData("TipTaxes", "TipSug_Pos", tolrow);
            String SugFields1 = reader.getCellData("TipTaxes", "SuggestionFields1", tolrow);
            String SugFields2 = reader.getCellData("TipTaxes", "SuggestionFields2", tolrow);
            String SugFields3 = reader.getCellData("TipTaxes", "SuggestionFields3", tolrow);
            String SugFields4 = reader.getCellData("TipTaxes", "SuggestionFields4", tolrow);
            String MxTpAllowed = reader.getCellData("TipTaxes", "MaxTipAllowed", tolrow);
            String MxTipHigh = reader.getCellData("TipTaxes", "MaxTipHigher", tolrow);
            String Tax = reader.getCellData("TipTaxes", "Tax", tolrow);
            String StateTax = reader.getCellData("TipTaxes", "StateTax", tolrow);
            String LocalTax = reader.getCellData("TipTaxes", "LocalTax", tolrow);

            Object[] obj = {Tip, TipSug_Pap, TipSug_Pos, SugFields1, SugFields2, SugFields3, SugFields4, MxTpAllowed,
                    MxTipHigh, Tax, StateTax, LocalTax};
            setTipTax.add(obj);
        }
        return setTipTax;
    }


    public static ArrayList<Object[]> getTransaction() {
        ArrayList<Object[]> setTransaction = new ArrayList<>();

        reader = new Xls_Reader("E:\\IntelljWorkspaces\\src\\main\\java\\com\\denovo\\ExcelData\\Params.xlsx");

        int tolrow = reader.getRowCount("Transaction");

        for (int rowNum = 2; rowNum <= tolrow; rowNum++) {
            String TxType = reader.getCellData("Transaction", "Tx Type", tolrow);
            String Avs = reader.getCellData("Transaction", "Avs", tolrow);
            String CardType = reader.getCellData("Transaction", "Card Type", tolrow);
            String CardSchemes = reader.getCellData("Transaction", "Card Schemes", tolrow);
            String ManualKeyEntry = reader.getCellData("Transaction", "Manual Key Entry", tolrow);
            String MandatoryCVV = reader.getCellData("Transaction", "Mandatory CVV", tolrow);
            String SignatureLine = reader.getCellData("Transaction", "Signature Line", tolrow);

            Object[] obj = {TxType, Avs, CardType, CardSchemes, ManualKeyEntry, MandatoryCVV, SignatureLine};
            setTransaction.add(obj);
        }

        return setTransaction;
    }

    public static ArrayList<Object[]> getSettlement() {
        ArrayList<Object[]> setSettlement = new ArrayList<>();

        reader = new Xls_Reader("E:\\IntelljWorkspaces\\src\\main\\java\\com\\denovo\\ExcelData\\Params.xlsx");

        int tolrow = reader.getRowCount("Settlement");

        for (int rowNum = 2; rowNum <= tolrow; rowNum++) {
            String SettlementMode = reader.getCellData("Settlement", "Settlement Mode", tolrow);
            String Set_Time_HH = reader.getCellData("Settlement", "Set_Time_HH", tolrow);
            String Set_Time_MM = reader.getCellData("Settlement", "Set_Time_MM", tolrow);
            String Set_Time_Day = reader.getCellData("Settlement", "Set_Time_Day", tolrow);
            String PrintReport = reader.getCellData("Settlement", "Print Report", tolrow);
            String Retry = reader.getCellData("Settlement", "Retry", tolrow);
            String EveryMinutes = reader.getCellData("Settlement", "EveryMinutes", tolrow);

            Object[] obj = {SettlementMode, Set_Time_HH, Set_Time_MM, Set_Time_Day, PrintReport, Retry, EveryMinutes};
            setSettlement.add(obj);
        }
        return setSettlement;
    }


    public static ArrayList<Object[]> getCustomFee() {
        ArrayList<Object[]> getcustomfee = new ArrayList<>();

        reader = new Xls_Reader("E:\\IntelljWorkspaces\\src\\main\\java\\com\\denovo\\ExcelData\\Params.xlsx");

        int tolrow = reader.getRowCount("CustomFee");

        for (int rowNum = 2; rowNum <= tolrow; rowNum++) {
            String Fee = reader.getCellData("CustomFee", "Fee", tolrow);
            String FeeType_Custom = reader.getCellData("CustomFee", "FeeType_Custom Fee", tolrow);
            String Typesysmbol = reader.getCellData("CustomFee", "Type(%,$)", tolrow);
            String CustomfeeAmount = reader.getCellData("CustomFee", "Custom fee", tolrow);
            String CappedPercent = reader.getCellData("CustomFee", "Capped %", tolrow);
            String DisplayLabel = reader.getCellData("CustomFee", "Display Label", tolrow);
            String DiscloseFeetoCustomer = reader.getCellData("CustomFee", "Disclose Fee to Customer", tolrow);
            String ApplyFeeOnTip = reader.getCellData("CustomFee", "Apply Fee On Tip", tolrow);
            String MerchantCanRemoveFee = reader.getCellData("CustomFee", "Merchant Can Remove Fee", tolrow);
            String ApplyFeeOnDebitCard = reader.getCellData("CustomFee", "Apply Fee On Debit Card", tolrow);
            String PasswordProtectRemove = reader.getCellData("CustomFee", "Password Protect Remove Option", tolrow);



            Object[] obj = {Fee, FeeType_Custom, Typesysmbol, CustomfeeAmount, CappedPercent, DisplayLabel,
                    DiscloseFeetoCustomer,ApplyFeeOnTip,MerchantCanRemoveFee,ApplyFeeOnDebitCard,PasswordProtectRemove};
            getcustomfee.add(obj);
        }
        return getcustomfee;
    }

    public static ArrayList<Object[]> getSurchargeFee() {
        ArrayList<Object[]> getsurchargefee = new ArrayList<>();

        reader = new Xls_Reader("E:\\IntelljWorkspaces\\src\\main\\java\\com\\denovo\\ExcelData\\Params.xlsx");

        int tolrow = reader.getRowCount("SurchargeFee");

        for (int rowNum = 2; rowNum <= tolrow; rowNum++) {

            String FeeType_SurchargeFee = reader.getCellData("SurchargeFee", "FeeType_Surcharge Fee", tolrow);
            String Typesymbol = reader.getCellData("SurchargeFee", "Type(%,$)", tolrow);
            String Surchargefee = reader.getCellData("SurchargeFee", "Surcharge fee", tolrow);
            String CappedPercent = reader.getCellData("SurchargeFee", "Capped %", tolrow);
            String DisplayLabelforCD = reader.getCellData("SurchargeFee", "Display Label for CD", tolrow);
            String DiscloseFeetoCustomer = reader.getCellData("SurchargeFee", "Disclose Fee to Customer", tolrow);
            String ApplySurchargeOnTip = reader.getCellData("SurchargeFee", "Apply Surcharge On Tip", tolrow);
            String MerchantCanRemoveFee = reader.getCellData("SurchargeFee", "Merchant Can Remove Fee", tolrow);
            String PasswordProtectRemove = reader.getCellData("SurchargeFee", "Password Protect Remove Option", tolrow);
            String Typesymbol2 = reader.getCellData("SurchargeFee", "Type(%,$)", tolrow);
            String DebitCardTxAmount = reader.getCellData("SurchargeFee", "Debit Card Tx Amount", tolrow);
            String DisplayLabelforDebitCard = reader.getCellData("SurchargeFee", "Display Label for Debit Card", tolrow);


            Object[] obj = {FeeType_SurchargeFee, Typesymbol, Surchargefee, CappedPercent, DisplayLabelforCD, DiscloseFeetoCustomer,
                    ApplySurchargeOnTip,MerchantCanRemoveFee,PasswordProtectRemove,Typesymbol2,DebitCardTxAmount,DisplayLabelforDebitCard};
            getsurchargefee.add(obj);
        }
        return getsurchargefee;
    }

    public static ArrayList<Object[]> getDTI() {
        ArrayList<Object[]> getdti = new ArrayList<>();

        reader = new Xls_Reader("E:\\IntelljWorkspaces\\src\\main\\java\\com\\denovo\\ExcelData\\Params.xlsx");

        int tolrow = reader.getRowCount("DTI");

        for (int rowNum = 2; rowNum <= tolrow; rowNum++) {

            String FeeType_DTIFee = reader.getCellData("DTI", "FeeType_DTI", tolrow);
            String Typesymbol = reader.getCellData("DTI", "Type(%,$)", tolrow);
            String DtiAmt = reader.getCellData("DTI", "DtiAmt", tolrow);
            String SVConDebitcard = reader.getCellData("DTI", "Apply SVC on Debit card", tolrow);
            String FeeOnTip = reader.getCellData("DTI", "Apply Fee On Tip", tolrow);
            String DiscountType = reader.getCellData("DTI", "Apply Discount Type", tolrow);
            String DiscountAmount = reader.getCellData("DTI", "Discount Amount", tolrow);

            Object[] obj = {FeeType_DTIFee, Typesymbol, DtiAmt, SVConDebitcard, FeeOnTip, DiscountType,
                    DiscountAmount};
            getdti.add(obj);
        }
        return getdti;
    }

}