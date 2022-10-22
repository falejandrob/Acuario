package com.faborjas.acuario.viewmodels;

import androidx.lifecycle.ViewModel;

import com.faborjas.acuario.entities.Acuario;

import java.util.ArrayList;
import java.util.List;

public class AcuariosViewModel extends ViewModel {
    private List<Acuario> acuarioList;

    public List<Acuario> getAcuarioList() {
        if (acuarioList == null){
            acuarioList = new ArrayList<>();
        }
        return acuarioList;
    }

    public void setAcuarioList(List<Acuario> acuarioList) {
        this.acuarioList = acuarioList;
    }
}
