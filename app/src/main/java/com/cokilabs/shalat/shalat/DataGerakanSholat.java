package com.cokilabs.shalat.shalat;

/**
 * Created by user on 01/09/2018.
 */

public class DataGerakanSholat {
    String srcGerakan;
    String srcArab;
    String srcAudio;
    String txtNamaGerakan;
    String txtLatin;

    public DataGerakanSholat(String txtNamaGerakan, String srcGerakan, String srcArab, String srcAudio, String txtLatin){
        setSrcArab(srcArab);
        setSrcGerakan(srcGerakan);
        setSrcAudio(srcAudio);
        setTxtNamaGerakan(txtNamaGerakan);
        setTxtLatin(txtLatin);
    }

    public String getTxtLatin() {
        return txtLatin;
    }

    public void setTxtLatin(String txtLatin) {
        this.txtLatin = txtLatin;
    }

    public String getSrcGerakan() {
        return srcGerakan;
    }

    public void setSrcGerakan(String srcGerakan) {
        this.srcGerakan = srcGerakan;
    }

    public String getSrcArab() {
        return srcArab;
    }

    public void setSrcArab(String srcArab) {
        this.srcArab = srcArab;
    }

    public String getSrcAudio() {
        return srcAudio;
    }

    public void setSrcAudio(String srcAudio) {
        this.srcAudio = srcAudio;
    }

    public String getTxtNamaGerakan() {
        return txtNamaGerakan;
    }

    public void setTxtNamaGerakan(String txtNamaGerakan) {
        this.txtNamaGerakan = txtNamaGerakan;
    }
}
